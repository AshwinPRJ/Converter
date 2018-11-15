package com.vyavharamitra.dealer.bean;

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
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.vyavharamitra.utils.DbConstant;

/**
 * @author : Brahmani
 * @created date : 27 Nov 2017
 * @modified by :kalyani
 * @modified date :27 Nov 2017
 */
@Entity
@Table(name = "bil_dlr", schema = DbConstant.SCHEMA_NAME)
public class DealerRegisterBean extends DealerRegisterHelper {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bil_dlr_dlr_id_seq")
	@SequenceGenerator(name="bil_dlr_dlr_id_seq", sequenceName="bil_dlr_dlr_id_seq", allocationSize=1)
	@Column(name = "dlr_id")
	private Integer dealerId;

	@Column(name = "dlr_name")
	private String dealerName;

	@Column(name = "dlr_add1")
	private String dealerAddress1;

	@Column(name = "dlr_add2")
	private String dealerAddress2;

	@Column(name = "dlr_loclity")
	private String dealerLocality;

	@Column(name = "dlr_street")
	private String dealerStreet;

	@Column(name = "dlr_city")
	private String dealerCity;

	@Column(name = "dlr_dist")
	private String dealerDistrict;

	@Column(name = "dlr_state")
	private String dealerState;

	@Column(name = "dlr_pincode")
	private Integer dealerPincode;

	@Column(name = "dlr_mobile")
	private BigInteger dealerMobile;

	@JsonInclude(Include.NON_NULL)
	@Column(name = "dlr_lanno")
	private BigInteger dealerLannumber;

	@Column(name = "dlr_eon")
	private Date dealerEnteredOn;

	@Column(name = "dlr_etime")
	private String dealerEnteredTime;

	@Column(name = "dlr_eby")
	private String dealerEnteredBy;

	@Column(name = "dlr_status")
	private String dealerStatus;

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
	 * @return the dealerName
	 */
	public String getDealerName() {
		return dealerName;
	}

	/**
	 * @param dealerName
	 *            the dealerName to set
	 */
	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	/**
	 * @return the dealerAddress1
	 */
	public String getDealerAddress1() {
		return dealerAddress1;
	}

	/**
	 * @param dealerAddress1
	 *            the dealerAddress1 to set
	 */
	public void setDealerAddress1(String dealerAddress1) {
		this.dealerAddress1 = dealerAddress1;
	}

	/**
	 * @return the dealerAddress2
	 */
	public String getDealerAddress2() {
		return dealerAddress2;
	}

	/**
	 * @param dealerAddress2
	 *            the dealerAddress2 to set
	 */
	public void setDealerAddress2(String dealerAddress2) {
		this.dealerAddress2 = dealerAddress2;
	}

	/**
	 * @return the dealerLocality
	 */
	public String getDealerLocality() {
		return dealerLocality;
	}

	/**
	 * @param dealerLocality
	 *            the dealerLocality to set
	 */
	public void setDealerLocality(String dealerLocality) {
		this.dealerLocality = dealerLocality;
	}

	/**
	 * @return the dealerStreet
	 */
	public String getDealerStreet() {
		return dealerStreet;
	}

	/**
	 * @param dealerStreet
	 *            the dealerStreet to set
	 */
	public void setDealerStreet(String dealerStreet) {
		this.dealerStreet = dealerStreet;
	}

	/**
	 * @return the dealerCity
	 */
	public String getDealerCity() {
		return dealerCity;
	}

	/**
	 * @param dealerCity
	 *            the dealerCity to set
	 */
	public void setDealerCity(String dealerCity) {
		this.dealerCity = dealerCity;
	}

	/**
	 * @return the dealerDistrict
	 */
	public String getDealerDistrict() {
		return dealerDistrict;
	}

	/**
	 * @param dealerDistrict
	 *            the dealerDistrict to set
	 */
	public void setDealerDistrict(String dealerDistrict) {
		this.dealerDistrict = dealerDistrict;
	}

	/**
	 * @return the dealerState
	 */
	public String getDealerState() {
		return dealerState;
	}

	/**
	 * @param dealerState
	 *            the dealerState to set
	 */
	public void setDealerState(String dealerState) {
		this.dealerState = dealerState;
	}

	/**
	 * @return the dealerPincode
	 */
	public Integer getDealerPincode() {
		return dealerPincode;
	}

	/**
	 * @param dealerPincode
	 *            the dealerPincode to set
	 */
	public void setDealerPincode(Integer dealerPincode) {
		this.dealerPincode = dealerPincode;
	}

	/**
	 * @return the dealerMobile
	 */
	public BigInteger getDealerMobile() {
		return dealerMobile;
	}

	/**
	 * @param dealerMobile
	 *            the dealerMobile to set
	 */
	public void setDealerMobile(BigInteger dealerMobile) {
		this.dealerMobile = dealerMobile;
	}

	/**
	 * @return the dealerLannumber
	 */
	public BigInteger getDealerLannumber() {
		return dealerLannumber;
	}

	/**
	 * @param dealerLannumber
	 *            the dealerLannumber to set
	 */
	public void setDealerLannumber(BigInteger dealerLannumber) {
		this.dealerLannumber = dealerLannumber;
	}

	/**
	 * @return the dealerEnteredOn
	 */
	public Date getDealerEnteredOn() {
		return dealerEnteredOn;
	}

	/**
	 * @param dealerEnteredOn
	 *            the dealerEnteredOn to set
	 */
	public void setDealerEnteredOn(Date dealerEnteredOn) {
		this.dealerEnteredOn = dealerEnteredOn;
	}

	/**
	 * @return the dealerEnteredTime
	 */
	public String getDealerEnteredTime() {
		return dealerEnteredTime;
	}

	/**
	 * @param dealerEnteredTime
	 *            the dealerEnteredTime to set
	 */
	public void setDealerEnteredTime(String dealerEnteredTime) {
		this.dealerEnteredTime = dealerEnteredTime;
	}

	/**
	 * @return the dealerEnteredBy
	 */
	public String getDealerEnteredBy() {
		return dealerEnteredBy;
	}

	/**
	 * @param dealerEnteredBy
	 *            the dealerEnteredBy to set
	 */
	public void setDealerEnteredBy(String dealerEnteredBy) {
		this.dealerEnteredBy = dealerEnteredBy;
	}

	/**
	 * @return the dealerStatus
	 */
	public String getDealerStatus() {
		return dealerStatus;
	}

	/**
	 * @param dealerStatus
	 *            the dealerStatus to set
	 */
	public void setDealerStatus(String dealerStatus) {
		this.dealerStatus = dealerStatus;
	}

}