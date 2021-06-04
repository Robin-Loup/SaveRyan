#include <stdio.h>
#include <stdlib.h>

void egrainer(int n)
{
	if (n == 1)
	{
		printf("1 1");
	}
	else
	{
		printf("%x " , n);
		egrainer(n-1);
		printf(" %x" , n);
	}
}


int main(int argc, char* argv[])
{
	egrainer(atoi(argv[1]));
	printf("\n");
	/*if (argc == 2)
	{
		int n = atoi(argv[1]);
		for(int i = n; i >= 1; i--)
		{
			if (i == 1)
			{
				printf("%x", i);
			}
			else
			{
				printf("%x ", i);
			}
		}	
		for(int i = 1; i <= n; i++)
		{
			printf(" %x", i); 
		}
		printf("\n");
	}*/
	return 0;
}

