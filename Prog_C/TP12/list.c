#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "list.h"

List create_list(char *word){
    List lst = (List)malloc(sizeof(Node));
    lst->next = NULL;
    lst->word = (char*)malloc(strlen(word)+1);
    strcpy(lst->word, word);
    return lst;
}

void free_list(List lst){
    List tmp;
    while(lst){
        tmp = lst;
        lst = lst->next;
        free(tmp->word);
        free(tmp);
    }
}

int equal(char* w1, char* w2) {
    return strcmp(w1, w2) == 0;
}

List find_list(List lst, char word[]) {
    List ptr = lst;
    while (ptr != NULL && !equal(ptr->word, word)){
        ptr = ptr->next;
    }
    return ptr;
}

List add_list(List lst, char *word){
    if(!find_list(lst, word)){
        List new = create_list(word);
        new->next = lst;
        return new;
    }
    return lst;
}

int size_list(List lst){
    if(lst){
        return 1 + size_list(lst->next);
    }
    return 0;
}