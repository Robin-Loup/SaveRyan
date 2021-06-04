CC=gcc
CFLAGS=-W -Wall -ansi -pedantic
LDFLAGS=
EXEC=exe

all: $(EXEC)

exe: tp2.o main.o
	$(CC) -o exe tp2.o main.o $(LDFLAGS)

stack.o: tp2.c
	$(CC) -o tp2.o -c tp2.c $(CFLAGS)

main -o: main.c
	$(CC) -o main.o -c main.c $(CFLAGS)

clean: 
	rm -rf *.o

mrproper: clean
	rm -rf $(EXEC)
