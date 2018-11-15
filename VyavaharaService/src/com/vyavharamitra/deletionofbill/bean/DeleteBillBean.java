package com.vyavharamitra.deletionofbill.bean;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vyavharamitra.utils.DbConstant;
@Entity
@Table(name = "bil_delsellitem", schema = DbConstant.SCHEMA_NAME)

public class DeleteBillBean extends DeleteBillHelper{
	@Id

	@Column(name = "delsellitem_sid")
	private Integer delsellItemId;

	@Column(name = "delsellitem_cname")
	private String delsellItemCustName;

	@Column(name = "delsellitem_sdate")
	private Date delsellItemDate;

	@Column(name = "delsellitem_totcost")
	private BigDecimal delsellItemTotalCost;

	@Column(name = "delsellitem_eby")
	private String delsellItemEnteredBy;

	@Column(name = "delsellitem_edate")
	private Date delsellItemEnteredDate;

	@Column(name = "delsellitem_etime")
	private String delsellItemEnteredTime;

	@Column(name = "delsellitem_cphno")
	private BigInteger delsellItemCustomerPhone;

	@Column(name = "delsellitem_bid")
	private Integer delsellItemBranchId;

	@Column(name = "delsellitem_billno")
	private BigInteger delsellItemno;
	
	
	@Column(name = "delsellitem_delby")
	private String delsellItemDelby;

	@Column(name = "delsellitem_deldate")
	private Date delsellDelDate;
	

	@Column(name = "delsellitem_deltime")
	private String delsellDelTime;


	/**
	 * @return the delsellItemId
	 */
	public Integer getDelsellItemId() {
		return delsellItemId;
	}


	/**
	 * @param delsellItemId the delsellItemId to set
	 */
	public void setDelsellItemId(Integer delsellItemId) {
		this.delsellItemId = delsellItemId;
	}


	/**
	 * @return the delsellItemCustName
	 */
	public String getDelsellItemCustName() {
		return delsellItemCustName;
	}


	/**
	 * @param delsellItemCustName the delsellItemCustName to set
	 */
	public void setDelsellItemCustName(String delsellItemCustName) {
		this.delsellItemCustName = delsellItemCustName;
	}


	/**
	 * @return the delsellItemDate
	 */
	public Date getDelsellItemDate() {
		return delsellItemDate;
	}


	/**
	 * @param delsellItemDate the delsellItemDate to set
	 */
	public void setDelsellItemDate(Date delsellItemDate) {
		this.delsellItemDate = delsellItemDate;
	}


	/**
	 * @return the delsellItemTotalCost
	 */
	public BigDecimal getDelsellItemTotalCost() {
		return delsellItemTotalCost;
	}


	/**
	 * @param delsellItemTotalCost the delsellItemTotalCost to set
	 */
	public void setDelsellItemTotalCost(BigDecimal delsellItemTotalCost) {
		this.delsellItemTotalCost = delsellItemTotalCost;
	}


	/**
	 * @return the delsellItemEnteredBy
	 */
	public String getDelsellItemEnteredBy() {
		return delsellItemEnteredBy;
	}


	/**
	 * @param delsellItemEnteredBy the delsellItemEnteredBy to set
	 */
	public void setDelsellItemEnteredBy(String delsellItemEnteredBy) {
		this.delsellItemEnteredBy = delsellItemEnteredBy;
	}


	/**
	 * @return the delsellItemEnteredDate
	 */
	public Date getDelsellItemEnteredDate() {
		return delsellItemEnteredDate;
	}


	/**
	 * @param delsellItemEnteredDate the delsellItemEnteredDate to set
	 */
	public void setDelsellItemEnteredDate(Date delsellItemEnteredDate) {
		this.delsellItemEnteredDate = delsellItemEnteredDate;
	}


	/**
	 * @return the delsellItemEnteredTime
	 */
	public String getDelsellItemEnteredTime() {
		return delsellItemEnteredTime;
	}


	/**
	 * @param delsellItemEnteredTime the delsellItemEnteredTime to set
	 */
	public void setDelsellItemEnteredTime(String delsellItemEnteredTime) {
		this.delsellItemEnteredTime = delsellItemEnteredTime;
	}


	/**
	 * @return the delsellItemCustomerPhone
	 */
	public BigInteger getDelsellItemCustomerPhone() {
		return delsellItemCustomerPhone;
	}


	/**
	 * @param delsellItemCustomerPhone the delsellItemCustomerPhone to set
	 */
	public void setDelsellItemCustomerPhone(BigInteger delsellItemCustomerPhone) {
		this.delsellItemCustomerPhone = delsellItemCustomerPhone;
	}


	/**
	 * @return the delsellItemBranchId
	 */
	public Integer getDelsellItemBranchId() {
		return delsellItemBranchId;
	}


	/**
	 * @param delsellItemBranchId the delsellItemBranchId to set
	 */
	public void setDelsellItemBranchId(Integer delsellItemBranchId) {
		this.delsellItemBranchId = delsellItemBranchId;
	}


	/**
	 * @return the delsellItemno
	 */
	public BigInteger getDelsellItemno() {
		return delsellItemno;
	}


	/**
	 * @param delsellItemno the delsellItemno to set
	 */
	public void setDelsellItemno(BigInteger delsellItemno) {
		this.delsellItemno = delsellItemno;
	}


	/**
	 * @return the delsellItemDelby
	 */
	public String getDelsellItemDelby() {
		return delsellItemDelby;
	}


	/**
	 * @param delsellItemDelby the delsellItemDelby to set
	 */
	public void setDelsellItemDelby(String delsellItemDelby) {
		this.delsellItemDelby = delsellItemDelby;
	}


	/**
	 * @return the delsellDelDate
	 */
	public Date getDelsellDelDate() {
		return delsellDelDate;
	}


	/**
	 * @param delsellDelDate the delsellDelDate to set
	 */
	public void setDelsellDelDate(Date delsellDelDate) {
		this.delsellDelDate = delsellDelDate;
	}


	/**
	 * @return the delsellDelTime
	 */
	public String getDelsellDelTime() {
		return delsellDelTime;
	}


	/**
	 * @param delsellDelTime the delsellDelTime to set
	 */
	public void setDelsellDelTime(String delsellDelTime) {
		this.delsellDelTime = delsellDelTime;
	}


	public void setDelsellItem(BigInteger sellItem) {
		// TODO Auto-generated method stub
		
	}




}
