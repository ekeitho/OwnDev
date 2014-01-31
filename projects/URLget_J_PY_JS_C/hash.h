typedef struct {
    int size;
    void **keys;
    void **values;
} Hash;
 
Hash *hash_new (int size);

int hash_index (Hash *hash, void *key);
 
void hash_insert (Hash *hash, void *key, void *value); 

void *hash_lookup (Hash *hash, void *key);
