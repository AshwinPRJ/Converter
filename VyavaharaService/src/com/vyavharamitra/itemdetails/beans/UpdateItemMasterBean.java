package com.vyavharamitra.itemdetails.beans;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vyavharamitra.utils.DbConstant;

/**
 * @author : Aswini
 * @created date : 17 Nov 2017
 * @modified by :
 * @modified date :
 */

@Entity
@Table(name = "bil_uitem", schema = DbConstant.SCHEMA_NAME)
public class UpdateItemMasterBean {

	@Id
	@Column(name = "uitem_bitemid")
	private Integer branchItemId;

	@Column(name = "uitem_name")
	private String updatedItemName;

	@Column(name = "uitem_quan")
	private BigDecimal updatedItemQuantity;

	@Column(name = "uitem_purcost")
	private BigDecimal updatedItemPurchaseCost;

	@Column(name = "uitem_sellcost")
	private BigDecimal updatedItemSellingCost;

	@Column(name = "uitem_minquan")
	private BigDecimal updatedItemMinimumQuantity;

	@Column(name = "uitem_maxquan")
	private BigDecimal updatedItemMaxQuantity;

	@Column(name = "uitem_requan")
	private BigDecimal updatedItemReorderQuantity;

	@Column(name = "uitem_convfact")
	private BigDecimal updatedItemConversionFactor;

	@Column(name = "uitem_loi")
	private String updatedLocationOfItem;

	@Column(name = "uitem_wac")
	private BigDecimal updatedWaitedAverageCost;

	@Column(name = "uitem_cid")
	private Integer updatedCategoryId;

	@Column(name = "uitem_uid")
	private Integer updatedPurchaseUnitMeasurementId;

	@Column(name = "uitem_suid")
	private Integer updatedSellingUnitMeasurementId;

	@Column(name = "uitem_stkinunits")
	private BigDecimal updatedStockInUnits;

	@Column(name = "uitem_sgst")
	private BigDecimal updatedItemsgst;

	@Column(name = "uitem_cgst")
	private BigDecimal updatedItemcgst;

	@Column(name = "uitem_igst")
	private BigDecimal updatedItemigst;

	@Column(name = "uitem_mrp")
	private BigDecimal updatedItemmrp;

	@Column(name = "uitem_bid")
	private Integer branchId;

	@Column(name = "uitem_hsn")
	private String hsn;

	@Column(name = "uitem_exciseduty")
	private BigDecimal exciseDuty;
	
	@Column(name = "uitem_eby")
	private String enteredBy;

	@Column(name = "uitem_edate")
	private Date enteredDate;

	@Column(name = "uitem_etime")
	private String enteredTime;

	/**
	 * @return the branchItemId
	 */
	public Integer getBranchItemId() {
		return branchItemId;
	}

	/**
	 * @param branchItemId the branchItemId to set
	 */
	public void setBranchItemId(Integer branchItemId) {
		this.branchItemId = branchItemId;
	}

	/**
	 * @return the updatedItemName
	 */
	public String getUpdatedItemName() {
		return updatedItemName;
	}

	/**
	 * @param updatedItemName the updatedItemName to set
	 */
	public void setUpdatedItemName(String updatedItemName) {
		this.updatedItemName = updatedItemName;
	}

	/**
	 * @return the updatedItemQuantity
	 */
	public BigDecimal getUpdatedItemQuantity() {
		return updatedItemQuantity;
	}

	/**
	 * @param updatedItemQuantity the updatedItemQuantity to set
	 */
	public void setUpdatedItemQuantity(BigDecimal updatedItemQuantity) {
		this.updatedItemQuantity = updatedItemQuantity;
	}

	/**
	 * @return the updatedItemPurchaseCost
	 */
	public BigDecimal getUpdatedItemPurchaseCost() {
		return updatedItemPurchaseCost;
	}

