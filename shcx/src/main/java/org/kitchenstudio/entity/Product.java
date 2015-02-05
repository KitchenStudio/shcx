package org.kitchenstudio.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@ManyToOne(optional = false)
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	private ProductCategory category;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "PRODUCT_ID")
	private List<ProductSpecification> specifications = new ArrayList<>();

	public Product() {
		
	}

	public Product(String name, ProductCategory category,
			List<ProductSpecification> specifications) {
		this.name = name;
		this.category = category;
		this.specifications = specifications;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public List<ProductSpecification> getSpecifications() {
		return specifications;
	}

	public void setSpecifications(List<ProductSpecification> specifications) {
		this.specifications = specifications;
	}

}
