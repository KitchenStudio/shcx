package org.kitchenstudio.web.controller;

import java.util.List;

import javax.validation.Valid;

import org.kitchenstudio.entity.Company;
import org.kitchenstudio.entity.Order;
import org.kitchenstudio.entity.Site;
import org.kitchenstudio.entity.SiteType;
import org.kitchenstudio.service.CompanyService;
import org.kitchenstudio.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/site")
public class SiteController {
	
	@Autowired
	SiteService siteService;
	
	@Autowired
	CompanyService companyService;
	
	@ModelAttribute("siteTypes")
	public SiteType [] populateSites(){
		return SiteType.values();
	}
	
	@ModelAttribute("companies")
	public List<Company> populateStaffs() {
		System.out.println(companyService.findAll().size()+"size");
		return companyService.findAll();
	}
	
	@RequestMapping({"","/"})
	String home(Model model){
		List<Site> sites = siteService.findAll();
		model.addAttribute("sites", sites);
		return "site/home";
	}
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	String create(Model model){
		if(!model.containsAttribute("site")){
			Site site = new Site();
			model.addAttribute(site);
		}
		return "site/new";
		
	}
	
	@RequestMapping(value="/new",method=RequestMethod.POST)
	String create(@Valid Site site,BindingResult result){
		if(result.hasErrors()){
			return"site/new";
		}
		siteService.add(site);
		return "redirect:/site";
	}
	
	@RequestMapping(value="/{id}/detail",method=RequestMethod.GET)
	String detail(@PathVariable("id")Site site,Model model){
		model.addAttribute(site);
		return "site/detail";
	}
	
	@RequestMapping(value="/{id}/modify",method=RequestMethod.GET)
	String modify(@PathVariable("id")Site site,Model model){
		model.addAttribute(site);
		return "site/modify";
	}
	@RequestMapping(value="/{id}/modify",method=RequestMethod.POST)
	String modify(@Valid Site site,BindingResult result){
		if(result.hasErrors()){
			return "site/modify";
		}
		siteService.add(site);
		return "redirect:/site/{id}/detail?success";
	}
	
	@RequestMapping("/{id}/delete")
	String delete(@PathVariable("id") Site site) {
		siteService.delete(site);
		return "redirect:/site";
	}
	
}
