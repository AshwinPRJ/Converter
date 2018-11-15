package com.vyavharamitra.reports.keys.dao.implementation;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.reports.keys.dao.IPurchaseBillReportDao;
import com.vyavharamitra.reports.keys.to.request.DealerReportRequest;
import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.utils.Utils;
/**
 * @author : Kalyani
 * @created date : 
 * @modified by :
 * @modified date :
 */
@Repository
public class PurchaseBillReportDaoImp implements IPurchaseBillReportDao{
	private Session session;
	@SuppressWarnings("unchecked")
	public List<PurchaseBillBean>getpurchasedetails(SessionFactory sessionFactory,DealerReportRequest dealerReportRequest, Integer branchId) {
		
		String gstNo=dealerReportRequest.getPurchaseBillBean().getPurchaseEmbeddedBean().getPurchaseSuplierGSTNo();
		System.out.println("supplier gst number="+gstNo);
		List<PurchaseBillBean> purchaseBillBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			Date strFromDate=dealerReportRequest.getPurchaseBillBean().getFromdate();
			Date strToDate=dealerReportRequest.getPurchaseBillBean().getTodate();
			/*Date strFromDate=dealerReportRequest.getPurchaseBillBean().getFromdate();
			Date strToDate=dealerReportRequest.getPurchaseBillBean().getTodate();*/
			//Date gstno=dealerReportRequest.getPurchaseBillBean().getPurchaseGst();
			purchaseBillBean =(List<PurchaseBillBean>) session.createSQLQuery("select to_char(purchase_date,'dd Mon yyyy') as purchase_date,purchase_billno,purchase_vendname,purchase_place,purchase_gstno,purchase_branchid,item_name,\r\n" + 
					"			purchaseditems_quantity,purchaseditems_prize,purchaseditems_cgst,purchaseditems_sgst,purchaseditems_igst,purchaseditems_totalpurchas,purchaseditems_totalitemgst,purchaseditems_totalamount from bil_purchase,bil_item,\r\n" + 
					"			bil_purchaseditems where purchase_billno=purchaseditems_billno and item_itmid=purchaseditems_itemid and purchase_branchid='"+branchId+"'and purchase_gstno='"+gstNo+"'and purchase_date between '"+ strFromDate+"' and '"+ strToDate+"' order by purchase_date").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();
				
			}
		}
		if(!Utils.isNullList(purchaseBillBean))
		{
			return purchaseBillBean;
		}
		return purchaseBillBean;
	}
	
	
	
	//report by date range
	
	@SuppressWarnings("unchecked")
	public List<PurchaseBillBean>getpurchasedatedetails(SessionFactory sessionFactory,DealerReportRequest dealerReportRequest, Integer branchId) {
		List<PurchaseBillBean> purchaseBillBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			Date strFromDate=dealerReportRequest.getPurchaseBillBean().getFromdate();
			Date strToDate=dealerReportRequest.getPurchaseBillBean().getTodate();
			purchaseBillBean =(List<PurchaseBillBean>) session.createSQLQuery("select to_char(purchase_date,'dd Mon yyyy') as purchase_date,purchase_billno,purchase_vendname,purchase_place,purchase_gstno,purchase_branchid,item_name,\r\n" + 
					"			purchaseditems_quantity,purchaseditems_prize,purchaseditems_cgst,purchaseditems_sgst,purchaseditems_igst,purchaseditems_totalpurchas,purchaseditems_totalitemgst,purchaseditems_totalamount from bil_purchase,bil_item,\r\n" + 
					"			bil_purchaseditems where purchase_billno=purchaseditems_billno and purchase_branchid='"+branchId+"' and item_itmid=purchaseditems_itemid and purchase_date between '"+strFromDate+"' and '"+strToDate+"' order by purchase_date ").list();

			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();
				
			}
		}
		if(!Utils.isNullList(purchaseBillBean))
		{
			return purchaseBillBean;
		}
		return purchaseBillBean;
	}

	
}



