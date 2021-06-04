#include <stdio.h>
#include <stdlib.h>

#include "sudoku.h"


void initialize_empty_board(Board grid){

}

void print_ligne(){
    printf("-------------------------------------\n");
}

void print_board(Board grid){
    int x;
    int y;
    print_ligne();
    for (x = 0; x < 9; x++){
        for (y = 0; y < 9; y++){
            printf("| %i ", grid[x][y]);
        }
        printf("|\n");
        print_ligne();
    }
}

int elem_valide(Board grid,int height, int width){
  int i;
  int j;
  /*longueur*/
  for (i = 0; i < 9; i++){
    if (i != height && grid[i][width] == grid[height][width]){
      return 0;
    }
  }
  /*largeur*/
  for (i = 0; i < 9; i++){
    if (i != width && grid[height][i] == grid[height][width]){
      return 0;
    }
  }

  /*carré*/
  for (i = 0; i < 3; i++){
    for (j = 0; j < 3; j++){
      if (i + (height/3)*3 != height && j + (width/3)*3 != width &&
       grid[i+(height/3)*3][j+(width/3)*3] == grid[height][width]){
        return 0;
      }
    }
  }
  return 1;
}

void parcourir(Board grid, int *height, int *width){
  int i, j;
  *height = -1;
  *width = -1;
  for(i = 0; i < 9; i++)
  {
    for (j = 0; j < 9; j++)
    {
      /*printf("height = %i; width = %i;\n", i, j);*/
      if (grid[i][j] == 0)
      {
        *height = i;
        *width = j;
        /*printf("height = %i; width = %i;\n", *height, *width);*/
        return;
      }
    }
  }
  
}

void add_elem(Board grid){
  int *height = (int*)malloc(sizeof(int));
  int *width = (int*)malloc(sizeof(int));
  int i;

  parcourir(grid, height, width);
  /*printf("height1 = %i; width1 = %i;\n", *height, *width);*/
  /*printf("\n");*/
  if (*height != -1 && *width != -1)
  {
    for (i = 1; i < 10; i++)
    {
      grid[*height][*width] = i;
      
      if (elem_valide(grid, *height, *width) == 1)
      {
        /*print_board(grid);
        printf("height1 = %i; width1 = %i;\n", *height, *width);*/
        /*printf("oui\n");*/
        add_elem(grid);
        grid[*height][*width] = 0;
      }
      else
      {
        grid[*height][*width] = 0;
      }
    }
  }
  else
  {
    print_board(grid);
    printf("fini\n");
  }
}

void solver(Board grid){
    add_elem(grid);
    /*printf("\n");
    print_board(grid);
    printf("end\n");*/
}

