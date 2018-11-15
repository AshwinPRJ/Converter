package com.vyavharamitra.search.dao.implementation;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.search.dao.IItemDetailsSearchDao;
import com.vyavharamitra.search.to.request.ItemDetailsSearchRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

@Repository
public class ItemDetailsSearchDaoImpl implements IItemDetailsSearchDao {
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	private Session session;

	@SuppressWarnings("unchecked")
	public List<ItemMasterBean> getItemDetailsDao (SessionFactory sessionFactory) {
		List<ItemMasterBean> itemMasterBeanList = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
			Integer branchID = ucb.getBranchNumber();
			
			itemMasterBeanList =(List<ItemMasterBean>) session.createSQLQuery("SELECT item_bitemid,item_name,item_sellcost,item_sgst,item_cgst,item_igst,item_exciseduty,item_quan,item_itmid FROM BIL_ITEM where  item_bid='" + branchID + "' and item_status='A'  ").list();

			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(itemMasterBeanList))
		{
			return itemMasterBeanList;
		}
		return itemMasterBeanList;
	}

	@SuppressWarnings("unchecked")
	public List<ItemMasterBean> getItemDetailsDaoblur (SessionFactory sessionFactory,ItemDetailsSearchRequest itemDetailsSearchRequest) {
		List<ItemMasterBean> itemMasterBeanlist = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
			Integer branchID = ucb.getBranchNumber();
			Integer branchItemId = itemDetailsSearchRequest.getItemMasterBean().getBranchItemId();
			itemMasterBeanlist =(List<ItemMasterBean>) session.createSQLQuery("select  item_name,(select ctoi_cname from bil_ctoi where  item_cid=ctoi_cid ) as ctoi_cname  ,(select uom_name from bil_uom where uom_uid=item_uid) as pumeserment ,(select uom_name from bil_uom where uom_uid=item_suid) as sellmeserment,item_purcost,item_sellcost,item_minquan,item_maxquan,item_requan,item_convfact,item_loi,item_cid,item_uid,item_suid,item_sgst,item_cgst,item_igst,item_mrp,item_hsn,item_exciseduty from  bil_item where  item_bid='" + branchID
					+ "' and item_bitemid='" + branchItemId + "' and item_status='A' ").list();

			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(itemMasterBeanlist))
		{
			return itemMasterBeanlist;
		}
		return itemMasterBeanlist;
	}
}
