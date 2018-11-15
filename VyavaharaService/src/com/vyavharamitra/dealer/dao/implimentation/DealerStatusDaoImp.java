package com.vyavharamitra.dealer.dao.implimentation;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.dealer.dao.IdealerStatusDao;
import com.vyavharamitra.dealer.to.request.DealerStatusRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

@Repository
public class DealerStatusDaoImp implements IdealerStatusDao {

	private Session session;

	@Override
	public UserCreationBean dealerUpdateDao(SessionFactory sessionFactory, DealerStatusRequest dealerStatusRequest) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		UserCreationBean userCreationBean=new UserCreationBean();

		String userNumber = dealerStatusRequest.getUserCreationBean().getUserNumber();
		String userStatus = dealerStatusRequest.getUserCreationBean().getUserStatus();
		Integer dealerId=dealerStatusRequest.getUserCreationBean().getDealerId();


		Query dealerQuery = session.createSQLQuery("update bil_dlr set dlr_status = '"+userStatus+"'from bil_om,bil_usm where dlr_id = '"+ dealerId+"'and usm_type='U' and dlr_id=om_dlrid");
		dealerQuery.executeUpdate();

		Query dealerStatusQuery = session.createSQLQuery("update bil_usm set usm_sta='" + userStatus
				+ "'  from bil_dlr where usm_type='D'   and dlr_mobile = CAST (usm_uid AS numeric ) and usm_uid='"
				+ userNumber + "' ");
		dealerStatusQuery.executeUpdate();

		Query userStatusQuery = session.createSQLQuery(
				"update bil_usm set usm_sta='" + userStatus + "' from bil_om,bil_dlr where usm_type='U'   and dlr_id= '"
						+ dealerId + "' and om_id=usm_bid  and dlr_id=om_dlrid");
		userStatusQuery.executeUpdate();

		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(userCreationBean)) {
			return userCreationBean;
		}
		return userCreationBean;
	}


	/**
	 * read category item
	 */
	@SuppressWarnings("unchecked")
	public List<DealerRegisterBean> dealerRegisterReadDao(SessionFactory sessionFactory, Integer dealerId) {
		List<DealerRegisterBean> dealerRegisterList = Collections.emptyList();
		try {
			 session = sessionFactory.openSession();
			Criteria dealerDetails = session.createCriteria(DealerRegisterBean.class)
					.add(Restrictions.eq("dealerId", dealerId));
			dealerRegisterList = dealerDetails.list();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		}
		if(!Utils.isNullList(dealerRegisterList)) {
			return dealerRegisterList;
		}
		return dealerRegisterList;
	}

}
