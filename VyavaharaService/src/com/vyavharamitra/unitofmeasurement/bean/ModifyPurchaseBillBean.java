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
@Table(name = "bil_upurchase", schema = DbConstant.SCHEMA_NAME)
public class ModifyPurchaseBillBean {

	@Id
	@Column(name = "upurchase_bilno")
	private BigInteger uBillNo;
	
	@Column(name = "upurchase_vendname")
	private String uVendorName;
	
	@Column(name = "upurchase_place")
	private String uPlace;
	
	@Column(name = "upurchase_gstno")
	private String uGstNo;
	
	@Column(name = "upurchase_gstamount")
	private BigInteger uPurchaseAmount;
	
	@Column(name = "upurchase_enteredby")
	private String uPurchaseEnteredBy;
	
	@Column(name = "upurchase_enteredtime")
	private String uPurchaseEnteredTime;
	
	@Column(name = "upurchase_date")
	private Date uPurchaseDate;
	
	@Column(name = "upurchase_branchid")
	private Integer uPurchaseBranchId;

	/**
	 * @return the uBillNo
	 */
	public BigInteger getuBillNo() {
		return uBillNo;
	}

	/**
	 * @param uBillNo the uBillNo to set
	 */
	public void setuBillNo(BigInteger uBillNo) {
		this.uBillNo = uBillNo;
	}

	/**
	 * @return the uVendorName
	 */
	public String getuVendorName() {
		return uVendorName;
	}

	/**
	 * @param uVendorName the uVendorName to set
	 */
	public void setuVendorName(String uVendorName) {
		this.uVendorName = uVendorName;
	}

	/**
	 * @return the uPlace
	 */
	public String getuPlace() {
		return uPlace;
	}

	/**
	 * @param uPlace the uPlace to set
	 */
	public void setuPlace(String uPlace) {
		this.uPlace = uPlace;
	}

	/**
	 * @return the uGstNo
	 */
	public String getuGstNo() {
		return uGstNo;
	}

	/**
	 * @param uGstNo the uGstNo to set
	 */
	public void setuGstNo(String uGstNo) {
		this.uGstNo = uGstNo;
	}

	/**
	 * @return the uPurchaseAmount
	 */
	public BigInteger getuPurchaseAmount() {
		return uPurchaseAmount;
	}

	/**
	 * @param uPurchaseAmount the uPurchaseAmount to set
	 */
	public void setuPurchaseAmount(BigInteger uPurchaseAmount) {
		this.uPurchaseAmount = uPurchaseAmount;
	}

	/**
	 * @return the uPurchaseEnteredBy
	 */
	public String getuPurchaseEnteredBy() {
		return uPurchaseEnteredBy;
	}

	/**
	 * @param uPurchaseEnteredBy the uPurchaseEnteredBy to set
	 */
	public void setuPurchaseEnteredBy(String uPurchaseEnteredBy) {
		this.uPurchaseEnteredBy = uPurchaseEnteredBy;
	}

	/**
	 * @return the uPurchaseEnteredTime
	 */
	public String getuPurchaseEnteredTime() {
		return uPurchaseEnteredTime;
	}

	/**
	 * @param uPurchaseEnteredTime the uPurchaseEnteredTime to set
	 */
	public void setuPurchaseEnteredTime(String uPurchaseEnteredTime) {
		this.uPurchaseEnteredTime = uPurchaseEnteredTime;
	}

	/**
	 * @return the uPurchaseDate
	 */
	public Date getuPurchaseDate() {
		return uPurchaseDate;
	}

	/**
	 * @param uPurchaseDate the uPurchaseDate to set
	 */
	public void setuPurchaseDate(Date uPurchaseDate) {
		this.uPurchaseDate = uPurchaseDate;
	}

	/**
	 * @return the uPurchaseBranchId
	 */
	public Integer getuPurchaseBranchId() {
		return uPurchaseBranchId;
	}

	/**
	 * @param uPurchaseBranchId the uPurchaseBranchId to set
	 */
	public void setuPurchaseBranchId(Integer uPurchaseBranchId) {
		this.uPurchaseBranchId = uPurchaseBranchId;
	}
			
	
}
