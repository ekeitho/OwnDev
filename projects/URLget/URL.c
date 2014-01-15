#include <stdio.h>
#include <string.h>
#include "hash.h"
#include <stdlib.h>

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
	char *querry, *token, *running;
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



		while( (token2 = strsep(&temp, "=")) != NULL )
		{
			int length = strlen(token2);
			char field[] = "    ";
			sprintf(field, "%s", token2);

			
			char *token3 = strsep(&temp, "=");
			length = strlen(token3);
			char value[]= "  ";
			sprintf(value, "%s", token3);	
			
			hash_insert(hash, field, "YO");				
		}
	}

}
