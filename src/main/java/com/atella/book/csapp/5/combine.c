#include"vec.h"

void combine1(vec_ptr v,data_t *dest) {
    long int i;

    *dest = IDENT;
    for(i = 0; i < vec_length(v); i++) {
        data_t val;
        get_vec_element(v, i, &val);
        *dest = *dest OP val;
    }
}

void combine2(vec_ptr v,data_t *dest) {

    long int i;
    long int len = vec_length(v);

    *dest = IDENT;
    for(i = 0; i < len; i++) {
        data_t val;
        get_vec_element(v, i, &val);
        *dest = *dest OP val;
    }
}

void combine3(vec_ptr v,data_t *dest) {

    long int i;
    long int len = vec_length(v);
    data_t *data = get_vec_start(v);

    *dest = IDENT;
    for(i = 0; i < len; i++) {
        *dest = *dest OP data[i];
    }
}

/* Accumulate result in local variable */
void combine4(vec_ptr v,data_t *dest) {

    long int i;
    long int len = vec_length(v);
    data_t *data = get_vec_start(v);

    data_t acc = IDENT;
    for(i = 0; i < len; i++) {
        acc = acc OP data[i];
    }

    *dest = acc;
}
