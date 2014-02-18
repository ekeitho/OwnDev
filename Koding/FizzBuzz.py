def FizzBuzz(number):
		string = ''
		if (number%3 == 0):
			string = "Fizz"
		if (number%5 == 0):
			string += "Buzz"
		if string == None:
			print number
		else:
			print string