package com.vyavharamitra.cashsales.dao.implementation;
/**
 * @author : Brahmani
 * @created date : 20 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.cashsales.dao.ICashSalesDao;
import com.vyavharamitra.utils.Utils;

@Repository
public class CashSalesDaoImpl implements ICashSalesDao{
	private Session session;
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();
	
	public CashSalesBean cashSalesCalculationDao(SessionFactory sessionFactory, CashSalesBean cashSalesBean) {
		session = sessionFactory.openSession();
		session.createCriteria(cashSalesBean.getClass());
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(cashSalesBean)) {
			return cashSalesBean;
		}
		return cashSalesBean;
	}

}