	/**
	 * @param updatedItemPurchaseCost the updatedItemPurchaseCost to set
	 */
	public void setUpdatedItemPurchaseCost(BigDecimal updatedItemPurchaseCost) {
		this.updatedItemPurchaseCost = updatedItemPurchaseCost;
	}

	/**
	 * @return the updatedItemSellingCost
	 */
	public BigDecimal getUpdatedItemSellingCost() {
		return updatedItemSellingCost;
	}

	/**
	 * @param updatedItemSellingCost the updatedItemSellingCost to set
	 */
	public void setUpdatedItemSellingCost(BigDecimal updatedItemSellingCost) {
		this.updatedItemSellingCost = updatedItemSellingCost;
	}

	/**
	 * @return the updatedItemMinimumQuantity
	 */
	public BigDecimal getUpdatedItemMinimumQuantity() {
		return updatedItemMinimumQuantity;
	}

	/**
	 * @param updatedItemMinimumQuantity the updatedItemMinimumQuantity to set
	 */
	public void setUpdatedItemMinimumQuantity(BigDecimal updatedItemMinimumQuantity) {
		this.updatedItemMinimumQuantity = updatedItemMinimumQuantity;
	}

	/**
	 * @return the updatedItemMaxQuantity
	 */
	public BigDecimal getUpdatedItemMaxQuantity() {
		return updatedItemMaxQuantity;
	}

	/**
	 * @param updatedItemMaxQuantity the updatedItemMaxQuantity to set
	 */
	public void setUpdatedItemMaxQuantity(BigDecimal updatedItemMaxQuantity) {
		this.updatedItemMaxQuantity = updatedItemMaxQuantity;
	}

	/**
	 * @return the updatedItemReorderQuantity
	 */
	public BigDecimal getUpdatedItemReorderQuantity() {
		return updatedItemReorderQuantity;
	}

	/**
	 * @param updatedItemReorderQuantity the updatedItemReorderQuantity to set
	 */
	public void setUpdatedItemReorderQuantity(BigDecimal updatedItemReorderQuantity) {
		this.updatedItemReorderQuantity = updatedItemReorderQuantity;
	}

	/**
	 * @return the updatedItemConversionFactor
	 */
	public BigDecimal getUpdatedItemConversionFactor() {
		return updatedItemConversionFactor;
	}

	/**
	 * @param updatedItemConversionFactor the updatedItemConversionFactor to set
	 */
	public void setUpdatedItemConversionFactor(BigDecimal updatedItemConversionFactor) {
		this.updatedItemConversionFactor = updatedItemConversionFactor;
	}

	/**
	 * @return the updatedLocationOfItem
	 */
	public String getUpdatedLocationOfItem() {
		return updatedLocationOfItem;
	}

	/**
	 * @param updatedLocationOfItem the updatedLocationOfItem to set
	 */
	public void setUpdatedLocationOfItem(String updatedLocationOfItem) {
		this.updatedLocationOfItem = updatedLocationOfItem;
	}

	/**
	 * @return the updatedWaitedAverageCost
	 */
	public BigDecimal getUpdatedWaitedAverageCost() {
		return updatedWaitedAverageCost;
	}

	/**
	 * @param updatedWaitedAverageCost the updatedWaitedAverageCost to set
	 */
	public void setUpdatedWaitedAverageCost(BigDecimal updatedWaitedAverageCost) {
		this.updatedWaitedAverageCost = updatedWaitedAverageCost;
	}

	/**
	 * @return the updatedCategoryId
	 */
	public Integer getUpdatedCategoryId() {
		return updatedCategoryId;
	}

	/**
	 * @param updatedCategoryId the updatedCategoryId to set
	 */
	public void setUpdatedCategoryId(Integer updatedCategoryId) {
		this.updatedCategoryId = updatedCategoryId;
	}

	/**
	 * @return the updatedPurchaseUnitMeasurementId
	 */
	public Integer getUpdatedPurchaseUnitMeasurementId() {
		return updatedPurchaseUnitMeasurementId;
	}

