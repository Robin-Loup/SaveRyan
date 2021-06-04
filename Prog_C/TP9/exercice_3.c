#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void print_str(char** tab, int size){
    int i;
    for (i = 0; i < size; i++){
        printf("%s\n", tab[i]);
    }
}

void free_str(char** tab, int size){
    int i;
    for (i = 0; i < size; i++){
        free(tab[i]);
    }
    free(tab);
}

int main(int argc, char* argv[]){
    int i;
    char** tab = (char**)malloc(sizeof(char*) * (argc - 1));
    for (i = 0; i < argc - 1; i++){
        char* tab1 = (char*)malloc(sizeof(char)* strlen(argv[i+1]));
        tab1 = strcpy(tab1, argv[i+1]);
        tab[i] = tab1;
    }
    print_str(tab, argc - 1);
    free_str(tab, argc - 1);
    return 0;
}