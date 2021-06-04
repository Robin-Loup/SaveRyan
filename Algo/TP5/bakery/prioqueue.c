#include <stdlib.h>
#include <stdio.h>
#include "prioqueue.h"
#include "event.h"


typedef struct _link {
    event* e;
    struct _link* next;
    } link;

struct _prioqueue {
    link* first;
    int size;
};

prioqueue* create_pq(){
    prioqueue* q = (prioqueue*)malloc(sizeof(prioqueue));
    q->first = NULL;
    q->size = 0;
    return q;
}

void free_pq(prioqueue* q){
    free(q);
}

int size_pq(prioqueue* q){
    return q->size;
}

void insert_pq(prioqueue* q, event* e){
    link* l = (link*)malloc(sizeof(prioqueue));
    l->e = e;
    l->next = NULL;
    
    link* tmp = q->first;
    if(tmp == NULL){
        q->first = l;
    }
    else if(tmp->e->etime > e->etime){
        l->next = q->first;
        q->first = l;
    }
    else{
        while(tmp->next != NULL && tmp->next->e->etime < e->etime){
            tmp = tmp->next;
        }
        l->next = tmp->next;
        tmp->next = l;
    }

    q->size++;
}

void display_pq(prioqueue* q){
    link* l = q->first;
    for(l; l!= NULL; l = l->next){
        printf("event type: %d; event time: %d\n", l->e->type, l->e->etime);
    }
}

event* remove_min_pq(prioqueue* q){
    if(size_pq(q) == 0){
        return NULL;
    }
    link* l = q->first;
    q->first = q->first->next;
    event* e = l->e;
    free(l);
    q->size--;
    return e;

}