package com.apk.manager.hibernate.mapping;

// Generated Sep 23, 2014 3:14:58 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ApplicationDetails generated by hbm2java
 */
@Entity
@Table(name = "application_details", catalog = "apk_manager")
public class ApplicationDetails implements java.io.Serializable {

	private Integer appId;
	private String appName;
	private String appOwner;
	private String appVer;
	private Date date;
	private boolean isActive;

	public ApplicationDetails() {
	}

	public ApplicationDetails(String appName, String appOwner, String appVer,
			Date date, boolean isActive) {
		this.appName = appName;
		this.appOwner = appOwner;
		this.appVer = appVer;
		this.date = date;
		this.isActive = isActive;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "APP_ID", unique = true, nullable = false)
	public Integer getAppId() {
		return this.appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	@Column(name = "APP_NAME", nullable = false, length = 45)
	public String getAppName() {
		return this.appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	@Column(name = "APP_OWNER", nullable = false, length = 45)
	public String getAppOwner() {
		return this.appOwner;
	}

	public void setAppOwner(String appOwner) {
		this.appOwner = appOwner;
	}

	@Column(name = "APP_VER", nullable = false, length = 45)
	public String getAppVer() {
		return this.appVer;
	}

	public void setAppVer(String appVer) {
		this.appVer = appVer;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE", nullable = false, length = 19)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "IS_ACTIVE", nullable = false)
	public boolean isIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}

}