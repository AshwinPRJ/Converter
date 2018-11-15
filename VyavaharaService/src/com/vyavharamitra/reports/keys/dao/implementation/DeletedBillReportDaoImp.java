package com.vyavharamitra.reports.keys.dao.implementation;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.deletionofbill.bean.DeleteBillBean;
import com.vyavharamitra.reports.keys.dao.IDeletedBillReportDao;
import com.vyavharamitra.reports.keys.to.request.DeletedBillReportRequest;
import com.vyavharamitra.utils.Utils;
/**
 * @author : Kalyani
 * @created date : 
 * @modified by :
 * @modified date :
 */
@Repository
public class DeletedBillReportDaoImp implements IDeletedBillReportDao{
	private Session session;
	@SuppressWarnings("unchecked")
	public List<DeleteBillBean>getdeletereportdetails(SessionFactory sessionFactory,DeletedBillReportRequest deletedBillReportRequest) {
		List<DeleteBillBean> deleteBillBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();		
			Integer branchid =deletedBillReportRequest.getDeleteBillBean().getDelsellItemBranchId();
		String sortBy=deletedBillReportRequest.getDeleteBillBean().getOrderby();
			deleteBillBean =(List<DeleteBillBean>) session.createSQLQuery("SELECT delsellitemline_billno, to_char(delsellitem_sdate,'DD Mon YYYY') as  delsellitem_sdate,item_itmid,item_name,delsellitemline_sellcost,delsellitemline_quant,  delsellitemline_totsellcost , delsellitemline_sgstprice, delsellitemline_cgstprice,delsellitemline_igstprice,delsellitem_totcost,delsellitem_eby, to_char(delsellitem_edate,'DD Mon YYYY') as delsellitem_edate,delsellitem_etime  \r\n" + 
					"	FROM bil_delsellitemline,bil_delsellitem,bil_item where delsellitem_sid=delsellitemline_sid and item_itmid=delsellitemline_itmid and  delsellitem_bid= '"
				+ branchid + "' order by " + sortBy + "  ").list();

			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
				
			}
		}
		if(!Utils.isNullList(deleteBillBean)) {
			return deleteBillBean;
		}
		return deleteBillBean;
	}
	
	
}
