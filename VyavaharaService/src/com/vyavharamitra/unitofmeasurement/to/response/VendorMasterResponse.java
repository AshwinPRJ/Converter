package com.vyavharamitra.unitofmeasurement.to.response;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.unitofmeasurement.bean.VendorMasterBean;
import com.vyavharamitra.utils.VyavaharaResponse;
public class VendorMasterResponse extends VyavaharaResponse{
	private VendorMasterBean vendorMasterBean;

	/**
	 * @return the vendorMasterBean
	 */
	public VendorMasterBean getVendorMasterBean() {
		return vendorMasterBean;
	}

	/**
	 * @param vendorMasterBean the vendorMasterBean to set
	 */
	public void setVendorMasterBean(VendorMasterBean vendorMasterBean) {
		this.vendorMasterBean = vendorMasterBean;
	}
	
}
