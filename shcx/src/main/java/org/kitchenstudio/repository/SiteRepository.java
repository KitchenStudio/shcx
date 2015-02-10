package org.kitchenstudio.repository;

import org.kitchenstudio.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.kitchenstudio.entity.Company;
import java.util.List;

public interface SiteRepository extends JpaRepository<Site, Long>{

	List<Site> findByCompany(Company company);
}
