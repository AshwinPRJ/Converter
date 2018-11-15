package com.vyavharamitra.greetings.dao.implementation;
import org.hibernate.Query;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.greetings.beans.GreetingsBean;
import com.vyavharamitra.greetings.dao.IgreetingsUpdateDao;
import com.vyavharamitra.utils.Utils;
@Repository
public class GreetingsUpdateDaoImp implements IgreetingsUpdateDao{
	public GreetingsBean greetingsUpdateDao(SessionFactory sessionFactory, GreetingsBean greetingsBean) {
		Session session;
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query updateQuery = session.createQuery(
				"UPDATE GreetingsBean  SET branchMessage =:branchMessage,branchExpiredDate =:branchExpiredDate,branchEnteredBy =:branchEnteredBy,branchDate =:branchDate,branchTime =:branchTime where branchId =:branchId  ");
		updateQuery.setParameter("branchMessage", greetingsBean.getBranchMessage());
		updateQuery.setParameter("branchExpiredDate", greetingsBean.getBranchExpiredDate());
		updateQuery.setParameter("branchEnteredBy", greetingsBean.getBranchEnteredBy());
		updateQuery.setParameter("branchDate", greetingsBean.getBranchDate());
		updateQuery.setParameter("branchTime", greetingsBean.getBranchTime());
		updateQuery.setParameter("branchId", greetingsBean.getBranchId());
		updateQuery.executeUpdate();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(greetingsBean)) {
			return greetingsBean;
		}
		return greetingsBean;
}
}


