package org.kitchenstudio.repository;

import org.kitchenstudio.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.kitchenstudio.entity.ProductCategory;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

	List<Product> findByCategory(ProductCategory category);

}
