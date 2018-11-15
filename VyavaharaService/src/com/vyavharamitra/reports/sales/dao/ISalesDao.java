package com.vyavharamitra.reports.sales.dao;
/**
 * @author : Mohan M
 * @created date : 
 */
import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.reports.sales.to.Request.SalesRequest;

public interface ISalesDao {

	List<CashSalesBean> salesByBranch(SalesRequest salesRequest, SessionFactory sessionFactory);

	List<CashSalesBean> salesSummery(SalesRequest salesRequest, SessionFactory sessionFactory);

	List<CashSalesBean> salesSummeryByDate(SalesRequest salesRequest, SessionFactory sessionFactory);

	List<CashSalesBean> salesSummeryByCustomer(SalesRequest salesRequest, SessionFactory sessionFactory);

	List<CashSalesBean> salesSummerybillsummery(SalesRequest salesRequest, SessionFactory sessionFactory);
	
	List<CashSalesBean> salesSummeryQuantity(SalesRequest salesRequest, SessionFactory sessionFactory);

}
