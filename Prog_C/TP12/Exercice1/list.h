
typedef struct node {
char *word;
struct node *next;
} Node , *List;

List add_list(List lst, char *word);

int size_list(List lst);

void free_list(List lst);