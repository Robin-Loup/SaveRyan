#include "person.h"

List_person create_person(char *str, int index){
    List_person person = (List_person)malloc(sizeof(Person));
    char *name = (char*)malloc(sizeof(char) * 50);
    strcpy(name, str);
    person->index = index;
    person->name = name;
    person->next = NULL;
    return person;
}

List_person create_person_list(FILE *fichier, List_person first){
    int i = 0;
    if(first)
        i = first->index;
    char *name_f = (char*)malloc(sizeof(char) * 50);
    List_person tmp = first;
    while(fscanf(fichier,"%[^\n]",name_f) != EOF){
        /*printf ("%s\n", name_f);*/
        List_person person = create_person(name_f, i);
        if (tmp){
            tmp->next = person;
            tmp = tmp->next; 
        }
        else{
            tmp = person;
            first = person;
        }
        fscanf(fichier,"%[\n]",name_f); 
        /*printf ("%s\n", name_f);*/
        i++;
    }

    free(name_f);
    return first;
}


void write_person(List_person lp, FILE *fichier){
    while (lp){
        fprintf(fichier, "%s\n", lp->name);
        lp = lp->next;
    }
}

List_person add_person(List_person lp, List_person new_person){
    if (!lp)
        return new_person;
    List_person tmp = lp;
    while(tmp->next)
        tmp = tmp->next;
    tmp->next = new_person;
    return lp;
}

void free_person(List_person p){
    if (p){
        free(p->name);
        free_person(p->next);
        free(p);
    }
    
}

List_person ref_person(List_person person, int index){
    List_person tmp = person;
    while (tmp){
        if (tmp->index == index)
            return tmp;
        tmp = tmp->next;
    }
    return NULL;
}

int size_p(List_person personnage){
    int i = 0;
    while (personnage){
        i++;
        personnage = personnage->next;
    }
    return i;
}

void print_list_p(List_person personnage){
    List_person tmp = personnage;
    while (tmp){
        printf("%d, %s\n", tmp->index, tmp->name);
        tmp = tmp->next;
    }
}

List_person find(List_person lp, char *name){
    List_person ltp = lp;
    while (ltp){
        if (!strcmp(ltp->name, name))
            return ltp;
        ltp = ltp->next;
    }
    return create_person(name, size_p(lp));  
}

int exist(List_person lp ,int index){
    List_person ltp = lp;
    while (ltp){
        if (ltp->index == index)
            return 1;
        ltp = ltp->next;
    }
    return 0;
}