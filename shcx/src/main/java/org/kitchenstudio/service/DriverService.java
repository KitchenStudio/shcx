package org.kitchenstudio.service;

import java.util.List;

import org.kitchenstudio.entity.Driver;

public interface DriverService {
	
	List<Driver> findAll();
	void save(Driver driver);
	void delete(Driver driver);
}
