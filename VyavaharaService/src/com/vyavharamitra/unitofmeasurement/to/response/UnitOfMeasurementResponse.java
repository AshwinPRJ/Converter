package com.vyavharamitra.unitofmeasurement.to.response;
/**
 * @author : Kalyani
 * @created date :27 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;
import com.vyavharamitra.utils.VyavaharaResponse;

public class UnitOfMeasurementResponse extends VyavaharaResponse {
	private UnitOfMeasurementBean unitOfMeasurementBean;

	/**
	 * @return the unitOfMeasurementBean
	 */
	public UnitOfMeasurementBean getUnitOfMeasurementBean() {
		return unitOfMeasurementBean;
	}

	/**
	 * @param unitOfMeasurementBean
	 *            the unitOfMeasurementBean to set
	 */
	public void setUnitOfMeasurementBean(UnitOfMeasurementBean unitOfMeasurementBean) {
		this.unitOfMeasurementBean = unitOfMeasurementBean;
	}
}