	/**
	 * @param updatedPurchaseUnitMeasurementId the updatedPurchaseUnitMeasurementId to set
	 */
	public void setUpdatedPurchaseUnitMeasurementId(Integer updatedPurchaseUnitMeasurementId) {
		this.updatedPurchaseUnitMeasurementId = updatedPurchaseUnitMeasurementId;
	}

	/**
	 * @return the updatedSellingUnitMeasurementId
	 */
	public Integer getUpdatedSellingUnitMeasurementId() {
		return updatedSellingUnitMeasurementId;
	}

	/**
	 * @param updatedSellingUnitMeasurementId the updatedSellingUnitMeasurementId to set
	 */
	public void setUpdatedSellingUnitMeasurementId(Integer updatedSellingUnitMeasurementId) {
		this.updatedSellingUnitMeasurementId = updatedSellingUnitMeasurementId;
	}

	/**
	 * @return the updatedStockInUnits
	 */
	public BigDecimal getUpdatedStockInUnits() {
		return updatedStockInUnits;
	}

	/**
	 * @param updatedStockInUnits the updatedStockInUnits to set
	 */
	public void setUpdatedStockInUnits(BigDecimal updatedStockInUnits) {
		this.updatedStockInUnits = updatedStockInUnits;
	}

	/**
	 * @return the updatedItemsgst
	 */
	public BigDecimal getUpdatedItemsgst() {
		return updatedItemsgst;
	}

	/**
	 * @param updatedItemsgst the updatedItemsgst to set
	 */
	public void setUpdatedItemsgst(BigDecimal updatedItemsgst) {
		this.updatedItemsgst = updatedItemsgst;
	}

	/**
	 * @return the updatedItemcgst
	 */
	public BigDecimal getUpdatedItemcgst() {
		return updatedItemcgst;
	}

	/**
	 * @param updatedItemcgst the updatedItemcgst to set
	 */
	public void setUpdatedItemcgst(BigDecimal updatedItemcgst) {
		this.updatedItemcgst = updatedItemcgst;
	}

	/**
	 * @return the updatedItemigst
	 */
	public BigDecimal getUpdatedItemigst() {
		return updatedItemigst;
	}

	/**
	 * @param updatedItemigst the updatedItemigst to set
	 */
	public void setUpdatedItemigst(BigDecimal updatedItemigst) {
		this.updatedItemigst = updatedItemigst;
	}

	/**
	 * @return the updatedItemmrp
	 */
	public BigDecimal getUpdatedItemmrp() {
		return updatedItemmrp;
	}

	/**
	 * @param updatedItemmrp the updatedItemmrp to set
	 */
	public void setUpdatedItemmrp(BigDecimal updatedItemmrp) {
		this.updatedItemmrp = updatedItemmrp;
	}

	/**
	 * @return the branchId
	 */
	public Integer getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	/**
	 * @return the hsn
	 */
	public String getHsn() {
		return hsn;
	}

	/**
	 * @param hsn the hsn to set
	 */
	public void setHsn(String hsn) {
		this.hsn = hsn;
	}

	/**
	 * @return the exciseDuty
	 */
	public BigDecimal getExciseDuty() {
		return exciseDuty;
	}

	/**
	 * @param exciseDuty the exciseDuty to set
	 */
	public void setExciseDuty(BigDecimal exciseDuty) {
		this.exciseDuty = exciseDuty;
	}

	/**
	 * @return the enteredBy
	 */
	public String getEnteredBy() {
		return enteredBy;
	}

	/**
	 * @param enteredBy the enteredBy to set
	 */
	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	/**
	 * @return the enteredDate
	 */
	public Date getEnteredDate() {
		return enteredDate;
	}

	/**
	 * @param enteredDate the enteredDate to set
	 */
	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}

	/**
	 * @return the enteredTime
	 */
	public String getEnteredTime() {
		return enteredTime;
	}

	/**
	 * @param enteredTime the enteredTime to set
	 */
	public void setEnteredTime(String enteredTime) {
		this.enteredTime = enteredTime;
	}


}
