package org.kitchenstudio.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/image")
public class ImageRestController {

	@RequestMapping("/temp")
	String temp(MultipartFile file, HttpServletRequest request) {

		try {
			String syspath = request.getServletContext().getRealPath("/");
			File upload = new File(syspath + "/upload");

			if (!upload.isDirectory()) {
				upload.mkdir();
			}

			System.out.println(upload.getPath());
			String[] name = file.getOriginalFilename().split("\\.");
			String suffix = name[name.length - 1];
			File tempFile = File.createTempFile("img", "." + suffix, upload);
			file.transferTo(tempFile);

			return request.getContextPath() + "/upload/" + tempFile.getName();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
