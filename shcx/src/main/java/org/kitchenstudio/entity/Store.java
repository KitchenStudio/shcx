package org.kitchenstudio.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Store {

	@Id
	@GeneratedValue
	Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	private Product product;

	@ManyToOne(optional = false)
	@JoinColumn(name = "SITE_ID", nullable = false)
	private Site site;

	private BigDecimal quantity;

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

	public Site getSite() {
		return site;
	}

	public void setSite(Site site) {
		this.site = site;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

}
