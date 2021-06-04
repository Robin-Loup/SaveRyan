#include <stdio.h>

#include "sudoku.h"
#include "in_out.h"

int main(int argc, char* argv[]){
  Board B;
  /*int i;*/

  fread_board(argv[1], B);

  print_board(B);
  printf("\n");
  solver(B);

  /*for (i = 0; i < 9; i++){
    printf("%i\n", i/3);
  }*/


  return 0;
}
