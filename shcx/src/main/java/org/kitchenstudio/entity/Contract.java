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

@Entity
public class Contract {

	@Id
	@GeneratedValue
	private Long id;

	private String lessor;

	private String lessee;
	

	@ManyToOne(optional = false)
	@JoinColumn(name = "COMPANY_ID")
	private Company company;
	
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}



	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "CONTRACT_ID")
//	@Valid
	private List<ContractItem> contractItems = new ArrayList<ContractItem>(); 

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLessor() {
		return lessor;
	}

	public void setLessor(String lessor) {
		this.lessor = lessor;
	}

	public String getLessee() {
		return lessee;
	}

	public void setLessee(String lessee) {
		this.lessee = lessee;
	}

	// public Staff getHandler() {
	// return handler;
	// }
	//
	// public void setHandler(Staff handler) {
	// this.handler = handler;
	// }

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public List<ContractItem> getContractItems() {
		return contractItems;
	}

	public void setContractItems(List<ContractItem> contractItems) {
		this.contractItems = contractItems;
	}

	@PrePersist
	void onInserted() {
		createdTime = new Date();
	}
}
