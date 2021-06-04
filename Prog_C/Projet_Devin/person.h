#ifndef PERSON
#define PERSON
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

typedef struct person {
int index;
char  *name;
struct person *next;
} Person , *List_person;

List_person create_person_list(FILE *fihier, List_person first);

void free_person(List_person p);

List_person ref_person(List_person person, int index);

int size_p(List_person personnage);

void print_list_p(List_person personnage);

List_person add_person(List_person lp, List_person new_person);

void write_person(List_person lp, FILE *fichier);

List_person find(List_person lp, char *name);

int exist(List_person lp ,int index);

List_person create_person(char *str, int index);

#endif