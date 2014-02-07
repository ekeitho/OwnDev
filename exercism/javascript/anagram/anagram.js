var _= require('underscore');

module.exports = function(string)
{
	this.string = string.toLowerCase();
	this.list = string.match(/.{1}/g);
	this.list.sort();

	this.match = function(stringList)
	{
		list = [];

		for ( var i = 0; i < stringList.length; i++)
		{

			inputList = stringList[i].match(/.{1}/g);
			inputList.sort();

			if (_.isEqual(inputList, this.list))
			{
				list.push(stringList[i]);
			}
		}

		return list;
	};

};


