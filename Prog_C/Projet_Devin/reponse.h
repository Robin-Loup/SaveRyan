#ifndef REPONSE
#define REPONSE
#include "question.h"
#include "person.h"
#include <stdlib.h>
#include <stdio.h>

typedef struct data {
List_question question;
int reponse;
struct data *next;
} Data , *List_Data;

List_Data add_data(List_Data ld, List_question q, int reponse);
void free_data(List_Data d);
void update(List_Data ld, List_person reponse);

#endif