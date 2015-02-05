$(function() {
	var freshProduct = function() {
		var category = $(this).val();
		var product = $(this).parents(".row").find(".product");
		var oldVal = product.val();
		$.get("/api/v1/product", {
			category : category
		}, function(products) {
			var newVal = 0;
			if (products[0]) {
				newVal = products[0].id;
			}
			product.find("option").remove();
			for (var i = 0; i < products.length; i++) {
				// 如果选项中存在原来的值
				if (products[i].id == oldVal) {
					newVal = oldVal;
				}
				product.append(new Option(products[i].name, products[i].id));
			}
			product.val(newVal);
		}, 'json')
	};
	$(".category").each(freshProduct);
	$(".category").change(freshProduct);
});
