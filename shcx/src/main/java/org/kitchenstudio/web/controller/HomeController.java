package org.kitchenstudio.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("")
public class HomeController {

	@RequestMapping({ "", "/index.html" })
	String home() {
		return "home";
	}
}
