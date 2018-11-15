package com.vyavharamitra.unitofmeasurement.to.request;

import java.util.List;

import com.vyavharamitra.unitofmeasurement.bean.DelPurchaseBillBean;
import com.vyavharamitra.unitofmeasurement.bean.ModifyPurchaseBillBean;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.unitofmeasurement.bean.PurchaseEmbeddedBean;
import com.vyavharamitra.unitofmeasurement.bean.PurchasedItemBean;
import com.vyavharamitra.unitofmeasurement.to.response.HelperPurchaseBean;

public class PurchaseBillRequest {
	
	private PurchaseBillBean purchaseBillBean;
	private PurchaseEmbeddedBean purchaseEmbeddedBean;
	private ModifyPurchaseBillBean modifyPurchaseBillBean;
	private DelPurchaseBillBean delPurchaseBillBean;
	private List<PurchasedItemBean> purchasedItemBean ;

	 private HelperPurchaseBean helperPurchaseBean;



	public HelperPurchaseBean getHelperPurchaseBean() {
		return helperPurchaseBean;
	}

	public void setHelperPurchaseBean(HelperPurchaseBean helperPurchaseBean) {
		this.helperPurchaseBean = helperPurchaseBean;
	}

	public List<PurchasedItemBean> getPurchasedItemBean() {
		return purchasedItemBean;
	}

	public void setPurchasedItemBean(List<PurchasedItemBean> purchasedItemBean) {
		this.purchasedItemBean = purchasedItemBean;
	}

	public PurchaseBillBean getPurchaseBillBean() {
		return purchaseBillBean;
	}

	public void setPurchaseBillBean(PurchaseBillBean purchaseBillBean) {
		this.purchaseBillBean = purchaseBillBean;
	}

	
	public PurchaseEmbeddedBean getPurchaseEmbeddedBean() {
		return purchaseEmbeddedBean;
	}

	public void setPurchaseEmbeddedBean(PurchaseEmbeddedBean purchaseEmbeddedBean) {
		this.purchaseEmbeddedBean = purchaseEmbeddedBean;
	}

	public ModifyPurchaseBillBean getModifyPurchaseBillBean() {
		return modifyPurchaseBillBean;
	}

	public void setModifyPurchaseBillBean(ModifyPurchaseBillBean modifyPurchaseBillBean) {
		this.modifyPurchaseBillBean = modifyPurchaseBillBean;
	}

	public DelPurchaseBillBean getDelPurchaseBillBean() {
		return delPurchaseBillBean;
	}

	public void setDelPurchaseBillBean(DelPurchaseBillBean delPurchaseBillBean) {
		this.delPurchaseBillBean = delPurchaseBillBean;
	}

}
