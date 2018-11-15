package com.vyavharamitra.reports.sales.dao.implimentation;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
/**
 * @author : Mohan M
 * @created date : 
 * @modified by :
 * @modified date :
 */

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.reports.sales.dao.ISalesDao;
import com.vyavharamitra.reports.sales.to.Request.SalesRequest;
import com.vyavharamitra.utils.Utils;
@Repository
public class SalesDaoImpl implements ISalesDao {
	private Session session;

	@SuppressWarnings("unchecked")
	public List<CashSalesBean> salesByBranch(SalesRequest salesRequest, SessionFactory sessionFactory) {
		List<CashSalesBean> cashSalesBean = null;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Integer branchid=salesRequest.getCashSalesBean().getSellItemBranchId();
			String sortBy=salesRequest.getCashSalesBean().getOrderby();
			cashSalesBean =(List<CashSalesBean>) session.createSQLQuery("select sellitem_billno,"
					+ "to_char(sellitem_sdate,'DD Mon YYYY') as sellitem_sdate,sellitem_cphno,sellitem_cname,sellitem_gstin, item_name, "
					+ "item_sellcost as price,sellitemline_valuerp as discount ,sellitemline_sellcost as sellingcost,"
					+ "sellitemline_quant,sellitemline_sgstprice, sellitemline_cgstprice,sellitemline_igstprice,sellitemline_totsellgst as ammount,sellitem_eby,"
					+ "to_char(sellitem_edate,'DD Mon YYYY') as sellitem_edate  from bil_sellitemline,bil_sellitem,bil_item where"
					+ " sellitem_sta='A' and item_itmid=sellitemline_itmid and item_bid=sellitemline_bid and "
					+ " sellitemline_sid=sellitem_sid and sellitem_bid=sellitemline_bid and sellitem_bid= '" + branchid + "' "
							+ " order by " + sortBy + " ").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(cashSalesBean))
		{
			return cashSalesBean;
		}
		return cashSalesBean;
	}


	@SuppressWarnings("unchecked")
	public List<CashSalesBean> salesSummery(SalesRequest salesRequest, SessionFactory sessionFactory) {
		List<CashSalesBean> cashSalesBean = null;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Integer branchid=salesRequest.getCashSalesBean().getSellItemBranchId();
			String sortBy=salesRequest.getCashSalesBean().getOrderby();
			cashSalesBean =(List<CashSalesBean>) session.createSQLQuery("select sellitem_billno,	to_char(sellitem_sdate,'DD Mon YYYY') as sellitem_sdate,sellitem_cphno,sellitem_gstin, sellitem_cname,item_name,item_sellcost as price, sellitemline_valuerp as discount, sellitemline_sellcost as sellingcost,\r\n" + 
					"		sellitemline_quant,sellitemline_sgstprice,sellitemline_cgstprice,sellitemline_igstprice,sellitemline_totsellgst as ammount,sellitem_eby,to_char(sellitem_edate,'DD Mon YYYY') as sellitem_edate   \r\n" + 
					"		FROM bil_sellitemline,bil_sellitem,bil_item , bil_bm where sellitem_sta='A' and item_itmid=sellitemline_itmid and item_bid=sellitemline_bid   and  sellitemline_sid=sellitem_sid  and sellitem_bid=sellitemline_bid \r\n" + 
					"    and bm_id = sellitem_billno   and sellitem_bid= '" + branchid + "' "
							+ " order by " + sortBy + " ").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(cashSalesBean))
		{
			return cashSalesBean;
		}
		return cashSalesBean;
	}


	@SuppressWarnings("unchecked")
	public List<CashSalesBean> salesSummeryByDate(SalesRequest salesRequest, SessionFactory sessionFactory) {
		List<CashSalesBean> cashSalesBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			Integer branchid=salesRequest.getCashSalesBean().getSellItemBranchId();
			String sortBy=salesRequest.getCashSalesBean().getOrderby();
			Date strFromDate=salesRequest.getCashSalesBean().getFromdate();
			Date strToDate=salesRequest.getCashSalesBean().getTodate();
			cashSalesBean =(List<CashSalesBean>) session.createSQLQuery(" select sellitem_billno,\r\n" + 
					"		to_char(sellitem_sdate,'DD Mon YYYY') as sellitem_sdate,sellitem_cphno,sellitem_gstin, sellitem_cname,item_name,item_sellcost as price,sellitemline_valuerp as discount ,sellitemline_sellcost as sellingcost,\r\n" + 
					"		sellitemline_quant,sellitemline_sgstprice,sellitemline_cgstprice,sellitemline_igstprice,sellitemline_totsellgst as ammount,sellitem_eby,\r\n" + 
					"		to_char(sellitem_edate,'DD Mon YYYY') as sellitem_edate   FROM  bil_sellitemline,bil_sellitem,bil_item where sellitem_sta='A' and item_itmid=sellitemline_itmid \r\n" + 
					"		and item_bid=sellitemline_bid and  sellitemline_sid=sellitem_sid and sellitem_bid=sellitemline_bid and sellitem_edate between'"+strFromDate+"' and '"+strToDate+"' and sellitem_bid= '"+branchid+"' order by "+sortBy+" ").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(cashSalesBean))
		{
			return cashSalesBean;
		}
		return cashSalesBean;
	}


	@SuppressWarnings("unchecked")
	public List<CashSalesBean> salesSummeryByCustomer(SalesRequest salesRequest, SessionFactory sessionFactory) {
		List<CashSalesBean> cashSalesBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			Integer branchid=salesRequest.getCashSalesBean().getSellItemBranchId();
			BigInteger	mobilenumber=salesRequest.getCashSalesBean().getSellItemCustomerPhone();
			Date strFromDate=salesRequest.getCashSalesBean().getFromdate();
			Date strToDate=salesRequest.getCashSalesBean().getTodate();
			cashSalesBean =(List<CashSalesBean>) session.createSQLQuery(" select sellitem_billno,to_char(sellitem_sdate,'DD Mon YYYY')"
					+ " as sellitem_sdate,sellitem_gstin,sellitem_cphno, item_name, sellitem_cname,item_sellcost as price,sellitemline_valuerp as discount"
					+ " ,sellitemline_sellcost as sellingcost,sellitemline_quant,sellitemline_sgstprice, sellitemline_cgstprice,"
					+ "sellitemline_igstprice,sellitemline_totsellgst as ammount,sellitem_eby,to_char"
					+ "(sellitem_edate,'DD Mon YYYY') as sellitem_edate   from bil_sellitemline,bil_sellitem,bil_item where"
					+ " sellitem_sta='A'and item_itmid=sellitemline_itmid and item_bid=sellitemline_bid  and  "
					+ "sellitemline_sid=sellitem_sid and sellitem_sdate between '"+strFromDate+"' and '"+strToDate+"' "
							+ "and sellitem_bid=sellitemline_bid and sellitem_bid= '"+branchid+"'  and "
									+ "sellitem_cphno='"+mobilenumber+"' order by sellitem_sdate  ").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(cashSalesBean))
		{
			return cashSalesBean;
		}
		return cashSalesBean;
	}

	@SuppressWarnings("unchecked")
	public List<CashSalesBean> salesSummerybillsummery(SalesRequest salesRequest, SessionFactory sessionFactory) {
		List<CashSalesBean> cashSalesBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			Integer branchid=salesRequest.getCashSalesBean().getSellItemBranchId();
			Date strFromDate=salesRequest.getCashSalesBean().getFromdate();
			Date strToDate=salesRequest.getCashSalesBean().getTodate();
			cashSalesBean =(List<CashSalesBean>) session.createSQLQuery("select to_char(sellitem_sdate,'DD Mon YYYY') as "
					+ "sellitem_sdate,sellitem_billno,sum( sellitemline_totsellcost) as Totalsalvalue ,sum(sellitemline_sgstprice) "
					+ "as sgstprice,sum(sellitemline_cgstprice)as cgstprice ,sum(sellitemline_igstprice)as igstprice,(sum( sellitemline_totsellcost)+sum(sellitemline_sgstprice)+"
					+ "sum(sellitemline_cgstprice)+sum(sellitemline_igstprice)+sum(sellitemline_excisedutyvalue))"
					+ " as total, round((sum( sellitemline_totsellcost)+sum(sellitemline_sgstprice)+sum(sellitemline_cgstprice)+"
					+ "sum(sellitemline_igstprice)+sum(sellitemline_excisedutyvalue))) as totround from bil_sellitem,bil_item,"
					+ "bil_sellitemline where sellitem_sta='A' and item_itmid=sellitemline_itmid and sellitem_billno=sellitemline_billno and "
					+ "sellitem_bid='"+ branchid + "' and sellitem_sid=sellitemline_sid and sellitem_sdate "
							+ "between '" + strFromDate+ "' and '" + strToDate+ "' group by sellitem_sdate,"
									+ "sellitem_billno,sellitem_totcost,sellitemline_excisedutyvalue order by 1  ").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		if(Utils.isNullList(cashSalesBean))
		{
			return cashSalesBean;
		}
		return cashSalesBean;
	}

	
	@SuppressWarnings("unchecked")
	public List<CashSalesBean> salesSummeryQuantity(SalesRequest salesRequest, SessionFactory sessionFactory) {
		List<CashSalesBean> cashSalesBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			Integer branchid=salesRequest.getItemMasterBean().getBranchId();
			System.out.println(branchid);
			Date strFromDate=salesRequest.getItemMasterBean().getFromdate();
			System.out.println(strFromDate);
			Date strToDate=salesRequest.getItemMasterBean().getTodate();
			System.out.println(strToDate);
			cashSalesBean =(List<CashSalesBean>) session.createSQLQuery("SELECT DISTINCT bi.item_itmid,bi.item_name,bpi.purchaseditems_quantity,bi.item_quan,bsi.sellitemline_quant from bil_item bi \r\n" + 
					" LEFT JOIN bil_sellitem bs\r\n" + 
					"        ON bs.sellitem_sid = bi.item_itmid\r\n" + 
					" LEFT JOIN bil_sellitemline bsi\r\n" + 
					"        ON bsi.sellitemline_itmid = bs.sellitem_sid     \r\n" + 
					" LEFT JOIN bil_purchaseditems bpi\r\n" + 
					"        ON bpi.purchaseditems_itemid = bi.item_itmid\r\n" + 
					"     WHERE bs.sellitem_sdate >= '"+strFromDate+"' \r\n" + 
					"       AND bs.sellitem_sdate <= '"+strToDate+"' and bsi.sellitemline_bid='"+branchid+"'order by 1 ").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(cashSalesBean))
		{
			return cashSalesBean;
		}
		return cashSalesBean;
	}


}
