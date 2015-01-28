package org.kitchenstudio.service;

import java.util.List;

import org.kitchenstudio.model.Driver;

public interface DriverService {
	
	List<Driver> findAll();
	void add(Driver driver);
	void delete(Driver driver);
}
