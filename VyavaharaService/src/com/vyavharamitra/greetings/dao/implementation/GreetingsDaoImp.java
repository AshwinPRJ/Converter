package com.vyavharamitra.greetings.dao.implementation;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.greetings.beans.GreetingsBean;
import com.vyavharamitra.greetings.dao.IGreetingsDao;
import com.vyavharamitra.greetings.to.request.GreetingsRequest;
import com.vyavharamitra.utils.Utils;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
@Repository
public class GreetingsDaoImp implements IGreetingsDao {

	private Session session;
	DateFormat dateFormate = new SimpleDateFormat("HH:mm:ss");
	Calendar calenderObj = Calendar.getInstance();
	Date date = new Date();

	public GreetingsBean greetingsCreateDao(SessionFactory sessionFactory, GreetingsBean greetingsBean) {
		
		greetingsBean.setBranchTime(dateFormate.format(calenderObj.getTime()));
		greetingsBean.setBranchDate(date);
		session = sessionFactory.openSession();
		session.saveOrUpdate(greetingsBean);
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(greetingsBean)) {
			return greetingsBean;
		}
		return greetingsBean;
	}
	// read greetings details
		@SuppressWarnings("unchecked")
		public List<GreetingsBean> greetingsFetch(SessionFactory sessionFactory, GreetingsRequest greetingsRequest){
			List<GreetingsBean> greetingsBean = null;
			try{
				BigInteger branchId=greetingsRequest.getGreetingsBean().getBranchId();
				 session = sessionFactory.openSession();
				session.getTransaction().begin();
				Query greetingsStatusUpdateQuery = session.createSQLQuery("update bil_brnmsg set brnmsg_sta='A' where brnmsg_expdt>=CURRENT_DATE and brnmsg_bid='"+ branchId + "' ");
				greetingsStatusUpdateQuery.executeUpdate();
				Query greetingsStatusUpdateQuery1 = session.createSQLQuery("update bil_brnmsg set brnmsg_sta='D' where brnmsg_expdt<CURRENT_DATE and brnmsg_bid='"
						+ branchId + "' ");
				greetingsStatusUpdateQuery1.executeUpdate();
				greetingsBean =(List<GreetingsBean>) session.createSQLQuery("select brnmsg_msg,to_char(brnmsg_expdt,'DD Mon YYYY') as brnmsg_expdt from bil_brnmsg,bil_bm where brnmsg_bid=bm_id and brnmsg_sta='A'and brnmsg_bid='"+ branchId + "' ").list();
				session.getTransaction().commit();
			}catch (Exception e) {
				Utils.logger("Exception : " + e);
			} finally {
				if (session != null && session.isOpen()) {
					session.close();
				}
			}
			if(!Utils.isNullList(greetingsBean)) {
				return greetingsBean;
			}
			return greetingsBean;
		}
}

