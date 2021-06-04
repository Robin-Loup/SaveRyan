#ifndef TREE_H
#define TREE_H

typedef struct _node {
    int data;                /* data stored : an integer    */
    struct _node *left;      /* pointer to the left child   */
    struct _node *right;     /* pointer to the right child  */
} node;

/*
 * Allocate memory for a new node.
 */
node *create_node(int data);

void display_prefix(node *t);

void display_infix(node *t);

void display_suffix(node *t);

void free_tree(node *t);

node *scan_tree(void);

int count_nodes(node *t);

int count_leaves(node *t);

int count_only_children(node *t);

int height(node *t);

node *find_bst(node *t, int elt);

node *insert_bst(node *t, int elt);

node *tree_alea(int val);

double chrono(node *t, int n);

node *extract_min_bst(node *t, node **min);

node *remove_bst(node *t, int elt);

double chrono_ordre(node *t, int n);

#endif /* TREE_H */
