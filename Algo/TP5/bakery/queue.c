#include <stdlib.h>
#include <stdio.h>
#include "queue.h"


typedef struct _link {
    customer* c;
    struct _link* next;
} link;

struct _queue {
    link* first;
    link* last;
    int size;
};

queue *create_q() {
    queue *q = (queue*)malloc(sizeof(queue));
    q->first = NULL;
    q->last = NULL;
    q->size = 0;
    return q;
}

void free_q(queue *q) {
    free(q);
}

int size_q(queue *q) {
    return q->size;
}

void enqueue_q(queue* q, customer* c){
    link* l = (link*)malloc(sizeof(link));
    l->c = c;
    l->next = NULL;
    if (q->first == NULL){
        q->first = l;
        q->last = l;
    }
    else{
        q->last->next = l;
        q->last = q->last->next;
    }
    q->size++;
}

void display_q(queue *q){
    link* l = q->first;
    for(l; l!= NULL; l = l->next){
        printf("customer time: %d\n", l->c->atime);
    }
}

customer* dequeue_q(queue* q){
    if(size_q(q) == 0){
        return NULL;
    }
    link* l = q->first;
    customer* c = q->first->c;
    q->first = q->first->next;
    q->size--;
    free(l);
    if(size_q(q) == 0){
        q->last = NULL;
    }
    return c;
}

/*int main() {
    queue* q = create_q();
    customer* c1 = create_customer(1);
    customer* c2 = create_customer(2);
    customer* c3 = create_customer(3);

    enqueue_q(q, c1);
    enqueue_q(q, c2);
    enqueue_q(q, c3);

    display_q(q);

    return 0;
}*/

