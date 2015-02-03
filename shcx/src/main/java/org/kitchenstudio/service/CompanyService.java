package org.kitchenstudio.service;

import java.util.List;

import org.kitchenstudio.entity.Company;

public interface CompanyService {
	
	void save(Company company);
	
	List<Company> findAll();
}
