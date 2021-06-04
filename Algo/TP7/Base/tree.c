#include "tree.h"
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

node *create_node(int data) {
  node *n = (node *)malloc(sizeof(node));
  assert(n != NULL);
  n->data = data;
  n->left = NULL;
  n->right = NULL;
  return n;
}

void display_prefix_f(node *t){
  if (t){
    printf("%d ", t->data);
    display_prefix_f(t->left);
    display_prefix_f(t->right);
  }
}

void display_prefix(node *t){
  display_prefix_f(t);
  printf("\n");
}

void display_infix_f(node *t){
  if (t){
    display_infix_f(t->left);
    printf("%d ", t->data);
    display_infix_f(t->right);
  }
}

void display_infix(node *t){
  display_infix_f(t);
  printf("\n");
}

void display_suffix_f(node *t){
  if (t){
    display_suffix_f(t->left);
    display_suffix_f(t->right);
    printf("%d ", t->data);
  }
}

void display_suffix(node *t){
  display_suffix_f(t);
  printf("\n");
}

void free_tree(node *t){
  if(t){
    free_tree(t->left);
    free_tree(t->right);
    free(t);
  }
}

node *scan_tree(void){
  int data;
  /*printf("entrer un entier : ");*/
  scanf("%d", &data);
  if (data == 0){
    return NULL;
  }
  node *t = create_node(data);
  t->left = scan_tree();
  t->right = scan_tree();
  return t;
}

int count_nodes(node *t){
  if (t){
    return 1 + count_nodes(t->left) + count_nodes(t->right);
  }
  return 0;
}

int count_leaves(node *t){
  if (t){
    if (!t->left && !t->right){
      return 1;
    }
    return count_leaves(t->left) + count_leaves(t->right);
  }
  return 0;
}

int count_only_children(node *t){
  if (t){
    if ((!t->left && t->right) || (!t->right && t->left))
      return 1 + count_only_children(t->left) + count_only_children(t->right);
    else
      return count_only_children(t->left) + count_only_children(t->right);
  }
  return 0;
}

int max(int a, int b){
  if(a>b)
    return a;
  return b;
}

int height(node *t){
  if (t){
    return 1 + max(height(t->left), height(t->right));
  }
  return -1;
}