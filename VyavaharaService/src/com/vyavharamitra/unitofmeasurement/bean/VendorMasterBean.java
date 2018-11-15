package com.vyavharamitra.unitofmeasurement.bean;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vyavharamitra.utils.DbConstant;
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "bil_vendmast", schema = DbConstant.SCHEMA_NAME)
public class VendorMasterBean {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bil_vendmast_vendmast_vid_seq")
	@SequenceGenerator(name="bil_vendmast_vendmast_vid_seq", sequenceName="bil_vendmast_vendmast_vid_seq", allocationSize=1)
	@Column(name = "vendmast_vid")
	private Integer vendorId;
	
	@Column(name = "vendmast_vname")
	private String vendorName;
	
	@Column(name = "vendmast_gstno")
	private String vendorGst;
	
	@Column(name = "vendmast_pan")
	private String vendorPanNo;
	
	@Column(name = "vendmast_mailid")
	private String vendorMailId;
	
	@Column(name = "vendmast_mobno")
	private BigInteger vendorMobileNo;
	
	@Column(name = "vendmast_cpname")
	private String vendorCpName;
	
	@Column(name = "vendmast_addline1")
	private String vendorAddLine;
	
	
	@Column(name = "vendmast_addline2")
	private String vendorAddLine2;
	
	@Column(name = "vendmast_city")
	private String vendorCity;
	
	
	@Column(name = "vendmast_state")
	private String vendorState;
	
	@Column(name = "vendmast_pin")
	private BigInteger vendorPinNo;
	
	
	@Column(name = "vendmast_eby")
	private String vendorEnteredBy;
	
	@Column(name = "vendmast_edate")
	private Date vendorEnteredDate;

	
	@Column(name = "vendmast_etime")
	private String vendorEnteredTime;

	@Column(name = "vendmast_dist")
	private String vendorDistrict;
	
	
	@Column(name = "vendmast_country")
	private String vendorCountry;
	
	@Column(name = "vendmast_phno")
	private BigInteger vendorPhoneNo;
	
	@Column(name = "vendmast_branchid")
	private Integer vendorBranchID;


	
	

