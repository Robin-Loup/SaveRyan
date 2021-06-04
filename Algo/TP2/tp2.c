#include <stdio.h>
#include <string.h>


/******Exercice 1******/
int palindrome_rec(char str[], int lo, int hi){
    if (lo >= hi)
    {
        return 1;
    }
    else
    {
        if (str[lo] == str[hi])
        {
            return palindrome_rec(str, lo + 1, hi - 1);
        }
        else
        {
            return 0;
        }
    }
}

int palindrome(char str[]){
    return palindrome_rec(str, 0, strlen(str)-1);
}



/******Exercice 2******/
void increasing_sequence_rec(int n){
    if(n== 1)
    {
        printf("%i", n);
    }
    else
    {
        increasing_sequence_rec(n-1);
        printf("% i", n);
    }
}

void decreasing_sequence_rec(int n){
    if(n== 1)
    {
        printf("%i\n", n);
    }
    else
    {
        printf("%i ", n);
        decreasing_sequence_rec(n-1);
    }
}

/******Exercice 3*****/
int count(int t[], int lo, int hi, int elt){
    if (lo == hi)
    {
        return t[lo] == elt;
    }
    else
    {
        return (t[lo] == elt) + count(t, lo+1, hi, elt);
    }
}

int maximum(int a, int b){
    if (a > b)
    {
        return a;
    }
    else
    {
        return b;
    }
}

int max_count(int t[], int lo, int hi){
    if (lo == hi)
    {
        return 1;
    }
    else
    {
        return maximum(count(t, lo, hi,t[lo]), max_count(t, lo+1, hi));
    }
}

/******Exercice 4*****/
int sum_digits_iter(int n){
    int result = 0;
    while (n >= 10)
    {
        result += n % 10;
        n = n/10;
    }
    return result + n;
}

int sum_digits_rec(int n){
    if (n < 10)
    {
        return n;
    }
    else
    {
        return n % 10 + sum_digits_rec(n/10);
    }
}

/******Exercice 5*****/
int digit_sum_digits_iter(int n){
    while (n >= 10)
    {
        n = sum_digits_iter(n);
    }
    return n;
}

int digit_sum_digits_rec(int n){
    if (n < 10)
    {
        return n;
    }
    else
    {
        return digit_sum_digits_rec(sum_digits_rec(n));
    }
    
}

/******Exercice 6*****/
int longest_incr_iter(int t[], int lo, int hi){
    int max = 1;
    int suite = 1;
    while (lo < hi)
    {
        if (t[lo] < t[lo+1])
        {
            suite++;
            /*printf("suite = %i\n",suite);*/

        }
        else
        {
            max = maximum(max, suite);
            /*printf("%i\n",max);*/
            suite = 1;
        }
        lo++;
    }
    return maximum(suite, max);
}

int first_incr(int t[], int lo, int hi){
    if (lo >= hi || t[lo] >= t[lo + 1])
    {
        return 1;
    }
    else
    {
        
        return 1 + first_incr(t, lo+1, hi);   
    }  
}

int longest_incr_rec(int t[], int lo, int hi){
    if (lo > hi)
    {
        return 1;
    }
    else
    {
        int val_actuel = first_incr(t, lo, hi);
        return maximum(val_actuel, longest_incr_rec(t, lo + val_actuel, hi)); 
    }
}

struct Suite
{
    int first;
    int longueur;
};

struct Suite longest_incr_iter_mod(int t[], int lo, int hi){
    int max = 1;
    int suite = 1;
    int first = lo;
    int first1 = lo;
    struct Suite rendu;

    while (lo < hi)
    {
        if (t[lo] < t[lo+1])
        {
            suite++;
            /*printf("suite = %i\n",suite);*/

        }
        else
        {
            if (suite > max){
                first = first1;
            }
            max = maximum(max, suite);
            /*printf("%i\n",max);*/
            suite = 1;
            first1 = lo + 1;
        }
        lo++;
    }
    if (suite > max){
        first = first1;
    }
     max = maximum(suite, max);
     rendu.first = first;
     rendu.longueur = max;
     return rendu;
}


struct Suite first_incr_mod(int t[], int lo, struct Suite rendu, int hi){
    if (lo >= hi || t[lo] >= t[lo + 1])
    {
        rendu.longueur++;
        return rendu;
    }
    else
    {
        rendu.longueur++;
        return first_incr_mod(t, lo+1, rendu, hi);   
    }  
}

struct Suite longest_incr_rec_mod(int t[], int lo, struct Suite rendu, int hi){
    if (lo > hi)
    {
        rendu.longueur++;
        return rendu;
    }
    else
    {
        struct Suite rendu2;
        rendu2.longueur = rendu.longueur;
        rendu2.first = rendu.first + 1;
        if (first_incr_mod(t, lo, rendu, hi).longueur > longest_incr_rec_mod(t, lo+1, rendu2, hi).longueur){
            return first_incr_mod(t, lo, rendu, hi);
        }
        else
        {
            return longest_incr_rec_mod(t, lo+1, rendu2, hi);
        }
        
        /*return maximum(first_incr(t, lo, hi), longest_incr_rec(t, lo+1, hi));*/ 
    }
}


