package org.kitchenstudio.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.kitchenstudio.model.Driver;
import org.kitchenstudio.model.Staff;
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
		model.addAttribute("driver",new Driver());
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
	String create(@Valid Driver driver, BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println(result.getAllErrors());
			return "/driver/new";
		}
		driverService.add(driver);
		return "redirect:/driver";
	}

	@RequestMapping("/delete/{id}")
	String delete(@PathVariable("id") Driver driver) {
		driverService.delete(driver);
		return "redirect:/driver";
	}
	
	@RequestMapping(value = "/info/{id}", method = RequestMethod.GET)
	String info(@PathVariable("id") Driver driver, Model model) {
		model.addAttribute(driver);
		return "driver/detail";
	}

	@RequestMapping(value = "/info", method = RequestMethod.POST)
	String info(@Valid Driver driver, BindingResult result) {
		if (result.hasErrors()) {
			return "driver/modify";
		}
		driverService.add(driver);
		return "driver/modifysuccess";
	}

	@RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
	String modify(@PathVariable("id") Driver driver, Model model) {
		model.addAttribute(driver);
		return "driver/modify";
	}

}
