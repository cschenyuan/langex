
#define IDENT 0
#define OP +

typedef int data_t;

typedef struct {
    long int len;
    data_t *data;
} vec_rec, *vec_ptr;

vec_ptr new_rec(long int);

int get_vec_element(vec_ptr,long int,data_t*);

data_t *get_vec_start(vec_ptr);

long int vec_length(vec_ptr);
