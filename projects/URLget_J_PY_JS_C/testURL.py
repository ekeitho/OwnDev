import URL
	
ekeitho = URL.Url("http://www.ekeitho.com?toast=pb")
if ekeitho.getValue("toast") == "pb":
	print "Passed Test 1: Got Correct Value for ekeitho"
else:
	print "Failed Test 1: Wrong Value"

try:
	ekeitho.getValue("pb")
except KeyError:
	print "Passed Test 2: URL class passed the test with an unknown field"
else:
	print "Failed Test 2: returned an unknown field somehow."
