package com.vyavharamitra.search.to.response;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import java.util.List;

import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;
import com.vyavharamitra.utils.VyavaharaResponse;

public class UnitMeasurementSearchResponse extends VyavaharaResponse{
	private List<UnitOfMeasurementBean> unitOfMeasurementBean;

	/**
	 * @return the unitOfMeasurementBean
	 */
	public List<UnitOfMeasurementBean> getUnitOfMeasurementBean() {
		return unitOfMeasurementBean;
	}

	/**
	 * @param unitOfMeasurementBean the unitOfMeasurementBean to set
	 */
	public void setUnitOfMeasurementBean(List<UnitOfMeasurementBean> unitOfMeasurementBean) {
		this.unitOfMeasurementBean = unitOfMeasurementBean;
	}

}
