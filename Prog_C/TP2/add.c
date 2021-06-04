#include <stdio.h>
#include <stdlib.h>

/*int main()
{
	int n1;
	int n2;
	int number1;
	int number2;
	n1 = scanf("%d", &number1);
	if (n1 == 1)
	{
		n2 = scanf ("%d", &number2);
		if (n2 == 1)
		{
			int result = number1 + number2;
			printf("%x\n", result);
		}	
		else
		{
			fprintf(stderr, "n2 n'es pas un nombre\n");
		}
	}
	else
	{
		fprintf(stderr, "n1 n'est pas un nombre\n");
	}
	return 0;
	
}*/

int main(int argc, char* argv[])
{
	if (argc == 3)
	{
		int a = atoi(argv[1]);
		int b = atoi(argv[2]);
		int ab = a + b;
		printf("%x\n",ab); 
	}
	else
	{
		printf("%x variables, Pas le bon nombre de variables\n", argc - 1);
	}
	return 0;
}
