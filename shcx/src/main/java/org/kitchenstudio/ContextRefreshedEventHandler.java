package org.kitchenstudio;

import org.kitchenstudio.entity.Driver;
import org.kitchenstudio.entity.Staff;
import org.kitchenstudio.repository.DriverRepository;
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

	@Autowired
	private DriverRepository driverRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info("Context Refreshed!");

		for (int i = 0; i < 10; i++) {
			Staff staff = new Staff();
			staff.setName("张琳" + i);
			staff.setPhoneNumber("18366116016");
			staff.setIDCard("350322199203140552");
			staff.setBankNumber("1234123412341234123");

			staffRepository.save(staff);
		}

		for(int i=0;i<10;i++){
			Driver driver = new Driver();
			driver.setName("老司机"+i);
			driver.setBankNumber("123456789098765432"+i);
			driver.setIDcard("12345678901234567"+i);
			driver.setNation(""+i);
			driver.setPlateNumber("沪A1234"+i);
			driver.setPhoneNumber(""+i+i+i+i);
			
			driverRepository.save(driver);
		}
	}
}
