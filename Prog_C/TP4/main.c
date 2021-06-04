#include "stack.h"
#include <stdio.h>

int main()
{
	int empty = 0;
	stack_init();
	printf("size= %i\n", stack_size());

	empty = stack_is_empty();
	if (empty == 1)
		printf("VIDE\n");
	else
		printf("NON VIDE\n");

	stack_push(2);
	printf("size= %i\n", stack_size());

        empty = stack_is_empty();
	if (empty == 1)
                printf("VIDE\n");
        else
                printf("NON VIDE\n");


	stack_push(6);
	stack_push(7);
	stack_push(7);

	printf("top = %i\n", stack_top());

	stack_display();

	printf("element de 1 est: %i\n", stack_get_element(1));

	printf("element poper est: %i\n", stack_pop());

	stack_display();
	printf("size= %i\n", stack_size());

	return 0;	
}
