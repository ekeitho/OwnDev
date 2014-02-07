var Bob = function()
{

}
module.exports = Bob;

Bob.prototype.hey = function(spoke)
{
	if(spoke.search("\xc4") == -1 
		&& spoke.search("Let's") == -1 
			&& spoke.charAt(spoke.length) == '!' 
				|| spoke.slice(0,spoke.length-1).toUpperCase() == spoke.slice(0,spoke.length-1) )
	{
		return "Woah, chill out!";
	}

	else if( spoke.charAt(spoke.length) == "?" )
	{
		return "Sure.";
	}

	else if( spoke.length == 0 || spoke.valueOf() == 0)
	{
		return "Fine. Be that way!";
	}
	else
	{
		return "Whatever.";
	}

}