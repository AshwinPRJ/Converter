package com.vyavharamitra.loginvalidations.dao.implementation;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.dealer.bean.DealerRegisterBean;
import com.vyavharamitra.loginvalidations.dao.ILoginValidationsDao;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.usercreation.to.request.UserCreationRequest;
import com.vyavharamitra.utils.Utils;
@Repository
public class LoginValidationsDaoImpl implements ILoginValidationsDao {
private Session session;
@Autowired
private HttpServletRequest httpServletRequest;
/**
 * @author : M Mohan
 * @created date : 
 * @modified by :
 * @modified date :
 */
	public UserCreationBean loginValidationsDao(SessionFactory sessionFactory, UserCreationBean userCreationBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		UserCreationBean ucb = new UserCreationBean();
		DealerRegisterBean ucb1 = new DealerRegisterBean();
		
		try {
			session = sessionFactory.openSession();
			ucb = (UserCreationBean) session.createCriteria(UserCreationBean.class)
						.add(Restrictions.eq("userNumber", userCreationBean.getUserNumber()))
						.add(Restrictions.eq("userFirstPassword", userCreationBean.getUserFirstPassword()))
						.add(Restrictions.eq("userStatus","A"))
						.uniqueResult();	
			
			String userType=ucb.getUserType();
			String	strUserId=userCreationBean.getUserNumber();
			if(userType.equalsIgnoreCase("D")){
				ucb1=  (DealerRegisterBean) session.createCriteria(DealerRegisterBean.class)
						.add(Restrictions.eq("dealerMobile",new BigInteger(strUserId)))
						.uniqueResult();	
			
			ucb.setDealerId(ucb1.getDealerId());
			}
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session.isOpen()) {
				session.close();
			}
		}
		if(!Utils.isNullList(ucb)) {
			return ucb;
		}
		return ucb;
	}

public UserCreationBean userLoginValuesDao(SessionFactory sessionFactory) {
	UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
	String userLastIp=httpServletRequest.getRemoteAddr();
	String userNumber=ucb.getUserNumber();
	Integer branchNumber=ucb.getBranchNumber();
	session = sessionFactory.openSession();
	session.beginTransaction();
	UserCreationBean userCreationBean = new UserCreationBean();
	Query Qry = session.createSQLQuery("Update bil_usm set usm_lst ='Y', usm_lip =:userLastIp where usm_uid =:userNumber ");
	Qry=Qry.setParameter("userNumber",userNumber);
	Qry=Qry.setParameter("userLastIp",userLastIp);
	Qry.executeUpdate();
	Query UsrLogQry = session.createSQLQuery("Insert into bil_usmlog(usmlog_bid,usmlog_uid,usmlog_lidt,usmlog_lit, usmlog_lodt,usmlog_lot,usmlog_lip) values ('" + branchNumber + "','" + userNumber + "',current_date,current_time(0),null, null,'" + userLastIp + "') ");
	UsrLogQry.executeUpdate();
	session.getTransaction().commit();
	if (session.isOpen()) {
		session.close();
	}
	if(!Utils.isNullList(userCreationBean)) {
		return userCreationBean;
	}

	return userCreationBean ;
	
	
}
public UserCreationBean userLogoutValuesDao(SessionFactory sessionFactory) {
	UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
	String userNumber=ucb.getUserNumber();
	Integer branchNumber=ucb.getBranchNumber();
	session = sessionFactory.openSession();
	session.beginTransaction();
	UserCreationBean userCreationBean = new UserCreationBean();
	Query Qry = session.createSQLQuery("Update bil_usm set usm_lst = 'N',usm_lip='' where usm_uid =:userNumber ");
	Qry=Qry.setParameter("userNumber",userNumber);
	Qry.executeUpdate();
	Query UsrLogQry = session.createSQLQuery("Update bil_usmlog set usmlog_lodt=current_date, usmlog_lot=current_time(0) where usmlog_bid ='" + branchNumber +"' and usmlog_uid = '" + userNumber+ "' and usmlog_lodt is null ");
	UsrLogQry.executeUpdate();
	session.getTransaction().commit();
	if (session.isOpen()) {
		session.close();
	}
	if(!Utils.isNullList(userCreationBean)) {
		return userCreationBean;
	}

	return userCreationBean ;
	
	
}
}
