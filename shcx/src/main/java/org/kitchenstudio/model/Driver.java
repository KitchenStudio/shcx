package org.kitchenstudio.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.kitchenstudio.model.Staff.GenderType;


@Entity
public class Driver {

	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String plate_number;
	
	private String phone_number;
	
	@Enumerated(EnumType.STRING)
	private GenderType gender;
	
	public enum gender{
		MALE,FEMALE;
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



	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPlate_number() {
		return plate_number;
	}

	public void setPlate_number(String plate_number) {
		this.plate_number = plate_number;
	}
}
