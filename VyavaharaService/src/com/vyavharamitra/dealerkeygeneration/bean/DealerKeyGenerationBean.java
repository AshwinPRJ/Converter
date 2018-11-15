package com.vyavharamitra.dealerkeygeneration.bean;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.vyavharamitra.utils.DbConstant;

/**
 * @author : Mohan M
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
@Entity
@Table(name = "bil_dlrkey", schema = DbConstant.SCHEMA_NAME)
public class DealerKeyGenerationBean extends Helper {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bil_dlrkey_dlrkey_no_seq")
	@SequenceGenerator(name="bil_dlrkey_dlrkey_no_seq", sequenceName="bil_dlrkey_dlrkey_no_seq", allocationSize=1)
	@Column(name = "dlrkey_no")
	private Integer keyNumber;
	
	@Column(name = "dlrkey_id")
	private Integer dealerID;

	@Column(name = "dlrkey_key")
	private BigInteger dealerKey;
	
	@Column(name = "dlrkey_status")
	private String keyStatus;

	@Column(name = "dlrkey_eby")
	private String enteredBy;

	@Column(name = "dlrkey_edate")
	private Date enteredDate;

	@Column(name = "dlrkey_etime")
	private String enteredTime;
	
	@Column(name = "dlrkey_adate")
	private Date activatedDate;

	@Column(name = "dlrkey_atime")
	private String activatedTime;
	
	

	/**
	 * @return the keyNumber
	 */
	public Integer getKeyNumber() {
		return keyNumber;
	}

	/**
	 * @param keyNumber the keyNumber to set
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
	 * @param dealerID the dealerID to set
	 */
	public void setDealerID(Integer dealerID) {
		this.dealerID = dealerID;
	}

	/**
	 * @return the dealerKey
	 */
	public BigInteger getDealerKey() {
		return dealerKey;
	}

	/**
	 * @param dealerKey the dealerKey to set
	 */
	public void setDealerKey(BigInteger dealerKey) {
		this.dealerKey = dealerKey;
	}

	/**
	 * @return the keyStatus
	 */
	public String getKeyStatus() {
		return keyStatus;
	}

	/**
	 * @param keyStatus the keyStatus to set
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
	 * @param enteredBy the enteredBy to set
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
	 * @param enteredDate the enteredDate to set
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
	 * @param enteredTime the enteredTime to set
	 */
	public void setEnteredTime(String enteredTime) {
		this.enteredTime = enteredTime;
	}

	/**
	 * @return the activatedDate
	 */
	public Date getActivatedDate() {
		return activatedDate;
	}

	/**
	 * @param activatedDate the activatedDate to set
	 */
	public void setActivatedDate(Date activatedDate) {
		this.activatedDate = activatedDate;
	}

	/**
	 * @return the activatedTime
	 */
	public String getActivatedTime() {
		return activatedTime;
	}

	/**
	 * @param activatedTime the activatedTime to set
	 */
	public void setActivatedTime(String activatedTime) {
		this.activatedTime = activatedTime;
	}
	
}
