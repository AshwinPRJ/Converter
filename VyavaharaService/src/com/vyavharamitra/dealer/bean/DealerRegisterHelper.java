package com.vyavharamitra.dealer.bean;

/**
 * @author : Brahmani
 * @created date : 28 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.Date;

public class DealerRegisterHelper {
	private int orgId;
	private Date orgdate;

	/**
	 * @return the orgdate
	 */
	public Date getOrgdate() {
		return orgdate;
	}

	/**
	 * @param orgdate
	 *            the orgdate to set
	 */
	public void setOrgdate(Date orgdate) {
		this.orgdate = orgdate;
	}

	/**
	 * @return the orgId
	 */
	public int getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId
	 *            the orgId to set
	 */
	public void setOrgId(int orgId) {
		this.orgId = orgId;
	}

}
