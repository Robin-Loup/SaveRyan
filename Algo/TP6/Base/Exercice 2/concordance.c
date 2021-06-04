#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "list.h"

#define MAX_WORD_LENGTH 80

link *read_text(FILE *infile) {
    int pos = 0;
    char *word = (char *)malloc(MAX_WORD_LENGTH*sizeof(char));
    link *lst = NULL;
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
    }

    free(word);
    return lst;
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

    link *lst = read_text(fin);
    fclose(fin);


    display_list(lst);
    printf("\n");
    int words = 0;
    int tot_words = 0;
    link *ptr;
    olink *pto;
    for (ptr = lst; ptr != NULL; ptr = ptr->next) {
        words++;
        for(pto = ptr->occurrences; pto!= NULL; pto = pto->next){
            tot_words++;
        }
        
    }

    printf("total number of distinct words = %d\n", words);
    printf("total number of  words = %d\n", tot_words);

    free_list(lst);

    return 0;
}