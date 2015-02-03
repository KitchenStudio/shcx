package org.kitchenstudio.service.impl;

import java.util.List;

import org.kitchenstudio.entity.Company;
import org.kitchenstudio.repository.CompanyRepository;
import org.kitchenstudio.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

	private CompanyRepository companyRepository;
	
	@Autowired
	public CompanyServiceImpl(CompanyRepository companyRepository) {
		this.companyRepository=companyRepository;
	}
	
	@Override
	public void save(Company company) {
		// TODO Auto-generated method stub
		companyRepository.save(company);
	}
	
	@Override
	public List<Company> findAll() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}
}
