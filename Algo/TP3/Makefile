CC=gcc
CFLAGS=-W -Wall -ansi -pedantic
LDFLAGS=$(shell pkg-config --libs-only-l MLV)
EXEC=exe

all: $(EXEC)

exe: tp3.o main.o
	$(CC) -o exe tp3.o main.o $(LDFLAGS)

stack.o: tp3.c
	$(CC) -o tp3.o -c tp3.c $(CFLAGS)

main -o: main.c
	$(CC) -o main.o -c main.c $(CFLAGS)

clean: 
	rm -rf *.o

mrproper: clean
	rm -rf $(EXEC)
