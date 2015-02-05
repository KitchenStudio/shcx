package org.kitchenstudio.service;

import java.util.List;

import org.kitchenstudio.entity.Product;
import org.kitchenstudio.entity.ProductCategory;

public interface ProductService {

	List<Product> findAll();

	List<ProductCategory> allCategories();

}
