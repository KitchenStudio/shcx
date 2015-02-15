package org.kitchenstudio.repository;

import org.kitchenstudio.entity.Product;
import org.kitchenstudio.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.kitchenstudio.entity.Site;

public interface StoreRepository extends JpaRepository<Store, Long>{

	Store findBySiteAndProduct(Site site, Product product);
}
