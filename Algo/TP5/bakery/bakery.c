#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include "event.h"
#include "customer.h"
#include "queue.h"
#include "prioqueue.h"

#define N_VENDORS 3
#define CLOSING_TIME 700
#define ARRIVAL_RATE (1.0/100)
#define MEAN_SERVICE_TIME 250

prioqueue*  event_queue;
queue*      customer_queue;
customer*   vendor[N_VENDORS];
int current_time;
int nb_client;
double nb_attente;

double normal_delay(double mean){
    return -mean*log(1-((double)rand()/RAND_MAX));
}

void add_customer(customer *c){
    int i;

    for(i = 0; i < N_VENDORS; i++){
        if (vendor[i] == NULL){
            vendor[i] = c;
            event* depart = create_departure(current_time + normal_delay(MEAN_SERVICE_TIME), c);
            nb_attente += depart->etime - c->atime;
            insert_pq(event_queue, depart);
            return;
        }
    }
    enqueue_q(customer_queue, c);
}

void remove_customer(customer *c){
    int i = 0;
    for(i = 0; i < N_VENDORS; i++){
        if(vendor[i] == c){
            vendor[i] = NULL;
            free_customer(c);
            if(size_q(customer_queue) != 0){
                c = dequeue_q(customer_queue);
                vendor[i] = c;
                event* depart = create_departure(current_time + normal_delay(MEAN_SERVICE_TIME), c);
                nb_attente += depart->etime - c->atime;
                insert_pq(event_queue, depart);
            }
        }
    }
}

void process_arrival(event *e) {
    int time;
    nb_client++;
    add_customer(e->c);
    time = current_time + normal_delay(1.0/ARRIVAL_RATE);
    if (time < CLOSING_TIME){
        customer* client = create_customer(time);
        event* evenement = create_arrival(time, client);
        insert_pq(event_queue, evenement);
    }
}

void process_departure(event *e) {
    remove_customer(e->c);
}

void print_etat(){
    int i;

    printf("%4d | ", current_time);

    for(i = 0; i < N_VENDORS; i++){
        if (vendor[i] == NULL){
           printf("_");  
        }
        else{
            printf("X");
        }
    }
    printf(" | ");

    for(i = 0; i < size_q(customer_queue); i++){
        printf("X");
    }
    printf("\n");
}


int main() {
    int i;
    event* e;

    event_queue = create_pq();
    customer_queue = create_q();
    for (i = 0; i < N_VENDORS; i++){
        vendor[i] = NULL;
    }
    current_time = 0;
    nb_client = 0;
    nb_attente = 0;

    /*Creation client*/

    customer* client_1 = create_customer(0);
    e = create_arrival(client_1->atime, client_1);
    insert_pq(event_queue, e);

    /*enqueue_q(customer_queue, client_1);
    customer* client_test = dequeue_q(customer_queue);
    printf("%d\n", client_test->atime);
    */

   while(size_pq(event_queue) > 0){
       e = remove_min_pq(event_queue);
       current_time = e->etime;
       /*printf("%d\n", e->etime);*/
       if (e->type == EVENT_ARRIVAL){
           process_arrival(e);
       }
       else{
           process_departure(e);
       }
       print_etat();
       free_event(e);
   }
   printf("nombre de client : %d;  Temps d'attente moyen : %f\n", nb_client, nb_attente/nb_client);
   free_pq(event_queue);
   free_q(customer_queue);

    return 0;
}