package org.kitchenstudio.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.kitchenstudio.model.Driver;
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

		return "driver";
	}

	@RequestMapping("/add")
	String add(Driver driver) {
		driverService.add(driver);
		return "redirect:/driver";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	String create(Model model) {
		if (!model.containsAttribute("driver")) {
			Driver driver = new Driver();
			model.addAttribute(driver);
		}
		return "driver_new";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	String create(@Valid Driver dirver, BindingResult result) {
		if (result.hasErrors()) {
			return "diver_new";
		}
		return "redirect:/driver/new";
	}

	@RequestMapping("/delete/{id}")
	String delete(@PathVariable("id") Driver driver) {
		driverService.delete(driver);
		return "redirect:/driver";
	}
}
