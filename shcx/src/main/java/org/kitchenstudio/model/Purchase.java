package org.kitchenstudio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Purchase {
	
	@Id
	@GeneratedValue
	private Long id;
	
	
}
