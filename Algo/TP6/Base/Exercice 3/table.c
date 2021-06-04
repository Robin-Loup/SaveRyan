#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "list.h"
#include "table.h"


table *create_table(int M){
    int i;

    table *tab = (table*)malloc(sizeof(table));

    tab->bucket = (link**)malloc(sizeof(link*) * M);
    for(i = 0; i < M; i++){
        tab->bucket[i] = NULL;
    }
    tab->M = M;
    tab->size = 0;

    return tab;
}

void free_table(table *tab){
    int i;
    for(i = 0; i < tab->M; i++){
        free_list(tab->bucket[i]);
    }
    free(tab->bucket);
    free(tab);
}

int puiss(int a, int b){
    int res, i;
    res = 1;
    for (i = 0; i < b; i++){
        res = res * a;
    }

    return res;
}

unsigned hach(char word[]){
    int i, res;
    res = 0;

    for (i = 0; word[i] != '\0'; i++){
        res += puiss(word[i], i+1);
         /*printf("res = %d\n", res);*/

    }

    return res;
}

void add_occ_table(table *tab, char word[], int pos){
    link *tmp;
    unsigned hachage = hach(word);
    /*printf("%d : %d\n", hachage, hachage % tab->M);*/
    tmp = find_list(tab->bucket[hachage % tab->M], word);
    if (tmp == NULL){
          
        tab->bucket[hachage % tab->M] = insert_first_list(tab->bucket[hachage % tab->M], word);
       
        add_occurrence(tab->bucket[hachage % tab->M], pos);
    }
    else{
        add_occurrence(tmp, pos);
    }
    tab->size++;

}

void display_table(table *tab){
    int i;
    for(i = 0; i < tab->M; i++){
        display_list(tab->bucket[i]);
    }
}

void write_table(table *tab, FILE *fichier){
    int i;
    for(i = 0; i < tab->M; i++){
        write_list(tab->bucket[i], fichier);
    }
}

int size_table(table *tab){
    int i;
    int words = 0;
    link *ptr;
    for(i = 0; i < tab->M; i++){
        for (ptr = tab->bucket[i]; ptr != NULL; ptr = ptr->next) {
            words++;
        }
    }
    return words;
}