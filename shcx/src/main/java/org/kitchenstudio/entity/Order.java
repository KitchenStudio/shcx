package org.kitchenstudio.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity(name = "TABLE_ORDER")
public class Order {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "CUST_ID", nullable = false)
	private Staff operator;// 经手人

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "ORDER_ID")
	@Valid
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();// 多个订单项

	@Enumerated(EnumType.STRING)
	private OrderType type;

	@ManyToOne
	@JoinColumn(name = "DRIVER_ID")
	private Driver driver;

	@ManyToOne
	@JoinColumn(name = "CONTRACT_ID")
	@NotNull
	private Contract contract;

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Staff getOperator() {
		return operator;
	}

	public void setOperator(Staff operator) {
		this.operator = operator;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

}
