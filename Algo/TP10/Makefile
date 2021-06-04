CC=gcc
CFLAGS=-Wall -ansi
LDFLAGS=-lm
DEPS=heap.h array.h sort.h
OBJ=heap.o array.o sort.o

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

tp10: main.o $(OBJ)
	gcc -o $@ $^ $(LDFLAGS)

.PHONY: clean
clean:
	rm -f $(OBJ) tp10 main.o