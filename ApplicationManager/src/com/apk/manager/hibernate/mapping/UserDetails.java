package com.apk.manager.hibernate.mapping;

// Generated Sep 23, 2014 3:14:58 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserDetails generated by hbm2java
 */
@Entity
@Table(name = "user_details", catalog = "apk_manager")
public class UserDetails implements java.io.Serializable {

	private Integer slNo;
	private String userName;
	private String password;
	private String firstName;
	private String middleName;
	private String lastName;
	private String department;
	private String contact;
	private Boolean isActive;

	public UserDetails() {
	}

	public UserDetails(String userName) {
		this.userName = userName;
	}

	public UserDetails(String userName, String password, String firstName,
			String middleName, String lastName, String department,
			String contact, Boolean isActive) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.department = department;
		this.contact = contact;
		this.isActive = isActive;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SL_NO", unique = true, nullable = false)
	public Integer getSlNo() {
		return this.slNo;
	}

	public void setSlNo(Integer slNo) {
		this.slNo = slNo;
	}

	@Column(name = "USER_NAME", nullable = false, length = 45)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PASSWORD", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "FIRST_NAME", length = 45)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "MIDDLE_NAME", length = 45)
	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	@Column(name = "LAST_NAME", length = 45)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "DEPARTMENT", length = 45)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "CONTACT", length = 45)
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "IS_ACTIVE")
	public Boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}