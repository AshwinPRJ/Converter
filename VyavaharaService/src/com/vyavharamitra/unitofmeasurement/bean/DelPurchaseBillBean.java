package com.vyavharamitra.unitofmeasurement.bean;
import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vyavharamitra.utils.DbConstant;
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "bil_delpurchase", schema = DbConstant.SCHEMA_NAME)
public class DelPurchaseBillBean {
	@Id
	@Column(name = "delpurchase_billno")
	private BigInteger delBillNo;
	
	@Column(name = "delpurchase_vendname")
	private String delVendorName;
	
	@Column(name = "delpurchase_place")
	private String delPlace;
	
	@Column(name = "delpurchase_gstno")
	private String delGstNo;
	
	@Column(name = "delpurchase_purvalue")
	private BigInteger delPurchaseAmount;
	
	@Column(name = "delpurchase_gstamount")
	private String delPurchaseEnteredBy;
	
	@Column(name = "delpurchase_enteredby")
	private String delPurchaseEnteredTime;
	
	@Column(name = "delpurchase_entereddate")
	private Date delPurchaseEnteredDate;
	
	@Column(name = "delpurchase_date")
	private Date delPurchaseDate;
	
	@Column(name = "delpurchase_branchid")
	private Integer delPurchaseBranchId;

	/**
	 * @return the delBillNo
	 */
	public BigInteger getDelBillNo() {
		return delBillNo;
	}

	/**
	 * @param delBillNo the delBillNo to set
	 */
	public void setDelBillNo(BigInteger delBillNo) {
		this.delBillNo = delBillNo;
	}

	/**
	 * @return the delVendorName
	 */
	public String getDelVendorName() {
		return delVendorName;
	}

	/**
	 * @param delVendorName the delVendorName to set
	 */
	public void setDelVendorName(String delVendorName) {
		this.delVendorName = delVendorName;
	}

	/**
	 * @return the delPlace
	 */
	public String getDelPlace() {
		return delPlace;
	}

	/**
	 * @param delPlace the delPlace to set
	 */
	public void setDelPlace(String delPlace) {
		this.delPlace = delPlace;
	}

	/**
	 * @return the delGstNo
	 */
	public String getDelGstNo() {
		return delGstNo;
	}

	/**
	 * @param delGstNo the delGstNo to set
	 */
	public void setDelGstNo(String delGstNo) {
		this.delGstNo = delGstNo;
	}

	/**
	 * @return the delPurchaseAmount
	 */
	public BigInteger getDelPurchaseAmount() {
		return delPurchaseAmount;
	}

	/**
	 * @param delPurchaseAmount the delPurchaseAmount to set
	 */
	public void setDelPurchaseAmount(BigInteger delPurchaseAmount) {
		this.delPurchaseAmount = delPurchaseAmount;
	}

	/**
	 * @return the delPurchaseEnteredBy
	 */
	public String getDelPurchaseEnteredBy() {
		return delPurchaseEnteredBy;
	}

	/**
	 * @param delPurchaseEnteredBy the delPurchaseEnteredBy to set
	 */
	public void setDelPurchaseEnteredBy(String delPurchaseEnteredBy) {
		this.delPurchaseEnteredBy = delPurchaseEnteredBy;
	}

	/**
	 * @return the delPurchaseEnteredTime
	 */
	public String getDelPurchaseEnteredTime() {
		return delPurchaseEnteredTime;
	}

	/**
	 * @param delPurchaseEnteredTime the delPurchaseEnteredTime to set
	 */
	public void setDelPurchaseEnteredTime(String delPurchaseEnteredTime) {
		this.delPurchaseEnteredTime = delPurchaseEnteredTime;
	}

	/**
	 * @return the delPurchaseEnteredDate
	 */
	public Date getDelPurchaseEnteredDate() {
		return delPurchaseEnteredDate;
	}

	/**
	 * @param delPurchaseEnteredDate the delPurchaseEnteredDate to set
	 */
	public void setDelPurchaseEnteredDate(Date delPurchaseEnteredDate) {
		this.delPurchaseEnteredDate = delPurchaseEnteredDate;
	}

	/**
	 * @return the delPurchaseDate
	 */
	public Date getDelPurchaseDate() {
		return delPurchaseDate;
	}

	/**
	 * @param delPurchaseDate the delPurchaseDate to set
	 */
	public void setDelPurchaseDate(Date delPurchaseDate) {
		this.delPurchaseDate = delPurchaseDate;
	}

	/**
	 * @return the delPurchaseBranchId
	 */
	public Integer getDelPurchaseBranchId() {
		return delPurchaseBranchId;
	}

	/**
	 * @param delPurchaseBranchId the delPurchaseBranchId to set
	 */
	public void setDelPurchaseBranchId(Integer delPurchaseBranchId) {
		this.delPurchaseBranchId = delPurchaseBranchId;
	}
	
}
