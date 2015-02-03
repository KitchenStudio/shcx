package org.kitchenstudio.repository;

import org.kitchenstudio.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
