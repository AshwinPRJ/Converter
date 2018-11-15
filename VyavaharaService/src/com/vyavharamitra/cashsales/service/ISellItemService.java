package com.vyavharamitra.cashsales.service;

/**
 * @author : Brahmani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.cashsales.to.request.CashSalesCreateRequest;

public interface ISellItemService {

	CashSalesBean createCashSalesService(CashSalesCreateRequest cashSalesCreateRequest);

}
