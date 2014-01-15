#include <stdio.h>
#include <string.h>
#include "hash.h"


typedef struct
{
	char urlString[100];
} URL;

void createUrlMap(URL *url, Hash *hash);

int main()
{
	URL url;
	printf("Please enter a valid url string.");
	scanf("%s", url.urlString);


	Hash *hash = hash_new(10);
	createUrlMap(&url, hash);	

	printf("hello => %s\n", hash_lookup(hash, "tag"));	
		

}

void createUrlMap(URL *url, Hash *hash)
{
	char *running, *token, *querry;
	char *fValues[2];
	int count = 0;
	
	running = strdup(url->urlString);		
	while( (token = strsep(&running, "?")) != NULL)
	{
		if (count == 1)
		{
			querry = token;
		}
		count++;
	}
	count = 0;


	running = strdup(querry);
		
	while( (token = strsep(&running, "&")) != NULL )
	{
		char *temp; 
		char *token2; //need another token for the = seperator
		temp = strdup(token); //loads 'field=value'

		while( (token2= strsep(&temp, "=")) != NULL )
		{
			fValues[count] = token2; //need to store field
						 //and value into an array
			count++;	
		}
	
		hash_insert( hash, fValues[0], fValues[1] );

		//errors in putting in array values?!?
	}

	hash_insert(hash, "tag", "hi"); //this works...

	printf("hello => %s\n", hash_lookup(hash, "tag"));

}
