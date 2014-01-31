typedef struct {
    int size;
    void **keys;
    void **values;
} Hash;
 
Hash *hash_new (int size);

int hash_index (Hash *hash, char *key);
 
void hash_insert (Hash *hash, char *key, char *value); 

void *hash_lookup (Hash *hash, char *key);
