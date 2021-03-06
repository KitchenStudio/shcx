package org.kitchenstudio.service.impl;

import java.util.List;

import org.kitchenstudio.entity.Driver;
import org.kitchenstudio.repository.DriverRepository;
import org.kitchenstudio.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {

	private final DriverRepository driverRepository;

	@Autowired
	public DriverServiceImpl(DriverRepository driverRespository) {
		this.driverRepository = driverRespository;
	}

	@Override
	public List<Driver> findAll() {
		return driverRepository.findAll();
	}

	@Override
	public void save(Driver driver) {
		driverRepository.save(driver);
	}

	@Override
	public void delete(Driver driver) {
		driverRepository.delete(driver);
	}

}