	/**
	 * @return the vendorId
	 */
	public Integer getVendorId() {
		return vendorId;
	}

	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}

	/**
	 * @return the vendorBranchID
	 */
	public Integer getVendorBranchID() {
		return vendorBranchID;
	}

	/**
	 * @param vendorBranchID the vendorBranchID to set
	 */
	public void setVendorBranchID(Integer vendorBranchID) {
		this.vendorBranchID = vendorBranchID;
	}

	/**
	 * @return the vendorName
	 */
	public String getVendorName() {
		return vendorName;
	}

	/**
	 * @param vendorName the vendorName to set
	 */
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	/**
	 * @return the vendorGst
	 */
	public String getVendorGst() {
		return vendorGst;
	}

	/**
	 * @param vendorGst the vendorGst to set
	 */
	public void setVendorGst(String vendorGst) {
		this.vendorGst = vendorGst;
	}

	/**
	 * @return the vendorPanNo
	 */
	public String getVendorPanNo() {
		return vendorPanNo;
	}

	/**
	 * @param vendorPanNo the vendorPanNo to set
	 */
	public void setVendorPanNo(String vendorPanNo) {
		this.vendorPanNo = vendorPanNo;
	}

	/**
	 * @return the vendorMailId
	 */
	public String getVendorMailId() {
		return vendorMailId;
	}

	/**
	 * @param vendorMailId the vendorMailId to set
	 */
	public void setVendorMailId(String vendorMailId) {
		this.vendorMailId = vendorMailId;
	}

	/**
	 * @return the vendorMobileNo
	 */
	public BigInteger getVendorMobileNo() {
		return vendorMobileNo;
	}

	/**
	 * @param vendorMobileNo the vendorMobileNo to set
	 */
	public void setVendorMobileNo(BigInteger vendorMobileNo) {
		this.vendorMobileNo = vendorMobileNo;
	}

	/**
	 * @return the vendorCpName
	 */
	public String getVendorCpName() {
		return vendorCpName;
	}

	/**
	 * @param vendorCpName the vendorCpName to set
	 */
	public void setVendorCpName(String vendorCpName) {
		this.vendorCpName = vendorCpName;
	}

	/**
	 * @return the vendorAddLine
	 */
	public String getVendorAddLine() {
		return vendorAddLine;
	}

	/**
	 * @param vendorAddLine the vendorAddLine to set
	 */
	public void setVendorAddLine(String vendorAddLine) {
		this.vendorAddLine = vendorAddLine;
	}

	/**
	 * @return the vendorAddLine2
	 */
	public String getVendorAddLine2() {
		return vendorAddLine2;
	}

	/**
	 * @param vendorAddLine2 the vendorAddLine2 to set
	 */
	public void setVendorAddLine2(String vendorAddLine2) {
		this.vendorAddLine2 = vendorAddLine2;
	}

	/**
	 * @return the vendorCity
	 */
	public String getVendorCity() {
		return vendorCity;
	}

	/**
	 * @param vendorCity the vendorCity to set
	 */
	public void setVendorCity(String vendorCity) {
		this.vendorCity = vendorCity;
	}

	/**
	 * @return the vendorState
	 */
	public String getVendorState() {
		return vendorState;
	}

	/**
	 * @param vendorState the vendorState to set
	 */
	public void setVendorState(String vendorState) {
		this.vendorState = vendorState;
	}

	/**
	 * @return the vendorPinNo
	 */
	public BigInteger getVendorPinNo() {
		return vendorPinNo;
	}

	/**
	 * @param vendorPinNo the vendorPinNo to set
	 */
	public void setVendorPinNo(BigInteger vendorPinNo) {
		this.vendorPinNo = vendorPinNo;
	}

	/**
	 * @return the vendorEnteredBy
	 */
	public String getVendorEnteredBy() {
		return vendorEnteredBy;
	}

	/**
	 * @param vendorEnteredBy the vendorEnteredBy to set
	 */
	public void setVendorEnteredBy(String vendorEnteredBy) {
		this.vendorEnteredBy = vendorEnteredBy;
	}

	/**
	 * @return the vendorEnteredDate
	 */
	public Date getVendorEnteredDate() {
		return vendorEnteredDate;
	}

	/**
	 * @param vendorEnteredDate the vendorEnteredDate to set
	 */
	public void setVendorEnteredDate(Date vendorEnteredDate) {
		this.vendorEnteredDate = vendorEnteredDate;
	}

	/**
	 * @return the vendorEnteredTime
	 */
	public String getVendorEnteredTime() {
		return vendorEnteredTime;
	}

	/**
	 * @param vendorEnteredTime the vendorEnteredTime to set
	 */
	public void setVendorEnteredTime(String vendorEnteredTime) {
		this.vendorEnteredTime = vendorEnteredTime;
	}

	/**
	 * @return the vendorDistrict
	 */
	public String getVendorDistrict() {
		return vendorDistrict;
	}

	/**
	 * @param vendorDistrict the vendorDistrict to set
	 */
	public void setVendorDistrict(String vendorDistrict) {
		this.vendorDistrict = vendorDistrict;
	}

	/**
	 * @return the vendorCountry
	 */
	public String getVendorCountry() {
		return vendorCountry;
	}

	/**
	 * @param vendorCountry the vendorCountry to set
	 */
	public void setVendorCountry(String vendorCountry) {
		this.vendorCountry = vendorCountry;
	}

	/**
	 * @return the vendorPhoneNo
	 */
	public BigInteger getVendorPhoneNo() {
		return vendorPhoneNo;
	}

	/**
	 * @param vendorPhoneNo the vendorPhoneNo to set
	 */
	public void setVendorPhoneNo(BigInteger vendorPhoneNo) {
		this.vendorPhoneNo = vendorPhoneNo;
	}

	
	
}
