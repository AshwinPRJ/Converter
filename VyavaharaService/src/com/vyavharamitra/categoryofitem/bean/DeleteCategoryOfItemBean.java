package com.vyavharamitra.categoryofitem.bean;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vyavharamitra.utils.DbConstant;


/**
 * @author : lavanya
 * @created date : 01 Dec 2017
 * @modified by : 
 * @modified date :
 */
@Entity
@Table(name = "bil_delctoi", schema = DbConstant.SCHEMA_NAME)
public class DeleteCategoryOfItemBean extends CategoryHelper {
	
	@Id
	@Column(name = " delctoi_cid")
	private Integer categoryId;

	@Column(name = " delctoi_cname")
	private String categoryName;

	@Column(name = " delctoi_sgst")
	private BigDecimal categorySGST;

	@Column(name = " delctoi_cgst")
	private BigDecimal categoryCGST;

	@Column(name = " delctoi_igst")
	private BigDecimal categoryIGST;

	@Column(name = " delctoi_eby")
	private String categoryEnteredBy;

	@Column(name = " delctoi_eon")
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date categoryEnteredDate;

	@Column(name = " delctoi_etime")
	private String categoryEnterdTime;

	@Column(name = " delctoi_delby")
	private String categoryDeletedBy;

	@Column(name = " delctoi_deltime")
	private String categoryDeletedTime;

	@Column(name = " delctoi_delon")
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date categoryDeletedDate;
	
	

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
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the categorySGST
	 */
	public BigDecimal getCategorySGST() {
		return categorySGST;
	}

	/**
	 * @param categorySGST the categorySGST to set
	 */
	public void setCategorySGST(BigDecimal categorySGST) {
		this.categorySGST = categorySGST;
	}

	/**
	 * @return the categoryCGST
	 */
	public BigDecimal getCategoryCGST() {
		return categoryCGST;
	}

	/**
	 * @param categoryCGST the categoryCGST to set
	 */
	public void setCategoryCGST(BigDecimal categoryCGST) {
		this.categoryCGST = categoryCGST;
	}

	/**
	 * @return the categoryIGST
	 */
	public BigDecimal getCategoryIGST() {
		return categoryIGST;
	}

	/**
	 * @param categoryIGST the categoryIGST to set
	 */
	public void setCategoryIGST(BigDecimal categoryIGST) {
		this.categoryIGST = categoryIGST;
	}

	/**
	 * @return the categoryEnteredBy
	 */
	public String getCategoryEnteredBy() {
		return categoryEnteredBy;
	}

	/**
	 * @param categoryEnteredBy the categoryEnteredBy to set
	 */
	public void setCategoryEnteredBy(String categoryEnteredBy) {
		this.categoryEnteredBy = categoryEnteredBy;
	}

	/**
	 * @return the categoryEnteredDate
	 */
	public Date getCategoryEnteredDate() {
		return categoryEnteredDate;
	}

	/**
	 * @param categoryEnteredDate the categoryEnteredDate to set
	 */
	public void setCategoryEnteredDate(Date categoryEnteredDate) {
		this.categoryEnteredDate = categoryEnteredDate;
	}

	/**
	 * @return the categoryEnterdTime
	 */
	public String getCategoryEnterdTime() {
		return categoryEnterdTime;
	}

	/**
	 * @param categoryEnterdTime the categoryEnterdTime to set
	 */
	public void setCategoryEnterdTime(String categoryEnterdTime) {
		this.categoryEnterdTime = categoryEnterdTime;
	}

	/**
	 * @return the categoryDeletedBy
	 */
	public String getCategoryDeletedBy() {
		return categoryDeletedBy;
	}

	/**
	 * @param categoryDeletedBy the categoryDeletedBy to set
	 */
	public void setCategoryDeletedBy(String categoryDeletedBy) {
		this.categoryDeletedBy = categoryDeletedBy;
	}

	/**
	 * @return the categoryDeletedTime
	 */
	public String getCategoryDeletedTime() {
		return categoryDeletedTime;
	}

	/**
	 * @param categoryDeletedTime the categoryDeletedTime to set
	 */
	public void setCategoryDeletedTime(String categoryDeletedTime) {
		this.categoryDeletedTime = categoryDeletedTime;
	}

	/**
	 * @return the categoryDeletedDate
	 */
	public Date getCategoryDeletedDate() {
		return categoryDeletedDate;
	}

	/**
	 * @param categoryDeletedDate the categoryDeletedDate to set
	 */
	public void setCategoryDeletedDate(Date categoryDeletedDate) {
		this.categoryDeletedDate = categoryDeletedDate;
	}

	
	
}