#ifndef QUESTION
#define QUESTION
#include <stdlib.h>
#include <stdio.h>
#include <string.h>

typedef struct reponse {
int person;
int rep;
int nb;
struct reponse *next;
} Reponse , *List_reponse;

typedef struct question {
char  *quest;
struct reponse * reponses;
struct question * next;
} Question , *List_question;

List_reponse create_reponse(int person, int rep, int nb);

List_question create_question_list(FILE *fichier, List_question q);

void free_question(List_question q);

void print_q(List_question lq);

List_question ref_question(List_question question, int index);

void print_list_q(List_question question);

void write_question(List_question lq, FILE *fichier);

List_question add_question(List_question lq, List_question q);

List_reponse add_reponse(List_reponse rep, List_reponse add);

List_question create_question(char *str);

int size_q(List_question question);

#endif