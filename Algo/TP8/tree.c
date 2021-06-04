#include "tree.h"
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <time.h>

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

node *find_bst(node *t, int elt){
  if (!t){
    return NULL;
  }

  if (t->data == elt){
    return t;
  }
  if (t->data > elt){
    return find_bst(t->left, elt);
  }

  return find_bst(t->right, elt);
}

node *insert_bst(node *t, int elt){
  if (!t){
    return create_node(elt);
  }

  if (t->data == elt){
    return t;
  }

  if (t->data > elt){
    t->left = insert_bst(t->left, elt);
    return t;
  }

  t->right = insert_bst(t->right, elt);
  return t;
}

node *tree_alea(int val){
  node *t = NULL;
  int i, random;
  srand(time(NULL));
  for(i = 0; i < val; i++){
    random = rand() % (2*val);
    if (!find_bst(t, random)){
      t = insert_bst(t, random);
    }
    else
      i--;
  }
  return t;
}

double chrono(node *t, int n){
  int i;
  srand(time(NULL));
  clock_t begin = clock();
  for(i = 0; i < n; i++){
     t = insert_bst(t, rand() % (2*n));
  }

  clock_t end = clock();
  return (end - begin) / CLOCKS_PER_SEC;
}

double chrono_ordre(node *t, int n){
  int i;
  clock_t begin = clock();
  for(i = 1; i <= n; i++){
     t = insert_bst(t, i);
  }

  clock_t end = clock();
  return (end - begin) / CLOCKS_PER_SEC;
}

node *extract_min_bst(node *t, node **min){
  if (!t){
    min = NULL;
    return NULL;
  }
  if (t->left){
    t = extract_min_bst(t->left, min);
    return t;
  }
  else{
    *min = t;
    return t->right;
  }
}

node *remove_bst(node *t, int elt){
  if (t){
    if (t->data > elt){
      t->left = remove_bst(t->left, elt);
    }
    else if (t->data < elt){
      t->right = remove_bst(t->right, elt);
    }
    else{
      node *left = t->left;
      node *right = t->right;
      free(t);
      if(!left)
        return right;
      if(!right)
        return left;
      node *succ;
      right = extract_min_bst(right, &succ);
      succ->left = left;
      succ->right = right;
      t = succ;
    }
  }
  return t;
}