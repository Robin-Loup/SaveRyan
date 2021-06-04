#include "tree.h"
#include "visualtree.h"
#include <stdio.h>
#include <assert.h>
#include <time.h>

int main(){
    /*node *t = scan_tree();
    int i;
    for( i = 0; i < 100; i++){
        if (find_bst(t,i)){
            printf("%d ", i);
        }
    }
    printf("\n");
    write_tree(t);

    t = insert_bst(t, 2);
    t = insert_bst(t, 15);
    write_tree(t);*/
    
    
    char ch;
    int data;
    node *t = NULL;
    printf("1. construire un nouvel arbre à partir d'une suite d'entiers (`s 7 5 0 0 12 10 0 0 0')\n");
    printf("2. construire un arbre avec un nombre d'entiers aléatoires : (a 500')\n");
    printf("3. insérer un élément dans l'arbre (`i 18')\n");
    printf("4. faire une recherche dans l'arbre (`f 42')\n");
    printf("5. afficher les entiers de l'arbre triés en ordre croissant (t)\n");
    printf("6. eleminer une elment (r 42)\n");
    printf("7. terminer le programme (q)\n");
    scanf(" %c", &ch);
    while(ch != 'q'){
        {
            if (ch =='s'){
                free_tree(t);
                t = scan_tree();
            }

            if (ch == 'a'){
                free_tree(t);
                scanf("%d", &data);
                t = tree_alea(data);
            }

            if (ch == 'i'){
                scanf("%d", &data);
                t = insert_bst(t, data);
            }

            if (ch == 'f'){
                scanf("%d", &data);
                if (find_bst(t, data))
                    printf("Trouvé\n");
                else
                    printf("Pas Trouvé\n");
            }

            if (ch == 't'){
                display_infix(t);
            }
            if (ch == 'r'){
                scanf("%d", &data);
                t = remove_bst(t, data);
            }
        }
        printf("1. construire un nouvel arbre à partir d'une suite d'entiers (`s 7 5 0 0 12 10 0 0 0')\n");
        printf("2. construire un arbre avec un nombre d'entiers aléatoires : (a 500')\n");
        printf("3. insérer un élément dans l'arbre (`i 18')\n");
        printf("4. faire une recherche dans l'arbre (`f 42')\n");
        printf("5. afficher les entiers de l'arbre triés en ordre croissant (t)\n");
        printf("6. eleminer une elment (r 42)\n");
        printf("7. terminer le programme (q)\n");
        scanf(" %c", &ch);
    }
    free_tree(t);

    /****Chrono****/
    /*node *t = NULL;
    printf("%f\n", chrono(t, 8000000));         8.10⁶ elements
    printf("%f\n", chrono_ordre(t, 75000));     7,5.10⁴ elements
    */

    /****test****/
    /*node *t = NULL;
    t = tree_alea(500);
    int i, random;
    srand(time(NULL));
    for(i = 0; i < 200; i++){
        random = rand() % (999);
    }
    write_tree(t);*/

    return 0;
}