package com.vyavharamitra.branch.dao.implementation;

/**
 * @author : mohan
 * @created date :29 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.branch.dao.IBranchDao;
import com.vyavharamitra.branch.to.BranchRequest;
import com.vyavharamitra.greetings.beans.BranchBean;
import com.vyavharamitra.utils.Utils;

@Repository
public class BranchDaoImpl implements IBranchDao {
	/**
	 * branch details read
	 */
	public BranchBean getBranchName(BranchRequest branchRequest, SessionFactory sessionFactory) {
		BranchBean branchBean;
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		branchBean = (BranchBean) session.createCriteria(BranchBean.class)
				.add(Restrictions.eq("branchMasterId", branchRequest.getBranchBean().getBranchMasterId()))
				.uniqueResult();
		session.getTransaction().commit();

		if (session.isOpen()) {
			session.close();

		}
		if(!Utils.isNullList(branchBean)) {
			return branchBean;
		}
		return branchBean;
	}
}
