CC=gcc
CFLAGS=-g -Wall -ansi
LDFLAGS=-lm
DEPS=list.h
OBJ=list.o

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

exe: main.c $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS) $(LDFLAGS)

.PHONY: clean
clean:
	rm -f $(OBJ) exe