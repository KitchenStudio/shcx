package org.kitchenstudio.web.controller;

import java.util.List;

import org.kitchenstudio.entity.Site;
import org.kitchenstudio.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/site")
public class SiteController {
	
	@Autowired
	SiteService siteService;
	
	@RequestMapping({"","/"})
	String home(Model model){
		List<Site> sites = siteService.findAll();
		model.addAttribute("sites", sites);
		return "site/home";
	}
}
