define(["credits","products"], function(credits, products){
    console.log("Function : purchaseProduct");

    return {
        purchaseProduct: function(){
        var credit = credits.getCredits();
        var no = credits.noCredits();
        if(credit > 0){
            products.reserveProduct();
            return true;
        }
        return false;
        }
    }
});
