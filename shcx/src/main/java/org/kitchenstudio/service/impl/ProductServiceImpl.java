package org.kitchenstudio.service.impl;

import java.util.List;

import org.kitchenstudio.entity.Product;
import org.kitchenstudio.repository.ProductRepository;
import org.kitchenstudio.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	private final ProductRepository productRepository;
	
	@Autowired
	public ProductServiceImpl(ProductRepository productRepository) {
		// TODO Auto-generated constructor stub
		this.productRepository=productRepository;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

}
