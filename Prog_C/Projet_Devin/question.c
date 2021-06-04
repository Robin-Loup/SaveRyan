#include "question.h"


List_reponse create_reponse(int person, int rep, int nb){
    List_reponse l = (List_reponse)malloc(sizeof(Reponse));
    l->person = person;
    l->rep = rep;
    l->nb = nb;
    l->next = NULL;
    return l;
}

void free_reponse(List_reponse l){
    if (l){
        free_reponse(l->next);
        free(l);
    }
    
}

List_reponse add_reponse(List_reponse rep, List_reponse add){
    add->next = rep;
    return add;
}



List_question create_question(char *str){
    List_question q = (List_question)malloc(sizeof(Question));
     char *quest = (char*)malloc(sizeof(char) * 50);
    strcpy(quest, str);
    q->quest = quest;
    q->next = NULL;
    q->reponses = NULL;
    return q;
}

List_question add_question(List_question lq, List_question q){
    if (!lq)
        return q;
    List_question tmp = lq;
    while(tmp->next)
        tmp = tmp->next;
    tmp->next = q;
    return lq;
}

List_question create_question_list(FILE *fichier, List_question q){
    char temp;
    char *quest = (char*)malloc(sizeof(char) * 50);
    char *person = (char*)malloc(sizeof(char) * 50);
    char *reponse = (char*)malloc(sizeof(char) * 50);
    char *nb = (char*)malloc(sizeof(char) * 50);
    List_question tmp = q;
    while(fscanf(fichier,"%[^\n]",quest) != EOF){
        List_question question = create_question(quest);
        List_reponse rep = NULL;
       
        fscanf(fichier,"%s",person);
        /*printf("question :%s\n", quest);*/
        while (strcmp(person, "-1")){
            fscanf(fichier,"%s",reponse);
            fscanf(fichier,"%s",nb);   
            /*printf("%s, %s, %s\n", person, reponse, nb);*/
            List_reponse add = create_reponse(atoi(person), atoi(reponse), atoi(nb));
            rep = add_reponse(rep, add);

            fscanf(fichier,"%s",person);
        }
        question->reponses = rep;
        if(tmp){
            tmp->next = question;
            tmp = tmp->next;
        }
        else{
            tmp = question;
            q = question;
        }
        fscanf(fichier, "%c", &temp); /*instruction temporaire pour effacer le tampon*/ 
    }
    free(quest);
    free(person);
    free(reponse);
    free(nb);

    return q;
}

void write_question(List_question lq, FILE *fichier){
    while (lq){
        fprintf(fichier, "%s\n", lq->quest);
        List_reponse lr = lq->reponses;
        while (lr)
        {
            fprintf(fichier, "%d %d %d ", lr->person, lr->rep, lr->nb);
            lr = lr->next;
        }
        fprintf(fichier, "-1\n");
        lq = lq->next;
    }
}

void free_question(List_question q){
    if (q){
        free_reponse(q->reponses);
        free_question(q->next);
        free(q);
    }
    
}

void update_r( List_reponse lr, int perso, int rep){
    List_reponse tmp = lr;
    while(tmp){
        if (tmp->person == perso && tmp->rep == rep)
        {
            tmp->nb++;
            return;
        }
        else
            tmp = tmp->next;
    }
    lr = add_reponse(lr, create_reponse(perso, rep, 1));
}

void update_q( List_question lq, int ques, int perso, int rep){
    List_question tmp = lq;
    int i ;
     for(i = 0; i < ques; i++){
        if (tmp)
            tmp = tmp->next;
        else
            return;
     }
     update_r(tmp->reponses, perso, rep);
}

void print_q(List_question lq){
    printf("%s\n", lq->quest);
}

List_question ref_question(List_question question, int index){
    int i;
    List_question tmp = question;
    for(i = 0; i < index; i++){
        tmp = tmp->next;
    }
    return tmp;
}

void print_list_q(List_question question){
    List_question tmp = question;
    while (tmp){
        printf("%s\n", tmp->quest);
        List_reponse lr = tmp->reponses;
        while(lr){
            printf("(%d, %d, %d) ", lr->person, lr->rep, lr->nb);
            lr = lr->next;
        }
        printf("\n");
        tmp = tmp->next;
    }
}

int size_q(List_question question){
    int i = 0;
    while (question){
        i++;
        question = question->next;
    }
    return i;
}

