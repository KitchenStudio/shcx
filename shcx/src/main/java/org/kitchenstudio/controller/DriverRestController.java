package org.kitchenstudio.controller;

import org.kitchenstudio.model.Driver;
import org.kitchenstudio.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/driver")
public class DriverRestController {

	@Autowired
	private DriverService driverService;

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
	void delete(@PathVariable("id") Driver driver) {
		driverService.delete(driver);
	}
}
