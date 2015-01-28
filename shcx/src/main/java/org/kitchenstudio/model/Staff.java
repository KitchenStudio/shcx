package org.kitchenstudio.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;

@Entity
public class Staff {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@Length(min = 18, max = 18, message = "身份证长度不符合")
	private String IDCard;

	@Enumerated(EnumType.STRING)
	private GenderType gender;

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

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public enum GenderType {
		MALE, FEMALE
	}
}
