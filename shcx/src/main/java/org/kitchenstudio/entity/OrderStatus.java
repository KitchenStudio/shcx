package org.kitchenstudio.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class OrderStatus {

	@Id
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;

	@Enumerated(EnumType.STRING)
	private OrderStatusType type;

	@ManyToOne(optional = false)
	@JoinColumn(name = "ORDER_ID")
	private Order order;

	@ManyToOne(optional = false)
	@JoinColumn(name = "CUST_ID")
	private Staff operator;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public OrderStatusType getType() {
		return type;
	}

	public void setType(OrderStatusType type) {
		this.type = type;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Staff getOperator() {
		return operator;
	}

	public void setOperator(Staff operator) {
		this.operator = operator;
	}

}
