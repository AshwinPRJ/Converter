package com.vyavharamitra.dealer.dao.implimentation;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
/**
 * @author : Brahmani
 * @created date : 29 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.dealer.dao.IdealerRegisterDao;
import com.vyavharamitra.organization.bean.OrganizationMasterBean;
import com.vyavharamitra.unitofmeasurement.bean.PurchasedItemBean;
import com.vyavharamitra.utils.Utils;

@Repository
public class DealerRegisterDaoImpl implements IdealerRegisterDao {

	private Session session;

	public DealerRegisterBean dealerCreateDao(SessionFactory sessionFactory, DealerRegisterBean dealerRegisterBean) {
		session = sessionFactory.openSession();
		BigInteger mblnumber = dealerRegisterBean.getDealerMobile();
		String dname = dealerRegisterBean.getDealerName();
		String enteredby = dealerRegisterBean.getDealerEnteredBy();
		java.util.Date entereddate = dealerRegisterBean.getDealerEnteredOn();
		session.save(dealerRegisterBean);
		Query createUsmQuery = session.createSQLQuery(
				"INSERT INTO bil_usm(usm_uid,usm_sn,usm_eby, usm_edt, usm_et,usm_type, usm_level, usm_bid, usm_fp) VALUES ('"
						+ mblnumber + "','" + dname + "','" + enteredby + "','" + entereddate
						+ "',to_char(now(),'HH24:MI:SS'),'D','1','1','NA')");
		createUsmQuery.executeUpdate();
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(dealerRegisterBean)) {
			return dealerRegisterBean;
		}
		return dealerRegisterBean;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrganizationMasterBean> dealersOrgReadDao(SessionFactory sessionFactory,
			DealerRegisterBean dealerRegisterBean) {
		session=sessionFactory.openSession();
		session.getTransaction().begin();
		Integer dealerIdForOrg=dealerRegisterBean.getDealerId();
		List<OrganizationMasterBean> organizationMasterBeans=Collections.emptyList();
		
		Criteria organizationMasterBeansdetails=session.createCriteria(OrganizationMasterBean.class).
				add(Restrictions.eq("dealerId",dealerIdForOrg));
		
		organizationMasterBeans=organizationMasterBeansdetails.list();
		
		session.getTransaction().commit();
		if(session.isOpen())
		{
			session.close();
		}
		if(!Utils.isNullList(organizationMasterBeans)) {
			return organizationMasterBeans;
		}
				
		return organizationMasterBeans;
		
		
	}

}