package com.vyavharamitra.unitofmeasurement.dao.implementation;

import java.math.BigDecimal;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.unitofmeasurement.bean.PurchasedItemBean;
import com.vyavharamitra.unitofmeasurement.dao.IPurchaseBillDao;
import com.vyavharamitra.unitofmeasurement.to.request.PurchaseBillRequest;
import com.vyavharamitra.unitofmeasurement.to.response.HelperPurchaseBean;
import com.vyavharamitra.utils.Utils;

/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
@Repository
public class PurchaseBillDaoImp implements IPurchaseBillDao {

	private Session session;
	DateFormat dateFormate = new SimpleDateFormat("HH:mm:ss");
	Calendar calenderObj = Calendar.getInstance();
	Date date = new Date();

	public PurchaseBillBean purchaseCreateDao(SessionFactory sessionFactory, PurchaseBillBean purchaseBillBean,
			List<PurchasedItemBean> list) {
		purchaseBillBean.setPurchaseEnteredTime(dateFormate.format(calenderObj.getTime()));
		purchaseBillBean.setPurchaseDate(date);
		session = sessionFactory.openSession();

		session.save(purchaseBillBean);
		for (PurchasedItemBean purchasedItemBean : list) {
			session.save(purchasedItemBean);
			ItemMasterBean itemMasterBean = new ItemMasterBean();
			itemMasterBean = (ItemMasterBean) session.get(ItemMasterBean.class, purchasedItemBean.getPurchasedItemId());
			System.out.println("item master " + itemMasterBean);
			BigDecimal oldQunatity = itemMasterBean.getItemQuantity();
			BigDecimal currentQuantity = purchasedItemBean.getPurchasedItemQuantity();
			BigDecimal newQuantity = oldQunatity.add(currentQuantity);
			itemMasterBean.setItemQuantity(newQuantity);
			session.update(itemMasterBean);
		}
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if (!Utils.isNullList(purchaseBillBean)) {
			return purchaseBillBean;
		}
		return purchaseBillBean;
	}

	@SuppressWarnings("unchecked")
	public HelperPurchaseBean purchaseFetch(SessionFactory sessionFactory, PurchaseBillRequest purchaseBillRequest) {
		HelperPurchaseBean helperPurchaseBean=new HelperPurchaseBean();
		session = sessionFactory.openSession();
		session.beginTransaction();
		PurchaseBillBean purchaseBillBean = (PurchaseBillBean) session.createCriteria(PurchaseBillBean.class)
				.add(Restrictions.eq("purchaseEmbeddedBean.purchaseBillNo", purchaseBillRequest.getPurchaseBillBean().getPurchaseEmbeddedBean()
						.getPurchaseBillNo()))
				.add(Restrictions.eq("purchaseEmbeddedBean.purchaseSuplierGSTNo", purchaseBillRequest.getPurchaseBillBean().getPurchaseEmbeddedBean()
						.getPurchaseSuplierGSTNo()))
				.add(Restrictions.eq("purchaseStatus", "A"))
				.add(Restrictions.eq("purchaseEmbeddedBean.purchaseBranchId", purchaseBillRequest.getPurchaseBillBean().getPurchaseEmbeddedBean()
						.getPurchaseBranchId())).uniqueResult();
		
		List<PurchasedItemBean> purchasedItemBeans=Collections.emptyList();
		Criteria purchasedItemDetails=session.createCriteria(PurchasedItemBean.class)
				.add(Restrictions.eq("purchasedBillNo", purchaseBillRequest.getPurchaseBillBean().getPurchaseEmbeddedBean()
						.getPurchaseBillNo()))
				.add(Restrictions.eq("purchasedSuplierGSTNo", purchaseBillRequest.getPurchaseBillBean().getPurchaseEmbeddedBean()
						.getPurchaseSuplierGSTNo()))
				.add(Restrictions.eq("purchasedBranchId", purchaseBillRequest.getPurchaseBillBean().getPurchaseEmbeddedBean()
						.getPurchaseBranchId()));
		purchasedItemBeans=purchasedItemDetails.list();
		session.getTransaction().commit();
		helperPurchaseBean.setPurchaseBillBean(purchaseBillBean);
		helperPurchaseBean.setPurchasedItemBean(purchasedItemBeans);
		
		if (session.isOpen()) {
			session.close();
		}

		return helperPurchaseBean;
	}

}
