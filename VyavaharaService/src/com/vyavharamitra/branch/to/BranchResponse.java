package com.vyavharamitra.branch.to;
/**
 * @author : mohan
 * @created date :29 Nov 2017
 * @modified by :
 * @modified date :
 */
import com.vyavharamitra.greetings.beans.BranchBean;
import com.vyavharamitra.utils.VyavaharaResponse;

public class BranchResponse extends VyavaharaResponse{

	private BranchBean branchBean;

	/**
	 * @return the branchBean
	 */
	public BranchBean getBranchBean() {
		return branchBean;
	}

	/**
	 * @param branchBean the branchBean to set
	 */
	public void setBranchBean(BranchBean branchBean) {
		this.branchBean = branchBean;
	}
}
