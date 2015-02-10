package org.kitchenstudio.controller;

import java.util.List;

import org.kitchenstudio.entity.Company;
import org.kitchenstudio.entity.Site;
import org.kitchenstudio.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyRestController {
	
	@RequestMapping(value = "/{id}/sites", method = RequestMethod.GET)
	List<Site> getSites(@PathVariable("id") Company company) {
		return siteService.findByCompany(company);
	}
	
	@Autowired
	private SiteService siteService;
	
}
