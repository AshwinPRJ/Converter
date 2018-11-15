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
 * @created date : 02 Dec 2017
 * @modified by : 
 * @modified date :
 */


@Entity
@Table(name = "bil_uctoi", schema = DbConstant.SCHEMA_NAME)
public class UpdateCategoryOfItemBean {
	
	@Id
	@Column(name = " uctoi_cid")
	private Integer categoryId;

	@Column(name = " uctoi_cname")
	private String categoryName;

	@Column(name = " uctoi_sgst")
	private BigDecimal categorySGST;

	@Column(name = " uctoi_cgst")
	private BigDecimal categoryCGST;

	@Column(name = " uctoi_igst")
	private BigDecimal categoryIGST;

	@Column(name = " uctoi_eby")
	private String categoryEnteredBy;

	@Column(name = " uctoi_eon")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date categoryEnteredDate;

	@Column(name = " uctoi_etime")
	private String categoryEnterdTime;

	@Column(name = " uctoi_uby")
	private String categoryUpdatedBy;

	@Column(name = " uctoi_utime")
	private String categoryUpdatedTime;

	@Column(name = " uctoi_uon")
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private Date categoryUpdatedDate;

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
	 * @return the categoryUpdatedBy
	 */
	public String getCategoryUpdatedBy() {
		return categoryUpdatedBy;
	}

	/**
	 * @param categoryUpdatedBy the categoryUpdatedBy to set
	 */
	public void setCategoryUpdatedBy(String categoryUpdatedBy) {
		this.categoryUpdatedBy = categoryUpdatedBy;
	}

	/**
	 * @return the categoryUpdatedTime
	 */
	public String getCategoryUpdatedTime() {
		return categoryUpdatedTime;
	}

	/**
	 * @param categoryUpdatedTime the categoryUpdatedTime to set
	 */
	public void setCategoryUpdatedTime(String categoryUpdatedTime) {
		this.categoryUpdatedTime = categoryUpdatedTime;
	}

	/**
	 * @return the categoryUpdatedDate
	 */
	public Date getCategoryUpdatedDate() {
		return categoryUpdatedDate;
	}

	/**
	 * @param categoryUpdatedDate the categoryUpdatedDate to set
	 */
	public void setCategoryUpdatedDate(Date categoryUpdatedDate) {
		this.categoryUpdatedDate = categoryUpdatedDate;
	}

	

	}
