package com.vyavharamitra.itemdetails.beans;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.vyavharamitra.cashsales.beans.CashSalesHelper;
import com.vyavharamitra.cashsales.beans.CashSalesLineBean;
import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;
import com.vyavharamitra.utils.DbConstant;

/**
 * @author : Brahmani
 * @created date : 17 Nov 2017
 * @modified by :
 * @modified date :
 */

@Entity
@Table(name = "bil_item", schema = DbConstant.SCHEMA_NAME)

public class ItemMasterBean extends CashSalesHelper{

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bil_item_item_itmid_seq")
	@SequenceGenerator(name="bil_item_item_itmid_seq", sequenceName="bil_item_item_itmid_seq", allocationSize=1)
	@Column(name = "item_itmid")
	private Integer itemNumber;

	@Column(name = "item_name")
	private String itemName;

	@Column(name = "item_quan")
	private BigDecimal itemQuantity;

	@Column(name = "item_purcost")
	private BigDecimal itemPurchaseCost;

	@Column(name = "item_sellcost")
	private BigDecimal itemSellingCost;

	@Column(name = "item_minquan")
	private BigDecimal itemMinimumQuantity;

	@Column(name = "item_maxquan")
	private BigDecimal itemMaxQuantity;

	@Column(name = "item_requan")
	private BigDecimal itemReorderQuantity;

	@Column(name = "item_convfact")
	private BigDecimal itemConversionFactor;

	@Column(name = "item_loi")
	private String locationOfItem;

	@Column(name = "item_wac")
	private BigDecimal waitedAverageCost;

	@Column(name = "item_cid")
	private Integer categoryId;

	@Column(name = "item_uid")
	private Integer purchaseUnitMeasurementId;

	@Column(name = "item_suid")
	private Integer sellingUnitMeasurementId;

	@Column(name = "item_stkinunits")
	private BigDecimal stockInUnits;

	@Column(name = "item_sgst")
	private BigDecimal sgst;

	@Column(name = "item_cgst")
	private BigDecimal cgst;

	@Column(name = "item_igst")
	private BigDecimal igst;

	@Column(name = "item_mrp")
	private BigDecimal mrp;

	@Column(name = "item_bitemid")
	private Integer branchItemId;

	@Column(name = "item_bid")
	private Integer branchId;

	@Column(name = "item_hsn")
	private String hsn;

	@Column(name = "item_exciseduty")
	private BigDecimal exciseDuty;
	
	@Column(name = "item_eby")
	private String enteredBy;

	@Column(name = "item_edate")
	private Date enteredDate;

	@Column(name = "item_etime")
	private String enteredTime;

	@Column(name = "item_uby")
	private String updatedBy;

	@Column(name = "item_uon")
	private Date updatedOn;

	@Column(name = "item_utime")
	private String updatedTime;
	
	@Column(name = "item_status")
	private String itemStatus;
	
	

	@OneToOne(targetEntity=CategoryOfItemBean.class,cascade=CascadeType.ALL)
	@JoinColumn(name="item_itmid",referencedColumnName="ctoi_cid" ,insertable=false ,updatable=false)
	private CategoryOfItemBean categoryOfItemBean;
	
	@OneToOne(targetEntity=CashSalesLineBean.class,cascade=CascadeType.ALL)
	@JoinColumn(name="item_cid",referencedColumnName="sellitemline_itmid" ,insertable=false ,updatable=false)
	private CashSalesLineBean cashSalesLineBean;
	

	/**
	 * @return the cashSalesLineBean
	 */
	public CashSalesLineBean getCashSalesLineBean() {
		return cashSalesLineBean;
	}



	/**
	 * @param cashSalesLineBean the cashSalesLineBean to set
	 */
	public void setCashSalesLineBean(CashSalesLineBean cashSalesLineBean) {
		this.cashSalesLineBean = cashSalesLineBean;
	}



	@OneToOne(targetEntity=UnitOfMeasurementBean.class,cascade=CascadeType.ALL)
	@JoinColumn(name="item_uid",referencedColumnName="uom_uid" ,insertable=false ,updatable=false)
	private UnitOfMeasurementBean unitOfMeasurementBean;



	/**
	 * @return the itemNumber
	 */
	public Integer getItemNumber() {
		return itemNumber;
	}



