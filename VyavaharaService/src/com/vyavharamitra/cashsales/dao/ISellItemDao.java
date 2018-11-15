package com.vyavharamitra.cashsales.dao;
/**
 * @author : Brahmani
 * @created date : 21 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.cashsales.beans.CashSalesLineBean;
import com.vyavharamitra.organization.bean.BillVocherGenerationBean;

public interface ISellItemDao {

	CashSalesBean createCashSalesDao(SessionFactory sessionFactory, CashSalesBean cashSalesBean);

	CashSalesLineBean createCashSalesLineDao(SessionFactory sessionFactory, CashSalesLineBean cashSalesLineBean);

	CashSalesBean selectCashSalesDao(SessionFactory sessionFactory, CashSalesBean cashSalesBean);

	BillVocherGenerationBean createBillNumberDao(SessionFactory sessionFactory, Integer branchID);
	BillVocherGenerationBean selectBillNumberDao(SessionFactory sessionFactory, Integer branchID);

	void updateCashSale(SessionFactory sessionFactory, CashSalesLineBean cashSalesLineBean);

}
