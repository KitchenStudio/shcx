package org.kitchenstudio.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Staff {

	@Id
	@GeneratedValue
	private Long id;// 员工的id

	@NotBlank(message = "不能为空")
	private String name;// 员工的姓名

	@Length(min = 18, max = 18, message = "身份证长度不符合")
	private String IDCard;// 员工的身份证号

	@Enumerated(EnumType.STRING)
	private GenderType gender;// 员工的性别

	private String type;// 员工的类型

	private String address;// 员工的地址

	private String phoneNumber;// 员工的电话号码

	private String pathFaceimage;

	public String getPathFaceimage() {
		return pathFaceimage;
	}

	public void setPathFaceimage(String pathFaceimage) {
		this.pathFaceimage = pathFaceimage;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	private String education;// 员工的学历

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date birthday;// 出生日期

	@Length(min = 19, max = 19, message = "银行卡号位数不符合")
	private String bankNumber;// 银行卡号

	private String nation;// 民族

	// private String

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

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

	public String getIDCard() {
		return IDCard;
	}

	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public enum GenderType {
		MALE, FEMALE
	}
}
