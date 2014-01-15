#include <stdio.h>
#include <string.h>


typedef struct
{
	char urlString[100];
} URL;

void createUrlMap(URL *url);


int main()
{
	URL url;
	printf("Please enter a valid url string.");
	scanf("%s", url.urlString);

	createUrlMap(&url);	

}

void createUrlMap(URL *url)
{
	char *running, *token, *querry;
	char *fields[10];
	int count = 0;
	
	running = strdup(url->urlString);		
	while( (token = strsep(&running, "?")) != NULL)
	{
		if (count == 1)
		{
			querry = token;
			printf("HI");
		}
		count++;
	}

	count = 0;


	running = strdup(querry);
	while( (token = strsep(&running, "&")) != NULL )
	{
		fields[count] = token;		
	}

	

}
