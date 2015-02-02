package org.kitchenstudio.web.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.kitchenstudio.entity.Driver;
import org.kitchenstudio.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/driver")
public class DriverController {
	private final static Logger log = LoggerFactory
			.getLogger(DriverController.class);

	@Autowired
	private DriverService driverService;

	@RequestMapping({ "", "/" })
	String home(Model model) {
		List<Driver> drivers = driverService.findAll();
		model.addAttribute("drivers", drivers);

		return "driver/list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	String add(Model model) {
		model.addAttribute("driver", new Driver());
		return "driver/new";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	String create(Model model) {
		if (!model.containsAttribute("driver")) {
			Driver driver = new Driver();
			model.addAttribute(driver);
		}
		return "driver/new";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	String create(@RequestParam("file") MultipartFile file,
			@Valid Driver driver, BindingResult result,
			HttpServletRequest request) {
		if (result.hasErrors()) {
			// System.out.println(result.getAllErrors());
			return "/driver/new";
		}
		driver.setPathFaceimage(getFaceimagePath(request, file));
		driverService.save(driver);
		return "redirect:/driver";
	}

	@RequestMapping("/{id}/delete")
	String delete(@PathVariable("id") Driver driver) {
		driverService.delete(driver);
		return "redirect:/driver";
	}

	@RequestMapping(value = "/{id}/info", method = RequestMethod.GET)
	String info(@PathVariable("id") Driver driver, Model model) {
		model.addAttribute(driver);
		return "driver/detail";
	}

	@RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
	String info(@RequestParam("file") MultipartFile file, @Valid Driver driver,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "driver/modify";
		}
		driver.setPathFaceimage(getFaceimagePath(request, file));
		driverService.save(driver);
		return "driver/modifysuccess";
	}

	@RequestMapping(value = "/{id}/modify", method = RequestMethod.GET)
	String modify(@PathVariable("id") Driver driver, Model model) {
		model.addAttribute(driver);
		return "driver/modify";
	}

	String getFaceimagePath(HttpServletRequest request, MultipartFile file) {
		String conPath = null;
		String sysPath = request.getServletContext().getRealPath("/");
		try {

			File fileUpload = new File(sysPath + "/upload");
			if (!fileUpload.isDirectory()) {
				fileUpload.mkdir();
			} else {
				fileUpload.delete();
				fileUpload.mkdir();
			}
			String[] name = file.getOriginalFilename().split("\\.");
			String suffix = name[name.length - 1];
			File tempFile = File
					.createTempFile("img", "." + suffix, fileUpload);
			file.transferTo(tempFile);
			conPath = request.getContextPath() + "/upload/"
					+ tempFile.getName();
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return conPath;
	}
}
