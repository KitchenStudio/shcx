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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Purchase {

	@Id
	@GeneratedValue
	private Long id;

	 @ManyToOne(optional = false)
	 @JoinColumn(name = "STAFF_ID", nullable = false, updatable = true)
	 private Staff buyer;

	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(iso = ISO.DATE)
	@NotNull
	private Date createdTime;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "PURCHASE_ID")
	private List<PurchaseItem> purchaseItems = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Staff getBuyer() {
		return buyer;
	}

	public void setBuyer(Staff buyer) {
		this.buyer = buyer;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public List<PurchaseItem> getPurchaseItems() {
		return purchaseItems;
	}

	public void setPurchaseItems(List<PurchaseItem> items) {
		this.purchaseItems = items;
	}

}
