package org.kitchenstudio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;

@Entity
public class OrderItem implements StoreItem {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product product;

	@ManyToOne(optional = false)
	@JoinColumn(name = "SPEC_ID", nullable = false)
	private ProductSpecification specification;

	@Min(value = 1, message = "数量不小于 1")
	private int quantity;// 钢管的总长度或者是扣件的总数量

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductSpecification getSpecification() {
		return specification;
	}

	public void setSpecification(ProductSpecification specification) {
		this.specification = specification;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
