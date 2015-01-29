package org.kitchenstudio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String from;
	
	private String to;
	
	private String staff;

}
