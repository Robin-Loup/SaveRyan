#include "heap.h"
#include <stdlib.h>
#include <stdio.h>


heap *create_heap(int max){
    heap *h = (heap*)malloc(sizeof(heap));
    h->tree = (int*)malloc(sizeof(int)* max);
    h->size = 0;
    h->max = max;
    return h;
}


void free_heap(heap *h){
    free(h->tree);
    free(h);
}

void insert_heap(heap *h, int elt){
    int i;
    int swp;

    if (h->size + 1 > h->max){
        h->tree = (int*)realloc(h->tree, h->max * 2 * sizeof(int));
        h->max *= 2;
    }
    h->tree[h->size] = elt;
    i = h->size;
    h->size++;
    while (i > 0 && h->tree[i] < h->tree[(i-1)/2]){
        swp = h->tree[i];
        h->tree[i] = h->tree[(i-1)/2];
        h->tree[(i-1)/2] = swp;
        i = (i-1)/2;
    }
}

int is_heap(heap *h){
    int i;
    for (i = 0; i < h->size; i++){
        if (((2 * i) + 2 < h->size && (h->tree[(2 * i) + 2] < h->tree[i] || h->tree[(2 * i) + 1] < h->tree[i])) ||
         ((2 * i) + 1 < h->size && h->tree[(2 * i) + 1] < h->tree[i])){
            return 0;
         }
    }
    return 1;
}

int min_child(heap *h, int index){
    if((index * 2) + 1 < h->size){
        if ((index * 2) + 2 < h->size){
            if (h->tree[index * 2 + 1] < h->tree[index * 2 + 2])
                return (index * 2) + 1;
            else
                return (index * 2) + 2;
        }
        else
            return (index * 2) + 1;
    }
    return - 1;
}


int extract_min(heap *h){
    int swp;
    int val = h->tree[0];
    h->tree[0] = h->tree[h->size - 1];
    h->size--;
    int i = 0;
    int j = min_child(h, i);
    while(j != -1 && h->tree[i] > h->tree[j]){
        swp = h->tree[i];
        h->tree[i] = h->tree[j];
        h->tree[j] = swp;
        i = j;
        j = min_child(h, i);
    }

    return val;
}

void heapsort(int tab[], int size){
    int i;
    heap *h = create_heap(size);
    for(i = 0; i < size; i++){
        insert_heap(h,tab[i]);
    }
    for(i = size - 1; i >= 0; i--){
        tab[i] = extract_min(h);
    }
    free_heap(h);
}

void heapsort_2(int tab[], int size){
    int i;
    heap *h = (heap*)malloc(sizeof(heap));
    h->size = 0;
    h->max = size;
    h->tree = tab;
    for(i = 0; i < size; i++){
        insert_heap(h,tab[i]);
    }
    for(i = size - 1; i >= 0; i--){
        tab[i] = extract_min(h);
    }
    free(h);
}

void print_heap(heap *h){
    int i;
    for(i = 0; i < h->size; i++){
        printf("%d ", h->tree[i]);
    }
    printf("\n");
}