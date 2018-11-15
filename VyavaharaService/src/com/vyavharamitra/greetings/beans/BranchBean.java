package com.vyavharamitra.greetings.beans;
import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vyavharamitra.utils.DbConstant;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by : lavanya
 * @modified date : 05-Dec-2017
 */
@Entity
@Table(name = "bil_bm", schema = DbConstant.SCHEMA_NAME)
public class BranchBean {
	@Id
	@Column(name = "bm_id")
	private Integer branchMasterId;
	
	@Column(name = "bm_name")
	private String branchName;
	
	@Column(name = "bm_abbrv")
	private String branchAbbreviation;
	
	@Column(name = "bm_bdno")
	private String branchBuildingNo;
	
	@Column(name = "bm_bdname")
	private String branchBuildingName;
	
	@Column(name = "bm_srt")
	private String branchStreet;
	
	@Column(name = "bm_lty")
	private String branchLocality;
	
	@Column(name = "bm_dist")
	private String branchDistrict;
	
	@Column(name = "bm_city")
	private String branchCity;
	
	@Column(name = "bm_st")
	private String branchState;
	
	@Column(name = "bm_pin")
	private BigInteger branchPinCode;
	
	@Column(name = "bm_ph1")
	private BigInteger branchPhoneNumber;
	
	@Column(name = "bm_ph2")
	private BigInteger branchPhoneNumber2;
	
	@Column(name = "bm_pan")
	private String branchPanNo;
	
	@Column(name = "bm_tan")
	private String branchTanNo;
	

	@Column(name = "bm_ifsc")
	private String branchIfscCode;
	
	@Column(name = "bm_mccode")
	private String branchMcCode;
	
	@Column(name = "bm_wkoff")
	private String branchWeekOff;
	
	@Column(name = "bm_imgfile")
	private String branchImageFile;
	
	@Column(name = "bm_oi")
	private String branchOfficerId;
	
	
	@Column(name = "bm_dsg")
	private String branchDesignation;
	
	@Column(name = "bm_bdno1")
	private String branchBuildingNo1;
	
	@Column(name = "bm_bdname1")
	private String branchBuildingName1;
	
	@Column(name = "bm_srt1")
	private String branchStreet1;
	
	@Column(name = "bm_lty1")
	private String branchLocality1;
	
	@Column(name = "bm_dist1")
	private String branchDistrict1;
	
	@Column(name = "bm_city1")
	private String branchCity1;
	
	@Column(name = "bm_st1")
	private String branchState1;
	
	@Column(name = "bm_pin1")
	private BigInteger branchPinCode1;
	
	@Column(name = "bm_mobno")
	private BigInteger branchMobileNo;
	
	
	@Column(name = "bm_eid")
	private String branchEmployeeId;
	
	
	@Column(name = "bm_clos")
	private String branchClose;
	
	@Column(name = "bm_type")
	private String branchType;
	
	@Column(name = "bm_eby")
	private String branchEnteredBy;
	
	@Column(name = "bm_ed")
	private Date branchEnteredDate;
	
	
	@Column(name = "bm_et")
	private String branchEnteredTime;
	
	@Column(name = "bm_gstin")
	private String branchGstNo;
	
	@Column(name = "bm_imgpath")
	private String branchImagePath;

	/**
	 * @return the branchMasterId
	 */
	public Integer getBranchMasterId() {
		return branchMasterId;
	}

