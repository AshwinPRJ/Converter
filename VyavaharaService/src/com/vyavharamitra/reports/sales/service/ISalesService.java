package com.vyavharamitra.reports.sales.service;

import java.util.List;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.reports.sales.to.Request.SalesRequest;
/**
 * @author : Mohan M
 * @created date : 
 */
public interface ISalesService {

	List<CashSalesBean> salesByBranch(SalesRequest salesRequest);

	List<CashSalesBean> salesSummery(SalesRequest salesRequest);

	List<CashSalesBean> salesSummeryByDate(SalesRequest salesRequest);

	List<CashSalesBean> salesSummeryByCustomer(SalesRequest salesRequest);

	List<CashSalesBean> salesSummerybillsummery(SalesRequest salesRequest);
	
	List<CashSalesBean> salesSummeryQuantity(SalesRequest salesRequest);

}
