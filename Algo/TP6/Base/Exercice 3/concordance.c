#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "list.h"
#include "table.h"

#define MAX_WORD_LENGTH 80

table *read_text(FILE *infile) {
    int pos = 0;
    char *word = (char *)malloc(MAX_WORD_LENGTH*sizeof(char));
    /*link *lst = NULL;
    link *tmp = NULL;
    while (fscanf(infile, "%s ", word) != -1) {
        pos++;
        tmp = find_list(lst, word);
        if (tmp == NULL){
            lst = insert_first_list(lst, word);
            add_occurrence(lst, pos);
        }
        else
            add_occurrence(tmp, pos);
    }*/

    table *tab = create_table(50);

    while (fscanf(infile, "%s ", word) != -1) {
        pos++;
        add_occ_table(tab, word, pos);
    }

    free(word);
    /*return lst;*/
    return tab;
}

int main(int argc, char **argv) {

    if (argc < 2) {
        fprintf(stderr, "Usage: concordance <in_file>\n");
        return 1;
    }

    FILE *fin = fopen(argv[1], "r");
    if (fin == NULL) {
        fprintf(stderr, "Error opening file for reading: %s\n", argv[1]);
        return 1;
    }

    /*link *lst = read_text(fin);*/
    table *tab = read_text(fin);
    fclose(fin);

    FILE *fichier = fopen(argv[2], "w");
    if (fichier == NULL) {
        fprintf(stderr, "Error opening file for writing: %s\n", argv[2]);
        return 1;
    }

    write_table(tab, fichier);

    fclose(fichier);
    /*display_list(lst);*/
    display_table(tab);
    printf("\n");
    int words = size_table(tab);
    int tot_words = tab->size;
    /*link *ptr;
    olink *pto;
    for (ptr = lst; ptr != NULL; ptr = ptr->next) {
        words++;
        for(pto = ptr->occurrences; pto!= NULL; pto = pto->next){
            tot_words++;
        }
        
    }*/

    /*int i;
    link *ptr;
    for(i = 0; i < tab->M; i++){
        for (ptr = tab->bucket[i]; ptr != NULL; ptr = ptr->next) {
            words++;
        }
    }*/

    printf("total number of distinct words = %d\n", words);
    printf("total number of  words = %d\n", tot_words);

    /*free_list(lst);*/
    free_table(tab);

    return 0;
}