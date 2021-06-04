#include "tree.h"
#include "visualtree.h"
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <time.h>

#define MAX_WORD_LENGTH 80

void display(node* t, char *str1, char *str2){
    if (t){
        if (less(str2, t->word)){
            display(t->left, str1, str2);
            return;
        }

        if (less(t->word, str1)){
            display(t->right, str1, str2);
            return;
        }

        display_infix_between(t, str1, str2);
    }
}

int main(int argc, char **argv){
    node* t = NULL;
    FILE *fin = fopen(argv[1], "r");
    if (fin == NULL) {
        fprintf(stderr, "Error opening file for reading: %s\n", argv[1]);
        return 1;
    }

    char *word = (char *)malloc(MAX_WORD_LENGTH*sizeof(char));
    while (fscanf(fin, "%s ", word) != -1) {
        t = insert_bst(t, word);
    }
    free(word);
    fclose(fin);

    /****AFFICHAGE LEXICOGRAPHIQUE****/
    display_infix(t);
    write_tree(t);

    display(t, "Old", "farm");

    free_tree(t);

    return 0;
}