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

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class PlanOrder {

	@Id
	@GeneratedValue
	private Long id;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull
	private Date date;

	@ManyToOne(optional = false)
	@JoinColumn(name = "CUST_ID", nullable = false, updatable = true)
	private Staff handler; // 经手人

	@NotBlank(message = "不能为空")
	private String Lessor; // 出租方

	@NotBlank(message = "不能为空")
	private String lessee; // 承租方

	@OneToMany
	@JoinColumn(name = "ORDER_ID")
	@Valid
	private List<OrderItem> orderItems = new ArrayList<OrderItem>(); // 多个订单项

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date createdTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Staff getHandler() {
		return handler;
	}

	public void setHandler(Staff handler) {
		this.handler = handler;
	}

	public String getLessor() {
		return Lessor;
	}

	public void setLessor(String lessor) {
		Lessor = lessor;
	}

	public String getLessee() {
		return lessee;
	}

	public void setLessee(String lessee) {
		this.lessee = lessee;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@PrePersist
	protected void onCreated() {
		createdTime = new Date();
	}
}
