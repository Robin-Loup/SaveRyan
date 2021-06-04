#include <stdio.h>
#include <stdlib.h>

void print_tab(int* tab, int size){
    int i;
    for (i = 0; i < size-1; i++){
        printf("%d ", tab[i]);
    }
    printf("%d\n", tab[i]);
}

int main(int argc, char* argv[]){
    if (argc > 1){
        int i;
        int n = atoi(argv[1]);
        int* tab = (int*)malloc(sizeof(int) * n);
        for (i = 1; i <= n; i++){
            tab[i-1] = i;
        }
        print_tab(tab, n);
        free(tab);
    }
    return 0;
}