package com.vyavharamitra.organization.bean;


import java.math.BigInteger;

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
@Table(name = "bil_vn", schema = DbConstant.SCHEMA_NAME)
public class BillVocherGenerationBean {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="bil_vn_vn_sno_seq")
	@SequenceGenerator(name="bil_vn_vn_sno_seq", sequenceName="bil_vn_vn_sno_seq", allocationSize=1)
	@Column(name = "vn_sno")
	private Integer serialNumber;
	
	@Column(name = "vn_bid")
	private Integer branchNumber;
	
	@Column(name = "vn_billno")
	private BigInteger billNumber;

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
	 * @return the billNumber
	 */
	public BigInteger getBillNumber() {
		return billNumber;
	}

	/**
	 * @param billNumber the billNumber to set
	 */
	public void setBillNumber(BigInteger billNumber) {
		this.billNumber = billNumber;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BillVocherGenerationBean [serialNumber=" + serialNumber + ", branchNumber=" + branchNumber
				+ ", billNumber=" + billNumber + "]";
	}

	
	
}
