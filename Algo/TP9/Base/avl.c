#include "avl.h"
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <time.h>

int max(int a, int b){
    if( a>b)
        return a;
    return b;
}

int min(int a, int b){
    if( a>b)
        return b;
    return a;
}

node *create_node(int elt) {
    node *n = (node *)malloc(sizeof(node));
    assert(n != NULL);
    n->elt = elt;
    n->height = 0;
    n->left = NULL;
    n->right = NULL;
    return n;
}

void free_tree(node *t) {
    if (t != NULL) {
        free_tree(t->left);
        free_tree(t->right);
        free(t);
    }
}

/* SEARCH */

node *find_avl(node *t, int elt) {
    node *ptr = t;
    while (ptr != NULL && ptr->elt != elt) {
        if (ptr->elt > elt)
            ptr = ptr->left;
        else
            ptr = ptr->right;
    }
    return ptr;
}

void update_height(node *t){
    if (t){
        /*update_height(t->left);
        update_height(t->right);*/
        if (t->left){
            if (t->right){
                t->height = max(t->left->height, t->right->height) + 1;
            }
            else
                t->height = t->left->height + 1;
        }
        else if (t->right){
            t->height = t->right->height + 1;
        }
        else
            t->height = 0; 
    }
}

node *rotate_right(node *t){
    node *tmp = t->left;
    t->left = tmp->right;
    tmp->right = t;
    update_height(t);
    update_height(tmp);
    return tmp;
}

node *rotate_left(node *t){
    node *tmp = t->right;
    t->right = tmp->left;
    tmp->left = t;
    update_height(t);
    update_height(tmp);
    return tmp;
}

node *rotate_left_right(node *t){
    t->left= rotate_left(t->left);
    return rotate_right(t);
}

node *rotate_right_left(node *t){
    t->right = rotate_right(t->right);
    return rotate_left(t);
}

int compute_balance(node *t){
    if (!t->left){
        if (!t->right)
            return 0;
        else
            return 0- t->right->height;
    }

    if (!t->right){
        return t->left->height;
    }
    return t->left->height - t->right->height;
}

node *rebalance(node *t){
    int balance = compute_balance(t);
    if (balance < -1){
        if (compute_balance(t->right) == 1){
            return rotate_right_left(t);
        }
        else
            return rotate_left(t);
    }
    if (balance > 1){
        if (compute_balance(t->left) == -1){
            return rotate_left_right(t);
        }
        else
            return rotate_right(t);
    }

    return t;
}

node *insert_avl(node *t, int elt){
    if (!t){
        return create_node(elt);
    }

    if (t->elt == elt){
        return t;
    }

    if (t->elt > elt){
        t->left = insert_avl(t->left, elt);
        t = rebalance(t);
        update_height(t);
        return t;
    }

    t->right = insert_avl(t->right, elt);
    t = rebalance(t);
    update_height(t);
    return t;
}

int height(node *t){
  if (t){
    return (1 + max(height(t->left), height(t->right)));
  }
  return -1;
}

int is_avl(node *t){
    if (!t)
        return 1;
    if (height(t) == t->height &&
        compute_balance(t) > -2 &&
        compute_balance(t) < 2){
        return min(is_avl(t->left), is_avl(t->right));
    }
    printf("node = %d\n", t->elt);
    printf("height %d : %d; balance = %d\n",height(t), t->height, compute_balance(t));
    return 0;
}

double chrono(node *t, int n){
  int i;
  srand(time(NULL));
  clock_t begin = clock();
  for(i = 0; i < n; i++){
     t = insert_avl(t, rand() % (2*n));
  }

  clock_t end = clock();
  return (end - begin) / CLOCKS_PER_SEC;
}

double chrono_ordre(node *t, int n){
  int i;
  clock_t begin = clock();
  for(i = 1; i <= n; i++){
     t = insert_avl(t, i);
  }

  clock_t end = clock();
  return (end - begin) / CLOCKS_PER_SEC;
}