	/**
	 * @param branchMasterId the branchMasterId to set
	 */
	public void setBranchMasterId(Integer branchMasterId) {
		this.branchMasterId = branchMasterId;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the branchAbbreviation
	 */
	public String getBranchAbbreviation() {
		return branchAbbreviation;
	}

	/**
	 * @param branchAbbreviation the branchAbbreviation to set
	 */
	public void setBranchAbbreviation(String branchAbbreviation) {
		this.branchAbbreviation = branchAbbreviation;
	}

	/**
	 * @return the branchBuildingNo
	 */
	public String getBranchBuildingNo() {
		return branchBuildingNo;
	}

	/**
	 * @param branchBuildingNo the branchBuildingNo to set
	 */
	public void setBranchBuildingNo(String branchBuildingNo) {
		this.branchBuildingNo = branchBuildingNo;
	}

	/**
	 * @return the branchBuildingName
	 */
	public String getBranchBuildingName() {
		return branchBuildingName;
	}

	/**
	 * @param branchBuildingName the branchBuildingName to set
	 */
	public void setBranchBuildingName(String branchBuildingName) {
		this.branchBuildingName = branchBuildingName;
	}

	/**
	 * @return the branchStreet
	 */
	public String getBranchStreet() {
		return branchStreet;
	}

	/**
	 * @param branchStreet the branchStreet to set
	 */
	public void setBranchStreet(String branchStreet) {
		this.branchStreet = branchStreet;
	}

	/**
	 * @return the branchLocality
	 */
	public String getBranchLocality() {
		return branchLocality;
	}

	/**
	 * @param branchLocality the branchLocality to set
	 */
	public void setBranchLocality(String branchLocality) {
		this.branchLocality = branchLocality;
	}

	/**
	 * @return the branchDistrict
	 */
	public String getBranchDistrict() {
		return branchDistrict;
	}

	/**
	 * @param branchDistrict the branchDistrict to set
	 */
	public void setBranchDistrict(String branchDistrict) {
		this.branchDistrict = branchDistrict;
	}

	/**
	 * @return the branchCity
	 */
	public String getBranchCity() {
		return branchCity;
	}

	/**
	 * @param branchCity the branchCity to set
	 */
	public void setBranchCity(String branchCity) {
		this.branchCity = branchCity;
	}

	/**
	 * @return the branchState
	 */
	public String getBranchState() {
		return branchState;
	}

	/**
	 * @param branchState the branchState to set
	 */
	public void setBranchState(String branchState) {
		this.branchState = branchState;
	}

	/**
	 * @return the branchPinCode
	 */
	public BigInteger getBranchPinCode() {
		return branchPinCode;
	}

	/**
	 * @param branchPinCode the branchPinCode to set
	 */
	public void setBranchPinCode(BigInteger branchPinCode) {
		this.branchPinCode = branchPinCode;
	}

	/**
	 * @return the branchPhoneNumber
	 */
	public BigInteger getBranchPhoneNumber() {
		return branchPhoneNumber;
	}

	/**
	 * @param branchPhoneNumber the branchPhoneNumber to set
	 */
	public void setBranchPhoneNumber(BigInteger branchPhoneNumber) {
		this.branchPhoneNumber = branchPhoneNumber;
	}

	/**
	 * @return the branchPhoneNumber2
	 */
	public BigInteger getBranchPhoneNumber2() {
		return branchPhoneNumber2;
	}

	/**
	 * @param branchPhoneNumber2 the branchPhoneNumber2 to set
	 */
	public void setBranchPhoneNumber2(BigInteger branchPhoneNumber2) {
		this.branchPhoneNumber2 = branchPhoneNumber2;
	}

	/**
	 * @return the branchPanNo
	 */
	public String getBranchPanNo() {
		return branchPanNo;
	}

	/**
	 * @param branchPanNo the branchPanNo to set
	 */
	public void setBranchPanNo(String branchPanNo) {
		this.branchPanNo = branchPanNo;
	}

	/**
	 * @return the branchTanNo
	 */
	public String getBranchTanNo() {
		return branchTanNo;
	}

	/**
	 * @param branchTanNo the branchTanNo to set
	 */
	public void setBranchTanNo(String branchTanNo) {
		this.branchTanNo = branchTanNo;
	}

	/**
	 * @return the branchIfscCode
	 */
	public String getBranchIfscCode() {
		return branchIfscCode;
	}

	/**
	 * @param branchIfscCode the branchIfscCode to set
	 */
	public void setBranchIfscCode(String branchIfscCode) {
		this.branchIfscCode = branchIfscCode;
	}

	/**
	 * @return the branchMcCode
	 */
	public String getBranchMcCode() {
		return branchMcCode;
	}

	/**
	 * @param branchMcCode the branchMcCode to set
	 */
	public void setBranchMcCode(String branchMcCode) {
		this.branchMcCode = branchMcCode;
	}

	/**
	 * @return the branchWeekOff
	 */
	public String getBranchWeekOff() {
		return branchWeekOff;
	}

	/**
	 * @param branchWeekOff the branchWeekOff to set
	 */
	public void setBranchWeekOff(String branchWeekOff) {
		this.branchWeekOff = branchWeekOff;
	}

	/**
	 * @return the branchImageFile
	 */
	public String getBranchImageFile() {
		return branchImageFile;
	}

	/**
	 * @param branchImageFile the branchImageFile to set
	 */
	public void setBranchImageFile(String branchImageFile) {
		this.branchImageFile = branchImageFile;
	}

	/**
	 * @return the branchOfficerId
	 */
	public String getBranchOfficerId() {
		return branchOfficerId;
	}

	/**
	 * @param branchOfficerId the branchOfficerId to set
	 */
	public void setBranchOfficerId(String branchOfficerId) {
		this.branchOfficerId = branchOfficerId;
	}

	/**
	 * @return the branchDesignation
	 */
	public String getBranchDesignation() {
		return branchDesignation;
	}

	/**
	 * @param branchDesignation the branchDesignation to set
	 */
	public void setBranchDesignation(String branchDesignation) {
		this.branchDesignation = branchDesignation;
	}

	/**
	 * @return the branchBuildingNo1
	 */
	public String getBranchBuildingNo1() {
		return branchBuildingNo1;
	}

	/**
	 * @param branchBuildingNo1 the branchBuildingNo1 to set
	 */
	public void setBranchBuildingNo1(String branchBuildingNo1) {
		this.branchBuildingNo1 = branchBuildingNo1;
	}

	/**
	 * @return the branchBuildingName1
	 */
	public String getBranchBuildingName1() {
		return branchBuildingName1;
	}

	/**
	 * @param branchBuildingName1 the branchBuildingName1 to set
	 */
	public void setBranchBuildingName1(String branchBuildingName1) {
		this.branchBuildingName1 = branchBuildingName1;
	}

	/**
	 * @return the branchStreet1
	 */
	public String getBranchStreet1() {
		return branchStreet1;
	}

	/**
	 * @param branchStreet1 the branchStreet1 to set
	 */
	public void setBranchStreet1(String branchStreet1) {
		this.branchStreet1 = branchStreet1;
	}

	/**
	 * @return the branchLocality1
	 */
	public String getBranchLocality1() {
		return branchLocality1;
	}

	/**
	 * @param branchLocality1 the branchLocality1 to set
	 */
	public void setBranchLocality1(String branchLocality1) {
		this.branchLocality1 = branchLocality1;
	}

	/**
	 * @return the branchDistrict1
	 */
	public String getBranchDistrict1() {
		return branchDistrict1;
	}

	/**
	 * @param branchDistrict1 the branchDistrict1 to set
	 */
	public void setBranchDistrict1(String branchDistrict1) {
		this.branchDistrict1 = branchDistrict1;
	}

	/**
	 * @return the branchCity1
	 */
	public String getBranchCity1() {
		return branchCity1;
	}

	/**
	 * @param branchCity1 the branchCity1 to set
	 */
	public void setBranchCity1(String branchCity1) {
		this.branchCity1 = branchCity1;
	}

	/**
	 * @return the branchPinCode1
	 */
	public BigInteger getBranchPinCode1() {
		return branchPinCode1;
	}

	/**
	 * @param branchPinCode1 the branchPinCode1 to set
	 */
	public void setBranchPinCode1(BigInteger branchPinCode1) {
		this.branchPinCode1 = branchPinCode1;
	}

	/**
	 * @return the branchMobileNo
	 */
	public BigInteger getBranchMobileNo() {
		return branchMobileNo;
	}

	/**
	 * @param branchMobileNo the branchMobileNo to set
	 */
	public void setBranchMobileNo(BigInteger branchMobileNo) {
		this.branchMobileNo = branchMobileNo;
	}

	/**
	 * @return the branchEmployeeId
	 */
	public String getBranchEmployeeId() {
		return branchEmployeeId;
	}

	/**
	 * @param branchEmployeeId the branchEmployeeId to set
	 */
	public void setBranchEmployeeId(String branchEmployeeId) {
		this.branchEmployeeId = branchEmployeeId;
	}

	/**
	 * @return the branchClose
	 */
	public String getBranchClose() {
		return branchClose;
	}

	/**
	 * @param branchClose the branchClose to set
	 */
	public void setBranchClose(String branchClose) {
		this.branchClose = branchClose;
	}

	/**
	 * @return the branchType
	 */
	public String getBranchType() {
		return branchType;
	}

	/**
	 * @param branchType the branchType to set
	 */
	public void setBranchType(String branchType) {
		this.branchType = branchType;
	}

	/**
	 * @return the branchEnteredBy
	 */
	public String getBranchEnteredBy() {
		return branchEnteredBy;
	}

	/**
	 * @param branchEnteredBy the branchEnteredBy to set
	 */
	public void setBranchEnteredBy(String branchEnteredBy) {
		this.branchEnteredBy = branchEnteredBy;
	}

	/**
	 * @return the branchEnteredDate
	 */
	public Date getBranchEnteredDate() {
		return branchEnteredDate;
	}

	/**
	 * @param branchEnteredDate the branchEnteredDate to set
	 */
	public void setBranchEnteredDate(Date branchEnteredDate) {
		this.branchEnteredDate = branchEnteredDate;
	}

	/**
	 * @return the branchEnteredTime
	 */
	public String getBranchEnteredTime() {
		return branchEnteredTime;
	}

	/**
	 * @param branchEnteredTime the branchEnteredTime to set
	 */
	public void setBranchEnteredTime(String branchEnteredTime) {
		this.branchEnteredTime = branchEnteredTime;
	}

	/**
	 * @return the branchGstNo
	 */
	public String getBranchGstNo() {
		return branchGstNo;
	}

	/**
	 * @param branchGstNo the branchGstNo to set
	 */
	public void setBranchGstNo(String branchGstNo) {
		this.branchGstNo = branchGstNo;
	}

	/**
	 * @return the branchImagePath
	 */
	public String getBranchImagePath() {
		return branchImagePath;
	}

	/**
	 * @param branchImagePath the branchImagePath to set
	 */
	public void setBranchImagePath(String branchImagePath) {
		this.branchImagePath = branchImagePath;
	}

	/**
	 * @return the branchState1
	 */
	public String getBranchState1() {
		return branchState1;
	}

	/**
	 * @param branchState1 the branchState1 to set
	 */
	public void setBranchState1(String branchState1) {
		this.branchState1 = branchState1;
	}

	
	
	}

	
