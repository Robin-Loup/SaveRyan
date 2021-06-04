#include <stdio.h>
#include <stdlib.h>

void print_tab(char** tab, int size_x, int size_y){
    int i, j;
    for (i = 0; i < size_x; i++){
        for(j = 0; j < size_y -1; j++){
            printf("%c ", tab[i][j]);
        }
         printf("%c\n", tab[i][j]); 
    }
}
void free_tab(char** tab, int size){
    int i;
    for (i = 0; i < size; i++){
        free(tab[i]);
    }
    free(tab);
}

int main(int argc, char* argv[]){
    if (argc > 2){
        int i, j;
        int v = 0;
        int n = atoi(argv[1]);
        int m = atoi(argv[2]);
        char** tab = (char**)malloc(sizeof(char*) * n);
        for (i = 0; i < n; i++){
            char* tab1 = (char*)malloc(sizeof(char)* m);
            tab[i] = tab1;
            for (j = 0; j < m; j++){
                tab[i][j] = 'a' + (v %(('z'+1) - 'a'));
                v++; 
            }
        }
        print_tab(tab, n, m);
        free_tab(tab, n);
    }
    return 0;
}