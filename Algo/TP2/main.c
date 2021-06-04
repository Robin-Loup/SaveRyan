#include <stdio.h>
#include "tp2.h"

int test_valide(int val, int result, char fun[], char test[]){
    if (val == result){
        /*printf("La fonction %s tésté avec %s est vrai\n", fun, test);*/
        return 1;
    }
    else
    {
        printf("La fonction %s tésté avec %s est fausse.\n Il retourne %i au lieu de %i.\n", fun, test, val, result);
        return 0;
    }
}

void en_test(int nb_res, int nb_test){
    printf("%i test réussi sur %i\n", nb_res, nb_test);
}

struct Suite
{
    int first;
    int longueur;
};

void print_struct(struct Suite rendu){
    printf("Premier indice = %i;   taille suite = %i\n", rendu.first, rendu.longueur);
}
    
int main(){
    /******Exercice 1******/
    printf("Exercice 1\n");
    /*int palindrome(char str[]);*/
    int nb_res = 0;
    /*test1*/
    char str[] = "a";
    nb_res += test_valide(palindrome(str),1,"palindrome",str);

    /*test2*/
    char str1[] = "aba";
    nb_res += test_valide(palindrome(str1),1,"palindrome",str1);

    /*test3*/
    char str2[] = "abba";
    nb_res += test_valide(palindrome(str2),1,"palindrome",str2);

    /*test4*/
    char str3[] = "kayak";
    nb_res += test_valide(palindrome(str3),1,"palindrome",str3);

    /*test5*/
    char str4[] = "ab";
    nb_res += test_valide(palindrome(str4),0,"palindrome",str4);

    /*test6*/
    char str5[] = "abca";
    nb_res += test_valide(palindrome(str5),0,"palindrome",str5);

    /*test7*/
    char str6[] = "abdeba";
    nb_res += test_valide(palindrome(str6),0,"palindrome",str6);

    /*test8*/
    char str7[] = "radare";
    nb_res += test_valide(palindrome(str7),0,"palindrome",str7);


    en_test(nb_res, 8);
    printf("\n");

    /******Exercice 2******/
    printf("Exercice 2\n");
    /*void increasing_sequence_rec(int n);*/
    /*void decreasing_sequence_rec(int n);*/
    /*test*/
    int n;
    for (n = 1; n < 30; n+=3)
    {
        printf("Valeur tésté en croissant = %i\n", n);
        increasing_sequence_rec(n);
        printf("\n");
        printf("Valeur tésté en décroissant = %i\n", n);
        decreasing_sequence_rec(n);
    }
    printf("\n");

    /******Exercice 3*****/
    printf("Exercice 3\n");
    
    /*int count(int t[], int lo, int hi, int elt);*/
    int t1[] = {1, 4, 3, 3, 2, 3, 3, 4};
    int t2[] = {4};
    int t3[] = {1, 4, 2, 2, 2, 3, 3, 2};
    int t4[] = {1, 2, 3, 4, 5, 1, 2, 3};
    int t5[] = {1, 4, 3, 3, 2, 3, 3, 4, 6, 7, 8, 2 ,9 ,1 ,3 ,6};
    nb_res = 0;
    nb_res+= test_valide(count(t1, 0, 7, 3), 4, "count","[1, 4, 3, 3, 2, 3, 3, 4]");
    nb_res+= test_valide(count(t2, 0, 0, 4), 1, "count","[4]");
    nb_res+= test_valide(count(t2, 0, 0, 3), 0, "count","[4]");
    nb_res+= test_valide(count(t3, 0, 7, 2), 4, "count","[1, 4, 2, 2, 2, 3, 3, 2]");
    nb_res+= test_valide(count(t4, 0, 7, 3), 2, "count","[1, 2, 3, 4, 5, 1, 2, 3]");
    nb_res+= test_valide(count(t5, 1, 8, 3), 4, "count","[1, 4, 3, 3, 2, 3, 3, 4, 6, 7, 8, 2 ,9 ,1 ,3 ,6]");
    en_test(nb_res, 6);
    printf("\n");
    /*int max_count(int t[], int lo, int hi);*/
    nb_res = 0;
    nb_res+= test_valide(max_count(t1, 0, 7), 4, "max_count","[1, 4, 3, 3, 2, 3, 3, 4]");
    nb_res+= test_valide(max_count(t2, 0, 0), 1, "max_count","[4]");
    nb_res+= test_valide(max_count(t3, 0, 7), 4, "max_count","[1, 4, 2, 2, 2, 3, 3, 2]");
    nb_res+= test_valide(max_count(t4, 0, 7), 2, "max_count","[1, 2, 3, 4, 5, 1, 2, 3]");
    nb_res+= test_valide(max_count(t5, 1, 8), 4, "max_count","[1, 4, 3, 3, 2, 3, 3, 4, 6, 7, 8, 2 ,9 ,1 ,3 ,6]");
    en_test(nb_res, 5);
    printf("\n");

    /******Exercice 4*****/
    printf("Exercice 4\n");
    nb_res = 0;
    int n1 = 10;
    int n2 = 35;
    int n3 = 325;
    int n4 = 564;
    int n5 = 7585;
    
    /*int sum_digits_iter(int n);*/
    /*test1*/
    nb_res+= test_valide(sum_digits_iter(n1),1,"sum_digits_iter","n1");
    /*test2*/
    nb_res+= test_valide(sum_digits_iter(n2),8,"sum_digits_iter","n2");
    /*test3*/
    nb_res+= test_valide(sum_digits_iter(n3),10,"sum_digits_iter","n3");
    /*test4*/
    nb_res+= test_valide(sum_digits_iter(n4),15,"sum_digits_iter","n4");
    /*test5*/
    nb_res+= test_valide(sum_digits_iter(n5),25,"sum_digits_iter","n5");
    
    /*int sum_digits_rec(int n);*/
     /*test1*/
    nb_res+= test_valide(sum_digits_rec(n1),1,"sum_digits_rec","n1");
    /*test2*/
    nb_res+= test_valide(sum_digits_rec(n2),8,"sum_digits_rec","n2");
    /*test3*/
    nb_res+= test_valide(sum_digits_rec(n3),10,"sum_digits_rec","n3");
    /*test4*/
    nb_res+= test_valide(sum_digits_rec(n4),15,"sum_digits_rec","n4");
    /*test5*/
    nb_res+= test_valide(sum_digits_rec(n5),25,"sum_digits_rec","n5");
    en_test(nb_res, 10);
    printf("\n");

    /******Exercice 5*****/
    printf("Exercice 5\n");
    nb_res = 0;
    
    /*int digit_sum_digits_iter(int n);*/
     /*test1*/
    nb_res+= test_valide(digit_sum_digits_iter(n1),1,"sum_digits_iter","n1");
    /*test2*/
    nb_res+= test_valide(digit_sum_digits_iter(n2),8,"sum_digits_iter","n2");
    /*test3*/
    nb_res+= test_valide(digit_sum_digits_iter(n3),1,"sum_digits_iter","n3");
    /*test4*/
    nb_res+= test_valide(digit_sum_digits_iter(n4),6,"sum_digits_iter","n4");
    /*test5*/
    nb_res+= test_valide(digit_sum_digits_iter(n5),7,"sum_digits_iter","n5");
    
    /*int digit_sum_digits_rec(int n);*/
     /*test1*/
    nb_res+= test_valide(digit_sum_digits_rec(n1),1,"sum_digits_rec","n1");
    /*test2*/
    nb_res+= test_valide(digit_sum_digits_rec(n2),8,"sum_digits_rec","n2");
    /*test3*/
    nb_res+= test_valide(digit_sum_digits_rec(n3),1,"sum_digits_rec","n3");
    /*test4*/
    nb_res+= test_valide(digit_sum_digits_rec(n4),6,"sum_digits_rec","n4");
    /*test5*/
    nb_res+= test_valide(digit_sum_digits_rec(n5),7,"sum_digits_rec","n5");
    en_test(nb_res, 10);
    
    
    printf("\n");
    /******Exercice 6*****/
    printf("Exercice 6\n");
    nb_res = 0;
    /*int longest_incr_iter(int t[], int lo, int hi);*/
    nb_res+= test_valide(longest_incr_iter(t1, 0, 7), 2, "longest_incr_iter","[1, 4, 3, 3, 2, 3, 3, 4]");
    nb_res+= test_valide(longest_incr_iter(t2, 0, 0), 1, "longest_incr_iter","[4]");
    nb_res+= test_valide(longest_incr_iter(t3, 0, 7), 2, "longest_incr_iter","[1, 4, 2, 2, 2, 3, 3, 2]");
    nb_res+= test_valide(longest_incr_iter(t4, 0, 7), 5, "longest_incr_iter","[1, 2, 3, 4, 5, 1, 2, 3]");
    nb_res+= test_valide(longest_incr_iter(t5, 0, 15), 5, "longest_incr_iter","[1, 4, 3, 3, 2, 3, 3, 4, 6, 7, 8, 2 ,9 ,1 ,3 ,6]");
    en_test(nb_res, 5);

    /*int longest_incr_rec(int t[], int lo, int hi);*/
     nb_res = 0;
    nb_res+= test_valide(longest_incr_rec(t1, 0, 7), 2, "longest_incr_rec","[1, 4, 3, 3, 2, 3, 3, 4]");
    nb_res+= test_valide(longest_incr_rec(t2, 0, 0), 1, "longest_incr_rec","[4]");
    nb_res+= test_valide(longest_incr_rec(t3, 0, 7), 2, "longest_incr_rec","[1, 4, 2, 2, 2, 3, 3, 2]");
    nb_res+= test_valide(longest_incr_rec(t4, 0, 7), 5, "longest_incr_rec","[1, 2, 3, 4, 5, 1, 2, 3]");
    nb_res+= test_valide(longest_incr_rec(t5, 0, 15), 5, "longest_incr_rec","[1, 4, 3, 3, 2, 3, 3, 4, 6, 7, 8, 2 ,9 ,1 ,3 ,6]");
    en_test(nb_res, 5);
    printf("\n");

    struct Suite rendu;
    rendu.first = 0;
    rendu.longueur = 0;
    /*struct Suite longest_incr_rec_mod(int t[], int lo, struct Suite rendu, int hi);*/
    print_struct(longest_incr_rec_mod(t1, 0, rendu, 7));
    print_struct(longest_incr_rec_mod(t2, 0, rendu, 0));
    print_struct(longest_incr_rec_mod(t3, 0, rendu, 7));
    print_struct(longest_incr_rec_mod(t4, 0, rendu, 7));
    print_struct(longest_incr_rec_mod(t5, 0, rendu, 15));
    printf("\n");
    
    /*struct Suite longest_incr_iter_mod(int t[], int lo, int hi);*/
    print_struct(longest_incr_iter_mod(t1, 0, 7));
    print_struct(longest_incr_iter_mod(t2, 0, 0));
    print_struct(longest_incr_iter_mod(t3, 0, 7));
    print_struct(longest_incr_iter_mod(t4, 0, 7));
    print_struct(longest_incr_iter_mod(t5, 0, 15));
    }