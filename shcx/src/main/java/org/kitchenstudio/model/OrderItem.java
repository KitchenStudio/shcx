package org.kitchenstudio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@NotBlank(message="不能为空")
	private String type;// 钢管还是扣件
	
	@NotBlank(message="不能为空")
	private String kind;// 钢管的类型和扣件
	
//	@NotBlank(message="不能为空")
//	private int quantity;// 钢管的总长度或者是扣件的总数量

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

//	public int getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}

}
