package com.vyavharamitra.modifypurchasebill.bean;
import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.vyavharamitra.utils.DbConstant;
@Entity
@Table(name = "bil_upurchase", schema = DbConstant.SCHEMA_NAME)
public class ModifyPurchaseBean {
	
	@Id
	@Column(name = "upurchase_bilno")
	private Integer upurchasebillno;
	
	@Column(name = "upurchase_vendname")
	private String upurchasevendorname;
	
	@Column(name = "upurchase_place")
	private String upurchaseplace;
	
	@Column(name = "upurchase_gstno")
	private String upurchasegstno;
	
	@Column(name = "upurchase_purvalue")
	private BigInteger upurchasevalue;
	
	@Column(name = "upurchase_gstamount")
	private BigInteger upurchasegstamount;
	
	@Column(name = "upurchase_enteredby")
	private String upurchaseEnteredBy;
	
	@Column(name = "upurchase_date")
	private Date upurchaseDate;
	
	
	@Column(name = "upurchase_branchid")
	private Integer upurchasebranchId;


	/**
	 * @return the upurchasebillno
	 */
	public Integer getUpurchasebillno() {
		return upurchasebillno;
	}


	/**
	 * @param upurchasebillno the upurchasebillno to set
	 */
	public void setUpurchasebillno(Integer upurchasebillno) {
		this.upurchasebillno = upurchasebillno;
	}


	/**
	 * @return the upurchasevendorname
	 */
	public String getUpurchasevendorname() {
		return upurchasevendorname;
	}


	/**
	 * @param upurchasevendorname the upurchasevendorname to set
	 */
	public void setUpurchasevendorname(String upurchasevendorname) {
		this.upurchasevendorname = upurchasevendorname;
	}


	/**
	 * @return the upurchaseplace
	 */
	public String getUpurchaseplace() {
		return upurchaseplace;
	}


	/**
	 * @param upurchaseplace the upurchaseplace to set
	 */
	public void setUpurchaseplace(String upurchaseplace) {
		this.upurchaseplace = upurchaseplace;
	}


	/**
	 * @return the upurchasegstno
	 */
	public String getUpurchasegstno() {
		return upurchasegstno;
	}


	/**
	 * @param upurchasegstno the upurchasegstno to set
	 */
	public void setUpurchasegstno(String upurchasegstno) {
		this.upurchasegstno = upurchasegstno;
	}


	/**
	 * @return the upurchasevalue
	 */
	public BigInteger getUpurchasevalue() {
		return upurchasevalue;
	}


	/**
	 * @param upurchasevalue the upurchasevalue to set
	 */
	public void setUpurchasevalue(BigInteger upurchasevalue) {
		this.upurchasevalue = upurchasevalue;
	}


	/**
	 * @return the upurchasegstamount
	 */
	public BigInteger getUpurchasegstamount() {
		return upurchasegstamount;
	}


	/**
	 * @param upurchasegstamount the upurchasegstamount to set
	 */
	public void setUpurchasegstamount(BigInteger upurchasegstamount) {
		this.upurchasegstamount = upurchasegstamount;
	}


	/**
	 * @return the upurchaseEnteredBy
	 */
	public String getUpurchaseEnteredBy() {
		return upurchaseEnteredBy;
	}


	/**
	 * @param upurchaseEnteredBy the upurchaseEnteredBy to set
	 */
	public void setUpurchaseEnteredBy(String upurchaseEnteredBy) {
		this.upurchaseEnteredBy = upurchaseEnteredBy;
	}


	/**
	 * @return the upurchaseDate
	 */
	public Date getUpurchaseDate() {
		return upurchaseDate;
	}


	/**
	 * @param upurchaseDate the upurchaseDate to set
	 */
	public void setUpurchaseDate(Date upurchaseDate) {
		this.upurchaseDate = upurchaseDate;
	}


	/**
	 * @return the upurchasebranchId
	 */
	public Integer getUpurchasebranchId() {
		return upurchasebranchId;
	}


	/**
	 * @param upurchasebranchId the upurchasebranchId to set
	 */
	public void setUpurchasebranchId(Integer upurchasebranchId) {
		this.upurchasebranchId = upurchasebranchId;
	}
	
}
