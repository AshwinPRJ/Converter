package com.vyavharamitra.itemdetails.beans;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vyavharamitra.utils.DbConstant;

@Entity
@Table(name = "bil_delitem", schema = DbConstant.SCHEMA_NAME)

public class DeleteItemMasterBean {

	@Id
	@Column(name = "delitem_bitemid")
	private Integer delBranchItemNumber;

	@Column(name = "delitem_name")
	private String delItemName;

	@Column(name = "delitem_delby")
	private String delItemBy;

	@Column(name = "delitem_delon")
	private Date delItemOn;

	@Column(name = "delitem_deltime")
	private String delItemTime;

	@Column(name = "delitem_bid")
	private Integer delItemBranchId;

	/**
	 * @return the delBranchItemNumber
	 */
	public Integer getDelBranchItemNumber() {
		return delBranchItemNumber;
	}

	/**
	 * @param delBranchItemNumber the delBranchItemNumber to set
	 */
	public void setDelBranchItemNumber(Integer delBranchItemNumber) {
		this.delBranchItemNumber = delBranchItemNumber;
	}

	/**
	 * @return the delItemName
	 */
	public String getDelItemName() {
		return delItemName;
	}

	/**
	 * @param delItemName the delItemName to set
	 */
	public void setDelItemName(String delItemName) {
		this.delItemName = delItemName;
	}

	/**
	 * @return the delItemBy
	 */
	public String getDelItemBy() {
		return delItemBy;
	}

	/**
	 * @param delItemBy the delItemBy to set
	 */
	public void setDelItemBy(String delItemBy) {
		this.delItemBy = delItemBy;
	}

	/**
	 * @return the delItemOn
	 */
	public Date getDelItemOn() {
		return delItemOn;
	}

	/**
	 * @param delItemOn the delItemOn to set
	 */
	public void setDelItemOn(Date delItemOn) {
		this.delItemOn = delItemOn;
	}

	/**
	 * @return the delItemTime
	 */
	public String getDelItemTime() {
		return delItemTime;
	}

	/**
	 * @param delItemTime the delItemTime to set
	 */
	public void setDelItemTime(String delItemTime) {
		this.delItemTime = delItemTime;
	}

	/**
	 * @return the delItemBranchId
	 */
	public Integer getDelItemBranchId() {
		return delItemBranchId;
	}

	/**
	 * @param delItemBranchId the delItemBranchId to set
	 */
	public void setDelItemBranchId(Integer delItemBranchId) {
		this.delItemBranchId = delItemBranchId;
	}
	

}
