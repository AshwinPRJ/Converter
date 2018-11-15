package com.vyavharamitra.unitofmeasurement.bean;
import java.math.BigInteger;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vyavharamitra.utils.DbConstant;
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "bil_customer", schema = DbConstant.SCHEMA_NAME)
public class CustomerBean {
	@Id
	@Column(name = "customer_custid")
	private Integer customerId;
	
	@Column(name = "customer_custname")
	private String customerName;
	
	@Column(name = "customer_mobno")
	private BigInteger customerMobNo;
	
	@Column(name = "customer_enteredby")
	private String customerEnteredBy;
	
	@Column(name = "customer_entereddate")
	private Date customerEnteredDate;
	
	
	@Column(name = "customer_enteredtime")
	private String customerEnteredTime;
	
	@Column(name = "customer_branchid")
	private Integer customerBranchId;

	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * @return the customerMobNo
	 */
	public BigInteger getCustomerMobNo() {
		return customerMobNo;
	}

	/**
	 * @param customerMobNo the customerMobNo to set
	 */
	public void setCustomerMobNo(BigInteger customerMobNo) {
		this.customerMobNo = customerMobNo;
	}

	/**
	 * @return the customerEnteredBy
	 */
	public String getCustomerEnteredBy() {
		return customerEnteredBy;
	}

	/**
	 * @param customerEnteredBy the customerEnteredBy to set
	 */
	public void setCustomerEnteredBy(String customerEnteredBy) {
		this.customerEnteredBy = customerEnteredBy;
	}

	/**
	 * @return the customerEnteredDate
	 */
	public Date getCustomerEnteredDate() {
		return customerEnteredDate;
	}

	/**
	 * @param customerEnteredDate the customerEnteredDate to set
	 */
	public void setCustomerEnteredDate(Date customerEnteredDate) {
		this.customerEnteredDate = customerEnteredDate;
	}

	/**
	 * @return the customerEnteredTime
	 */
	public String getCustomerEnteredTime() {
		return customerEnteredTime;
	}

	/**
	 * @param customerEnteredTime the customerEnteredTime to set
	 */
	public void setCustomerEnteredTime(String customerEnteredTime) {
		this.customerEnteredTime = customerEnteredTime;
	}

	/**
	 * @return the customerBranchId
	 */
	public Integer getCustomerBranchId() {
		return customerBranchId;
	}

	/**
	 * @param customerBranchId the customerBranchId to set
	 */
	public void setCustomerBranchId(Integer customerBranchId) {
		this.customerBranchId = customerBranchId;
	}


}
