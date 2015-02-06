$(function() {
	$(".delete-link").click(function() {
		var href = 'api/v1' + $(this).attr('href');
		$('#alert-modal #confirm').click(function() {
			$.post(href, function() {
				// 刷新页面
				window.location.reload();
			});
		});
		$('#alert-modal').modal('show');
		return false;
	});

	$(".has-error input").hover(function() {
		$(this).tooltip('show');
	}, function() {
		$(this).tooltip('hide');
	});

	$("#fileupload").change(function(e) {
		loadImage(e.target.files[0], function(img) {
			$("#upload-area").html(img);
		}, {
			maxWidth : 120
		});
	});

	var refreshSpecification = function() {
		var product = $(this).val();
		var specification = $(this).parents(".row").find(".specification");
		var oldVal = specification.val();
		$.get("api/v1/product/" + product + "/specifications", function(
				specifications) {
			var newVal = 0;
			if (specifications[0]) {
				newVal = specifications[0].id;
			}
			specification.find("option").remove();
			for (var i = 0; i < specifications.length; i++) {
				// 如果选项中存在原来的值
				if (specifications[i].id == oldVal) {
					newVal = oldVal;
				}
				specification.append(new Option(specifications[i].name,
						specifications[i].id));
			}
			specification.val(newVal);
		}, 'json');
	};

	var refreshProduct = function() {
		var category = $(this).val();
		var product = $(this).parents(".row").find(".product");
		var oldVal = product.val();
		$.get("api/v1/product", {
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
			$(".product").each(refreshSpecification);
		}, 'json');
	};

	$(".category").each(refreshProduct);
	$(".product").each(refreshSpecification);
	$(".category").change(refreshProduct);
	$(".product").change(refreshSpecification);
});
