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
	
//	$("#uploadpicture").click(function(){
//		console.log("card");
//		
//	});

	$(".has-error").hover(function() {
		$(this).tooltip('show');
	}, function() {
		$(this).tooltip('hide');
	});
	
	var url = "/api/v1/image/temp";
	$("#fileupload").fileupload({
		url: url,
        previewMaxWidth: 100,
        previewMaxHeight: 100,
        previewCrop: true,
		done: function (e, data) {
			$("#uploadpicture").prop('src', data.result);
		}, 
		progressall: function (e, data) {
			var progress = parseInt(data.loaded / data.total * 100, 10);
			console.log(progress);
		}
	});
});