#include <stdlib.h>
#include <stdio.h>
#include "person.h"
#include "question.h"
#include "reponse.h"

List_person reponse(List_reponse lr, List_person lp, int rep){
    List_reponse tmp = lr;
    List_person personnes = NULL;
    List_person tmp_pers = personnes;
    while (tmp){
        if (tmp->rep == rep){
            List_person person = ref_person(lp, tmp->person);
            if (person){
                if (tmp_pers){
                    tmp_pers->next = create_person(person->name,person->index);
                    tmp_pers = tmp_pers->next;
                }
                else{
                    tmp_pers = create_person(person->name,person->index);
                    personnes = tmp_pers;
                }
            }
        }
        tmp = tmp->next;
    }
    return personnes;
}

int nb_reponse(List_reponse lr, List_person lp, int rep){
    int val = 0;
    List_reponse tmp = lr;
    while (tmp){
        if (tmp->rep == rep){
            List_person person = ref_person(lp, tmp->person);
            if (person){              
                val++;
            }
        }
        tmp = tmp->next;
    }
    return val;
}

int ensemble(List_reponse lr, List_person lp){
    int i;
    int min_ens = 0;
    for (i = 1; i < 6; i++){
        min_ens+= (nb_reponse(lr, lp, i));
        /*printf("%d\n", min_ens);*/
    }
    return min_ens;
}

List_question choose_q(List_question lq, List_person lp){
    List_question tmp = lq;
    int val;
    int index = 0;
    int i = 0;
    
    int min = ensemble(tmp->reponses, lp);
    while (tmp){
       /*printf("%s\n", tmp->quest);*/
        val = ensemble(tmp->reponses, lp);
        if (val < min){
            min = val;
            index = i;
        }
        i++;
       
        tmp = tmp->next;
    }
    return ref_question(lq, index);
}

void new_game(List_person lp, List_question lq){
    int r;
    char temp;
    char * str = (char*)malloc(sizeof(char) * 200);
    List_person ltp = lp;
    List_person ltp2 = NULL;
    List_Data list_donne = NULL;
    while(size_p(ltp) > 1){
        /*print_list_p(ltp);*/
        List_question my_quest = choose_q(lq, ltp);
       
        print_q(my_quest);
        printf("1-oui   2-je pense 3-je sais pas  4-je pense pas  5-non\n");
        scanf("%d", &r);
        ltp = reponse(my_quest->reponses, ltp, r);
        free_person(ltp2);
        ltp2 = ltp;
        list_donne = add_data(list_donne, my_quest, r);
    } 
    
    scanf("%c", &temp); /*instruction temporaire pour effacer le tampon*/
    if(size_p(ltp) == 1){
        printf("C'est %s\n1-oui 2-non\n", ltp->name);
        scanf("%d", &r);
        scanf("%c", &temp); /*instruction temporaire pour effacer le tampon*/
        if ( r != 1){
            printf("C'est qui?\n");
            scanf("%[^\n]", str);
            ltp2 = find(lp, str);
            if (ltp2->index == size_p(lp)){
                lp = add_person(lp, ltp2);
            }
            scanf("%c", &temp); /*instruction temporaire pour effacer le tampon*/
            if(size_q(lq) < 50){
                printf("Quel question aurais-je du poser?\n");
                scanf("%[^\n]", str);
                printf("Quelle serait la réponse à cette question?\n1-oui   2-je pense 3-je sais pas  4-je pense pas  5-non\n");
                scanf("%d", &r);
                List_question q = create_question(str);
                lq = add_question(lq, q);
                list_donne = add_data(list_donne, q, r);
            }
        }
    }  
    else{
        printf("C'est qui?\n");
        scanf("%[^\n]", str);
        ltp2 = find(lp, str);
        if (ltp2->index == size_p(lp)){
            lp = add_person(lp, ltp2);
        }
        scanf("%c", &temp); /*instruction temporaire pour effacer le tampon*/
        if(size_q(lq) < 50){
            printf("Quel question aurais-je du poser?\n");
            scanf("%[^\n]", str);
            printf("Quelle serait la réponse à cette question?\n1-oui   2-je pense 3-je sais pas  4-je pense pas  5-non\n");
            scanf("%d", &r);
            List_question q = create_question(str);
            lq = add_question(lq, q);
            list_donne = add_data(list_donne, q, r);
        }
      
    }
    
    update(list_donne, ltp2);
    free_data(list_donne);
    free(str);
    free_person(ltp);
    /*free_person(ltp2);*/
}

int main(int argc, char **argv) {
    FILE *perso;
    FILE *quest;

    

    if ((perso = fopen("Personnage.txt", "r")) == NULL)
    {
        fprintf(stderr,"Impossible d'ouvrir le fichier Personnage.txt\n");
        exit(1);
    }

    
    List_person lp = create_person_list(perso, NULL);
    fclose(perso);

    /*print_list_p(lp);*/
    if ((quest = fopen("Question.txt", "r")) == NULL)
    {
        fprintf(stderr,"Impossible d'ouvrir le fichier Question.txt\n");
        exit(1);
    }

    List_question lq = create_question_list(quest, NULL);
    /*print_list_q(lq);*/

    fclose(quest);
    


    /*print_list_p(lp);
    print_list_q(lq);*/
    
    int r = 1;
    while(r == 1){
        new_game(lp, lq);
        printf("On rejoue?\n1-oui 2-non\n");
        scanf(" %d", &r);
    }

    /*print_list_p(lp);
    print_list_q(lq);*/

    if ((perso = fopen("Personnage.txt", "w")) == NULL)
    {
        fprintf(stderr,"Impossible d'ouvrir le fichier Personnage.txt\n");
        exit(1);
    }
    write_person(lp, perso);
    fclose(perso);

    if ((quest = fopen("Question.txt", "w")) == NULL)
    {
        fprintf(stderr,"Impossible d'ouvrir le fichier Question.txt\n");
        exit(1);
    }
    write_question(lq, quest);
    fclose(quest);
    
    free_person(lp);
    free_question(lq);


    return 0;
}
