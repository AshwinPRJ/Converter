package com.vyavharamitra.cashsales.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vyavharamitra.utils.DbConstant;

/**
 * @author : Brahmani
 * @created date : 17 Nov 2017
 * @modified by :
 * @modified date :
 */

@Entity
@Table(name = "bil_sellitemline", schema = DbConstant.SCHEMA_NAME)
public class CashSalesLineBean extends CashSalesHelper implements Serializable{
	@Id
	@Column(name = "sellitemline_sid")
	private Integer sellItemLineId;

	@Column(name = "sellitemline_itmid")
	private Integer sellItemLineItemId;

	@Column(name = "sellitemline_sgst")
	private BigDecimal sellItemLineSGST;

	@Column(name = "sellitemline_cgst")
	private BigDecimal sellItemLineCGST;

	@Column(name = "sellitemline_igst")
	private BigDecimal sellItemLineIGST;

	@Column(name = "sellitemline_disctype")
	private String sellItemLineDiscountType;

	@Column(name = "sellitemline_discvalue")
	private BigDecimal sellItemLineDiscountValue;

	@Column(name = "sellitemline_valuerp")
	private BigDecimal sellItemLineValueRP;

	@Column(name = "sellitemline_sellcost")
	private BigDecimal sellItemLineSellCost;

	@Column(name = "sellitemline_quant")
	private BigDecimal sellItemLineQuantity;

	@Column(name = "sellitemline_totsellcost")
	private BigDecimal sellItemLineTotalSellCost;

	@Column(name = "sellitemline_sgstprice")
	private BigDecimal sellItemLineSGSTPrice;

	@Column(name = "sellitemline_cgstprice")
	private BigDecimal sellItemLineCGSTPrice;

	@Column(name = "sellitemline_igstprice")
	private BigDecimal sellItemLineIGSTPrice;

	@Column(name = "sellitemline_totsellgst")
	private BigDecimal sellItemLineTotalSellGST;

	@Column(name = "sellitemline_bid")
	private Integer sellItemLineBranchId;

	@Column(name = "sellitemline_billno")
	private BigInteger sellItemLineBillNo;

	@Column(name = "sellitemline_descriptive")
	private String sellItemLineDescriptive;

	@Column(name = "sellitemline_exciseduty")
	private BigDecimal sellItemLineCess;

	@Column(name = "sellitemline_excisedutyvalue")
	private BigDecimal sellItemLineCessValue;

	/**
	 * @return the sellItemLineId
	 */
	public Integer getSellItemLineId() {
		return sellItemLineId;
	}

	/**
	 * @param sellItemLineId
	 *            the sellItemLineId to set
	 */
	public void setSellItemLineId(Integer sellItemLineId) {
		this.sellItemLineId = sellItemLineId;
	}

	/**
	 * @return the sellItemLineItemId
	 */
	public Integer getSellItemLineItemId() {
		return sellItemLineItemId;
	}

	/**
	 * @param sellItemLineItemId
	 *            the sellItemLineItemId to set
	 */
	public void setSellItemLineItemId(Integer sellItemLineItemId) {
		this.sellItemLineItemId = sellItemLineItemId;
	}

	/**
	 * @return the sellItemLineSGST
	 */
	public BigDecimal getSellItemLineSGST() {
		return sellItemLineSGST;
	}

	/**
	 * @param sellItemLineSGST
	 *            the sellItemLineSGST to set
	 */
	public void setSellItemLineSGST(BigDecimal sellItemLineSGST) {
		this.sellItemLineSGST = sellItemLineSGST;
	}

	/**
	 * @return the sellItemLineCGST
	 */
	public BigDecimal getSellItemLineCGST() {
		return sellItemLineCGST;
	}

	/**
	 * @param sellItemLineCGST
	 *            the sellItemLineCGST to set
	 */
	public void setSellItemLineCGST(BigDecimal sellItemLineCGST) {
		this.sellItemLineCGST = sellItemLineCGST;
	}

	/**
	 * @return the sellItemLineIGST
	 */
	public BigDecimal getSellItemLineIGST() {
		return sellItemLineIGST;
	}

	/**
	 * @param sellItemLineIGST
	 *            the sellItemLineIGST to set
	 */
	public void setSellItemLineIGST(BigDecimal sellItemLineIGST) {
		this.sellItemLineIGST = sellItemLineIGST;
	}

	/**
	 * @return the sellItemLineDiscountType
	 */
	public String getSellItemLineDiscountType() {
		return sellItemLineDiscountType;
	}

	/**
	 * @param sellItemLineDiscountType
	 *            the sellItemLineDiscountType to set
	 */
	public void setSellItemLineDiscountType(String sellItemLineDiscountType) {
		this.sellItemLineDiscountType = sellItemLineDiscountType;
	}

	/**
	 * @return the sellItemLineDiscountValue
	 */
	public BigDecimal getSellItemLineDiscountValue() {
		return sellItemLineDiscountValue;
	}

	/**
	 * @param sellItemLineDiscountValue
	 *            the sellItemLineDiscountValue to set
	 */
	public void setSellItemLineDiscountValue(BigDecimal sellItemLineDiscountValue) {
		this.sellItemLineDiscountValue = sellItemLineDiscountValue;
	}

	/**
	 * @return the sellItemLineValueRP
	 */
	public BigDecimal getSellItemLineValueRP() {
		return sellItemLineValueRP;
	}

