package org.kitchenstudio.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ContractItem {

	@Id
	@GeneratedValue
	private Long id;

	private BigDecimal price;

	@ManyToOne(optional = false)
	@JoinColumn(name = "PRODUCT_ID")
	private Product product;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
