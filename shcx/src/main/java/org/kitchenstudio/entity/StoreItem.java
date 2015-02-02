package org.kitchenstudio.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StoreItem {

	@Id
	private StoreType storeType;

	private int quantity;

	public StoreItem() { // for Hibernate
	}

	public StoreItem(StoreType storeType, int quantity) {
		this.storeType = storeType;
		this.quantity = quantity;
	}

	public StoreType getStoreType() {
		return storeType;
	}

	public void setStoreType(StoreType storeType) {
		this.storeType = storeType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
