var urlString;
var map = {};

function URL (urlString)
{
	this.urlString = urlString;

	//splits the url from the domain name
	//and the querry
	var url = urlString.split("?");

	//if there is no query string
	//the array size of 'url' will be 1
	if (url.length == 1)
	{
		console.log("Your URL doesn't contain a query.");
	}	

	else
	{
		//gets the query part of the URL
		var query = url[1];

		//if query has more than one field
		//then we must seperate them
		var fields = query.split("&");

		for(var count = 0; count < fields.length; count++)
		{
	
	    		var fValues = new Array();	
	    		fValues = fields[count].split("=");

			if( fValues.length == 1)
			{
				console.log("Found field without value.");
			}			

	    		map[fValues[0]] = fValues[1];
		}
	}
}

//practice using different method techniques in javascript

URL.prototype.getField = function(field)
{
	return map[field];
}

var feedback = new URL("http://ekeitho.com?post=13&tag=running");
console.log( feedback.getField("post") );

//makes sure that if it is not in the map, it returns 'undefined'
console.log( feedback.getField("kadlj") );

//will allow me to create a URL without a query string
//with no crash
var noQuery = new URL("http://ekeitho.com/");

//this tests that there is a field without a value
var noValue = new URL("http://ekeitho.com?toast");
