typedef struct _table {
    link **bucket;
    int M;
    /* nombre de seaux */
    int size;
    /* nombre de mots dans la table */
} table;

table *create_table(int M);

void add_occ_table(table *tab, char word[], int pos);

void display_table( table *tab);

void free_table(table *tab);

int size_table(table *tab);

void write_table(table *tab, FILE *fichier);