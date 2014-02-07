
module.exports = function(info)
{
	var dict = {};

	var input = info.split(/\W/);


	for (var count =0; count < input.length; count++)
	{
		if( input[count] == "")
		{
			continue;
		}
		else if( dict[input[count]] == null)
		{
			dict[input[count]] = 1;
		}
		else
		{
			var value = dict[input[count]];
			value++;
			dict[input[count]] = value;
		}
	}
	return dict;
}