	/**
	 * @param sellItemLineValueRP
	 *            the sellItemLineValueRP to set
	 */
	public void setSellItemLineValueRP(BigDecimal sellItemLineValueRP) {
		this.sellItemLineValueRP = sellItemLineValueRP;
	}

	/**
	 * @return the sellItemLineSellCost
	 */
	public BigDecimal getSellItemLineSellCost() {
		return sellItemLineSellCost;
	}

	/**
	 * @param sellItemLineSellCost
	 *            the sellItemLineSellCost to set
	 */
	public void setSellItemLineSellCost(BigDecimal sellItemLineSellCost) {
		this.sellItemLineSellCost = sellItemLineSellCost;
	}

	/**
	 * @return the sellItemLineQuantity
	 */
	public BigDecimal getSellItemLineQuantity() {
		return sellItemLineQuantity;
	}

	/**
	 * @param sellItemLineQuantity
	 *            the sellItemLineQuantity to set
	 */
	public void setSellItemLineQuantity(BigDecimal sellItemLineQuantity) {
		this.sellItemLineQuantity = sellItemLineQuantity;
	}

	/**
	 * @return the sellItemLineTotalSellCost
	 */
	public BigDecimal getSellItemLineTotalSellCost() {
		return sellItemLineTotalSellCost;
	}

	/**
	 * @param sellItemLineTotalSellCost
	 *            the sellItemLineTotalSellCost to set
	 */
	public void setSellItemLineTotalSellCost(BigDecimal sellItemLineTotalSellCost) {
		this.sellItemLineTotalSellCost = sellItemLineTotalSellCost;
	}

	/**
	 * @return the sellItemLineSGSTPrice
	 */
	public BigDecimal getSellItemLineSGSTPrice() {
		return sellItemLineSGSTPrice;
	}

	/**
	 * @param sellItemLineSGSTPrice
	 *            the sellItemLineSGSTPrice to set
	 */
	public void setSellItemLineSGSTPrice(BigDecimal sellItemLineSGSTPrice) {
		this.sellItemLineSGSTPrice = sellItemLineSGSTPrice;
	}

	/**
	 * @return the sellItemLineCGSTPrice
	 */
	public BigDecimal getSellItemLineCGSTPrice() {
		return sellItemLineCGSTPrice;
	}

	/**
	 * @param sellItemLineCGSTPrice
	 *            the sellItemLineCGSTPrice to set
	 */
	public void setSellItemLineCGSTPrice(BigDecimal sellItemLineCGSTPrice) {
		this.sellItemLineCGSTPrice = sellItemLineCGSTPrice;
	}

	/**
	 * @return the sellItemLineIGSTPrice
	 */
	public BigDecimal getSellItemLineIGSTPrice() {
		return sellItemLineIGSTPrice;
	}

	/**
	 * @param sellItemLineIGSTPrice
	 *            the sellItemLineIGSTPrice to set
	 */
	public void setSellItemLineIGSTPrice(BigDecimal sellItemLineIGSTPrice) {
		this.sellItemLineIGSTPrice = sellItemLineIGSTPrice;
	}

	/**
	 * @return the sellItemLineTotalSellGST
	 */
	public BigDecimal getSellItemLineTotalSellGST() {
		return sellItemLineTotalSellGST;
	}

	/**
	 * @param sellItemLineTotalSellGST
	 *            the sellItemLineTotalSellGST to set
	 */
	public void setSellItemLineTotalSellGST(BigDecimal sellItemLineTotalSellGST) {
		this.sellItemLineTotalSellGST = sellItemLineTotalSellGST;
	}

	/**
	 * @return the sellItemLineBranchId
	 */
	public Integer getSellItemLineBranchId() {
		return sellItemLineBranchId;
	}

	/**
	 * @param sellItemLineBranchId
	 *            the sellItemLineBranchId to set
	 */
	public void setSellItemLineBranchId(Integer sellItemLineBranchId) {
		this.sellItemLineBranchId = sellItemLineBranchId;
	}

	/**
	 * @return the sellItemLineBillNo
	 */
	public BigInteger getSellItemLineBillNo() {
		return sellItemLineBillNo;
	}

	/**
	 * @param sellItemLineBillNo
	 *            the sellItemLineBillNo to set
	 */
	public void setSellItemLineBillNo(BigInteger sellItemLineBillNo) {
		this.sellItemLineBillNo = sellItemLineBillNo;
	}

	/**
	 * @return the sellItemLineDescriptive
	 */
	public String getSellItemLineDescriptive() {
		return sellItemLineDescriptive;
	}

	/**
	 * @param sellItemLineDescriptive
	 *            the sellItemLineDescriptive to set
	 */
	public void setSellItemLineDescriptive(String sellItemLineDescriptive) {
		this.sellItemLineDescriptive = sellItemLineDescriptive;
	}

	/**
	 * @return the sellItemLineCess
	 */
	public BigDecimal getSellItemLineCess() {
		return sellItemLineCess;
	}

	/**
	 * @param sellItemLineCess
	 *            the sellItemLineCess to set
	 */
	public void setSellItemLineCess(BigDecimal sellItemLineCess) {
		this.sellItemLineCess = sellItemLineCess;
	}

	/**
	 * @return the sellItemLineCessValue
	 */
	public BigDecimal getSellItemLineCessValue() {
		return sellItemLineCessValue;
	}

	/**
	 * @param sellItemLineCessValue
	 *            the sellItemLineCessValue to set
	 */
	public void setSellItemLineCessValue(BigDecimal sellItemLineCessValue) {
		this.sellItemLineCessValue = sellItemLineCessValue;
	}

}
