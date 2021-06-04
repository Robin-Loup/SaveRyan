CC=gcc
CFLAGS=-W -Wall -ansi -pedantic
LDFLAGS=
EXEC=exe

all: $(EXEC)

exe: main.o
	$(CC) -o exe main.o $(LDFLAGS)

main -o: main.c
	$(CC) -o main.o -c main.c $(CFLAGS)

clean: 
	rm -rf *.o

mrproper: clean
	rm -rf $(EXEC)
