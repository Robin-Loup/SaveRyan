CC=gcc
CFLAGS=-g -Wall -ansi
LDFLAGS=-lm
DEPS=person.h question.h reponse.h
OBJ=person.o question.o reponse.o

%.o: %.c $(DEPS)
	$(CC) -c -o $@ $< $(CFLAGS)

exe: main.c $(OBJ)
	$(CC) -o $@ $^ $(CFLAGS) $(LDFLAGS)

.PHONY: clean
clean:
	rm -f $(OBJ) exe