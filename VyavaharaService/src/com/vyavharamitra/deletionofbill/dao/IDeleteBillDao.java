package com.vyavharamitra.deletionofbill.dao;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.deletionofbill.bean.DeleteBillBean;
import com.vyavharamitra.deletionofbill.bean.DeleteSellitemBean;
import com.vyavharamitra.deletionofbill.to.request.DeleteBillRequest;
import com.vyavharamitra.deletionofbill.to.request.DeleteRequest;
import com.vyavharamitra.itemdetails.beans.ItemMasterBean;

public interface IDeleteBillDao {
	
	

	public List<CashSalesBean> sellitemFetch(SessionFactory sessionFactory, DeleteBillRequest deleteBillRequest);

	public DeleteBillBean deleteCreateDao(SessionFactory sessionFactory, DeleteBillBean deleteBillBean);

	public DeleteBillBean updatebillstatus(SessionFactory sessionFactory, DeleteRequest deleteRequest);

	public ItemMasterBean updateitemquan(SessionFactory sessionFactory, DeleteRequest deleteRequest);

	public DeleteSellitemBean deleteLineCreateDao(SessionFactory sessionFactory, DeleteSellitemBean deleteSellitemBean);
	



}
