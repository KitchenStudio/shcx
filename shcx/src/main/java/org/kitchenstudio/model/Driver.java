package org.kitchenstudio.model;

import javax.persistence.Entity;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
//import org.kitchenstudio.model.Staff.GenderType;


@Entity
public class Driver {

	@Id
	@GeneratedValue
	private Long id;//司机id
	
	@NotBlank(message="姓名不能为空！")
	private String name;//司机姓名
	
	@Length(min = 7, max = 7, message = "车牌号=省的简称+城市代号+5位号码,共7位")
	private String plateNumber;//司机车牌号
	
	@NotBlank(message="联系电话不能为空！")
	private String phoneNumber;//司机联系电话
	
	@Length(min = 18, max = 18, message = "身份证长度不符合")
	private String IDcard;//司机身份证号
	
	//@NotBlank(message="地址不能为空")
	private String address;// 司机的地址
	
	private String nation;// 民族
	
	private String bankNumber;
	
//	@Enumerated(EnumType.STRING)
//	private GenderType gender;
//	
//	public enum gender{
//		MALE,FEMALE;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



//	public GenderType getGender() {
//		return gender;
//	}
//
//	public void setGender(GenderType gender) {
//		this.gender = gender;
//	}


	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPlateNumber() {
		return plateNumber;
	}
	
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getIDcard() {
		return IDcard;
	}

	public void setIDcard(String iDcard) {
		IDcard = iDcard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}
}
