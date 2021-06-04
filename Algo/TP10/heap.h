typedef struct {
  int *tree;
  int size;
  int max;
} heap;

heap *create_heap(int max);

void free_heap(heap *h);

void insert_heap(heap *h, int elt);

int is_heap(heap *h);

int extract_min(heap *h);

void heapsort(int tab[], int size);

void heapsort_2(int tab[], int size);

void print_heap(heap *h);