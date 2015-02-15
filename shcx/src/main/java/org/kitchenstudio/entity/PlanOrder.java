package org.kitchenstudio.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class PlanOrder {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "OPERATOR_ID", nullable = false)
	private Staff operator;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "ORDER_ID")
	@Valid
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();// 多个订单项

	@ManyToOne
	@JoinColumn(name = "CONTRACT_ID")
	@NotNull
	private Contract contract;

	@ManyToOne(optional = false)
	@JoinColumn(name = "SITE_ID", nullable = false)
	private Site Site;

	private boolean confirmed;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
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

	public boolean isConfirmed() {
		return confirmed;
	}

	public void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@PrePersist
	void onCreated() {
		createdTime = new Date();
	}

}
