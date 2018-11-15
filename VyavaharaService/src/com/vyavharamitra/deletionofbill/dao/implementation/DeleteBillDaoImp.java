package com.vyavharamitra.deletionofbill.dao.implementation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.deletionofbill.bean.DeleteBillBean;
import com.vyavharamitra.deletionofbill.bean.DeleteSellitemBean;
import com.vyavharamitra.deletionofbill.dao.IDeleteBillDao;
import com.vyavharamitra.deletionofbill.to.request.DeleteBillRequest;
import com.vyavharamitra.deletionofbill.to.request.DeleteRequest;
import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;
@Repository
public class DeleteBillDaoImp implements IDeleteBillDao {
	private Session session;
	@Autowired
	private HttpServletRequest httpServletRequest;

	@SuppressWarnings("unchecked")
	public List<CashSalesBean> sellitemFetch(SessionFactory sessionFactory,DeleteBillRequest deleteBillRequest){
		List<CashSalesBean> cashSalesBean = null;
		try{
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			BigInteger sellItemBillNumber=deleteBillRequest.getCashSalesBean().getSellItemBillNumber();
			UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
			 Integer sellItemBranchId=ucb.getBranchNumber();
			
			cashSalesBean =(List<CashSalesBean>) session.createSQLQuery("select sellitem_sid,sellitem_cname,sellitem_sdate,sellitem_totcost,sellitem_eby,sellitem_edate,sellitem_etime,sellitem_cphno,sellitem_bid,sellitem_billno,sellitemline_itmid,sellitemline_sgst,sellitemline_cgst,sellitemline_disctype,sellitemline_discvalue,sellitemline_valuerp,sellitemline_sellcost,sellitemline_quant,sellitemline_totsellcost,sellitemline_sgstprice,sellitemline_totsellgst,sellitemline_cgstprice,sellitemline_descriptive,sellitemline_billno,sellitemline_igst,sellitemline_igstprice,sellitemline_excisedutyvalue,sellitemline_bid from bil_sellitem,bil_sellitemline where sellitem_sid=sellitemline_sid and sellitem_bid=sellitemline_bid and sellitem_billno=sellitemline_billno and sellitemline_billno='"
					+ sellItemBillNumber + "' and sellitemline_bid='" + sellItemBranchId + "'  ").list();
			

	session.getTransaction().commit();
		}catch (Exception e) {
			Utils.logger("Exception : " +e);
		}
		return cashSalesBean;
	}

	//inserting of data into delete beans
	
	public DeleteBillBean deleteCreateDao(SessionFactory sessionFactory, DeleteBillBean deleteBillBean){
		
		session = sessionFactory.openSession();
		session.save(deleteBillBean);
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(deleteBillBean)) {
			return deleteBillBean;
		}
		return deleteBillBean;
	}

	public DeleteSellitemBean deleteLineCreateDao(SessionFactory sessionFactory, DeleteSellitemBean deleteSellitemBean){
		
		session = sessionFactory.openSession();
		session.save(deleteSellitemBean);
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(deleteSellitemBean)) {
			return deleteSellitemBean;
		}
		return deleteSellitemBean;
	}

	public  DeleteBillBean updatebillstatus(SessionFactory sessionFactory,DeleteRequest deleteRequest){
		
		 Integer sellItemId=deleteRequest.getDeleteBillBean().getDelsellItemId();
		DeleteBillBean  deleteBillBean=new DeleteBillBean();
		session = sessionFactory.openSession();
		session.beginTransaction();

		Query itemUpdateQuery = session.createSQLQuery("UPDATE BIL_SELLITEM SET SELLITEM_STA='D' where sellitem_sid='" + sellItemId+ "'  ");
		itemUpdateQuery.executeUpdate();

		
		
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(deleteBillBean)) {
			return deleteBillBean;
		}
		return deleteBillBean ;
	}

	public ItemMasterBean updateitemquan(SessionFactory sessionFactory,DeleteRequest deleteRequest){
		 Integer branchId=deleteRequest.getDeleteSellitemBean().getDelBranchId();
		  Integer branchItemId=deleteRequest.getDeleteSellitemBean().getDelItemId();
		  BigDecimal quantity=deleteRequest.getDeleteSellitemBean().getDelQuantity();
		ItemMasterBean itemMasterBean=new ItemMasterBean();
		session = sessionFactory.openSession();
		session.beginTransaction();

		Query itemUpdateQuery = session.createSQLQuery("UPDATE BIL_ITEM SET ITEM_QUAN=ITEM_QUAN+'" + quantity
				+ "', ITEM_STKINUNITS = ITEM_STKINUNITS+('" + quantity + "' * ITEM_CONVFACT) where item_bitemid='" + branchItemId
				+ "' and item_bid='" + branchId + "' ");
		itemUpdateQuery.executeUpdate();

		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(itemMasterBean)) {
			return itemMasterBean;
		}
		return itemMasterBean ;
	}
	}
	

	



