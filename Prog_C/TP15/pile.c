#include <stdlib.h>
#include <stdio.h>
#include <assert.h>
#include "pile.h"

typedef struct _link {
    int data;
    struct _link* next;
} link;

struct _pile {
    link* first;
    int size;
};

pile *create_p(){
    pile *p = (pile*)malloc(sizeof(pile));
    p->first = NULL;
    p->size = 0;
    return p;
}

void free_p(pile *p){
    link *tmp = p->first;
    while(tmp != NULL){
        link *tmp2 = tmp;
        tmp = tmp->next;
        free(tmp2);
    }
    free(p);
}

int size_p(pile *p){
    return p->size;
}

void push(pile *p, int val){
    link *l = (link*)malloc(sizeof(link));
    l->data = val;
    l->next = p->first;
    p->first = l;
    p->size++;
}

int pop(pile *p){
    int val;
    if (size_p(p) == 0){
        assert(p->first == NULL);
    }
    
    link *tmp = p->first;
    p-> first = p->first->next;
    p->size--;
    val = tmp->data;
    free(tmp);

    return val;
}

void clear(pile *p){
    while (size_p(p) != 0){
        pop(p);
    }
}

void reverse(pile *p){
    int x, y;
    x = pop(p);
    y = pop(p);
    push(p, x);
    push(p, y);
}

void print(pile *p){
    link *tmp =p->first;
    printf("Taille de la pile : %d\n[", size_p(p));
    while(tmp!=NULL){
        if (tmp->next == NULL){
             printf("%d", tmp->data);
        }
        else{
            printf("%d, ", tmp->data);
        }
        tmp = tmp->next;
    }
    printf("]\n");
}

