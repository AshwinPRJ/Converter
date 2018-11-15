package com.vyavharamitra.branch.service;

import com.vyavharamitra.branch.to.BranchRequest;
import com.vyavharamitra.greetings.beans.BranchBean;
/**
 * @author : mohan
 * @created date :29 Nov 2017
 * @modified by :
 * @modified date :
 */
public interface IBranchService {

	public BranchBean getBranchName(BranchRequest branchRequest);

}
