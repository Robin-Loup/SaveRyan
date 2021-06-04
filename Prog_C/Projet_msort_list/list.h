
typedef struct node {
int data;
struct node *next;
} Node , *List;

List add_list(List lst, int val);

int size_list(List lst);

void free_list(List lst);

void print_list(List lst);