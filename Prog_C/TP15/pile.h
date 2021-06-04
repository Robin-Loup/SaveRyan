typedef struct _pile pile;

pile *create_p();

void free_p(pile *p);

int size_p(pile *p);

void push(pile *p, int val);

int pop(pile *p);

void print(pile *p);

void clear(pile *p);

void reverse(pile *p);