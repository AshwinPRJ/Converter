package com.vyavharamitra.unitofmeasurement.service;
/**
 * @author : Kalyani
 * @created date :27 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;
import com.vyavharamitra.unitofmeasurement.to.request.UnitOfMeasurementRequest;

public interface IUnitOfMeasurementService {

	public UnitOfMeasurementBean unitOfMeasurementCreateService(UnitOfMeasurementRequest unitOfMeasurementRequest);
	
	
	public UnitOfMeasurementBean unitOfMeasurementReadService(UnitOfMeasurementRequest unitOfMeasurementRequest);


}