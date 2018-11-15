package com.vyavharamitra.reports.bill.dao.implementation;


import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.reports.bill.dao.IBillDao;
import com.vyavharamitra.reports.bill.to.request.BillRequest;

/**
 * @author : Lavanya
 * @created date :19 Dec 2017
 * @modified by :
 * @modified date :
 */

@Repository
public class BillDaoImp implements IBillDao {
	private Session session;
	Date date = new Date();

	@SuppressWarnings("unchecked")
	public List<CashSalesBean> billReadDao1(SessionFactory sessionFactory,
			BillRequest billRequest) {
		List<CashSalesBean> cashSalesBean = null;
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			BigInteger sellItemBillNumber=billRequest.getCashSalesBean().getSellItemBillNumber();
			Integer sellItemBranchId = billRequest.getCashSalesBean().getSellItemBranchId();
			Integer sellItemId =billRequest.getCashSalesBean().getSellItemId();


			cashSalesBean =(List<CashSalesBean>) session.createSQLQuery("SELECT * FROM BIL_SELLITEMLINE,BIL_SELLITEM where sellitem_sid=sellitemline_sid and sellitem_sta='A' and sellitemline_billno='" + sellItemBillNumber
					+ "' and sellitemline_bid='" + sellItemBranchId + "' and sellitemline_sid='" + sellItemId + "' ").list();

	session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		return cashSalesBean;
	}

	
	@SuppressWarnings("unchecked")
	public List<CashSalesBean> billReadDao2(SessionFactory sessionFactory,
			BillRequest billRequest) {
		List<CashSalesBean> cashSalesBean = null;
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			BigInteger sellItemBillNumber=billRequest.getCashSalesBean().getSellItemBillNumber();
			Integer sellItemBranchId = billRequest.getCashSalesBean().getSellItemBranchId();
			Integer sellItemId =billRequest.getCashSalesBean().getSellItemId();
			cashSalesBean =(List<CashSalesBean>) session.createSQLQuery( "select distinct bm_id,om_name,bm_bdname,bm_srt,"
					+ "bm_dist,bm_city,bm_pin,bm_ph1,bm_eid,sellitem_billno,substring(sellitem_cname,0,35) as name1,"
					+ "substring(sellitem_cname,36,55) as name2,substring(sellitem_cname,86,55) as name3,"
					+ "substring(sellitem_cname,136,55) as name4,sellitem_gstin,sellitem_cphno,"
					+ "to_char(sellitem_sdate,'DD Mon YYYY') as sellitem_sdate,sellitem_eby,bm_gstin,bm_imgpath,om_billformate,"
					+ "sellitem_bdno,sellitem_bdname,sellitem_srt,sellitem_lty,sellitem_dist,sellitem_city,sellitem_st,"
					+ "sellitem_pin,sellitem_remarks,sellitem_transtype,sellitem_transdetails  from bil_item,bil_om,bil_sellitem,bil_sellitemline,bil_bm where sellitem_sta='A'and"
					+ " bm_id = om_id and sellitem_sid=sellitemline_sid  and"
					+ " sellitemline_bid=bm_id and sellitemline_billno='"+ sellItemBillNumber + "' and sellitemline_bid='" + sellItemBranchId + "' and sellitemline_sid='" + sellItemId + "'  ").list();


			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		System.out.println("report for headers "+ cashSalesBean);
		return cashSalesBean;
	}
	
	@SuppressWarnings("unchecked")
	public List<CashSalesBean> billReadDao3(SessionFactory sessionFactory,
			BillRequest billRequest) {
		List<CashSalesBean> cashSalesBean = null;
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			BigInteger sellItemBillNumber=billRequest.getCashSalesBean().getSellItemBillNumber();
			Integer sellItemBranchId = billRequest.getCashSalesBean().getSellItemBranchId();
			Integer sellItemId =billRequest.getCashSalesBean().getSellItemId();

			cashSalesBean =(List<CashSalesBean>) session.createSQLQuery( "select COALESCE(item_hsn, '') as item_hsn,"
					+ "substring(sellitemline_descriptive,0,15) as sellitemline_descriptive,sellitemline_sellcost,"
					+ "substr(item_name,0,15) as item_name,(sellitemline_sgstprice+sellitemline_cgstprice+sellitemline_igstprice+sellitemline_excisedutyvalue) as totgst,"
					+ "sellitemline_quant,sellitemline_totsellgst,round(sellitemline_totsellcost,2) as sellitemline_totsellcost,"
					+ "(sellitemline_igst) as gstper from bil_item,bil_ctoi,bil_sellitemline,bil_sellitem "
					+ " where sellitem_sta='A' and item_itmid=sellitemline_itmid and item_cid=ctoi_cid and sellitem_sid=sellitemline_sid   and "
					+ "item_bid=sellitemline_bid  and sellitemline_billno='"
					+ sellItemBillNumber + "' and sellitemline_bid='" + sellItemBranchId + "' and sellitemline_sid='" + sellItemId
					+ "'   order by item_itmid").list();



			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		return cashSalesBean;
	}
	
