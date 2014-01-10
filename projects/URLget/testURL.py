import URL
	
ekeitho = URL.Url("http://www.ekeitho.com?toast=pb")
if ekeitho.getValue("toast") == "pb":
	print "Got Correct Value for ekeitho"
else:
	print "Wrong Value"
