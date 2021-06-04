#include <stdlib.h>
#include <stdio.h>
#include "list.h"

#define MAX_WORD_LENGTH 80
#define NB_PACK 4096

unsigned hash(char *word){
    int i;
    unsigned val = 0;
    for(i = 0; word[i] != '\0'; i++){
        val+= word[i] * (i+1);
    }

    return val % NB_PACK;
}

/*List *read_file(FILE *fichier){
    int i;
    char *word = (char *)malloc(MAX_WORD_LENGTH*sizeof(char));
    List tab[NB_PACK];
    for(i = 0; i < NB_PACK; i++){
        tab[i] = NULL;
    }
    while (fscanf(fichier, "%s ", word) != -1) {
         printf("%d\n", hash(word));
        tab[hash(word)] = add_list(tab[hash(word)], word);
         printf("couou\n");
    }
   
    free(word);
    return tab;
}*/

int main(int argc, char **argv) {
    int i, size;
    FILE *fichier = fopen("Germinal.txt", "r");
    if (fichier == NULL) {
        fprintf(stderr, "Error opening file for reading: %s\n", "Germinal.txt");
        return 1;
    }

    List tab[NB_PACK];
    char *word = (char *)malloc(MAX_WORD_LENGTH*sizeof(char));
    for(i = 0; i < NB_PACK; i++){
        tab[i] = NULL;
    }
    while (fscanf(fichier, "%s ", word) != -1) {
        tab[hash(word)] = add_list(tab[hash(word)], word);
    }
   
    free(word);
    
    fclose(fichier);
    size = 0;
    
    for(i = 0; i < NB_PACK; i++){
        
        size += size_list(tab[i]);
        free_list(tab[i]);
    }
    
    printf("%d different words found in Germinal\n", size);


    return 0;
}