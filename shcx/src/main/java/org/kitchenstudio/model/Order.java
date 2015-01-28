package org.kitchenstudio.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Order {

	@Id
	@GeneratedValue
	private Long id;

	private String date;

	private int isOut;// 0代表进料单，1代表出料单
	
	//ManyToOne
	//private 项目
	private String handler;// 经手人

	private String renter;// 出租方

	private String lessee;// 承租方

	private Set<OrderItem> orderItems;//多个订单项
//	@OneToMany(targetEntity=org.kitchenstudio.model.OrderItem.class, 
//            mappedBy="order")
	@OneToMany(orphanRemoval=true)
	@JoinColumn(name="ORDER_ID", nullable=false)
	public Set<OrderItem> getOrderItems() { return orderItems; }
	
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getIsOut() {
		return isOut;
	}

	public void setIsOut(int isOut) {
		this.isOut = isOut;
	}

	public String getHandler() {
		return handler;
	}

	public void setHandler(String handler) {
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


	// private Driver;
	// private plateNumber;
	// private 单子的状态 ：刚刚创建，正在装货，在途，到达
	//

}
