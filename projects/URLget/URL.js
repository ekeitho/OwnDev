var urlString;
var map;

function URL (urlString)
{
	this.urlString = urlString;

	var query = new Array();
	
	var query = urlString.split("?");

	var fields = new Array();

	var fields = query[1].split("&");

	map = new Map();

	for(var count = 0; count < fields.length; count++)
	{
	
	    var fValues = new Array();	
	    fValues = fields[count].split("=");

	    map.put( fValues[0], fValues[1]);	
	}
}

URL.prototype.getField = function(field)
{
	return map.get(field);
}

function Map()
{
	this.keys = new Array();
        this.data = new Object();

        this.put = function(key, value)
        {
    	       if(this.data[key] == null)
               {
               		this.keys.push(key);
               }
               this.data[key] = value;
        };

        this.get = function(key)
        {
  	        return this.data[key];
        };
}

var feedback = new URL("http://ekeitho.com?post=13&tag=running");
console.log( feedback.getField("post") );

