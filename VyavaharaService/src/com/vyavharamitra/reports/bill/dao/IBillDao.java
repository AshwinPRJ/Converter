package com.vyavharamitra.reports.bill.dao;
import java.util.List;
import org.hibernate.SessionFactory;
import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.reports.bill.to.request.BillRequest;

/**
 * @author : Lavanya
 * @created date :19 Dec 2017
 * @modified by :
 * @modified date :
 */
public interface IBillDao {
	public List<CashSalesBean> billReadDao1(SessionFactory sessionFactory,BillRequest billRequest);
	
	public List<CashSalesBean> billReadDao2(SessionFactory sessionFactory,BillRequest billRequest);
	
	public List<CashSalesBean> billReadDao3(SessionFactory sessionFactory,BillRequest billRequest);
	
	public List<CashSalesBean> billReadDao4(SessionFactory sessionFactory,BillRequest billRequest);
	
	public List<CashSalesBean> billReadDao5(SessionFactory sessionFactory,BillRequest billRequest);
	
	public List<CashSalesBean> billReadDao6(SessionFactory sessionFactory,BillRequest billRequest);

	public List<CashSalesBean> billDao(SessionFactory sessionFactory, BillRequest billRequest);

}
