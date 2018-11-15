package com.vyavharamitra.deletionofbill.bean;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vyavharamitra.utils.DbConstant;

@Entity
@Table(name = "bil_delsellitemline", schema = DbConstant.SCHEMA_NAME)
public class DeleteSellitemBean {
	@Id
	@Column(name = "delsellitemline_sid")
	private Integer delId;

	@Column(name = "delsellitemline_itmid")
	private Integer delItemId;

	@Column(name = "delsellitemline_sgst")
	private BigDecimal delSgst;

	@Column(name = "delsellitemline_cgst")
	private BigDecimal delCgst;

	
	@Column(name = "delsellitemline_disctype")
	private String delDiscountType;

	@Column(name = "delsellitemline_discvalue")
	private BigDecimal delDiscountValue;

	@Column(name = "delsellitemline_valuerp")
	private BigDecimal delValueRp;

	@Column(name = "delsellitemline_sellcost")
	private BigDecimal delSellCost;

	@Column(name = "delsellitemline_quant")
	private BigDecimal delQuantity;

	@Column(name = "delsellitemline_totsellcost")
	private BigDecimal delTotalSellCost;

	@Column(name = "delsellitemline_sgstprice")
	private BigDecimal delTotSelSgst;

	@Column(name = "delsellitemline_totsellgst")
	private BigDecimal delTotSelGst;

	@Column(name = "delsellitemline_bid")
	private Integer delBranchId;

	@Column(name = "delsellitemline_cgstprice")
	private BigInteger delCgstPrice;
	
	@Column(name = "delsellitemline_billno")
	private BigDecimal delBillNo;

	@Column(name = "delsellitemline_descriptive")
	private String delDescriptive;
	
	@Column(name = "delsellitemline_exciseduty")
	private BigDecimal delExciseDuty;
	
	
	@Column(name = "delsellitemline_igst")
	private BigDecimal deligst;
	
	@Column(name = "delsellitemline_igstprice")
	private BigDecimal delIgstPrice;
	
	@Column(name = "delsellitemline_excisedutyvalue")
	private BigDecimal delExciseDutyValue;

	/**
	 * @return the delId
	 */
	public Integer getDelId() {
		return delId;
	}

	/**
	 * @param delId the delId to set
	 */
	public void setDelId(Integer delId) {
		this.delId = delId;
	}

	/**
	 * @return the delItemId
	 */
	public Integer getDelItemId() {
		return delItemId;
	}

	/**
	 * @param delItemId the delItemId to set
	 */
	public void setDelItemId(Integer delItemId) {
		this.delItemId = delItemId;
	}

	/**
	 * @return the delSgst
	 */
	public BigDecimal getDelSgst() {
		return delSgst;
	}

	/**
	 * @param delSgst the delSgst to set
	 */
	public void setDelSgst(BigDecimal delSgst) {
		this.delSgst = delSgst;
	}

	/**
	 * @return the delCgst
	 */
	public BigDecimal getDelCgst() {
		return delCgst;
	}

	/**
	 * @param delCgst the delCgst to set
	 */
	public void setDelCgst(BigDecimal delCgst) {
		this.delCgst = delCgst;
	}

	/**
	 * @return the delDiscountType
	 */
	public String getDelDiscountType() {
		return delDiscountType;
	}

	/**
	 * @param delDiscountType the delDiscountType to set
	 */
	public void setDelDiscountType(String delDiscountType) {
		this.delDiscountType = delDiscountType;
	}

	/**
	 * @return the delDiscountValue
	 */
	public BigDecimal getDelDiscountValue() {
		return delDiscountValue;
	}

	/**
	 * @param delDiscountValue the delDiscountValue to set
	 */
	public void setDelDiscountValue(BigDecimal delDiscountValue) {
		this.delDiscountValue = delDiscountValue;
	}

	/**
	 * @return the delValueRp
	 */
	public BigDecimal getDelValueRp() {
		return delValueRp;
	}

	/**
	 * @param delValueRp the delValueRp to set
	 */
	public void setDelValueRp(BigDecimal delValueRp) {
		this.delValueRp = delValueRp;
	}

	/**
	 * @return the delSellCost
	 */
	public BigDecimal getDelSellCost() {
		return delSellCost;
	}

