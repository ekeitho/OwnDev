var _= require('underscore');

module.exports = function(string)
{
	// splits the single word into a list of characters
	this.string = string.toLowerCase();
	this.list = string.match(/.{1}/g);
	// sorts the list for comparison use
	this.list.sort();

	// this method takes a list as its parameters
	this.match = function(stringList)
	{
		list = [];

		for ( var i = 0; i < stringList.length; i++)
		{
			// each word is put into their list of characters
			inputList = stringList[i].match(/.{1}/g);
			inputList.sort();

			// used underscores method to see if the list were equal
			// if they are equal then I put the word into the returned list
			if (_.isEqual(inputList, this.list))
			{
				list.push(stringList[i]);
			}
		}

		return list;
	};

};


