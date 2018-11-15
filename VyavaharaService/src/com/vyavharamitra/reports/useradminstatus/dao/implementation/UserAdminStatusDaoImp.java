package com.vyavharamitra.reports.useradminstatus.dao.implementation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;
import com.vyavharamitra.dealerkeygeneration.bean.DealerKeyGenerationBean;
import com.vyavharamitra.reports.useradminstatus.dao.IUserAdminStatusDao;
import com.vyavharamitra.reports.useradminstatus.to.request.UserAdminStatusRequest;

/**
 * @author : Lavanya
 * @created date :04 Jan 2018
 * @modified by :
 * @modified date :
 */
@Repository
public class UserAdminStatusDaoImp implements IUserAdminStatusDao {

	private Session session;
	@Autowired
	private HttpServletRequest httpServletRequest;
	/**
	 * Read User Admin Status
	 */
	@SuppressWarnings("unchecked")
	public List<UserCreationBean> userAdminStatusDao(SessionFactory sessionFactory,
			UserAdminStatusRequest userAdminStatusRequest) {
		UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
		List<UserCreationBean> userCreationBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();

			Integer dealerId=ucb.getDealerId();
			String userStatus= userAdminStatusRequest.getUserCreationBean().getUserStatus();
			String userType="U";
			String userLevel="1";
			userAdminStatusRequest.getUserCreationBean().setUserType(userType);
			userAdminStatusRequest.getUserCreationBean().setUserLevel(userLevel);
			userCreationBean =(List<UserCreationBean>) session.createSQLQuery("select usm_sn,usm_eby,to_char(usm_edt,'dd Mon yyyy') as usm_edt,usm_et,usm_uby,to_char(usm_udt,'dd Mon yyyy') as usm_udt,usm_ut from bil_usm,bil_om,bil_dlr where usm_type = '"+userType+"' and usm_level = '"+userLevel+"' and usm_sta='"
					+ userStatus + "'  and usm_bid=om_id  and om_dlrid=dlr_id and dlr_id='"+dealerId+"'    order by usm_sno").list();

			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(userCreationBean))
		{
			return userCreationBean;
		}
		return userCreationBean;
	}


}