	/**
	 * @param delSellCost the delSellCost to set
	 */
	public void setDelSellCost(BigDecimal delSellCost) {
		this.delSellCost = delSellCost;
	}

	/**
	 * @return the delQuantity
	 */
	public BigDecimal getDelQuantity() {
		return delQuantity;
	}

	/**
	 * @param delQuantity the delQuantity to set
	 */
	public void setDelQuantity(BigDecimal delQuantity) {
		this.delQuantity = delQuantity;
	}

	/**
	 * @return the delTotalSellCost
	 */
	public BigDecimal getDelTotalSellCost() {
		return delTotalSellCost;
	}

	/**
	 * @param delTotalSellCost the delTotalSellCost to set
	 */
	public void setDelTotalSellCost(BigDecimal delTotalSellCost) {
		this.delTotalSellCost = delTotalSellCost;
	}

	/**
	 * @return the delTotSelSgst
	 */
	public BigDecimal getDelTotSelSgst() {
		return delTotSelSgst;
	}

	/**
	 * @param delTotSelSgst the delTotSelSgst to set
	 */
	public void setDelTotSelSgst(BigDecimal delTotSelSgst) {
		this.delTotSelSgst = delTotSelSgst;
	}

	/**
	 * @return the delTotSelGst
	 */
	public BigDecimal getDelTotSelGst() {
		return delTotSelGst;
	}

	/**
	 * @param delTotSelGst the delTotSelGst to set
	 */
	public void setDelTotSelGst(BigDecimal delTotSelGst) {
		this.delTotSelGst = delTotSelGst;
	}

	/**
	 * @return the delBranchId
	 */
	public Integer getDelBranchId() {
		return delBranchId;
	}

	/**
	 * @param delBranchId the delBranchId to set
	 */
	public void setDelBranchId(Integer delBranchId) {
		this.delBranchId = delBranchId;
	}

	/**
	 * @return the delCgstPrice
	 */
	public BigInteger getDelCgstPrice() {
		return delCgstPrice;
	}

	/**
	 * @param delCgstPrice the delCgstPrice to set
	 */
	public void setDelCgstPrice(BigInteger delCgstPrice) {
		this.delCgstPrice = delCgstPrice;
	}

	/**
	 * @return the delBillNo
	 */
	public BigDecimal getDelBillNo() {
		return delBillNo;
	}

	/**
	 * @param delBillNo the delBillNo to set
	 */
	public void setDelBillNo(BigDecimal delBillNo) {
		this.delBillNo = delBillNo;
	}

	/**
	 * @return the delDescriptive
	 */
	public String getDelDescriptive() {
		return delDescriptive;
	}

	/**
	 * @param delDescriptive the delDescriptive to set
	 */
	public void setDelDescriptive(String delDescriptive) {
		this.delDescriptive = delDescriptive;
	}

	/**
	 * @return the delExciseDuty
	 */
	public BigDecimal getDelExciseDuty() {
		return delExciseDuty;
	}

	/**
	 * @param delExciseDuty the delExciseDuty to set
	 */
	public void setDelExciseDuty(BigDecimal delExciseDuty) {
		this.delExciseDuty = delExciseDuty;
	}

	/**
	 * @return the deligst
	 */
	public BigDecimal getDeligst() {
		return deligst;
	}

	/**
	 * @param deligst the deligst to set
	 */
	public void setDeligst(BigDecimal deligst) {
		this.deligst = deligst;
	}

	/**
	 * @return the delIgstPrice
	 */
	public BigDecimal getDelIgstPrice() {
		return delIgstPrice;
	}

	/**
	 * @param delIgstPrice the delIgstPrice to set
	 */
	public void setDelIgstPrice(BigDecimal delIgstPrice) {
		this.delIgstPrice = delIgstPrice;
	}

	/**
	 * @return the delExciseDutyValue
	 */
	public BigDecimal getDelExciseDutyValue() {
		return delExciseDutyValue;
	}

	/**
	 * @param delExciseDutyValue the delExciseDutyValue to set
	 */
	public void setDelExciseDutyValue(BigDecimal delExciseDutyValue) {
		this.delExciseDutyValue = delExciseDutyValue;
	}
	
}
