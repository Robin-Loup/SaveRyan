#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "list.h"

List create_list(int val){
    List lst = (List)malloc(sizeof(Node));
    lst->next = NULL;
    lst->data = val;
    return lst;
}

void free_list(List lst){
    List tmp;
    while(lst){
        tmp = lst;
        lst = lst->next;
        free(tmp);
    }
}


List add_list(List lst, int val){
    
    List new = create_list(val);
    new->next = lst;
    return new;
}

int size_list(List lst){
    if(lst){
        return 1 + size_list(lst->next);
    }
    return 0;
}

void print_list(List lst){
    while(lst){
        printf("%d ", lst->data);
        lst = lst->next;
    }
    printf("\n");
}