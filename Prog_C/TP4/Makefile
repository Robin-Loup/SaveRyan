CC=gcc
CFLAGS=-W -Wall -ansi -pedantic
LDFLAGS=
EXEC=exe

all: $(EXEC)

exe: stack.o main.o
	$(CC) -o exe stack.o main.o $(LDFLAGS)

stack.o: stack.c
	$(CC) -o stack.o -c stack.c $(CFLAGS)

main -o: main.c
	$(CC) -o main.o -c main.c $(CFLAGS)

clean: 
	rm -rf *.o

mrproper: clean
	rm -rf $(EXEC)
