package com.vyavharamitra.itemdetails.dao.implimentation;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
/**
 * @author			: Brahmani
 * @created date	: 29 Nov 2017
 * @modified by		: 
 * @modified date	: 
 */
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.itemdetails.beans.DeleteItemMasterBean;
import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.itemdetails.dao.IItemMasterDao;
import com.vyavharamitra.organization.bean.ItemVocherGenerationBean;
import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

@Repository
public class ItemMasterDaoImpl implements IItemMasterDao {
	private Session session;
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();
	@Autowired
	private HttpServletRequest httpServletRequest;




	public ItemVocherGenerationBean createItemNumberDao(SessionFactory sessionFactory, Integer branchID){
		session = sessionFactory.openSession();
		ItemVocherGenerationBean itemVocherGenerationBean=new ItemVocherGenerationBean();
		Query updateVNQuery = session.createSQLQuery("Update bil_bitem set bitem_itemid = bitem_itemid + 1   where  bitem_bid =:branchID ");
		updateVNQuery = updateVNQuery.setParameter("branchID",branchID);
		updateVNQuery.executeUpdate();
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(itemVocherGenerationBean)) {
			return itemVocherGenerationBean;
		}
		return itemVocherGenerationBean;
	}
	public ItemVocherGenerationBean selectItemNumberDao(SessionFactory sessionFactory, Integer branchID){
		session = sessionFactory.openSession();
		session.beginTransaction();
		ItemVocherGenerationBean fetchVocherDetails = (ItemVocherGenerationBean) session.createCriteria(ItemVocherGenerationBean.class)
				.add(Restrictions.eq("branchNumber",branchID)).uniqueResult();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(fetchVocherDetails)) {
			return fetchVocherDetails;
		}
		return fetchVocherDetails;
	}
	//create item details
	public ItemMasterBean createItemDetailsDao(SessionFactory sessionFactory,ItemMasterBean itemMasterBean) {
		UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
		itemMasterBean.setItemQuantity( new BigDecimal(0.0));
		itemMasterBean.setBranchId(ucb.getBranchNumber());
		itemMasterBean.setItemStatus("A");
		itemMasterBean.setEnteredBy(ucb.getEnteredBy());
		itemMasterBean.setEnteredDate(date);
		itemMasterBean.setEnteredTime(dateFormat.format(date));
		System.out.println(">>>>>>>>>>"+itemMasterBean);
		session = sessionFactory.openSession();
		session.save(itemMasterBean);
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(itemMasterBean)) {
			return itemMasterBean;
		}
		return itemMasterBean;
	}

	//select category details
	public CategoryOfItemBean fetchCategoryDetailsDao(CategoryOfItemBean categoryOfItemBean, SessionFactory sessionFactory) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		CategoryOfItemBean fetchCategoryDetails = (CategoryOfItemBean) session.createCriteria(CategoryOfItemBean.class)
				.add(Restrictions.eq("categoryId", categoryOfItemBean.getCategoryId())).uniqueResult();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(fetchCategoryDetails)) {
			return fetchCategoryDetails;
		}
		return fetchCategoryDetails;
	}

	//select unit measurement details
	public UnitOfMeasurementBean fetchUnitMeasurementDetailsDao(UnitOfMeasurementBean unitOfMeasurementBean, SessionFactory sessionFactory) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		UnitOfMeasurementBean fetchUnitMeasurementDetails = (UnitOfMeasurementBean) session.createCriteria(UnitOfMeasurementBean.class)
				.add(Restrictions.eq("unitMeasurementNumber", unitOfMeasurementBean.getUnitMeasurementNumber())).uniqueResult();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(fetchUnitMeasurementDetails)) {
			return fetchUnitMeasurementDetails;
		}
		return fetchUnitMeasurementDetails;
	}

	// delete Item details
	public ItemMasterBean deleteItemDetailsDao(SessionFactory sessionFactory,ItemMasterBean itemMasterBean) {
		UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
		session = sessionFactory.openSession();
		session.beginTransaction();
		String strDelBy=ucb.getUserNumber();
		Integer strDelItemId=itemMasterBean.getBranchItemId();
		String strItemName =itemMasterBean.getItemName();
		Integer strBranchId = ucb.getBranchNumber();
		SQLQuery iitemMasterBean=null;
		SQLQuery updateItemMasterBean=null;
		iitemMasterBean=session.createSQLQuery("update bil_item set item_status = 'I' where item_bitemid = '"+strDelItemId+"' and item_bid='"+strBranchId+"'");
		iitemMasterBean.executeUpdate();
		updateItemMasterBean=	session.createSQLQuery("insert into bil_delitem(delitem_bitemid,delitem_name,delitem_delby,delitem_delon,delitem_deltime,delitem_bid) values('"+strDelItemId+"','"+strItemName+"','"+strDelBy+"','"+date+"',to_char(now(),'HH24:MI:SS'),'"+strBranchId+"') ");
		updateItemMasterBean.executeUpdate();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(itemMasterBean)) {
			return itemMasterBean;
		}
		return itemMasterBean;
	}			
	//select details
	public ItemMasterBean selectItemDetailsDao(SessionFactory sessionFactory, ItemMasterBean itemMasterBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		ItemMasterBean itemDetails = (ItemMasterBean) session.createCriteria(ItemMasterBean.class)
				.add(Restrictions.eq("branchId", itemMasterBean.getBranchId()))
				.add(Restrictions.eq("branchItemId", itemMasterBean.getBranchItemId()))
				.uniqueResult();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(itemDetails)) {
			return itemDetails;
		}
		return itemDetails;
	}
	//create delete item details
	public DeleteItemMasterBean createDeleteItemDetailsDao(SessionFactory sessionFactory, DeleteItemMasterBean deleteItemMasterBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(deleteItemMasterBean);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(deleteItemMasterBean)) {
			return deleteItemMasterBean;
		}
		return deleteItemMasterBean;
	}

	// update Item details
	public ItemMasterBean updateItemDetailsDao(SessionFactory sessionFactory,ItemMasterBean itemMasterBean) {
		UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
		session = sessionFactory.openSession();
		session.beginTransaction();
		String updatedBy=ucb.getUserNumber();
		Integer strBItemId=itemMasterBean.getBranchItemId();
		String strItemName =itemMasterBean.getItemName();
		Integer strCateId =  itemMasterBean.getCategoryId();
		BigDecimal strCateSgst =  itemMasterBean.getSgst();
		BigDecimal strCateCgst = itemMasterBean.getCgst();
		BigDecimal strCateIgst = itemMasterBean.getIgst();
		Integer strPurUntId = itemMasterBean.getPurchaseUnitMeasurementId();
		Integer strSellUntId = itemMasterBean.getSellingUnitMeasurementId();
		BigDecimal strConvFact = itemMasterBean.getItemConversionFactor();
		BigDecimal strPurCost = itemMasterBean.getItemPurchaseCost();
		BigDecimal strSellCost1 =itemMasterBean.getItemSellingCost();
		BigDecimal strMRP = itemMasterBean.getMrp();
		BigDecimal strMinQuant = itemMasterBean.getItemMinimumQuantity();
		BigDecimal strMaxQuant = itemMasterBean.getItemMaxQuantity();
		BigDecimal strReOrdQuant =itemMasterBean.getItemReorderQuantity();
		String strItmLoc = itemMasterBean.getLocationOfItem();
		String strHsn = itemMasterBean.getHsn();
		BigDecimal strExcduty =itemMasterBean.getExciseDuty();
		Integer strBranchId = ucb.getBranchNumber();
		SQLQuery iitemMasterBean=null;
		SQLQuery updateItemMasterBean=null;
		iitemMasterBean=session.createSQLQuery(" update bil_item set  item_name='" + strItemName + "',  item_purcost='" + strPurCost
				+ "', item_sellcost='" + strSellCost1 + "',item_minquan='" + strMinQuant + "', item_maxquan='"
				+ strMaxQuant + "', item_requan='" + strReOrdQuant + "', item_convfact='" + strConvFact
				+ "',item_loi='" + strItmLoc + "',  item_uby='" + updatedBy + "', item_uon='" + date
				+ "', item_utime=to_char(now(),'HH24:MI:SS'),item_cid='" + strCateId + "', item_uid='" + strPurUntId
				+ "', item_suid='" + strSellUntId + "' ,item_sgst='" + strCateSgst + "',item_cgst='" + strCateCgst
				+ "', item_igst='" + strCateIgst + "', item_mrp='" + strMRP + "' , item_exciseduty='" + strExcduty + "',item_hsn='" + strHsn
				+ "' where  item_bitemid='" + strBItemId + "' and  item_bid='" + strBranchId + "' ");
		iitemMasterBean.executeUpdate();
		updateItemMasterBean=	session.createSQLQuery(" INSERT INTO BIL_UITEM(uitem_bitemid,uitem_name,uitem_purcost,uitem_sellcost,uitem_minquan,uitem_maxquan,uitem_requan,uitem_convfact,uitem_loi,uitem_hsn,uitem_exciseduty,uitem_eby,uitem_edate, uitem_etime,uitem_cid,uitem_uid,uitem_suid,uitem_sgst,uitem_cgst,uitem_igst,uitem_mrp,uitem_bid) values ('" + strBItemId + "','" + strItemName + "','" + strPurCost + "', '" + strSellCost1+ "','" + strMinQuant + "','" + strMaxQuant + "','" + strReOrdQuant + "','" + strConvFact + "','"+ strItmLoc + "','" + strHsn + "','" + strExcduty + "','" + updatedBy + "','" + date+ "',to_char(now(),'HH24:MI:SS'),'" + strCateId + "','" + strPurUntId + "','" + strSellUntId + "','"+ strCateSgst + "','" + strCateCgst + "','" + strCateIgst + "','" + strMRP + "','" + strBranchId+ "')  ");
		updateItemMasterBean.executeUpdate();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(itemMasterBean)) {
			return itemMasterBean;
		}
		return itemMasterBean;
	}			
}
