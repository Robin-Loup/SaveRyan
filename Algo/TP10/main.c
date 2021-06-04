#include "heap.h"
#include <stdio.h>
#include <time.h>
#include <stdlib.h>

#include "array.h"
#include "sort.h"

#define MAX_VALUE 100
#define MAX_SIZE 500000

clock_t timer(clock_t start) {
    clock_t diff = clock()-start;
    /*int sec = diff/CLOCKS_PER_SEC;*/
    /*printf("time: %ld ms\n", diff);*/
    return diff;
}

int main(){

    srand(time(NULL));

	int size = MAX_SIZE;
	int max_value = MAX_VALUE;
	
	clock_t start, total;
	double sec;
	total = 0;

    /* tableau de travail */
	int* tab = NULL;
	int* tab2 = NULL;


    /*start = clock();
	heapsort(tab, size);
	total += timer(start);
	sec = total/CLOCKS_PER_SEC;
    printf("total time (insertion_sort): %d s\n\n", sec);

    start = clock();
	quick_sort(tab2, size);
	total += timer(start);
	sec = total/CLOCKS_PER_SEC;
    printf("total time (quick_sort): %d s\n\n", sec);*/

    FILE *fichier = fopen("sort.dat", "w+");
	if (fichier != NULL)
	{
        for (size = 10; size <= MAX_SIZE; size+=100)
        {
            tab = create_array(size);
            tab2 = create_array(size);
            fill_random_array(tab, size, max_value);
            copy_array(tab, tab2, size);

            total = 0;
            start = clock();
	        heapsort(tab, size);
	        total += timer(start);
	        sec = total/1000;
            /*printf("total time (heapsort_sort): %d s\n\n", sec);*/
            fprintf(fichier, "\n%d %f", size, sec);

            total = 0;
            start = clock();
	        quick_sort(tab2, size);
	        total += timer(start);
	        sec = total/1000;
            /*printf("total time (quick_sort): %d s\n\n", sec);*/
            fprintf(fichier, " %f", sec);

        
            free(tab);
            free(tab2);
        }
    }
    fclose(fichier);


    /*heap *h = create_heap(20);
    insert_heap(h, 10);
    print_heap(h);
    insert_heap(h, 20);
    insert_heap(h, 5);
    insert_heap(h, 15);
    print_heap(h);
    printf("is heap %d\n", is_heap(h));
    printf("min = %d\n", extract_min(h));

    int tab[9] = {1,4,7,8,9,6,3,2,5};
    heapsort(tab, 9);
    int i;
    for(i = 0; i < 9; i++){
        printf("%d ",tab[i]);
    }
    printf("\n");*/
    return 0;
}