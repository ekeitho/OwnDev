define(function(products){

    return {
        getCredits: function(){
            console.log("Function : getCredits");
            var credits = "100"
            return credits;
        },
        noCredits: function(){
        	console.log("Function : noCredits")
        	var credits = "200"
        	return credits;
        }

    }
});
