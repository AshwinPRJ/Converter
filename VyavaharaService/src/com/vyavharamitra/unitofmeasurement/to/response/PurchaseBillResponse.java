package com.vyavharamitra.unitofmeasurement.to.response;
import java.util.List;

import com.vyavharamitra.unitofmeasurement.bean.ModifyPurchaseBillBean;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.unitofmeasurement.bean.PurchasedItemBean;
import com.vyavharamitra.utils.VyavaharaResponse;

public class PurchaseBillResponse extends VyavaharaResponse {
	private List<PurchaseBillBean> purchaseBillBean;
	private ModifyPurchaseBillBean modifyPurchaseBillBean;
	private PurchaseBillBean purchaseBean;
	private HelperPurchaseBean helperPurchaseBean;
	private List<PurchasedItemBean> purchasedItemBean;
	

	

	
	public List<PurchasedItemBean> getPurchasedItemBean() {
		return purchasedItemBean;
	}

	public void setPurchasedItemBean(List<PurchasedItemBean> purchasedItemBean) {
		this.purchasedItemBean = purchasedItemBean;
	}

	public HelperPurchaseBean getHelperPurchaseBean() {
		return helperPurchaseBean;
	}

	public void setHelperPurchaseBean(HelperPurchaseBean helperPurchaseBean) {
		this.helperPurchaseBean = helperPurchaseBean;
	}

	public PurchaseBillBean getPurchaseBean() {
		return purchaseBean;
	}

	public void setPurchaseBean(PurchaseBillBean purchaseBean) {
		this.purchaseBean = purchaseBean;
	}

	/**
	 * @return the modifyPurchaseBillBean
	 */
	public ModifyPurchaseBillBean getModifyPurchaseBillBean() {
		return modifyPurchaseBillBean;
	}

	/**
	 * @param modifyPurchaseBillBean the modifyPurchaseBillBean to set
	 */
	public void setModifyPurchaseBillBean(ModifyPurchaseBillBean modifyPurchaseBillBean) {
		this.modifyPurchaseBillBean = modifyPurchaseBillBean;
	}

	/**
	 * @return the purchaseBillBean
	 */
	public List<PurchaseBillBean> getPurchaseBillBean() {
		return purchaseBillBean;
	}

	/**
	 * @param purchaseBillBean the purchaseBillBean to set
	 */
	public void setPurchaseBillBean(List<PurchaseBillBean> purchaseBillBean) {
		this.purchaseBillBean = purchaseBillBean;
	}

	public void setPurchaseBillBean(PurchaseBillBean purchaseBillBean2) {

		
	}

	
	
	
	
	}

	
	


