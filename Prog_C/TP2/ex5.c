#include <stdio.h>

int main(int argc, char *argv[])
{
	char ch;
	FILE *fichier = fopen("ex5.c", "r");
	if (fichier != NULL)
	{
		do
		{
			ch = fgetc(fichier);
			putchar(ch);
		} while (ch != EOF);

		fclose(fichier);
	}

	return 0;
}