	@SuppressWarnings("unchecked")
	public List<CashSalesBean> billReadDao4(SessionFactory sessionFactory,
			BillRequest billRequest) {
		List<CashSalesBean> cashSalesBean = null;
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			BigInteger sellItemBillNumber=billRequest.getCashSalesBean().getSellItemBillNumber();
			Integer sellItemBranchId = billRequest.getCashSalesBean().getSellItemBranchId();
			Integer sellItemId =billRequest.getCashSalesBean().getSellItemId();

			cashSalesBean =(List<CashSalesBean>) session.createSQLQuery(  "select item_cid,"
					+ "round(sum(sellitemline_totsellcost),2) as Taxable_value  ,round(sum(sellitemline_sgstprice),2) as"
					+ " sellitemline_sgstprice,round(sum(sellitemline_cgstprice),2) as sellitemline_cgstprice,"
					+ "round(sum(sellitemline_igstprice),2) as sellitemline_igstprice,sellitemline_sgst,"
					+ "sellitemline_cgst,sellitemline_igst,sellitemline_exciseduty, "
					+ "round(sum(sellitemline_excisedutyvalue),2) as sellitemline_excisedutyvalue,(sellitemline_igst) as gstper,(round(sum(sellitemline_totsellcost),2)+round(sum(sellitemline_sgstprice)\r\n" + 
					"  ,2)+round(sum(sellitemline_cgstprice),2)+round(sum(sellitemline_igstprice),2)+round(sum(sellitemline_excisedutyvalue),2)) as totval  from bil_item,bil_sellitemline,bil_ctoi,bil_sellitem where sellitem_sta='A' and item_itmid=sellitemline_itmid and item_cid=ctoi_cid and item_bid=sellitemline_bid and sellitem_sid=sellitemline_sid and sellitemline_billno='"
					+ sellItemBillNumber + "' and sellitemline_bid='" + sellItemBranchId + "' and sellitemline_sid='" + sellItemId
					+ "'  GROUP BY item_cid,sellitemline_sgst,sellitemline_cgst,sellitemline_igst,sellitemline_exciseduty order by item_cid").list();

			

			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		return cashSalesBean;
	}
	
	@SuppressWarnings("unchecked")
	public List<CashSalesBean> billReadDao5(SessionFactory sessionFactory,
			BillRequest billRequest) {
		List<CashSalesBean> cashSalesBean = null;
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			BigInteger sellItemBillNumber=billRequest.getCashSalesBean().getSellItemBillNumber();
			Integer sellItemBranchId = billRequest.getCashSalesBean().getSellItemBranchId();
			Integer sellItemId =billRequest.getCashSalesBean().getSellItemId();


			cashSalesBean =(List<CashSalesBean>) session.createSQLQuery( "select distinct sellitem_eby from bil_sellitem,bil_sellitemline where sellitem_sta='A' and sellitemline_sid=sellitem_sid and sellitem_bid=sellitemline_bid and sellitemline_billno='"
					+ sellItemBillNumber + "' and sellitemline_bid='" + sellItemBranchId + "' and sellitemline_sid='" + sellItemId
					+ "' ").list();

			
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		return cashSalesBean;
	}
	
	@SuppressWarnings("unchecked")
	public List<CashSalesBean> billReadDao6(SessionFactory sessionFactory,
			BillRequest billRequest) {
		List<CashSalesBean> cashSalesBean = null;
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			BigInteger sellItemBillNumber=billRequest.getCashSalesBean().getSellItemBillNumber();
			Integer sellItemBranchId = billRequest.getCashSalesBean().getSellItemBranchId();
			Integer sellItemId =billRequest.getCashSalesBean().getSellItemId();

         cashSalesBean =(List<CashSalesBean>) session.createSQLQuery( "select distinct brnmsg_msg from bil_sellitem,bil_sellitemline,bil_brnmsg where sellitem_sta='A' and sellitemline_sid=sellitem_sid and sellitem_bid=brnmsg_bid and sellitemline_billno='"
					+ sellItemBillNumber + "' and sellitemline_bid='" + sellItemBranchId + "' and sellitemline_sid='" + sellItemId
					+ "' and brnmsg_expdt>=CURRENT_DATE ").list();

			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		return cashSalesBean;
	}
	
	@SuppressWarnings("unchecked")
	public List<CashSalesBean> billDao(SessionFactory sessionFactory,
			BillRequest billRequest) {
		List<CashSalesBean> cashSalesBean = null;
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			BigInteger sellItemBillNumber=billRequest.getCashSalesBean().getSellItemBillNumber();
			Integer sellItemBranchId = billRequest.getCashSalesBean().getSellItemBranchId();

         cashSalesBean =(List<CashSalesBean>) session.createSQLQuery( "select  sellitem_sid,to_char(sellitem_sdate,'DD Mon YYYY') as sellitem_sdate from bil_sellitem,bil_sellitemline where sellitem_sta='A' and sellitemline_sid=sellitem_sid  and sellitemline_billno='"
					+ sellItemBillNumber + "' and sellitemline_bid='" + sellItemBranchId + "'  ").list();

			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		return cashSalesBean;
	}
}
