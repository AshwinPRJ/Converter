package com.vyavharamitra.unitofmeasurement.bean;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PurchaseEmbeddedBean implements Serializable {
	
	@Column(name="purchase_billno")
	private BigInteger purchaseBillNo;
	
	@Column(name="purchase_gstno")
	private String purchaseSuplierGSTNo;
	
	@Column(name="purchase_branchid")
	private Integer purchaseBranchId;

	public BigInteger getPurchaseBillNo() {
		return purchaseBillNo;
	}

	public void setPurchaseBillNo(BigInteger purchaseBillNo) {
		this.purchaseBillNo = purchaseBillNo;
	}

	public String getPurchaseSuplierGSTNo() {
		return purchaseSuplierGSTNo;
	}

	public void setPurchaseSuplierGSTNo(String purchaseSuplierGSTNo) {
		this.purchaseSuplierGSTNo = purchaseSuplierGSTNo;
	}

	public Integer getPurchaseBranchId() {
		return purchaseBranchId;
	}

	public void setPurchaseBranchId(Integer purchaseBranchId) {
		this.purchaseBranchId = purchaseBranchId;
	}

	@Override
	public String toString() {
		return "PurchaseEmbeddedBean [purchaseBillNo=" + purchaseBillNo + ", purchaseSuplierGSTNo="
				+ purchaseSuplierGSTNo + ", purchaseBranchId=" + purchaseBranchId + "]";
	}

}
