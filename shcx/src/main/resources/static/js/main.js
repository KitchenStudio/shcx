$(function() {
	$(".delete-link").click(function() {
		var href = '/api/v1' + $(this).attr('href');
		$('#alert-modal #confirm').click(function() {
			$.post(href, function() {
				// 刷新页面
				window.location.reload();
			});
		});
		$('#alert-modal').modal('show');
		return false;
	});
	
	$("#uploadpicture").click(function(){
		console.log("card");
		
	});

	$(".has-error").hover(function() {
		$(this).tooltip('show');
	}, function() {
		$(this).tooltip('hide');
	});
});