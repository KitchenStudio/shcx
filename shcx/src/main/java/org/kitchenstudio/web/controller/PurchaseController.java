package org.kitchenstudio.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/purchase")
public class PurchaseController {
	
	@RequestMapping({"", "/"})
	String home(){
		return "purchase/home";
	}
	
	@RequestMapping("/new")
	String create(){
		return "purchase/new";
	}

	
	
}
