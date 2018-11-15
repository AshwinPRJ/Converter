package com.vyavharamitra.dealerkeygeneration.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vyavharamitra.utils.DbConstant;

/**
 * @author : Mohan M
 * @created date : 29 Nov 2017
 * @modified by :
 * @modified date :
 */
@Entity
@Table(name = "bil_dlrkeyen", schema = DbConstant.SCHEMA_NAME)
public class DealerEncyKeyGenerationBean {

	@Id
	@Column(name = "dlrkeyen_no")
	private Integer keyNumber;

	@Column(name = "dlrkeyen_id")
	private Integer dealerID;

	@Column(name = "dlrkeyen_enkey")
	private String dealerKey;

	@Column(name = "dlrkeyen_status")
	private String keyStatus;

	@Column(name = "dlrkeyen_eby")
	private String enteredBy;

	@Column(name = "dlrkeyen_edate")
	private Date enteredDate;

	@Column(name = "dlrkeyen_etime")
	private String enteredTime;

	/**
	 * @return the keyNumber
	 */
	public Integer getKeyNumber() {
		return keyNumber;
	}

	/**
	 * @param keyNumber
	 *            the keyNumber to set
	 */
	public void setKeyNumber(Integer keyNumber) {
		this.keyNumber = keyNumber;
	}

	/**
	 * @return the dealerID
	 */
	public Integer getDealerID() {
		return dealerID;
	}

	/**
	 * @param dealerID
	 *            the dealerID to set
	 */
	public void setDealerID(Integer dealerID) {
		this.dealerID = dealerID;
	}

	/**
	 * @return the dealerKey
	 */
	public String getDealerKey() {
		return dealerKey;
	}

	/**
	 * @param dealerKey
	 *            the dealerKey to set
	 */
	public void setDealerKey(String dealerKey) {
		this.dealerKey = dealerKey;
	}

	/**
	 * @return the keyStatus
	 */
	public String getKeyStatus() {
		return keyStatus;
	}

	/**
	 * @param keyStatus
	 *            the keyStatus to set
	 */
	public void setKeyStatus(String keyStatus) {
		this.keyStatus = keyStatus;
	}

	/**
	 * @return the enteredBy
	 */
	public String getEnteredBy() {
		return enteredBy;
	}

	/**
	 * @param enteredBy
	 *            the enteredBy to set
	 */
	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	/**
	 * @return the enteredDate
	 */
	public Date getEnteredDate() {
		return enteredDate;
	}

	/**
	 * @param enteredDate
	 *            the enteredDate to set
	 */
	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}

	/**
	 * @return the enteredTime
	 */
	public String getEnteredTime() {
		return enteredTime;
	}

	/**
	 * @param enteredTime
	 *            the enteredTime to set
	 */
	public void setEnteredTime(String enteredTime) {
		this.enteredTime = enteredTime;
	}
}
