package org.kitchenstudio;

import org.kitchenstudio.model.Staff;
import org.kitchenstudio.repository.StaffRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshedEventHandler implements
		ApplicationListener<ContextRefreshedEvent> {

	private static final Logger logger = LoggerFactory
			.getLogger(ContextRefreshedEventHandler.class);
	
	@Autowired
	private StaffRepository staffRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info("Context Refreshed!");
		
		Staff staff = new Staff();
		staff.setId(3L);
		staff.setName("张琳");
		staff.setIDCard("350322199203140552");
		staff.setBankNumber("1234123412341234123");
		
		staffRepository.save(staff);

	}

}