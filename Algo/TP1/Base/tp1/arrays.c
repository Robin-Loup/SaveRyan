#include "arrays.h"
#include <stdlib.h>

int *create_array(int max_size) {
    int *ptr = (int*)malloc(max_size*sizeof(int));
    return ptr;
}

void free_array(int t[]) {
    free(t);
}

/*
 * Write this function!
 */
void insert_unsorted(int t[], int *size, int elt) {
	t[*size] = elt;
	(*size)++;
}

/*
 * Write this function!
 */
int find_unsorted(int t[], int size, int elt) {
	int i;
	for (i = 0; i < size && t[i] != elt; i++);
	return i < size;
}

/*
 * Write this function!
 */
void insert_sorted(int t[], int *size, int elt) {

	int i;
	int j;
	for (i = 0; i < *size && t[i] < elt; i++);

	for (j = *size; j > i; j--)
	{
		t[j] = t[j-1];
	}

	t[i] = elt;
	(*size)++;
}

/*
 * Write this function!
 */
int find_sorted(int t[], int size, int elt) {
	if (size == 0)
		return 0;
	if (size == 1)
		return t[0] == elt;
	if (t[(size/2) -1] == elt)
		return 1;
	if (t[(size/2) - 1] > elt)
		return find_sorted(t, (size/2) -1, elt);
	if (t[size/2 -1] < elt)
		return find_sorted(t + ((size/2)), (size/2) + (size % 2), elt);
    return -1;
}
