#include <stdlib.h>
#include <stdio.h>
#include "list.h"

List trunc(List lst){
    if(!lst)
        return NULL;
    int i;
    List tmp = lst;
    List tmp2;
    for(i = 0; i < size_list(lst)/2 -1; i++){
        tmp = tmp->next;
    }
    tmp2 = tmp->next;
    tmp->next = NULL;
    return tmp2;
}

List tri(List lst1, List lst2){
    if(!lst1)
        return lst2;
    if(!lst2)
        return lst1;
    if (lst1->data < lst2->data){
        lst1->next = tri(lst1->next, lst2);
        return lst1;
    }
    else{
        lst2->next = tri(lst1, lst2->next);
        return lst2;
    }
}

List merge_sort(List lst){
    if (!lst)
        return NULL;

    if (size_list(lst) <= 1)
        return lst;

    List lst2 = trunc(lst);
    return tri(merge_sort(lst), merge_sort(lst2));
}

int main(int argc, char **argv) {
    List lst = NULL;
    lst = add_list(lst, 1);
    lst = add_list(lst, 3);
    lst = add_list(lst, 4);
    lst = add_list(lst, 5);
    lst = add_list(lst, 3);
    lst = add_list(lst, 6);

    lst = merge_sort(lst);
    print_list(lst);

    free_list(lst);
    return 0;
}