#ifndef TREE_H
#define TREE_H

typedef struct _node {
    char *word;                /* data stored : an integer    */
    struct _node *left;      /* pointer to the left child   */
    struct _node *right;     /* pointer to the right child  */
} node;

/*
 * Allocate memory for a new node.
 */
node *create_node(char *word);

void display_prefix(node *t);

void display_infix(node *t);

void display_suffix(node *t);

void free_tree(node *t);

int count_nodes(node *t);

int count_leaves(node *t);

int count_only_children(node *t);

int height(node *t);

node *insert_bst(node *t, char *word);

node *extract_min_bst(node *t, node **min);

int equal(char *s1, char *s2);

int less(char *s1, char *s2);

void display_infix_between(node *t, char *str1, char *str2);

#endif /* TREE_H */
