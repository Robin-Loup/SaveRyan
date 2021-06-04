#include "avl.h"
#include "visualtree.h"
#include <stdio.h>
#include <stdlib.h>

int main() {

    node *t = NULL;
    int i;
    for (i = 0; i < 100; i++) {
        t = insert_avl(t, i);
        if (!is_avl(t)) {
            printf("The tree is not balanced\n");
            break;
        }
    }
    printf("Ok!\n");
    write_tree(t);
    free_tree(t);

    t = NULL;
    printf("%f\n", chrono(t, 6000000)); /* 6 * 10⁶*/
    free_tree(t);

    t = NULL;
    printf("%f\n", chrono_ordre(t, 30000000)); /* 3 * 10⁷*/
    free_tree(t);

    return 0;
}
