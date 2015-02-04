package org.kitchenstudio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ProductSpecification {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	private double dim; // 量纲，比如 1.1米钢管量纲为1.1，只是借物理里面的词一用，不知道有没有更准确的词

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

	public double getDim() {
		return dim;
	}

	public void setDim(double dim) {
		this.dim = dim;
	}
}
