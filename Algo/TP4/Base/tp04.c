#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#include "array.h"
#include "sort.h"

#define MAX_VALUE 10
#define MAX_SIZE 15

clock_t timer(clock_t start) {
    clock_t diff = clock()-start;
    int msec = diff*1000/CLOCKS_PER_SEC;
    printf("time: %d ms\n", msec);
    return diff;
}

int compare(const void *a,const void *b)
{
  int aint = *(int*)a;
  int bint = *(int*)b;
  if (aint == bint)
    return 0;
  else
    if (aint < bint)
      return -1;
    else
      return 1;
}

int main(int argc, char *argv[]) {

	srand(time(NULL));

	int size = MAX_SIZE;
	int max_value = MAX_VALUE;
	
	clock_t start, total;
	int msec;
	total = 0;

	/* tableau de travail */
	int* tab = NULL;
	int* tab2 = NULL;

	/* allocation et initialisation du tableau avec des valeurs aléatoires */
	tab = create_array(size);
	fill_random_array(tab, size, max_value);

	print_array(tab, size);

	tab2 = create_array(size);
	copy_array(tab, tab2, size);

	/* tri du tableau */
	/*start = clock();
	selection_sort(tab, size);
	total += timer(start);
	msec = total*1000/CLOCKS_PER_SEC;
    printf("total time (selection_sort): %d ms\n\n", msec);*/

	/*start = clock();
	qsort(tab2, size, sizeof(int), compare);
	total += timer(start);
	msec = total*1000/CLOCKS_PER_SEC;
    printf("total time (qsort): %d ms\n\n", msec);*/

	start = clock();
	insertion_sort(tab, size);
	total += timer(start);
	msec = total*1000/CLOCKS_PER_SEC;
    printf("total time (insertion_sort): %d ms\n\n", msec);

	print_array(tab, size);

	start = clock();
	quick_sort(tab2, size);
	total += timer(start);
	msec = total*1000/CLOCKS_PER_SEC;
    printf("total time (quick_sort): %d ms\n\n", msec);

	print_array(tab2, size);

    
	
	/* libération du tableau */
	free(tab);
	free( tab2);
	tab = NULL;

	return EXIT_SUCCESS;
}
