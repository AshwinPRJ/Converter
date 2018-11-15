package com.vyavharamitra.unitofmeasurement.to.response;

import java.util.List;

import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.unitofmeasurement.bean.PurchasedItemBean;

public class HelperPurchaseBean {
	
	private PurchaseBillBean purchaseBillBean;
	private List<PurchasedItemBean> purchasedItemBean;
	
	public PurchaseBillBean getPurchaseBillBean() {
		return purchaseBillBean;
	}
	public void setPurchaseBillBean(PurchaseBillBean purchaseBillBean) {
		this.purchaseBillBean = purchaseBillBean;
	}
	public List<PurchasedItemBean> getPurchasedItemBean() {
		return purchasedItemBean;
	}
	public void setPurchasedItemBean(List<PurchasedItemBean> purchasedItemBean) {
		this.purchasedItemBean = purchasedItemBean;
	}
	
	

}
