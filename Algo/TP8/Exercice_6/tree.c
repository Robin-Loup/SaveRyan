#include "tree.h"
#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include <time.h>

int equal(char *s1, char *s2) {
    return strcmp(s1, s2) == 0;
}

int less(char *s1, char *s2) {
    return strcmp(s1, s2) < 0;
}

node *create_node(char *word) {
    node *new_node = (node *)malloc(sizeof(node));
    new_node->left = NULL;
    new_node->right = NULL;
    new_node->word = (char *)malloc((strlen(word)+1)*sizeof(char));
    strcpy(new_node->word, word);
    return new_node;
}

void display_prefix_f(node *t){
  if (t){
    printf("%s ", t->word);
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
    printf("%s ", t->word);
    display_infix_f(t->right);
  }
}

void display_infix(node *t){
  display_infix_f(t);
  printf("\n");
}

void display_infix_f_between(node *t, char *str1, char *str2){
  if (t){
    if(less(str1,t->word))
      display_infix_f_between(t->left, str1, str2);
    if (less(str1,t->word) && less(t->word, str2))
    printf("%s ", t->word);
    if(less(t->word, str2))
      display_infix_f_between(t->right, str1, str2);
  }
}

void display_infix_between(node *t, char *str1, char *str2){
  display_infix_f_between(t, str1, str2);
  printf("\n");
}

void display_suffix_f(node *t){
  if (t){
    display_suffix_f(t->left);
    display_suffix_f(t->right);
    printf("%s ", t->word);
  }
}

void display_suffix(node *t){
  display_suffix_f(t);
  printf("\n");
}

void free_tree(node *t){
  if(t){
    free(t->word);
    free_tree(t->left);
    free_tree(t->right);
    free(t);
  }
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

node *insert_bst(node *t, char* word){
  if (!t){
    return create_node(word);
  }

  if (equal(t->word, word)){
    return t;
  }

  if (less(word, t->word)){
    t->left = insert_bst(t->left, word);
    return t;
  }
  t->right = insert_bst(t->right, word);
  return t;
}
