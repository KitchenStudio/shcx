package org.kitchenstudio.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Purchase {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(optional = false)
	@JoinColumn(name = "STAFF_ID", nullable = true, updatable = false)
	private Staff buyer;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "PURCHASE_ID")
	private Set<PurchaseItem> purchaseItems;

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

	public Set<PurchaseItem> getPurchaseItems() {
		return purchaseItems;
	}

	public void setPurchaseItems(Set<PurchaseItem> purchaseItems) {
		this.purchaseItems = purchaseItems;
	}

}
