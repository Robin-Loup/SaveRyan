#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include "pile.h"

int is_operateur(char *str){
    if((str[0] == '+')|| (str[0] == '-') ||
     (str[0] == '*') || (str[0] == '%') ||
     (str[0] == '!') || (str[0] == '/') ||
     (str[0] == '^')){
         return 1;
     }
     return 0;
}

int fact(int x){
    if(x <= 1)
        return 1;
    return x * fact(x-1);
}

int expo(int x, int y){
    int i;
    int res = 1;
    for (i = 0; i < y; i++){
        res = res *x;
    }
    return res;
}

int operation(char op, pile *p){
    int x, y;
    if (op == '+'){
        x = pop(p);
        y = pop(p);
        return y + x;
    }

    if (op == '-'){
        x = pop(p);
        y = pop(p);
        return y - x;
    }

    if (op == '*'){
        x = pop(p);
        y = pop(p);
        return y * x;
    }

    if (op == '%'){
        x = pop(p);
        return fact(x);
    }

    if (op == '!'){
        x = pop(p);
        y = pop(p);
        return y % x;
    }

    if (op == '^'){
        x = pop(p);
        y = pop(p);
        return expo(y, x);
    }

    if (op == '/'){
        x = pop(p);
        y = pop(p);
        if(x != 0)
        {
            return y / x;
        }
        else
        {
            printf("division par zero\n");
            return 0;
        }
    }
    printf("erreur argument\n");
    return 0;
}

int main(){
    char str[50];
    int x;
    pile *p = create_p(); 
    do{
        scanf("%s", str);
        if (strcmp(str, "q") !=0)
        {
            if (str[0] >= '0' && str[0] <= '9'){
                x = atoi(str);
                push(p, x);
            }
            else if (strcmp(str, "p") == 0){
                x = pop(p);
                printf("%d\n", x);
                push(p, x);
            }
            else if (strcmp(str, "a") == 0){
                print(p);
            }
            else if (strcmp(str, "c") == 0){
                clear(p);
            }

            else if (strcmp(str, "r") == 0){
                reverse(p);
            }
            else if (is_operateur(str) != 0){
                x = operation(str[0], p);
                push(p, x);
            }
            else
                printf("%s n'est pas un argument valide\n", str);
        }
    } while (strcmp(str, "q") !=0);
    
    free_p(p);
    return 0;
}