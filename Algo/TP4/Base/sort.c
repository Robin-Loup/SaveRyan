#include <stdio.h>
#include <stdlib.h>
#include "sort.h"

#include "array.h"

int nb_less = 0;
int nb_swap = 0;

int less(int a, int b) {
	nb_less++;
	return a < b;
	
}

void swap(int *a, int *b) {
	int tmp = *a;
	*a = *b;
	*b = tmp;
	nb_swap++;
}

void selection_sort(int t[], int size) {
	int i, j, min;
	for (i = 0; i < size; i++){
		min = i;
		for (j = i; j < size; j++){
			if (less(t[j], t[min])){
				min = j;
			}
		}
		swap(t+i, t+min);
	}
}

void insertion_sort(int t[], int size)	{
	int i, j;
	for (i = 0; i < size; i++){
		for (j = i; less(t[j], t[j-1]) && j > 0; j--){
			swap(&t[j-1], &t[j]);
		}	
	}
}

int partition(int t[],int lo,int hi) {
	int i = lo+1;
	int j = hi;
	while(1) {
		while(less(t[i], t[lo]) && i < hi)
		    i++;
		while(less(t[lo], t[j]) && j > lo)
            j--;
		if(i >= j)break;
		swap(&t[i], &t[j]);
		    i++;
		   	j--;
	}
	swap(&t[lo], &t[j]);
	return j;
}

void quick(int t[], int lo, int hi) {
	int pivot;
	if (lo < hi)
	{
		pivot = partition(t, lo, hi);
		quick(t, lo, pivot-1);
		quick(t, pivot+1, hi);
	}
}

void quick_sort(int t[], int size)	{
	quick(t, 0, size-1);
}



