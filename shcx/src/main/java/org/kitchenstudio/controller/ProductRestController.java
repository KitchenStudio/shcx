package org.kitchenstudio.controller;

import java.util.List;

import org.kitchenstudio.entity.Product;
import org.kitchenstudio.entity.ProductCategory;
import org.kitchenstudio.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	List<Product> get(
			@RequestParam(value = "category", required = false) ProductCategory category) {

		if (category == null) {
			return productService.findAll();
		} else {
			return productService.findByCategory(category);
		}

	}
}
