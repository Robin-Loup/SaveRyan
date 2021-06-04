#include "reponse.h"


List_Data create_data(List_question question, int reponse){
    List_Data data = (List_Data)malloc(sizeof(Data));
    data->question = question;
    data->reponse = reponse;
    data->next = NULL;
    return data;
}

List_Data add_data(List_Data ld, List_question q, int reponse){
    List_Data new = create_data(q, reponse);
    new->next = ld;
    return new;
}

void free_data(List_Data d){
    if (d){
        free_data(d->next);
        free(d);
    }  
}

void print_data(List_Data ld){
    while(ld){
        printf("%s\n", ld->question->quest);
        printf("%d\n", ld->reponse);
        ld = ld->next;
    }
}

void update(List_Data ld, List_person reponse){
    /*print_data(ld);*/
    List_Data tmp = ld;
    while (tmp){ 
        List_question question = tmp->question;
        List_reponse lr = question->reponses;
        int find = 0;
        while(lr){
            if (lr->person == reponse->index && lr->rep == tmp->reponse){
                lr->nb++;
                find = 1;
            }
            lr = lr->next;
        }
        
        if (!find){
            /*print_list_p(reponse);*/
            question->reponses = add_reponse(question->reponses, create_reponse(reponse->index, tmp->reponse, 1));
        }
        
        tmp = tmp->next;
    }
}