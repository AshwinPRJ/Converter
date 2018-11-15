package com.vyavharamitra.search.dao.implementation;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.search.dao.IUserMobileSearchDao;
import com.vyavharamitra.search.to.request.UserMobileSearchRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

@Repository
public class UserMobileSearchDaoImpl implements IUserMobileSearchDao{

	private Session session;
	
	//user Mobile Number
	@SuppressWarnings("unchecked")
	public List<CashSalesBean> getUserMobileonblurDao(UserMobileSearchRequest userMobileSearchRequest,
			SessionFactory sessionFactory) {
		BigInteger sellItemCustomerPhone=userMobileSearchRequest.getCashSalesBean().getSellItemCustomerPhone();
		List<CashSalesBean> cashSalesBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			cashSalesBean=(List<CashSalesBean>) session.createSQLQuery("select sellitem_cname ,sellitem_bdno,sellitem_bdname,sellitem_srt ,sellitem_lty,sellitem_dist ,sellitem_city ,sellitem_st ,sellitem_pin from bil_sellitem where sellitem_cphno ='"+sellItemCustomerPhone +"'")
					.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();
				
			}
		}
		return cashSalesBean;
	}
}
