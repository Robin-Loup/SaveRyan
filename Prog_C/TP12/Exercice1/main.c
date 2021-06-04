#include <stdlib.h>
#include <stdio.h>
#include "list.h"

#define MAX_WORD_LENGTH 80

List read_file(FILE *fichier){
   char *word = (char *)malloc(MAX_WORD_LENGTH*sizeof(char));
   List lst = NULL;
    while (fscanf(fichier, "%s ", word) != -1) {
        lst = add_list(lst, word);
    }
    free(word);
    return lst;
}

int main(int argc, char **argv) {
    FILE *fichier = fopen("Germinal.txt", "r");
    if (fichier == NULL) {
        fprintf(stderr, "Error opening file for reading: %s\n", "Germinal.txt");
        return 1;
    }
    List lst = read_file(fichier);
    fclose(fichier);
    printf("%d different words found in Germinal\n", size_list(lst));
    free_list(lst);

    return 0;
}