package com.vyavharamitra.unitofmeasurement.bean;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vyavharamitra.utils.DbConstant;
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "bil_purchase", schema = DbConstant.SCHEMA_NAME)
public class PurchaseBillBean extends PurchaseBillHelper{

	@EmbeddedId
	private PurchaseEmbeddedBean purchaseEmbeddedBean;
	
	/*@OneToMany(fetch = FetchType.EAGER, mappedBy = "purchaseBillBean")
    List<PurchasedItemBean> purchasedItemBeanList = new ArrayList<>();*/
	
    @Column(name = "purchase_vendname")
	private String vendorName;
	
	@Column(name = "purchase_place")
	private String purchasePlace;
	
	@Column(name = "purchase_purvalue")
	private BigInteger purchaseValue;

	@Column(name = "purchase_gstamount")
	private BigInteger purchaseGstAmount;
	
	@Column(name = "purchase_enteredby")
	private String purchaseEnteredBy;
	
	@Column(name = "purchase_entereddate")
     @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date purchaseEnteredDate;
	
	@Column(name = "purchase_enteredtime")
	private String purchaseEnteredTime;
	
	@Column(name = "purchase_date")
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;

	@Column (name="purchase_sta")
	private String purchaseStatus;
	
	/*@Column(name="purchase_orggst")
	private String purchaseOrgGstNo;
	*/
	@Column(name="purchase_usm_sno")
	private Integer purchaseUserNo;
	

	public Integer getPurchaseUserNo() {
		return purchaseUserNo;
	}

	public void setPurchaseUserNo(Integer purchaseUserNo) {
		this.purchaseUserNo = purchaseUserNo;
	}

	public Date getPurchaseEnteredDate() {
		return purchaseEnteredDate;
	}

	public void setPurchaseEnteredDate(Date purchaseEnteredDate) {
		this.purchaseEnteredDate = purchaseEnteredDate;
	}



	public PurchaseEmbeddedBean getPurchaseEmbeddedBean() {
		return purchaseEmbeddedBean;
	}

	public void setPurchaseEmbeddedBean(PurchaseEmbeddedBean purchaseEmbeddedBean) {
		this.purchaseEmbeddedBean = purchaseEmbeddedBean;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getPurchasePlace() {
		return purchasePlace;
	}

	public void setPurchasePlace(String purchasePlace) {
		this.purchasePlace = purchasePlace;
	}

	public BigInteger getPurchaseValue() {
		return purchaseValue;
	}

	public void setPurchaseValue(BigInteger purchaseValue) {
		this.purchaseValue = purchaseValue;
	}

	public BigInteger getPurchaseGstAmount() {
		return purchaseGstAmount;
	}

	public void setPurchaseGstAmount(BigInteger purchaseGstAmount) {
		this.purchaseGstAmount = purchaseGstAmount;
	}

	public String getPurchaseEnteredBy() {
		return purchaseEnteredBy;
	}

	public void setPurchaseEnteredBy(String purchaseEnteredBy) {
		this.purchaseEnteredBy = purchaseEnteredBy;
	}

	public String getPurchaseEnteredTime() {
		return purchaseEnteredTime;
	}

	public void setPurchaseEnteredTime(String purchaseEnteredTime) {
		this.purchaseEnteredTime = purchaseEnteredTime;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}
/*
	public List<PurchasedItemBean> getPurchasedItemBeanList() {
		return purchasedItemBeanList;
	}

	public void setPurchasedItemBeanList(List<PurchasedItemBean> purchasedItemBeanList) {
		this.purchasedItemBeanList = purchasedItemBeanList;
	}*/

	@Override
	public String toString() {
		return "PurchaseBillBean [purchaseEmbeddedBean=" + purchaseEmbeddedBean + ", vendorName=" + vendorName
				+ ", purchasePlace=" + purchasePlace + ", purchaseValue=" + purchaseValue + ", purchaseGstAmount="
				+ purchaseGstAmount + ", purchaseEnteredBy=" + purchaseEnteredBy + ", purchaseEnteredDate="
				+ purchaseEnteredDate + ", purchaseEnteredTime=" + purchaseEnteredTime + ", purchaseDate="
				+ purchaseDate + ", purchaseStatus=" + purchaseStatus + ", purchaseUserNo=" + purchaseUserNo + "]";
	}

	

}
