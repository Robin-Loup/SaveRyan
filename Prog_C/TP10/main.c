#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define N 10


/*EXERCICE 1*/
void swap_mem(void* z1, void* z2, size_t size){
    /*size_t i;
    char* tmp = malloc(sizeof(char));
    char* a;
    char *b;
    int type = sizeof(z1);
    printf("%x\n", type);
    a = (char*)z1;
    b = (char*)z2;
    
    for (i = 0; i < size; i++){
        *tmp = a[i];
        a[i] = b[i];
        b[i] = *tmp;
    }

    free(tmp);*/

    unsigned char tmp;
    unsigned char *a = z1, *b = z2;
    while(size--) {
        tmp = *a;
        *a++ = *b;
        *b++ = tmp;
        }
}

int* init_tab(int sens)
{
  int* buffer = malloc(sizeof(int) * N);
  int i;
  for (i = 0; i<N; i++){
      if (sens == '+'){
        buffer[i] = i;
      }
      else{
          buffer[i] = N-i;
      }
    
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

void print_tab_char(char buffer[]){
  int i;
  printf("[");
  for (i = 0; i < 3 - 1; i++){
    printf("%c, ", buffer[i]);
  }
  printf("%c]\n", buffer[i]);
}



/*EXERCICE 2*/
typedef struct cell {
  char* first_name ;
  char* last_name ;
  int age ;
  struct cell* next ;
} Cell , *List ;

Cell* allocate_cell(char* first, char* last, int age){
  Cell* cell;
  char* first_name = (char*)malloc(sizeof(char) * 50);
  char* last_name = (char*)malloc(sizeof(char) * 50);
  cell = (Cell*)malloc(sizeof(Cell));
  strcpy(first_name, first);
  strcpy(last_name, last);
  cell->first_name = first_name;
  cell->last_name = last_name;
  cell->age = age;
  cell->next = NULL;
  return cell;
}

void free_list(List l){
  if (l != NULL){
    free_list(l->next);
    l->age = 0;
    l->first_name = NULL;
    l->last_name = NULL;
    free(l);
  }
}

int age_order(Cell* p1, Cell* p2){
  return p1->age < p2->age;
}

int name_order(Cell* p1, Cell* p2){
  int i;
  /*First_name*/
  for (i = 0; p1->first_name[i] != '\0'; i++){
    if (p2->first_name[i] == '\0' || p1->first_name[i] > p2->first_name[i]){
      return 0;
    }
    if (p1->first_name[i] < p2->first_name[i]){
      return 1;
    }
  }
  /*Last_name*/
  for (i = 0; p1->last_name[i] != '\0'; i++){
    if (p2->last_name[i] == '\0' || p1->last_name[i] > p2->last_name[i]){
      return 0;
    }
    if (p1->last_name[i] < p2->last_name[i]){
      return 1;
    }
  }
  return 0;
}

void ordered_insertion(List* l, Cell* new, int order_func(Cell*, Cell*)){
  if (*l == NULL){
    *l = new;
  }
  else if(order_func(*l, new) == 0){
    new->next = *l;
    *l = new;
  }

  else{
    if ((*l)->next == NULL){
      (*l)->next = new;
    }
    else {
      ordered_insertion(&((*l)->next), new, order_func);
    }
  }
}

void print_list(List l){
  if(l != NULL){
    Cell* actuel = l;
    while (actuel != NULL){
      printf("First name: %s Last name: %s Age: %d\n", actuel->first_name, actuel->last_name, actuel->age);
      actuel =  actuel->next;
    }   
  }
}

int main(/*int argc, char* argv[]*/){
  /*int* buffer1 = init_tab('+');
  int* buffer2 = init_tab('-');

  char * buffer3 = malloc(sizeof(char)*3);
  char * buffer4 = malloc(sizeof(char)*3);
  buffer3[0] ='1';
  buffer3[1] ='2';
  buffer3[2] ='3';

  
  buffer4[2] ='1';
  buffer4[1] ='2';
  buffer4[0] ='3';

  print_tab(buffer1);
  print_tab(buffer2);
  swap_mem(buffer1, buffer2, N);
  print_tab(buffer1);
  print_tab(buffer2);

  print_tab_char(buffer3);
  print_tab_char(buffer4);
  swap_mem(buffer3, buffer4, N);
  print_tab_char(buffer3);
  print_tab_char(buffer4);*/

  char* first;
  char* last;
  int* age;
  List* l;
  Cell* tmp;
  FILE *fichier;

  first = (char*)malloc(sizeof(char)*50);
  last = (char*)malloc(sizeof(char)*50);
  age = (int*)malloc(sizeof(int));
  l = (List*)malloc(sizeof(List));
 
  if ((fichier = fopen("liste_nom.txt", "r")) == NULL)
  {
    fprintf(stderr,"Impossible d'ouvrir le fichier\n");
    exit(1);
  }

  if(fscanf(fichier,"%s %s %d",first, last, age) != EOF){
    *l = allocate_cell(first, last, *age);
    tmp = *l;
    /*print_list(*l);*/
  }

  while(fscanf(fichier,"%s %s %d",first, last, age) != EOF){
    tmp = allocate_cell(first, last, *age);
    /*printf("%s %s %d\n", tmp->first_name, tmp->last_name, tmp->age);*/
    ordered_insertion(l, tmp, name_order);
  
    /*tmp->next = allocate_cell(first, last, *age);
    tmp = tmp->next;*/
  }
  print_list(*l);
  free_list(*l);
  fclose(fichier);
  free(first);
  free(last);
  free(age);
  free(l);
  return 0;
}