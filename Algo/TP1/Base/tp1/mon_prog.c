#include <stdio.h>
#include <stdlib.h>
#include "arrays.h"

int main(int argc, char* argv[])
{
	int *t = create_array(10);
	printf("1coucou\n");

	int *size = (int*)malloc(sizeof(int));
	*size = 0;
	printf("2coucou\n");

	insert_sorted(t, size, 1);
	printf("3coucou\n");
	
	insert_sorted(t, size, 2);
	printf("4coucou\n");

	insert_sorted(t, size, 31);
	printf("5coucou\n");

	insert_sorted(t, size, 4);
	printf("6coucou\n");
	insert_sorted(t, size, 5);
        printf("6coucou\n");


	printf("size = %i\n", *size);
	printf("find = %i\n", find_sorted(t, *size, 5));
	
	free(size);
	free(t);
	return 0;
}
