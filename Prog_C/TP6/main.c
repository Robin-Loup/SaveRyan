#include <stdio.h>
#include <stdlib.h>
#define N 10

int* init_tab()
{
  int* buffer = malloc(sizeof(int) * N);
  int i;
  for (i = 0; i<N; i++){
    buffer[i] = 0;
  }
  return buffer;
}

void print_tab(int buffer[]){
  int i;
  printf("[");
  for (i = 0; i < N - 1; i++){
    printf("%i, ", buffer[i]);
  }
  printf("%i]\n", buffer[i]);
}

void permutations(int buffer[], int current, int max)
{
  int i;
  if (current > max){
    print_tab(buffer);
  }
  else
  {
    for (i = 0; i < N; i++){
      if (buffer[i] == 0){
        buffer[i] = current;
        /*print_tab(buffer);*/
        permutations(buffer, current +1, max);
        buffer[i] = 0;
      }
    }
  }
  
}

int main(/*int argc, char* argv[]*/){
  int* buffer = init_tab();
  permutations(buffer, 1, N);
  
  free(buffer);
  return 0;
}