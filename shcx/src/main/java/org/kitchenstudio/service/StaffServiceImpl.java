package org.kitchenstudio.service;

import java.util.List;

import org.kitchenstudio.model.Staff;
import org.kitchenstudio.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffServiceImpl implements StaffService {

	private final StaffRepository staffRepository;

	@Autowired
	public StaffServiceImpl(StaffRepository staffRepository) {
		this.staffRepository = staffRepository;
	}

	@Override
	public List<Staff> findAll() {
		return staffRepository.findAll();
	}

	@Override
	public void add(Staff staff) {
		staffRepository.save(staff);
	}

	@Override
	public void delete(Staff staff) {
		staffRepository.delete(staff);
	}

	@Override
	public void save(Staff staff) {
		staffRepository.save(staff);
	}

}
