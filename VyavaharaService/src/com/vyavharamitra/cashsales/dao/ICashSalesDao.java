package com.vyavharamitra.cashsales.dao;
/**
 * @author : Brahmani
 * @created date : 17 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;

import com.vyavharamitra.cashsales.beans.CashSalesBean;

public interface ICashSalesDao {

	CashSalesBean cashSalesCalculationDao(SessionFactory sessionFactory, CashSalesBean createCashSalesBean);

}
