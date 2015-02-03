package org.kitchenstudio;

import org.kitchenstudio.entity.Contract;
import org.kitchenstudio.entity.Driver;
import org.kitchenstudio.entity.Staff;
import org.kitchenstudio.entity.StoreItem;
import org.kitchenstudio.entity.StoreType;
import org.kitchenstudio.entity.Type;
import org.kitchenstudio.repository.ContractRepository;
import org.kitchenstudio.repository.DriverRepository;
import org.kitchenstudio.repository.StaffRepository;
import org.kitchenstudio.repository.StoreRepository;
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

	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private ContractRepository contactRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info("Context Refreshed!");

		for (int i = 0; i < 10; i++) {
			Staff staff = new Staff();
			staff.setName("王小欣" + i);
			staff.setPhoneNumber("18366110000");
			staff.setIDCard("328333922232323224");
			staff.setBankNumber("1234123412341234123");

			staffRepository.save(staff);
		}

		for (int i = 0; i < 10; i++) {
			Driver driver = new Driver();
			driver.setName("老司机" + i);
			driver.setBankNumber("123456789098765432" + i);
			driver.setIDcard("12345678901234567" + i);
			driver.setNation("" + i);
			driver.setPlateNumber("沪A1234" + i);
			driver.setPhoneNumber("" + i + i + i + i);

			driverRepository.save(driver);
		}
		
		contactRepository.save(new Contract());

		StoreItem storeItem = new StoreItem();
		storeItem.setStoreType(new StoreType(Type.STEEL_PIPE, "1.1"));
		storeItem.setQuantity(10);
		storeRepository.save(storeItem);

		storeItem = new StoreItem();
		storeItem.setStoreType(new StoreType(Type.STEEL_PIPE, "1.1"));
		storeItem.setQuantity(21);
		storeRepository.save(storeItem);

		storeItem = storeRepository.findOne(new StoreType(Type.STEEL_PIPE,
				"1.1"));
		logger.info(String.format("钢管1.1米有 --- %d 米", storeItem.getQuantity()));
	}
}
