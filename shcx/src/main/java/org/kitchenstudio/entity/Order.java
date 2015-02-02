package org.kitchenstudio.entity;

import java.text.SimpleDateFormat;
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

@Entity(name = "ORD")
public class Order {

	@Id
	private Long id;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull
	private Date date;

	private int isOut;// 0代表进料单，1代表出料单

	// ManyToOne
	// private 项目
	@ManyToOne(optional = false)
	@JoinColumn(name = "CUST_ID", nullable = false)
	private Staff handler;// 经手人

	@NotBlank(message = "不能为空")
	private String renter;// 出租方

	@NotBlank(message = "不能为空")
	private String lessee;// 承租方

	@OneToMany
	@JoinColumn(name = "ORDER_ID")
	@Valid
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();// 多个订单项

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getIsOut() {
		return isOut;
	}

	public void setIsOut(int isOut) {
		this.isOut = isOut;
	}

	public Staff getHandler() {
		return handler;
	}

	public void setHandler(Staff handler) {
		this.handler = handler;
	}

	public String getRenter() {
		return renter;
	}

	public void setRenter(String renter) {
		this.renter = renter;
	}

	public String getLessee() {
		return lessee;
	}

	public void setLessee(String lessee) {
		this.lessee = lessee;
	}

	@PrePersist
	void generateId() {
		SimpleDateFormat format = new SimpleDateFormat("YYYYMMDDhhmm");
		String s = format.format(new Date());
		id = Long.parseLong(s);
	}

	// private Driver;
	// private plateNumber;
	// private 单子的状态 ：刚刚创建，正在装货，在途，到达
	//

}
