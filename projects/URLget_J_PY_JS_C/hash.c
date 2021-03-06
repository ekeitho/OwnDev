#include <stdio.h>
#include <stdlib.h>
#include "hash.h"

Hash *hash_new (int size) {
    Hash *hash = calloc(1, sizeof (Hash));
    hash->size = size;
    hash->keys = calloc(size, sizeof (void *));
    hash->values = calloc(size, sizeof (void *));
    return hash;
}
 
int hash_index (Hash *hash, char *key) {
    int index = *key % hash->size;
   // while (hash->keys[index] && hash->keys[index] != key)
   //     index = (index + 1) % hash->size;
    return index;
}
 
void hash_insert (Hash *hash, char *key, char *value) {
    int index = hash_index(hash, key);
    hash->keys[index] = key;
    hash->values[index] = value;
}
 
void *hash_lookup (Hash *hash, char *key) {
    int index = hash_index(hash, key);
    return hash->values[index];
}



