package com.vyavharamitra.reports.keys.dao.implementation;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.itemdetails.beans.DeleteItemMasterBean;
import com.vyavharamitra.itemdetails.beans.UpdateItemMasterBean;
import com.vyavharamitra.reports.keys.dao.IItemModifyReportDao;
import com.vyavharamitra.reports.keys.to.request.ItemDeleteReportRequest;
import com.vyavharamitra.reports.keys.to.request.ItemModifyReportRequest;
import com.vyavharamitra.utils.Utils;
/**
 * @author : Kalyani
 * @created date : 
 * @modified by :
 * @modified date :
 *
 *
 *
 */
@Repository
public class ItemModifyReportDaoImp implements IItemModifyReportDao{
	private Session session;
	@SuppressWarnings("unchecked")
	public List<UpdateItemMasterBean>getitemreportdetails(SessionFactory sessionFactory,ItemModifyReportRequest itemModifyReportRequest) {
		List<UpdateItemMasterBean> updateItemMasterBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			Integer itemId=itemModifyReportRequest.getUpdateItemMasterBean().getBranchItemId();
			Integer bid=itemModifyReportRequest.getUpdateItemMasterBean().getBranchId();
			updateItemMasterBean =(List<UpdateItemMasterBean>) session.createSQLQuery("SELECT uitem_bitemid, uitem_name,uitem_hsn,uitem_purcost,uitem_sellcost,uitem_minquan, uitem_maxquan, uitem_requan, uitem_convfact, uitem_loi,uitem_cid,uitem_mrp ,uitem_eby, to_char(uitem_edate,'DD Mon YYYY') as uitem_edate, uitem_etime FROM bil_uitem where uitem_bitemid='"+itemId+"' and uitem_bid='"+bid+"' ").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();
				
			}
		}
		if(!Utils.isNullList(updateItemMasterBean))
		{
			return updateItemMasterBean;
		}
		return updateItemMasterBean;
	}
	
	
	
	
	//delete Item history report
	
	@SuppressWarnings("unchecked")
	public List<DeleteItemMasterBean>getitemdeletereportdetails(SessionFactory sessionFactory,ItemDeleteReportRequest itemDeleteReportRequest) {
		List<DeleteItemMasterBean> deleteItemMasterBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			Integer branchid=itemDeleteReportRequest.getDeleteItemMasterBean().getDelItemBranchId();
			deleteItemMasterBean =(List<DeleteItemMasterBean>) session.createSQLQuery("SELECT delitem_bitemid,delitem_name,delitem_delby,to_char(delitem_delon,'DD Mon YYYY') as delitem_delon,delitem_deltime FROM bil_delitem where delitem_bid= '" + branchid + "'").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();
				
			}
		}
		if(!Utils.isNullList(deleteItemMasterBean))
		{
			return deleteItemMasterBean;
		}
		return deleteItemMasterBean;
	}
	
	
		
}


