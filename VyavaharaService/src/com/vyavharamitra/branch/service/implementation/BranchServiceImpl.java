package com.vyavharamitra.branch.service.implementation;

/**
 * @author : mohan
 * @created date :29 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.branch.dao.IBranchDao;
import com.vyavharamitra.branch.service.IBranchService;
import com.vyavharamitra.branch.to.BranchRequest;
import com.vyavharamitra.greetings.beans.BranchBean;

import resources.HibernateUtil;

@Service
public class BranchServiceImpl implements IBranchService {

	@Autowired
	private IBranchDao iBranchDao;

	private SessionFactory sessionFactory;

	public BranchServiceImpl() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
	public BranchBean getBranchName(BranchRequest branchRequest) {
		return iBranchDao.getBranchName(branchRequest, sessionFactory);
	}

}
