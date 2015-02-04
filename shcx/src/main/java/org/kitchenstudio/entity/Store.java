package org.kitchenstudio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;

@Entity
public class Store {
	
	@Id
	@GeneratedValue
	Long id;
	
	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "STORE_ID", nullable = false, updatable = true)
	@Valid
	private Purchase purchase;
	
	private Site site;
	
	private int quantity;
	
	
	
	

}
