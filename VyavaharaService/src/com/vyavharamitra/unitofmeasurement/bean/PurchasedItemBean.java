package com.vyavharamitra.unitofmeasurement.bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vyavharamitra.utils.DbConstant;

@Entity
@Table(name = "bil_purchaseditems", schema = DbConstant.SCHEMA_NAME)

public class PurchasedItemBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "purchaseditems_sno")
	private Integer serial;

	@Column(name = "purchaseditems_itemid")
	private Integer purchasedItemId;

	@Column(name = "purchaseditems_quantity")
	private BigDecimal purchasedItemQuantity;

	@Column(name = "purchaseditems_prize")
	private BigInteger purchasedItemPrize;

	@Column(name = "purchaseditems_updatedby")
	private String updatedBy;

	@Column(name = "purchaseditems_updateddate")
	private Date updatedDate;

	@Column(name = "purchaseditems_updatedtime")
	private String updatedTime;

	@Column(name = "purchaseditems_descption")
	private String purchasedItemDescription;

	@Column(name = "purchaseditems_billno")
	private BigInteger purchasedBillNo;

	@Column(name = "purchaseditems_gstno")
	private String purchasedSuplierGSTNo;

	@Column(name = "purchaseditems_branchid")
	private Integer purchasedBranchId;
	
	@Column(name = "purchaseditems_cgst")
	private BigDecimal purchasedCgst;

	@Column(name = "purchaseditems_sgst")
	private BigDecimal purchasedSgst;

	@Column(name = "purchaseditems_igst")
	private BigInteger purchasedIgst;
	
	@Column(name="purchaseditems_itemname")
	private String purchasedItemName;
	
	@Column(name="purchaseditems_totalamount")
    private BigInteger purchasedItemTotalAmnt;
    
	@Column(name="purchaseditems_totalitemgst")
    private  BigDecimal purchasedItemTotalItemgst;
	 
	@Column(name="purchaseditems_totalpurchas")
    private BigInteger purchasedItemTotalpurchas;



	/**
	 * @return the purchasedItemTotalpurchas
	 */
	public BigInteger getPurchasedItemTotalpurchas() {
		return purchasedItemTotalpurchas;
	}

	/**
	 * @param purchasedItemTotalpurchas the purchasedItemTotalpurchas to set
	 */
	public void setPurchasedItemTotalpurchas(BigInteger purchasedItemTotalpurchas) {
		this.purchasedItemTotalpurchas = purchasedItemTotalpurchas;
	}

	/**
	 * @return the purchasedItemTotalItemgst
	 */
		public BigInteger getPurchasedItemTotalAmnt() {
		return purchasedItemTotalAmnt;
	}

	public void setPurchasedItemTotalAmnt(BigInteger purchasedItemTotalAmnt) {
		this.purchasedItemTotalAmnt = purchasedItemTotalAmnt;
	}

	public String getPurchasedItemName() {
		return purchasedItemName;
	}

	public void setPurchasedItemName(String purchasedItemName) {
		this.purchasedItemName = purchasedItemName;
	}

	
	public void setPurchasedIgst(BigInteger purchasedIgst) {
		this.purchasedIgst = purchasedIgst;
	}

	public BigDecimal getPurchasedItemQuantity() {
		return purchasedItemQuantity;
	}

	public void setPurchasedItemQuantity(BigDecimal purchasedItemQuantity) {
		this.purchasedItemQuantity = purchasedItemQuantity;
	}

	public BigInteger getPurchasedItemPrize() {
		return purchasedItemPrize;
	}

	public void setPurchasedItemPrize(BigInteger purchasedItemPrize) {
		this.purchasedItemPrize = purchasedItemPrize;
	}

	public Integer getPurchasedItemId() {
		return purchasedItemId;
	}

	public void setPurchasedItemId(Integer purchasedItemId) {
		this.purchasedItemId = purchasedItemId;
	}

	public String getPurchasedItemDescription() {
		return purchasedItemDescription;
	}

	public void setPurchasedItemDescription(String purchasedItemDescription) {
		this.purchasedItemDescription = purchasedItemDescription;
	}

	public Integer getSerial() {
		return serial;
	}

	public void setSerial(Integer serial) {
		this.serial = serial;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}

	public BigInteger getPurchasedBillNo() {
		return purchasedBillNo;
	}

	public void setPurchasedBillNo(BigInteger purchasedBillNo) {
		this.purchasedBillNo = purchasedBillNo;
	}

	public String getPurchasedSuplierGSTNo() {
		return purchasedSuplierGSTNo;
	}

	public void setPurchasedSuplierGSTNo(String purchasedSuplierGSTNo) {
		this.purchasedSuplierGSTNo = purchasedSuplierGSTNo;
	}

	public Integer getPurchasedBranchId() {
		return purchasedBranchId;
	}

	public void setPurchasedBranchId(Integer purchasedBranchId) {
		this.purchasedBranchId = purchasedBranchId;
	}
	
	
	
	
	
	

	public BigDecimal getPurchasedCgst() {
		return purchasedCgst;
	}

	public void setPurchasedCgst(BigDecimal purchasedCgst) {
		this.purchasedCgst = purchasedCgst;
	}

	public BigDecimal getPurchasedSgst() {
		return purchasedSgst;
	}

	public void setPurchasedSgst(BigDecimal purchasedSgst) {
		this.purchasedSgst = purchasedSgst;
	}

	public BigDecimal getPurchasedItemTotalItemgst() {
		return purchasedItemTotalItemgst;
	}

	public void setPurchasedItemTotalItemgst(BigDecimal purchasedItemTotalItemgst) {
		this.purchasedItemTotalItemgst = purchasedItemTotalItemgst;
	}

	public BigInteger getPurchasedIgst() {
		return purchasedIgst;
	}

	@Override
	public String toString() {
		return "PurchasedItemBean [serial=" + serial + ", purchasedItemId=" + purchasedItemId
				+ ", purchasedItemQuantity=" + purchasedItemQuantity + ", purchasedItemPrize=" + purchasedItemPrize
				+ ", updatedBy=" + updatedBy + ", updatedDate=" + updatedDate + ", updatedTime=" + updatedTime
				+ ", purchasedItemDescription=" + purchasedItemDescription + ", purchasedBillNo=" + purchasedBillNo
				+ ", purchasedSuplierGSTNo=" + purchasedSuplierGSTNo + ", purchasedBranchId=" + purchasedBranchId
				+ ", purchasedCgst=" + purchasedCgst + ", purchasedSgst=" + purchasedSgst + ", purchasedIgst="
				+ purchasedIgst + ", purchasedItemName=" + purchasedItemName + ", purchasedItemTotalAmnt="
				+ purchasedItemTotalAmnt + "]";
	}


	

}
