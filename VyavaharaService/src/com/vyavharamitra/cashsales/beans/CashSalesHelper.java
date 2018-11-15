package com.vyavharamitra.cashsales.beans;

/**
 * @author : Brahmani
 * @created date : 17 Nov 2017
 * @modified by :
 * @modified date :
 */

import java.util.Date;

public class CashSalesHelper {

	private boolean Exclusive;
	private boolean Intra;
	private boolean Inter;
	private String orderby;
	private Date fromdate;
	private Date todate;
	
	/**
	 * @return the fromdate
	 */
	public Date getFromdate() {
		return fromdate;
	}
	/**
	 * @param fromdate the fromdate to set
	 */
	public void setFromdate(Date fromdate) {
		this.fromdate = fromdate;
	}
	/**
	 * @return the todate
	 */
	public Date getTodate() {
		return todate;
	}
	/**
	 * @param todate the todate to set
	 */
	public void setTodate(Date todate) {
		this.todate = todate;
	}
	/**
	 * @return the orderby
	 */
	public String getOrderby() {
		return orderby;
	}
	/**
	 * @param orderby the orderby to set
	 */
	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}
	/**
	 * @return the exclusive
	 */
	public boolean isExclusive() {
		return Exclusive;
	}
	/**
	 * @param exclusive the exclusive to set
	 */
	public void setExclusive(boolean exclusive) {
		Exclusive = exclusive;
	}
	/**
	 * @return the intra
	 */
	public boolean isIntra() {
		return Intra;
	}
	/**
	 * @param intra the intra to set
	 */
	public void setIntra(boolean intra) {
		Intra = intra;
	}
	/**
	 * @return the inter
	 */
	public boolean isInter() {
		return Inter;
	}
	/**
	 * @param inter the inter to set
	 */
	public void setInter(boolean inter) {
		Inter = inter;
	}
	
}
