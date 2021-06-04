#include "tree.h"
#include "visualtree.h"
#include <stdio.h>

int main() {

  node *t = scan_tree();
  /*node *t = create_node(3);
  node *t1;
  t1 = create_node(5);
  node *t2;
  t2 = create_node(12);
  node *t3;
  t3 = create_node(1);
  node *t4;
  t4 = create_node(4);
  node *t5;
  t5 = create_node(2);
  node *t6;
  t6 = create_node(7);
  
  t->left = t1;
  t1->left = t2;
  t1->right = t3;
  t3->left = t4;
  t->right = t5;
  t5->right = t6;*/
  display_prefix(t);
  display_infix(t);
  display_suffix(t);

  write_tree(t);
  printf("count node = %d\ncount leaves = %d\ncount only children = %d\nheight = %d\n", count_nodes(t), count_leaves(t), count_only_children(t), height(t));
  free_tree(t);

  return 0;
}