	/**
	 * @param itemNumber the itemNumber to set
	 */
	public void setItemNumber(Integer itemNumber) {
		this.itemNumber = itemNumber;
	}



	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}



	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}



	/**
	 * @return the itemQuantity
	 */
	public BigDecimal getItemQuantity() {
		return itemQuantity;
	}



	/**
	 * @param itemQuantity the itemQuantity to set
	 */
	public void setItemQuantity(BigDecimal itemQuantity) {
		this.itemQuantity = itemQuantity;
	}



	/**
	 * @return the itemPurchaseCost
	 */
	public BigDecimal getItemPurchaseCost() {
		return itemPurchaseCost;
	}



	/**
	 * @param itemPurchaseCost the itemPurchaseCost to set
	 */
	public void setItemPurchaseCost(BigDecimal itemPurchaseCost) {
		this.itemPurchaseCost = itemPurchaseCost;
	}



	/**
	 * @return the itemSellingCost
	 */
	public BigDecimal getItemSellingCost() {
		return itemSellingCost;
	}



	/**
	 * @param itemSellingCost the itemSellingCost to set
	 */
	public void setItemSellingCost(BigDecimal itemSellingCost) {
		this.itemSellingCost = itemSellingCost;
	}



	/**
	 * @return the itemMinimumQuantity
	 */
	public BigDecimal getItemMinimumQuantity() {
		return itemMinimumQuantity;
	}



	/**
	 * @param itemMinimumQuantity the itemMinimumQuantity to set
	 */
	public void setItemMinimumQuantity(BigDecimal itemMinimumQuantity) {
		this.itemMinimumQuantity = itemMinimumQuantity;
	}



	/**
	 * @return the itemMaxQuantity
	 */
	public BigDecimal getItemMaxQuantity() {
		return itemMaxQuantity;
	}



	/**
	 * @param itemMaxQuantity the itemMaxQuantity to set
	 */
	public void setItemMaxQuantity(BigDecimal itemMaxQuantity) {
		this.itemMaxQuantity = itemMaxQuantity;
	}



	/**
	 * @return the itemReorderQuantity
	 */
	public BigDecimal getItemReorderQuantity() {
		return itemReorderQuantity;
	}



	/**
	 * @param itemReorderQuantity the itemReorderQuantity to set
	 */
	public void setItemReorderQuantity(BigDecimal itemReorderQuantity) {
		this.itemReorderQuantity = itemReorderQuantity;
	}



	/**
	 * @return the itemConversionFactor
	 */
	public BigDecimal getItemConversionFactor() {
		return itemConversionFactor;
	}



	/**
	 * @param itemConversionFactor the itemConversionFactor to set
	 */
	public void setItemConversionFactor(BigDecimal itemConversionFactor) {
		this.itemConversionFactor = itemConversionFactor;
	}



	/**
	 * @return the locationOfItem
	 */
	public String getLocationOfItem() {
		return locationOfItem;
	}



	/**
	 * @param locationOfItem the locationOfItem to set
	 */
	public void setLocationOfItem(String locationOfItem) {
		this.locationOfItem = locationOfItem;
	}



	/**
	 * @return the waitedAverageCost
	 */
	public BigDecimal getWaitedAverageCost() {
		return waitedAverageCost;
	}



	/**
	 * @param waitedAverageCost the waitedAverageCost to set
	 */
	public void setWaitedAverageCost(BigDecimal waitedAverageCost) {
		this.waitedAverageCost = waitedAverageCost;
	}



	/**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}



	/**
	 * @param categoryId the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}



	/**
	 * @return the purchaseUnitMeasurementId
	 */
	public Integer getPurchaseUnitMeasurementId() {
		return purchaseUnitMeasurementId;
	}



	/**
	 * @param purchaseUnitMeasurementId the purchaseUnitMeasurementId to set
	 */
	public void setPurchaseUnitMeasurementId(Integer purchaseUnitMeasurementId) {
		this.purchaseUnitMeasurementId = purchaseUnitMeasurementId;
	}



	/**
	 * @return the sellingUnitMeasurementId
	 */
	public Integer getSellingUnitMeasurementId() {
		return sellingUnitMeasurementId;
	}



	/**
	 * @param sellingUnitMeasurementId the sellingUnitMeasurementId to set
	 */
	public void setSellingUnitMeasurementId(Integer sellingUnitMeasurementId) {
		this.sellingUnitMeasurementId = sellingUnitMeasurementId;
	}



	/**
	 * @return the stockInUnits
	 */
	public BigDecimal getStockInUnits() {
		return stockInUnits;
	}



	/**
	 * @param stockInUnits the stockInUnits to set
	 */
	public void setStockInUnits(BigDecimal stockInUnits) {
		this.stockInUnits = stockInUnits;
	}



	/**
	 * @return the sgst
	 */
	public BigDecimal getSgst() {
		return sgst;
	}



	/**
	 * @param sgst the sgst to set
	 */
	public void setSgst(BigDecimal sgst) {
		this.sgst = sgst;
	}



	/**
	 * @return the cgst
	 */
	public BigDecimal getCgst() {
		return cgst;
	}



	/**
	 * @param cgst the cgst to set
	 */
	public void setCgst(BigDecimal cgst) {
		this.cgst = cgst;
	}



	/**
	 * @return the igst
	 */
	public BigDecimal getIgst() {
		return igst;
	}



	/**
	 * @param igst the igst to set
	 */
	public void setIgst(BigDecimal igst) {
		this.igst = igst;
	}



	/**
	 * @return the mrp
	 */
	public BigDecimal getMrp() {
		return mrp;
	}



	/**
	 * @param mrp the mrp to set
	 */
	public void setMrp(BigDecimal mrp) {
		this.mrp = mrp;
	}



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



	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}



	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}



	/**
	 * @return the updatedOn
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}



	/**
	 * @param updatedOn the updatedOn to set
	 */
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}



	/**
	 * @return the updatedTime
	 */
	public String getUpdatedTime() {
		return updatedTime;
	}



	/**
	 * @param updatedTime the updatedTime to set
	 */
	public void setUpdatedTime(String updatedTime) {
		this.updatedTime = updatedTime;
	}



	/**
	 * @return the itemStatus
	 */
	public String getItemStatus() {
		return itemStatus;
	}



	/**
	 * @param itemStatus the itemStatus to set
	 */
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}



	/**
	 * @return the categoryOfItemBean
	 */
	public CategoryOfItemBean getCategoryOfItemBean() {
		return categoryOfItemBean;
	}



	/**
	 * @param categoryOfItemBean the categoryOfItemBean to set
	 */
	public void setCategoryOfItemBean(CategoryOfItemBean categoryOfItemBean) {
		this.categoryOfItemBean = categoryOfItemBean;
	}



	/**
	 * @return the unitOfMeasurementBean
	 */
	public UnitOfMeasurementBean getUnitOfMeasurementBean() {
		return unitOfMeasurementBean;
	}



	/**
	 * @param unitOfMeasurementBean the unitOfMeasurementBean to set
	 */
	public void setUnitOfMeasurementBean(UnitOfMeasurementBean unitOfMeasurementBean) {
		this.unitOfMeasurementBean = unitOfMeasurementBean;
	}



	@Override
	public String toString() {
		return "ItemMasterBean [itemNumber=" + itemNumber + ", itemName=" + itemName + ", itemQuantity=" + itemQuantity
				+ ", itemPurchaseCost=" + itemPurchaseCost + ", itemSellingCost=" + itemSellingCost
				+ ", itemMinimumQuantity=" + itemMinimumQuantity + ", itemMaxQuantity=" + itemMaxQuantity
				+ ", itemReorderQuantity=" + itemReorderQuantity + ", itemConversionFactor=" + itemConversionFactor
				+ ", locationOfItem=" + locationOfItem + ", waitedAverageCost=" + waitedAverageCost + ", categoryId="
				+ categoryId + ", purchaseUnitMeasurementId=" + purchaseUnitMeasurementId
				+ ", sellingUnitMeasurementId=" + sellingUnitMeasurementId + ", stockInUnits=" + stockInUnits
				+ ", sgst=" + sgst + ", cgst=" + cgst + ", igst=" + igst + ", mrp=" + mrp + ", branchItemId="
				+ branchItemId + ", branchId=" + branchId + ", hsn=" + hsn + ", exciseDuty=" + exciseDuty
				+ ", enteredBy=" + enteredBy + ", enteredDate=" + enteredDate + ", enteredTime=" + enteredTime
				+ ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + ", updatedTime=" + updatedTime
				+ ", itemStatus=" + itemStatus + ", categoryOfItemBean=" + categoryOfItemBean + ", cashSalesLineBean="
				+ cashSalesLineBean + ", unitOfMeasurementBean=" + unitOfMeasurementBean + "]";
	}
	
	

}
