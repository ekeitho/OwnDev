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


	Hash *hash = hash_new(100);
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
		char *token1; //need another token for the = seperator
		char *token2;
		char *permtoken;
		char *permtoken2;
		temp = strdup(token); //loads 'field=value'



		while( (token1 = strsep(&temp, "=")) != NULL )
		{

			permtoken = malloc(sizeof(char)* (strlen(token1)+1));
			strcpy(permtoken, token1);
			
			token2 = strsep(&temp, "=");
			permtoken2 = malloc(sizeof(char)*strlen(token2)+1);
			strcpy(permtoken2, token2);			

			hash_insert(hash, permtoken, permtoken2);				
		}
	}

}
