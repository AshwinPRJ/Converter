package com.vyavharamitra.organization.bean;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vyavharamitra.utils.DbConstant;

/**
 * @author : Kittu Kiran
 * @created date : 17 Nov 2017
 * @modified by :
 * @modified date :
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "bil_om", schema = DbConstant.SCHEMA_NAME)
public class OrganizationMasterBean {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bil_om_om_id_seq")
	@SequenceGenerator(name = "bil_om_om_id_seq", sequenceName = "bil_om_om_id_seq", allocationSize = 1)
	@Column(name = "om_id")
	private Integer organizationId;

	@Column(name = "om_date")
	private Date organizationDate;

	@Column(name = "om_name")
	private String organzisationName;

	@Column(name = "om_abbrv")
	private String organzisationAbbreviation;

	@Column(name = "om_bdno")
	private String organzisationBuildingNumber;

	@Column(name = "om_bdname")
	private String organzisationBuildingName;

	@Column(name = "om_srt")
	private String organzisationStreet;

	@Column(name = "om_lty")
	private String organzisationLocality;

	@Column(name = "om_dist")
	private String organzisationDistrict;

	@Column(name = "om_city")
	private String organzisationCity;

	@Column(name = "om_st")
	private String organzisationState;

	@Column(name = "om_pin")
	private BigInteger organzisationPincode;

	@Column(name = "om_ph1")
	private BigInteger organzisationPhoneNumber1;

	@Column(name = "om_ph2")
	private BigInteger organzisationPhoneNumber2;

	@Column(name = "om_pan")
	private String organzisationPermentAccountNumber;

	@Column(name = "om_tan")
	private String organzisationTaxAccountNumber;

	@Column(name = "om_mccode")
	private BigInteger organzisationMicrCode;

	@Column(name = "om_imgfile")
	private String organzisationImageFile;

	@Column(name = "om_oi")
	private String organizationInchargeName;

	@Column(name = "om_dsg")
	private String officerDesignation;

	@Column(name = "om_bdno1")
	private String officerBuildingNumber;

	@Column(name = "om_bdname1")
	private String officerBuildingName;

	@Column(name = "om_srt1")
	private String officerStreet;

	@Column(name = "om_lty1")
	private String officerlocality;

	@Column(name = "om_dist1")
	private String officerDistrict;

	@Column(name = "om_city1")
	private String officerCity;

	@Column(name = "om_st1")
	private String officerState;

	@Column(name = "om_pin1")
	private BigInteger officerPincode;

	@Column(name = "om_mobno")
	private BigInteger officerMobileNumber;

	@Column(name = "om_eid")
	private String officerEmailId;

	@Column(name = "om_nooflabels")
	private BigInteger numberOfLables;

	@Column(name = "om_dlrid")
	private Integer dealerId;

	@Column(name = "om_dlrkeyen")
	private String dealerKeyEncryption;

	@Column(name = "om_gst")
	private String goodsAndServiceTaxNumber;
	
	@Column(name="om_smsstatus")
	private String orgSmsStatus;
	
	
	
	
	
	

	public String getOrgSmsStatus() {
		return orgSmsStatus;
	}

	public void setOrgSmsStatus(String orgSmsStatus) {
		this.orgSmsStatus = orgSmsStatus;
	}

	/**
	 * @return the organizationId
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param organizationId
	 *            the organizationId to set
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @return the organizationDate
	 */
	public Date getOrganizationDate() {
		return organizationDate;
	}

	/**
	 * @param organizationDate
	 *            the organizationDate to set
	 */
	public void setOrganizationDate(Date organizationDate) {
		this.organizationDate = organizationDate;
	}

	/**
	 * @return the organzisationName
	 */
	public String getOrganzisationName() {
		return organzisationName;
	}

	/**
	 * @param organzisationName
	 *            the organzisationName to set
	 */
	public void setOrganzisationName(String organzisationName) {
		this.organzisationName = organzisationName;
	}

	/**
	 * @return the organzisationAbbreviation
	 */
	public String getOrganzisationAbbreviation() {
		return organzisationAbbreviation;
	}

	/**
	 * @param organzisationAbbreviation
	 *            the organzisationAbbreviation to set
	 */
	public void setOrganzisationAbbreviation(String organzisationAbbreviation) {
		this.organzisationAbbreviation = organzisationAbbreviation;
	}

	/**
	 * @return the organzisationBuildingNumber
	 */
	public String getOrganzisationBuildingNumber() {
		return organzisationBuildingNumber;
	}

	/**
	 * @param organzisationBuildingNumber
	 *            the organzisationBuildingNumber to set
	 */
	public void setOrganzisationBuildingNumber(String organzisationBuildingNumber) {
		this.organzisationBuildingNumber = organzisationBuildingNumber;
	}

	/**
	 * @return the organzisationBuildingName
	 */
	public String getOrganzisationBuildingName() {
		return organzisationBuildingName;
	}

	/**
	 * @param organzisationBuildingName
	 *            the organzisationBuildingName to set
	 */
	public void setOrganzisationBuildingName(String organzisationBuildingName) {
		this.organzisationBuildingName = organzisationBuildingName;
	}

	/**
	 * @return the organzisationStreet
	 */
	public String getOrganzisationStreet() {
		return organzisationStreet;
	}

	/**
	 * @param organzisationStreet
	 *            the organzisationStreet to set
	 */
	public void setOrganzisationStreet(String organzisationStreet) {
		this.organzisationStreet = organzisationStreet;
	}

	/**
	 * @return the organzisationLocality
	 */
	public String getOrganzisationLocality() {
		return organzisationLocality;
	}

	/**
	 * @param organzisationLocality
	 *            the organzisationLocality to set
	 */
	public void setOrganzisationLocality(String organzisationLocality) {
		this.organzisationLocality = organzisationLocality;
	}

	/**
	 * @return the organzisationDistrict
	 */
	public String getOrganzisationDistrict() {
		return organzisationDistrict;
	}

	/**
	 * @param organzisationDistrict
	 *            the organzisationDistrict to set
	 */
	public void setOrganzisationDistrict(String organzisationDistrict) {
		this.organzisationDistrict = organzisationDistrict;
	}

	/**
	 * @return the organzisationCity
	 */
	public String getOrganzisationCity() {
		return organzisationCity;
	}

	/**
	 * @param organzisationCity
	 *            the organzisationCity to set
	 */
	public void setOrganzisationCity(String organzisationCity) {
		this.organzisationCity = organzisationCity;
	}

	/**
	 * @return the organzisationState
	 */
	public String getOrganzisationState() {
		return organzisationState;
	}

	/**
	 * @param organzisationState
	 *            the organzisationState to set
	 */
	public void setOrganzisationState(String organzisationState) {
		this.organzisationState = organzisationState;
	}

	/**
	 * @return the organzisationPincode
	 */
	public BigInteger getOrganzisationPincode() {
		return organzisationPincode;
	}

	/**
	 * @param organzisationPincode
	 *            the organzisationPincode to set
	 */
	public void setOrganzisationPincode(BigInteger organzisationPincode) {
		this.organzisationPincode = organzisationPincode;
	}

	/**
	 * @return the organzisationPhoneNumber1
	 */
	public BigInteger getOrganzisationPhoneNumber1() {
		return organzisationPhoneNumber1;
	}

	/**
	 * @param organzisationPhoneNumber1
	 *            the organzisationPhoneNumber1 to set
	 */
	public void setOrganzisationPhoneNumber1(BigInteger organzisationPhoneNumber1) {
		this.organzisationPhoneNumber1 = organzisationPhoneNumber1;
	}

	/**
	 * @return the organzisationPhoneNumber2
	 */
	public BigInteger getOrganzisationPhoneNumber2() {
		return organzisationPhoneNumber2;
	}

	/**
	 * @param organzisationPhoneNumber2
	 *            the organzisationPhoneNumber2 to set
	 */
	public void setOrganzisationPhoneNumber2(BigInteger organzisationPhoneNumber2) {
		this.organzisationPhoneNumber2 = organzisationPhoneNumber2;
	}

	/**
	 * @return the organzisationPermentAccountNumber
	 */
	public String getOrganzisationPermentAccountNumber() {
		return organzisationPermentAccountNumber;
	}

	/**
	 * @param organzisationPermentAccountNumber
	 *            the organzisationPermentAccountNumber to set
	 */
	public void setOrganzisationPermentAccountNumber(String organzisationPermentAccountNumber) {
		this.organzisationPermentAccountNumber = organzisationPermentAccountNumber;
	}

	/**
	 * @return the organzisationTaxAccountNumber
	 */
	public String getOrganzisationTaxAccountNumber() {
		return organzisationTaxAccountNumber;
	}

	/**
	 * @param organzisationTaxAccountNumber
	 *            the organzisationTaxAccountNumber to set
	 */
	public void setOrganzisationTaxAccountNumber(String organzisationTaxAccountNumber) {
		this.organzisationTaxAccountNumber = organzisationTaxAccountNumber;
	}

	/**
	 * @return the organzisationMicrCode
	 */
	public BigInteger getOrganzisationMicrCode() {
		return organzisationMicrCode;
	}

	/**
	 * @param organzisationMicrCode
	 *            the organzisationMicrCode to set
	 */
	public void setOrganzisationMicrCode(BigInteger organzisationMicrCode) {
		this.organzisationMicrCode = organzisationMicrCode;
	}

	/**
	 * @return the organzisationImageFile
	 */
	public String getOrganzisationImageFile() {
		return organzisationImageFile;
	}

	/**
	 * @param organzisationImageFile
	 *            the organzisationImageFile to set
	 */
	public void setOrganzisationImageFile(String organzisationImageFile) {
		this.organzisationImageFile = organzisationImageFile;
	}

	/**
	 * @return the organizationInchargeName
	 */
	public String getOrganizationInchargeName() {
		return organizationInchargeName;
	}

	/**
	 * @param organizationInchargeName
	 *            the organizationInchargeName to set
	 */
	public void setOrganizationInchargeName(String organizationInchargeName) {
		this.organizationInchargeName = organizationInchargeName;
	}

	/**
	 * @return the officerDesignation
	 */
	public String getOfficerDesignation() {
		return officerDesignation;
	}

	/**
	 * @param officerDesignation
	 *            the officerDesignation to set
	 */
	public void setOfficerDesignation(String officerDesignation) {
		this.officerDesignation = officerDesignation;
	}

	/**
	 * @return the officerBuildingNumber
	 */
	public String getOfficerBuildingNumber() {
		return officerBuildingNumber;
	}

	/**
	 * @param officerBuildingNumber
	 *            the officerBuildingNumber to set
	 */
	public void setOfficerBuildingNumber(String officerBuildingNumber) {
		this.officerBuildingNumber = officerBuildingNumber;
	}

	/**
	 * @return the officerBuildingName
	 */
	public String getOfficerBuildingName() {
		return officerBuildingName;
	}

	/**
	 * @param officerBuildingName
	 *            the officerBuildingName to set
	 */
	public void setOfficerBuildingName(String officerBuildingName) {
		this.officerBuildingName = officerBuildingName;
	}

	/**
	 * @return the officerStreet
	 */
	public String getOfficerStreet() {
		return officerStreet;
	}

	/**
	 * @param officerStreet
	 *            the officerStreet to set
	 */
	public void setOfficerStreet(String officerStreet) {
		this.officerStreet = officerStreet;
	}

	/**
	 * @return the officerlocality
	 */
	public String getOfficerlocality() {
		return officerlocality;
	}

	/**
	 * @param officerlocality
	 *            the officerlocality to set
	 */
	public void setOfficerlocality(String officerlocality) {
		this.officerlocality = officerlocality;
	}

	/**
	 * @return the officerDistrict
	 */
	public String getOfficerDistrict() {
		return officerDistrict;
	}

	/**
	 * @param officerDistrict
	 *            the officerDistrict to set
	 */
	public void setOfficerDistrict(String officerDistrict) {
		this.officerDistrict = officerDistrict;
	}

	/**
	 * @return the officerCity
	 */
	public String getOfficerCity() {
		return officerCity;
	}

	/**
	 * @param officerCity
	 *            the officerCity to set
	 */
	public void setOfficerCity(String officerCity) {
		this.officerCity = officerCity;
	}

	/**
	 * @return the officerState
	 */
	public String getOfficerState() {
		return officerState;
	}

	/**
	 * @param officerState
	 *            the officerState to set
	 */
	public void setOfficerState(String officerState) {
		this.officerState = officerState;
	}

	/**
	 * @return the officerPincode
	 */
	public BigInteger getOfficerPincode() {
		return officerPincode;
	}

	/**
	 * @param officerPincode
	 *            the officerPincode to set
	 */
	public void setOfficerPincode(BigInteger officerPincode) {
		this.officerPincode = officerPincode;
	}

	/**
	 * @return the officerMobileNumber
	 */
	public BigInteger getOfficerMobileNumber() {
		return officerMobileNumber;
	}

	/**
	 * @param officerMobileNumber
	 *            the officerMobileNumber to set
	 */
	public void setOfficerMobileNumber(BigInteger officerMobileNumber) {
		this.officerMobileNumber = officerMobileNumber;
	}

	/**
	 * @return the officerEmailId
	 */
	public String getOfficerEmailId() {
		return officerEmailId;
	}

	/**
	 * @param officerEmailId
	 *            the officerEmailId to set
	 */
	public void setOfficerEmailId(String officerEmailId) {
		this.officerEmailId = officerEmailId;
	}

	/**
	 * @return the numberOfLables
	 */
	public BigInteger getNumberOfLables() {
		return numberOfLables;
	}

	/**
	 * @param numberOfLables
	 *            the numberOfLables to set
	 */
	public void setNumberOfLables(BigInteger numberOfLables) {
		this.numberOfLables = numberOfLables;
	}

	/**
	 * @return the dealerId
	 */
	public Integer getDealerId() {
		return dealerId;
	}

	/**
	 * @param dealerId
	 *            the dealerId to set
	 */
	public void setDealerId(Integer dealerId) {
		this.dealerId = dealerId;
	}

	/**
	 * @return the dealerKeyEncryption
	 */
	public String getDealerKeyEncryption() {
		return dealerKeyEncryption;
	}

	/**
	 * @param dealerKeyEncryption
	 *            the dealerKeyEncryption to set
	 */
	public void setDealerKeyEncryption(String dealerKeyEncryption) {
		this.dealerKeyEncryption = dealerKeyEncryption;
	}

	/**
	 * @return the goodsAndServiceTaxNumber
	 */
	public String getGoodsAndServiceTaxNumber() {
		return goodsAndServiceTaxNumber;
	}

	/**
	 * @param goodsAndServiceTaxNumber
	 *            the goodsAndServiceTaxNumber to set
	 */
	public void setGoodsAndServiceTaxNumber(String goodsAndServiceTaxNumber) {
		this.goodsAndServiceTaxNumber = goodsAndServiceTaxNumber;
	}

	@Override
	public String toString() {
		return "OrganizationMasterBean [organizationId=" + organizationId + ", organizationDate=" + organizationDate
				+ ", organzisationName=" + organzisationName + ", organzisationAbbreviation="
				+ organzisationAbbreviation + ", organzisationBuildingNumber=" + organzisationBuildingNumber
				+ ", organzisationBuildingName=" + organzisationBuildingName + ", organzisationStreet="
				+ organzisationStreet + ", organzisationLocality=" + organzisationLocality + ", organzisationDistrict="
				+ organzisationDistrict + ", organzisationCity=" + organzisationCity + ", organzisationState="
				+ organzisationState + ", organzisationPincode=" + organzisationPincode + ", organzisationPhoneNumber1="
				+ organzisationPhoneNumber1 + ", organzisationPhoneNumber2=" + organzisationPhoneNumber2
				+ ", organzisationPermentAccountNumber=" + organzisationPermentAccountNumber
				+ ", organzisationTaxAccountNumber=" + organzisationTaxAccountNumber + ", organzisationMicrCode="
				+ organzisationMicrCode + ", organzisationImageFile=" + organzisationImageFile
				+ ", organizationInchargeName=" + organizationInchargeName + ", officerDesignation="
				+ officerDesignation + ", officerBuildingNumber=" + officerBuildingNumber + ", officerBuildingName="
				+ officerBuildingName + ", officerStreet=" + officerStreet + ", officerlocality=" + officerlocality
				+ ", officerDistrict=" + officerDistrict + ", officerCity=" + officerCity + ", officerState="
				+ officerState + ", officerPincode=" + officerPincode + ", officerMobileNumber=" + officerMobileNumber
				+ ", officerEmailId=" + officerEmailId + ", numberOfLables=" + numberOfLables + ", dealerId=" + dealerId
				+ ", dealerKeyEncryption=" + dealerKeyEncryption + ", goodsAndServiceTaxNumber="
				+ goodsAndServiceTaxNumber + ", orgSmsStatus=" + orgSmsStatus + "]";
	}

	
	
}
