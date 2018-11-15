package com.vyavharamitra.reports.bill.service;

import java.util.List;
import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.organization.bean.OrganizationMasterBean;
import com.vyavharamitra.reports.bill.to.request.BillRequest;



/**
 * @author : Lavanya
 * @created date :19 Dec 2017
 * @modified by :
 * @modified date :
 */
public interface IBillService {
	public List<CashSalesBean> billReadService1(BillRequest billRequest);

	public List<CashSalesBean> billReadService2(BillRequest billRequest);

	public List<CashSalesBean> billReadService3(BillRequest billRequest);
	
	public List<CashSalesBean> billReadService4(BillRequest billRequest);
	
	public List<CashSalesBean> billReadService5(BillRequest billRequest);
	
	public List<CashSalesBean> billReadService6(BillRequest billRequest);

	public List<CashSalesBean> billService(BillRequest billRequest);
	
	

}
