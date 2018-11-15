package com.nviera.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Kittu Kiran
 * @created date	: 31 Jan 2017
 * @modified by		:
 * @modified date	:
 */

@Entity
@Table(name = "admin_details")

public class AdminDetailsBean {
	
	@Id
	@GeneratedValue
	@Column(name = "admin_details_id")
	private Integer adminSerialNumber;
	
	@Column(name = "admin_details_userid")
	private String adminUserId;
	
	@Column(name = "admin_details_password")
	private String adminPassword;
	
	@Column(name = "admin_details_birth_place")
	private String adminPlaceOfBirth;
	
	@Column(name = "admin_details_birth_city")
	private String adminPlaceOfCity;
	
	@Column(name = "admin_details_dob")
	private Date adminDOB;
	
	@Column(name = "admin_details_sta")
	private String adminStatus;
	
	@Column(name = "admin_details_created_by")
	private String adminCreatedBy;
	
	@Column(name = "admin_details_created_on")
	private Date adminCreatedOn;
	
	@Column(name = "admin_details_created_time")
	private String adminCreatedTime;

	/**
	 * @return the serialNumber
	 */
	public Integer getSerialNumber() {
		return adminSerialNumber;
	}

	/**
	 * @param serialNumber the serialNumber to set
	 */
	public void setSerialNumber(Integer serialNumber) {
		this.adminSerialNumber = serialNumber;
	}

	/**
	 * @return the adminUserId
	 */
	public String getAdminUserId() {
		return adminUserId;
	}

	/**
	 * @param adminUserId the adminUserId to set
	 */
	public void setAdminUserId(String adminUserId) {
		this.adminUserId = adminUserId;
	}

	/**
	 * @return the adminPassword
	 */
	public String getAdminPassword() {
		return adminPassword;
	}

	/**
	 * @param adminPassword the adminPassword to set
	 */
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	/**
	 * @return the adminPlaceOfBirth
	 */
	public String getAdminPlaceOfBirth() {
		return adminPlaceOfBirth;
	}

	/**
	 * @param adminPlaceOfBirth the adminPlaceOfBirth to set
	 */
	public void setAdminPlaceOfBirth(String adminPlaceOfBirth) {
		this.adminPlaceOfBirth = adminPlaceOfBirth;
	}

	/**
	 * @return the adminPlaceOfCity
	 */
	public String getAdminPlaceOfCity() {
		return adminPlaceOfCity;
	}

	/**
	 * @param adminPlaceOfCity the adminPlaceOfCity to set
	 */
	public void setAdminPlaceOfCity(String adminPlaceOfCity) {
		this.adminPlaceOfCity = adminPlaceOfCity;
	}

	/**
	 * @return the adminDOB
	 */
	public Date getAdminDOB() {
		return adminDOB;
	}

	/**
	 * @param adminDOB the adminDOB to set
	 */
	public void setAdminDOB(Date adminDOB) {
		this.adminDOB = adminDOB;
	}

	/**
	 * @return the adminStatus
	 */
	public String getAdminStatus() {
		return adminStatus;
	}

	/**
	 * @param adminStatus the adminStatus to set
	 */
	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

	/**
	 * @return the adminCreatedBy
	 */
	public String getAdminCreatedBy() {
		return adminCreatedBy;
	}

	/**
	 * @param adminCreatedBy the adminCreatedBy to set
	 */
	public void setAdminCreatedBy(String adminCreatedBy) {
		this.adminCreatedBy = adminCreatedBy;
	}

	/**
	 * @return the adminCreatedOn
	 */
	public Date getAdminCreatedOn() {
		return adminCreatedOn;
	}

	/**
	 * @param adminCreatedOn the adminCreatedOn to set
	 */
	public void setAdminCreatedOn(Date adminCreatedOn) {
		this.adminCreatedOn = adminCreatedOn;
	}

	/**
	 * @return the adminCreatedTime
	 */
	public String getAdminCreatedTime() {
		return adminCreatedTime;
	}

	/**
	 * @param adminCreatedTime the adminCreatedTime to set
	 */
	public void setAdminCreatedTime(String adminCreatedTime) {
		this.adminCreatedTime = adminCreatedTime;
	} 
}
