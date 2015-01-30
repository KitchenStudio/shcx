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
	

	$(".has-error input").hover(function() {
		$(this).tooltip('show');
	}, function() {
		$(this).tooltip('hide');
	});
	
	$("#fileupload").change(function(e){
		loadImage(
				e.target.files[0],
				function (img) {
					$("#upload-area").html(img);
				},
				{maxWidth: 120}
		);
	});
});

