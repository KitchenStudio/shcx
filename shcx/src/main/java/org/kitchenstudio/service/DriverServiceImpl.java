package org.kitchenstudio.service;

import java.util.List;

import org.kitchenstudio.model.Driver;
import org.kitchenstudio.repository.DriverRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService{

	private final DriverRespository driverRespository;
	
	@Autowired
	public DriverServiceImpl(DriverRespository driverRespository){
		this.driverRespository = driverRespository;
	}
	
	@Override
	public List<Driver> findAll() {
		return driverRespository.findAll();
	}

	@Override
	public void add(Driver driver) {
		driverRespository.save(driver);
	}

	@Override
	public void delete(Driver driver) {
		driverRespository.delete(driver);
	}

}
