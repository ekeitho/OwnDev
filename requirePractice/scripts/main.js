requirejs.config({
	baseUrl: 'scripts/lib',

	shim: {
		'purchase': ['products', 'credits']
	},

	paths: {
		credits: '../credit/credits'
	}
});

requirejs(['purchase'], function(purchase){
	purchase.purchaseProduct();
})
