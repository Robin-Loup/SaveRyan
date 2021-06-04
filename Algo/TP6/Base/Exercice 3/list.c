#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "list.h"

/**
 * Create a link representing 1 occurence of the string 'word'.
 * The string is copied and must be freed when the link is freed.
 */
link *create_link(char word[]) {
    link *lnk = malloc(sizeof(link));
    lnk->word = malloc(strlen(word)+1);
    strcpy(lnk->word, word);
    lnk->occurrences = NULL;
    lnk->next = NULL;
    return lnk;
}

void free_olink(olink *olnk){
    while (olnk) {
        olink *tmp = olnk;
        olnk = olnk->next;
        free(tmp);
    }
}
void free_link(link *lnk) {
    free(lnk->word);
    free_olink(lnk->occurrences);
    free(lnk);
}

void display_list(link *lst) {
    olink * tmp;
    while (lst) {
        tmp = lst->occurrences;
        printf("%s:", lst->word);
        while(tmp){
            if (tmp->next){
                printf(" %d,", tmp->pos);
            }
            else{
                printf(" %d\n", tmp->pos);
            }
            tmp = tmp->next;
        }
        lst = lst->next;
    }
}

void write_list(link *lst, FILE *fichier) {
    olink * tmp;
    while (lst) {
        tmp = lst->occurrences;
        fprintf(fichier, "%s:", lst->word);
        while(tmp){
            if (tmp->next){
                fprintf(fichier, " %d,", tmp->pos);
            }
            else{
                fprintf(fichier, " %d\n", tmp->pos);
            }
            tmp = tmp->next;
        }
        lst = lst->next;
    }
}

void add_occurrence(link *lnk,int pos){
    olink *new = (olink*)malloc(sizeof(olink));
    new->next = NULL;
    new->pos = pos;
   if(lnk->occurrences == NULL){
       lnk->occurrences = new;
   }
   else{
       olink *tmp = lnk->occurrences;
       new->next = tmp;
       lnk->occurrences = new;
      /* while (tmp->next != NULL)
       {
           tmp = tmp->next;
       }
       tmp->next = new;*/
       
   }
}

void free_list(link *lst) {
    while (lst) {
        link *tmp = lst;
        lst = lst->next;
        free_link(tmp);
    }
}

int equal(char* w1, char* w2) {
    return strcmp(w1, w2) == 0;
}

link *find_list(link* lst, char word[]) {
    link *ptr = lst;
    while (ptr != NULL && !equal(ptr->word, word))
        ptr = ptr->next;
    return ptr;
}

link *insert_first_list(link *lst, char word[]) {
    link *tmp = create_link(word);
    tmp->next = lst;
    return tmp;
}

