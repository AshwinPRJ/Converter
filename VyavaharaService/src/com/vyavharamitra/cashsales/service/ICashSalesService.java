package com.vyavharamitra.cashsales.service;

/**
 * @author : Brahmani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.cashsales.beans.CashSalesLineBean;
import com.vyavharamitra.cashsales.to.request.CashSalesCreateRequest;

public interface ICashSalesService {

	public CashSalesLineBean cashSalesCalculationService(CashSalesCreateRequest cashSalesCreateRequest);

}
