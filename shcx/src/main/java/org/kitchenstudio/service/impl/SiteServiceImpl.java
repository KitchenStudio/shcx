package org.kitchenstudio.service.impl;

import java.util.List;

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
		// TODO Auto-generated constructor stub
		 this.siteRepository=siteRepository;
	}
	@Override
	public List<Site> findAll() {
		// TODO Auto-generated method stub
		return siteRepository.findAll();
	}
}
