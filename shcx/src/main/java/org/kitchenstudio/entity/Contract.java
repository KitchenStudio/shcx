package org.kitchenstudio.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	@ManyToOne(optional = false)
	@JoinColumn(name = "LESSOR_ID")
	private Company lessor;

	@ManyToOne(optional = false)
	@JoinColumn(name = "LESSEE_ID")
	private Company lessee;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTime;

	@OneToMany(orphanRemoval = true)
	@JoinColumn(name = "CONTRACT_ID")
	private List<ContractItem> contractItems = new ArrayList<ContractItem>();

	@Enumerated(EnumType.STRING)
	private ContractStatus status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Company getLessor() {
		return lessor;
	}

	public void setLessor(Company lessor) {
		this.lessor = lessor;
	}

	public Company getLessee() {
		return lessee;
	}

	public void setLessee(Company lessee) {
		this.lessee = lessee;
	}

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
		status = ContractStatus.CREATED;
	}

	public ContractStatus getStatus() {
		return status;
	}

	public void setStatus(ContractStatus status) {
		this.status = status;
	}
}
