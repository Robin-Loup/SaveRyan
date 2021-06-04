#include <stdio.h>
#include <stdlib.h>

/* Allocate memory for an array which can contain `size`
   integers. The returned C array has memory for an extra last
   integer labelling the end of the array. */
int* allocate_integer_array(int size){
  int* new_tab;

  new_tab = (int*)malloc((size+1)*sizeof(int));
  if (new_tab == NULL){
    fprintf(stderr, "Memory allocation error\n");
    return NULL;
  }
  return new_tab;
}

/* Free an integer array */
void free_integer_array(int* tab){
  free(tab);
}

/*-----------EXERCICE 1-----------*/

int array_size(int* array){
	int compteur = 0;
	int* tmp = array;
	if (array == NULL)
		return compteur;
	while (*tmp != -1)
	{
		tmp++;
		compteur++;
	}
	return compteur;
}

void print_array(int* array){
	int* tmp = array;
	if (array != NULL)
	{
		printf("(");
		while (*tmp != -1 && *(tmp+1) != -1)
		{
			printf("%d, ", *tmp);
			tmp++;
		}
		if (*tmp != -1)
			printf("%d", *tmp);
		printf(")\n");
	}
}

int are_arrays_equal(int* first, int* second){
	int inc = 0;
	while (*(first + inc) != -1 && *(second + inc) != -1 && *(first + inc) == *(second + inc))
	{
		inc++;
	}
	if (*(first + inc) == -1 && *(second + inc) == -1)
		return 1;
	else
		return 0;
}

int* copy_array(int* array){
	int* copy;
	int compteur = 0;
	if (array == NULL)
		return NULL;
	else
	{
		copy = allocate_integer_array(array_size(array));
		while(*(array + compteur) != -1)
		{
			*(copy + compteur) =*(array + compteur);
			/*printf( "%i\n", *(copy + compteur));*/
			compteur++;
		}
		*(copy + compteur) = -1;
		return copy;
	}
}
/*-----------EXERCICE 2-----------*/

int* fill_array(void){
	int* table;
	int size;
	int compteur;
	int val;
	printf("ENTRER UNE TAILLE\n");
	scanf("%d", &size);
	table = allocate_integer_array(size);
       for (compteur = 0; compteur < size; compteur++)
       {
	       printf("ENTRER UNE VALEUR\n");
	       scanf("%d", &val);
	       /*printf( "%i\n", val);*/
	       *(table + compteur) = val;
       }	       
       *(table + size) = -1;
       return table;
}

int* random_array(int size, int max_entry){
        int* table;
        int compteur;

        table = allocate_integer_array(size);
       for (compteur = 0; compteur < size; compteur++)
       {
			/*printf( "%i\n", val);*/
			*(table + compteur) = rand() % (max_entry + 1);
       }
       *(table + size) = -1;
       return table;
}

int* concat_array(int* first, int* second){
	int* table;
	int compteur1;
	int compteur2;
	int size = array_size(first) + array_size(second);
	
	table = allocate_integer_array(size);
	for (compteur1 = 0; compteur1 < array_size(first); compteur1++)
	{
		*(table + compteur1) = *(first + compteur1);
	}
	for (compteur2 = 0; compteur2 < array_size(second); compteur2++)
	{
		*(table + compteur1 + compteur2) = *(second + compteur2);
	}
	*(table + compteur1 + compteur2) = -1;
	return table;


}

/*-----------EXERCICE 3-----------*/

int* merge_sorted_arrays(int* first, int* second){
	int* table;
	int compteur1 = 0;
	int compteur2 = 0;
	int size = array_size(first) + array_size(second);
	/*printf("%i\n", size);*/
	table = allocate_integer_array(size);
	while (compteur1 + compteur2 < size)
	{
		if ((*(first + compteur1) < *(second + compteur2) && *(first + compteur1) != -1) || *(second + compteur2) == -1)
		{
			*(table + compteur1 + compteur2) = *(first + compteur1);
			compteur1++;
		}
		else
		{
			*(table + compteur1 + compteur2) = *(second + compteur2);
			compteur2++;

		}
	}	
	*(table + compteur1 + compteur2) = -1;
	return table;
}

void split_arrays(int* array, int** first, int** second){
	int compteur;
	int compteur2;

	*first = allocate_integer_array(array_size(array)/2);
	*second = allocate_integer_array(array_size(array) - (array_size(array)/2));

	for (compteur = 0; compteur < array_size(array)/2; compteur++)
	{	
		(*first)[compteur] = array[compteur];
	}
	(*first)[compteur]= -1;

	for (compteur2 = 0; compteur2 < array_size(array) - (array_size(array)/2); compteur2++)
    {
        (*second)[compteur2] = array[compteur + compteur2];
    }
	(*second)[compteur2] = -1;
}

int* merge_sort(int* array){
	int* first;
	int* second;

	if (array_size(array) == 1)
	{
		return array;
	}
	else
	{
		split_arrays(array, &first, &second);
		return merge_sorted_arrays(merge_sort(first),merge_sort(second));
	}
	
	

}


/* An empty main to test the compilation of the allocation and free
   functions. */
int main(/*int argc, char* argv[]*/){
	int* table = random_array(20, 99);
	int* table2 = merge_sort(table);
	print_array(table);
	print_array(table2);

	/*printf("size= %i\n", array_size(table));
	print_array(table);

	copy = copy_array(table);
	print_array(copy);
	printf("%d\n", are_arrays_equal(table, copy));

	print_array(table);
	print_array(table2);
	printf("%d\n", are_arrays_equal(table, table2));

	table_conc = merge_sorted_arrays(table, table2);
	print_array(table_conc);

	first = NULL;
	second = NULL;
	split_arrays(table_conc, &first, &second);
	print_array(first);
	print_array(second);*/





	/*free_integer_array(table_conc);
	free_integer_array(first);
    free_integer_array(second);
	free_integer_array(table);
	free_integer_array(copy);*/
	free_integer_array(table);
	free_integer_array(table2);
  	return 0;
}
