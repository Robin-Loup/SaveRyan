CC=gcc
CFLAGS=-Wall -ansi
LDFLAGS=-lm
DEPS=pile.h
OBJ=pile.o

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

exe: main.c $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS) $(LDFLAGS)

.PHONY: clean
clean:
	rm -f $(OBJ) exe