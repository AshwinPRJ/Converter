package com.vyavharamitra.reports.keys.dao.implementation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.dealerkeygeneration.bean.DealerKeyGenerationBean;
import com.vyavharamitra.reports.keys.dao.IDealerKeyDao;
import com.vyavharamitra.reports.keys.to.request.DealerKeyRequest;
import com.vyavharamitra.utils.Utils;

/**
 * @author : Lavanya
 * @created date :18 Dec 2017
 * @modified by :
 * @modified date :
 */

@Repository
public class DealerKeyDaoImp implements IDealerKeyDao {

	private Session session;
	/**
	 * Read Total Keys
	 */
	@SuppressWarnings("unchecked")
	public List<DealerKeyGenerationBean> dealerKeyDao(SessionFactory sessionFactory,DealerKeyRequest dealerKeyRequest) {
		Integer dealerID=dealerKeyRequest.getDealerKeyGenerationBean().getDealerID();
		List<DealerKeyGenerationBean> dealerKeyGenerationBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			dealerKeyGenerationBean =(List<DealerKeyGenerationBean>) session.createSQLQuery(" select dlrkey_key,to_char(dlrkey_edate,'dd Mon yyyy') as dlrkey_edate ,dlrkey_eby,dlrkey_etime from bil_dlrkey  where  dlrkey_id='"+ dealerID + "' ").list();

			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(dealerKeyGenerationBean))
		{
			return dealerKeyGenerationBean;
		}
		return dealerKeyGenerationBean;
	}

	/**
	 * Read Key Status
	 */

	@SuppressWarnings("unchecked")
	public List<DealerKeyGenerationBean> dealerStatusKeyDao(SessionFactory sessionFactory,
			DealerKeyRequest dealerKeyRequest) {
		Integer dealerID=dealerKeyRequest.getDealerKeyGenerationBean().getDealerID();
		String keyStatus=dealerKeyRequest.getDealerKeyGenerationBean().getKeyStatus();
		List<DealerKeyGenerationBean> dealerKeyGenerationBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			dealerKeyGenerationBean =(List<DealerKeyGenerationBean>) session.createSQLQuery(" select dlrkey_key,to_char(dlrkey_edate,'dd Mon yyyy') as dlrkey_edate ,dlrkey_eby,dlrkey_etime from bil_dlrkey  where dlrkey_status='"+keyStatus+"' and  dlrkey_id='"+ dealerID + "' ").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(dealerKeyGenerationBean))
		{
			return dealerKeyGenerationBean;
		}
		return dealerKeyGenerationBean;
	}


}