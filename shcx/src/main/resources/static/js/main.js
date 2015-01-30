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
	
//	var url = "/api/v1/image/temp";
//	$("#fileupload").fileupload({
//		url: url,
//        previewMaxWidth: 100,
//        previewMaxHeight: 100,
//        previewCrop: true,
//		done: function (e, data) {
//			$("#uploadpicture").prop('src', data.result);
//		}, 
//		progressall: function (e, data) {
//			var progress = parseInt(data.loaded / data.total * 100, 10);
//			console.log(progress);
//		}
//	});
//	$("#fileupload").onchange = function (e) {
//		function (e) {
//            e.preventDefault();
//            e = e.originalEvent;
//            var target = e.dataTransfer || e.target,
//                file = target && target.files && target.files[0],
//                options = {
//                    maxWidth: result.width(),
//                    canvas: true
//                };
//            if (!file) {
//                return;
//            }
//            exifNode.hide();
//            thumbNode.hide();
//            loadImage.parseMetaData(file, function (data) {
//                if (data.exif) {
//                    options.orientation = data.exif.get('Orientation');
//                    displayExifData(data.exif);
//                }
//                displayImage(file, options);
//            });
//        }
});

