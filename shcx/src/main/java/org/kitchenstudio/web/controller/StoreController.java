package org.kitchenstudio.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
public class StoreController {

	@RequestMapping({ "", "/" })
	String home() {
		return "store/home";
	}

}
