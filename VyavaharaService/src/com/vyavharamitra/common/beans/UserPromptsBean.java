package com.vyavharamitra.common.beans;
/**
 * @author : Kittu Kiran
 * @created date : 18 Nov 2017
 * @modified by :
 * @modified date :
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vyavharamitra.utils.DbConstant;


@Entity
@Table(name = "bil_upf", schema = DbConstant.SCHEMA_NAME)
public class UserPromptsBean {
	@Id
	@Column(name = "upf_sno")
	private Integer serialNumber;
	
	@Column(name = "upf_eui")
	private Integer englishUserInterface;
	
	@Column(name = "upf_kui")
	private Integer kannadaUserInterface;
	
	@Column(name = "upf_mui")
	private Integer malayalamUserInterface;
	
	@Column(name = "upf_oui")
	private Integer orrisaUserInterface;
	
	@Column(name = "upf_cb")
	private Integer createdBy;
	
	@Column(name = "upf_co")
	private Integer createdOn;
	
	@Column(name = "upf_st")
	private Integer status;

	/**
	 * @return the serialNumber
	 */
	public Integer getSerialNumber() {
		return serialNumber;
	}

	/**
	 * @param serialNumber the serialNumber to set
	 */
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @return the englishUserInterface
	 */
	public Integer getEnglishUserInterface() {
		return englishUserInterface;
	}

	/**
	 * @param englishUserInterface the englishUserInterface to set
	 */
	public void setEnglishUserInterface(Integer englishUserInterface) {
		this.englishUserInterface = englishUserInterface;
	}

	/**
	 * @return the kannadaUserInterface
	 */
	public Integer getKannadaUserInterface() {
		return kannadaUserInterface;
	}

	/**
	 * @param kannadaUserInterface the kannadaUserInterface to set
	 */
	public void setKannadaUserInterface(Integer kannadaUserInterface) {
		this.kannadaUserInterface = kannadaUserInterface;
	}

	/**
	 * @return the malayalamUserInterface
	 */
	public Integer getMalayalamUserInterface() {
		return malayalamUserInterface;
	}

	/**
	 * @param malayalamUserInterface the malayalamUserInterface to set
	 */
	public void setMalayalamUserInterface(Integer malayalamUserInterface) {
		this.malayalamUserInterface = malayalamUserInterface;
	}

	/**
	 * @return the orrisaUserInterface
	 */
	public Integer getOrrisaUserInterface() {
		return orrisaUserInterface;
	}

	/**
	 * @param orrisaUserInterface the orrisaUserInterface to set
	 */
	public void setOrrisaUserInterface(Integer orrisaUserInterface) {
		this.orrisaUserInterface = orrisaUserInterface;
	}

	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdOn
	 */
	public Integer getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Integer createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
}
