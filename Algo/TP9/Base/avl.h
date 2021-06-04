#ifndef AVL_H
#define AVL_H

typedef struct _node {
    int elt;                 /* donnee stockee : un entier  */
    int height;              /* la hauteur de l'arbre       */
    struct _node *left;      /* pointeur sur le fils gauche */
    struct _node *right;     /* pointeur sur le fils droit  */
} node;

node *create_node(int elt);

void free_tree(node *t);

int is_avl(node *t);

node *find_avl(node *t, int elt);

node *insert_avl(node *t, int elt);

node *remove_avl(node *t, int elt);

int is_avl(node *t);

double chrono_ordre(node *t, int n);

double chrono(node *t, int n);

#endif /* AVL_H */
