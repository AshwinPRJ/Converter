package com.vyavharamitra.organization.bean;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.vyavharamitra.utils.DbConstant;


/**
 * @author : Lavanya
 * @created date : 05 Dec 2017
 * @modified by :
 * @modified date :
 */

@Entity
@Table(name = "bil_bitem", schema = DbConstant.SCHEMA_NAME)
public class ItemVocherGenerationBean {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bil_bitem_bitem_sno_seq")
	@SequenceGenerator(name="bil_bitem_bitem_sno_seq", sequenceName="bil_bitem_bitem_sno_seq", allocationSize=1)
	@Column(name = "bitem_sno")
	private Integer serialNumber;
	
	@Column(name = "bitem_bid")
	private Integer branchNumber;
	
	@Column(name = "bitem_itemid")
	private Integer ItemNumber;

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
	 * @return the branchNumber
	 */
	public Integer getBranchNumber() {
		return branchNumber;
	}

	/**
	 * @param branchNumber the branchNumber to set
	 */
	public void setBranchNumber(Integer branchNumber) {
		this.branchNumber = branchNumber;
	}

	/**
	 * @return the itemNumber
	 */
	public Integer getItemNumber() {
		return ItemNumber;
	}

	/**
	 * @param itemNumber the itemNumber to set
	 */
	public void setItemNumber(Integer itemNumber) {
		ItemNumber = itemNumber;
	}
	
	
	
}
