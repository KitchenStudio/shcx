package org.kitchenstudio.service.impl;

import java.util.List;

import org.kitchenstudio.entity.Staff;
import org.kitchenstudio.repository.StaffRepository;
import org.kitchenstudio.service.StaffService;
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

	@Override
	public Staff findOne(Long id) {
		return staffRepository.findOne(id);
	}

}
