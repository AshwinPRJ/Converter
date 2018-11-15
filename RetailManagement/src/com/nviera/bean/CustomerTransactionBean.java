package com.nviera.bean;

import java.math.BigDecimal;
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
@Table(name = "cust_transactions")

public class CustomerTransactionBean {
	
	@Id
	@GeneratedValue
	@Column(name = "cust_transactions_id")
	private Integer custTransSerialNumber;
	
	@Column(name = "cust_transactions_cust_id")
	private String custTransCustomerId;
	
	@Column(name = "cust_transactions_total_amount_purchased")
	private BigDecimal custTransTotalAmountPurchased;
	
	@Column(name = "cust_transactions_created_by")
	private String custTransCreatedBy;
	
	@Column(name = "cust_transactions_created_on")
	private Date custTransCreatedOn;
	
	@Column(name = "cust_transactions_created_time")
	private String custTransCreatedTime;

	/**
	 * @return the custTransSerialNumber
	 */
	public Integer getCustTransSerialNumber() {
		return custTransSerialNumber;
	}

	/**
	 * @param custTransSerialNumber the custTransSerialNumber to set
	 */
	public void setCustTransSerialNumber(Integer custTransSerialNumber) {
		this.custTransSerialNumber = custTransSerialNumber;
	}

	/**
	 * @return the custTransCustomerId
	 */
	public String getCustTransCustomerId() {
		return custTransCustomerId;
	}

	/**
	 * @param custTransCustomerId the custTransCustomerId to set
	 */
	public void setCustTransCustomerId(String custTransCustomerId) {
		this.custTransCustomerId = custTransCustomerId;
	}

	/**
	 * @return the custTransTotalAmountPurchased
	 */
	public BigDecimal getCustTransTotalAmountPurchased() {
		return custTransTotalAmountPurchased;
	}

	/**
	 * @param custTransTotalAmountPurchased the custTransTotalAmountPurchased to set
	 */
	public void setCustTransTotalAmountPurchased(BigDecimal custTransTotalAmountPurchased) {
		this.custTransTotalAmountPurchased = custTransTotalAmountPurchased;
	}

	/**
	 * @return the custTransCreatedBy
	 */
	public String getCustTransCreatedBy() {
		return custTransCreatedBy;
	}

	/**
	 * @param custTransCreatedBy the custTransCreatedBy to set
	 */
	public void setCustTransCreatedBy(String custTransCreatedBy) {
		this.custTransCreatedBy = custTransCreatedBy;
	}

	/**
	 * @return the custTransCreatedOn
	 */
	public Date getCustTransCreatedOn() {
		return custTransCreatedOn;
	}

	/**
	 * @param custTransCreatedOn the custTransCreatedOn to set
	 */
	public void setCustTransCreatedOn(Date custTransCreatedOn) {
		this.custTransCreatedOn = custTransCreatedOn;
	}

	/**
	 * @return the custTransCreatedTime
	 */
	public String getCustTransCreatedTime() {
		return custTransCreatedTime;
	}

	/**
	 * @param custTransCreatedTime the custTransCreatedTime to set
	 */
	public void setCustTransCreatedTime(String custTransCreatedTime) {
		this.custTransCreatedTime = custTransCreatedTime;
	}
}
