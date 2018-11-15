package com.vyavharamitra.search.dao.implementation;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.search.dao.IDealerDetailsSearchDao;
import com.vyavharamitra.search.to.request.DealerDetailsSearchRequest;
import com.vyavharamitra.utils.Utils;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */
@Repository
public class DealerDetailsSearchDaoImp implements IDealerDetailsSearchDao{

private Session session;
	
	@SuppressWarnings("unchecked")
	public List<DealerRegisterBean> getDealerDetailsonblurDao(DealerDetailsSearchRequest dealerDetailsSearchRequest,
			SessionFactory sessionFactory) {
		List<DealerRegisterBean> dealerRegisterBean = Collections.emptyList();
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			dealerRegisterBean = session.createCriteria(DealerRegisterBean.class)
					
					 .add(Restrictions.eq("dealerId",(dealerDetailsSearchRequest.getDealerRegisterBean()).getDealerId()))						
					.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();
				
			}
		}
		return dealerRegisterBean;
	}
		
	@SuppressWarnings("unchecked")
	public List<DealerRegisterBean> getDealerDetailsDao (SessionFactory sessionFactory) {
		List<DealerRegisterBean> dealerRegisterBeanlist = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			dealerRegisterBeanlist =(List<DealerRegisterBean>) session.createSQLQuery("select dlr_id,dlr_name,dlr_mobile,dlr_status from bil_dlr   ").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();
				
			}
		}
		if(!Utils.isNullList(dealerRegisterBeanlist))
		{
			return dealerRegisterBeanlist;
		}
		return dealerRegisterBeanlist;
	}
}
