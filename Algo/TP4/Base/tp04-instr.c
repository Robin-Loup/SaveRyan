#include <stdio.h>
#include <stdlib.h>

#include "array.h"
#include "sort.h"
#include <time.h>

#define MAX_VALUE 100
#define MAX_SIZE 10000

extern int nb_less;
extern int nb_swap;




int main(int argc, char *argv[]){
    srand(time(NULL));
    int* tab1 = NULL;
    int* tab2 = NULL;
    int* tab3 = NULL;

    int size;
	int max_value = MAX_VALUE;

    FILE *fichier = fopen("sort.dat", "w+");
	if (fichier != NULL)
	{
        for (size = 10; size <= MAX_SIZE; size+=100)
        {
            tab1 = create_array(size);
            tab2 = create_array(size);
            tab3 = create_array(size);
            fill_random_array(tab1, size, max_value);
            copy_array(tab1, tab2, size);
            copy_array(tab1, tab3, size);

            nb_less = 0;
            nb_swap = 0;

            selection_sort(tab1, size);
            fprintf(fichier, "\n%d %d", size, nb_less);

            nb_less = 0;
            nb_swap = 0;

            insertion_sort(tab2, size);
            fprintf(fichier, " %d", nb_less);

            nb_less = 0;
            nb_swap = 0;

            quick_sort(tab3, size);
            fprintf(fichier, " %d", nb_less);

            free(tab1);
            free(tab2);
            free(tab3);
        }
        /*printf("%d comparaisons\n", nb_less);
        printf("%d échanges\n", nb_swap);

		fprintf(fichier, "\n%d %d %d %d", size, 10, 20, 30);*/
		fclose(fichier);
	}

    

    return 0;
}