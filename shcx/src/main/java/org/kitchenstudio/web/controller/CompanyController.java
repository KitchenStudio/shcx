package org.kitchenstudio.web.controller;

import java.util.List;

import javax.validation.Valid;

import io.undertow.attribute.RequestMethodAttribute;

import org.kitchenstudio.entity.Company;
import org.kitchenstudio.entity.Staff;
import org.kitchenstudio.service.CompanyService;
import org.omg.CosNaming.BindingIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

	@RequestMapping({ "", "/" })
	String home(Model model) {
		List<Company> companies = companyService.findAll();
		model.addAttribute("companies", companies);
		return "company/home";
	}
	
	@RequestMapping(value="/new",method=RequestMethod.GET)
	String create(Model model){
		if(!model.containsAttribute("company")){
			Company company = new Company();
			model.addAttribute(company);
		}
		return "company/new";
	}

	@RequestMapping(value="/new",method=RequestMethod.POST)
	String create(@Valid Company company,BindingResult result){
		if(result.hasErrors()){
			return "company/new";
		}
		companyService.save(company);
		return "redirect:/company";
	}
	
	@RequestMapping(value="/{id}/detail",method=RequestMethod.GET)
	String detail(@PathVariable("id")Company company,Model model){
		model.addAttribute(company);
		return "/company/detail";
	}
	
	@RequestMapping(value="/{id}/modify",method=RequestMethod.GET)
	String modify(@PathVariable("id") Company company,Model model){
		model.addAttribute(company);
		return "company/modify";
	}
	
	@RequestMapping(value="/{id}/modify",method=RequestMethod.POST)
	String modify(@Valid Company company,BindingResult result){
		if(result.hasErrors()){
			return"company/modify";
		}
		companyService.save(company);
		return "redirect:/company/{id}/detail?success";
	}
}
