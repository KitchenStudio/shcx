package org.kitchenstudio.service.impl;

import java.util.List;

import org.kitchenstudio.entity.Company;
import org.kitchenstudio.entity.Site;
import org.kitchenstudio.repository.SiteRepository;
import org.kitchenstudio.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteServiceImpl implements SiteService{
	
	private final SiteRepository siteRepository;
	
	@Autowired
	 public SiteServiceImpl(SiteRepository siteRepository) {
		 this.siteRepository=siteRepository;
	}
	@Override
	public List<Site> findAll() {
		return siteRepository.findAll();
	}
	@Override
	public void add(Site site) {
		siteRepository.save(site);
	}
	
	@Override
	public void delete(Site site) {
		siteRepository.delete(site);
	}
	
	@Override
	public List<Site> findByCompany(Company company) {
		return siteRepository.findByCompany(company);
	}
}