package org.kitchenstudio.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Person {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "PERSON_ID")
	// join column is in table for Order
	private List<Number> numbers;

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

	public List<Number> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Number> numbers) {
		this.numbers = numbers;
	}
}
