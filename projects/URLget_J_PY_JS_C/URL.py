class Url:
	map = {} #global variables

	def __init__(self, url):
		self.url = url
		urlString = self.url.split("?")	#splits up the domain name and query string
		if len(urlString) == 1:	 #if there is no query string
			print "You gave only the domain name"
		else:
			query = urlString[1]
			fields = query.split("&")  #splits if there are two or more fields
			for index in range(len(fields)):  #iterates through each field
				fValues = fields[index].split("=") #splits the fields and values
				Url.map[fValues[0]] = fValues[1] #shows the power of dictionaries!!	
	
	def getUrl(self):
		return self.url;

	def getValue(self, key):
		return Url.map.get(key);	
	
