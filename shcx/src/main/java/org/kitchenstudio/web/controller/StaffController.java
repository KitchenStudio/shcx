package org.kitchenstudio.web.controller;

import java.util.List;

import org.kitchenstudio.model.Staff;
import org.kitchenstudio.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {

	@Autowired
	private StaffService staffService;

	@RequestMapping({ "", "/" })
	String home(Model model) {
		List<Staff> staffs = staffService.findAll();
		model.addAttribute("staffs", staffs);

		return "staff";
	}

	@RequestMapping("/add")
	String add(Staff staff) {
		staffService.add(staff);
		return "redirect:/staff";
	}
	
	@RequestMapping("/delete/{id}")
	String delete(@PathVariable("id") Staff staff) {
		staffService.delete(staff);
		return "redirect:/staff";
	}
}
