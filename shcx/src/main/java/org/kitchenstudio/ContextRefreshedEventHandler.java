package org.kitchenstudio;

import org.kitchenstudio.entity.Company;
import org.kitchenstudio.entity.Contract;
import org.kitchenstudio.entity.Driver;
import org.kitchenstudio.entity.Product;
import org.kitchenstudio.entity.ProductCategory;
import org.kitchenstudio.entity.ProductSpecification;
import org.kitchenstudio.entity.Staff;
import org.kitchenstudio.entity.Type;
import org.kitchenstudio.repository.CompanyRepository;
import org.kitchenstudio.repository.ContractRepository;
import org.kitchenstudio.repository.DriverRepository;
import org.kitchenstudio.repository.ProductCategoryRepository;
import org.kitchenstudio.repository.ProductRepository;
import org.kitchenstudio.repository.ProductSpecificationRepository;
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

	@Autowired
	private ContractRepository contractRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductCategoryRepository categoryRepository;

	@Autowired
	private ProductSpecificationRepository specificationRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info("Context Refreshed!");

		// 产品初始化
		// 存储分类
		ProductCategory category = new ProductCategory();
		category.setName("租赁");

		categoryRepository.save(category);

		// 存储规格
		ProductSpecification specification = new ProductSpecification();
		specification.setName("1.1米");

		specificationRepository.save(specification);

		// 存储产品
		for (int i = 0; i < 10; i++) {
			Product product = new Product();
			product.setName("钢管"+i);
			product.setCategory(category);
			product.getSpecifications().add(specification);

			productRepository.save(product);
		}

		// 员工初始化
		for (int i = 0; i < 10; i++) {
			Staff staff = new Staff();
			staff.setName("王小欣" + i);
			staff.setPhoneNumber("18366110000");
			staff.setIDCard("328333922232323224");
			staff.setBankNumber("1234123412341234123");

			staffRepository.save(staff);
		}

		// 司机初始化
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

		// 公司初始化
		for (int i = 0; i < 10; i++) {
			Company company = new Company();
			company.setAddress("地址" + i);
			company.setCharger("changer" + i);
			company.setName("name" + i);
			companyRepository.save(company);
		}

		// for(int i=0;i<10;i++){
		// Contract contract = new Contract();
		// contract.set
		// }
		// 合同初始化
		// contractRepository.save(new Contract());

	}
}
