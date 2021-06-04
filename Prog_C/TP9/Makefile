CC=gcc
CFLAGS=-W -Wall -ansi -pedantic
LDFLAGS=
EXEC=exe

all: $(EXEC)

exercice_1: exercice_1.o 
	$(CC) -o exercice_1 exercice_1.o $(LDFLAGS)

exercice_1.o: exercice_1.c
	$(CC) -o exercice_1.o -c exercice_1.c $(CFLAGS)

exercice_2: exercice_2.o 
	$(CC) -o exercice_2 exercice_2.o $(LDFLAGS)

exercice_2.o: exercice_2.c
	$(CC) -o exercice_2.o -c exercice_2.c $(CFLAGS)

exercice_3: exercice_3.o 
	$(CC) -o exercice_3 exercice_3.o $(LDFLAGS)

exercice_3.o: exercice_3.c
	$(CC) -o exercice_3.o -c exercice_3.c $(CFLAGS)


clean: 
	rm -rf *.o

mrproper: clean
	rm -rf $(EXEC)
