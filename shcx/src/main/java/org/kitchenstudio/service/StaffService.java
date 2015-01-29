package org.kitchenstudio.service;

import java.util.List;

import org.kitchenstudio.model.Staff;

public interface StaffService {

	List<Staff> findAll();
	void add(Staff staff);
	void delete(Staff staff);
	void save(Staff staff);
}
