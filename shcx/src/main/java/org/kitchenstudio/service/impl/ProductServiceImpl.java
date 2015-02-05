package org.kitchenstudio.service.impl;

import java.util.List;

import org.kitchenstudio.entity.Product;
import org.kitchenstudio.entity.ProductCategory;
import org.kitchenstudio.repository.ProductCategoryRepository;
import org.kitchenstudio.repository.ProductRepository;
import org.kitchenstudio.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	public ProductServiceImpl(ProductRepository productRepository,
			ProductCategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public List<ProductCategory> allCategories() {
		return categoryRepository.findAll();
	}
	
	@Override
	public List<Product> findByCategory(ProductCategory category) {
		return productRepository.findByCategory(category);
	}

	private final ProductRepository productRepository;

	private final ProductCategoryRepository categoryRepository;
}
