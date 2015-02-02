package org.kitchenstudio.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@RequestMapping({ "", "/" })
	String home() {
		return "company/home";
	}

}
