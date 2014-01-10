import URL
	
ekeitho = URL.Url("http://www.ekeitho.com?toast=pb")
if ekeitho.getValue("toast") == "pb":
	print "Got Correct Value for ekeitho"
else:
	print "Wrong Value"

try:
	ekeitho.getValue("pb")
except KeyError:
	print "URL class passed the test with an unknown field"
else:
	print "Failed test and returned an unknown field somehow."
