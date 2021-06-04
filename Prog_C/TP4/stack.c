#include "stack.h"
#include <stdio.h>

static Stack stack;

void stack_init(void)
{
	stack.size = 0;
}

int stack_size(void)
{
	return stack.size;
}

int stack_is_empty(void)
{
	if (stack.size == 0)
		return 1;
	else
		return 0;
}

int stack_top(void)
{
	if (!stack_is_empty())
		return stack.values[stack.size - 1];
	return 0;
}

int stack_pop(void)
{
	int pop = stack.values[stack.size - 1];
	stack.values[stack.size - 1] = 0;
	stack.size--;
	return pop;
}

void stack_push(int n)
{
	if (stack.size < MAX_SIZE)
	{
		stack.values[stack.size] = n;
		stack.size++;
	}
}

void stack_display(void)
{
	int i;
	for (i = 0; i < stack.size; i++)
	{
		if (i == 0)
			printf("%i", stack.values[i]);
		else
			printf(", %i", stack.values[i]);
	}
}

int stack_get_element(int index)
{
	return stack.values[index];
}

