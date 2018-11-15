package com.vyavharamitra.branch.dao;
/**
 * @author : mohan
 * @created date :29 Nov 2017
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;

import com.vyavharamitra.branch.to.BranchRequest;
import com.vyavharamitra.greetings.beans.BranchBean;

public interface IBranchDao {

	public BranchBean getBranchName(BranchRequest branchRequest, SessionFactory sessionFactory);

}
