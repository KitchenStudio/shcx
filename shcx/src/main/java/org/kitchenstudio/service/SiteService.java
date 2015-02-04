package org.kitchenstudio.service;

import java.util.List;

import org.kitchenstudio.entity.Site;

public interface SiteService {
	
	List<Site>findAll();
	void add(Site site);
	void delete(Site site);

}
