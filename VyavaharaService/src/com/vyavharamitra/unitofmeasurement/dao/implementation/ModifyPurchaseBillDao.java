package com.vyavharamitra.unitofmeasurement.dao.implementation;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.unitofmeasurement.bean.PurchaseBillBean;
import com.vyavharamitra.unitofmeasurement.bean.PurchasedItemBean;
import com.vyavharamitra.unitofmeasurement.dao.IModifyPurchaseBillDao;

@Repository
public class ModifyPurchaseBillDao implements IModifyPurchaseBillDao {
	private Session session;
	@Autowired
	private HttpServletRequest httpServletRequest;

	public PurchaseBillBean purchaseUpdateDao(SessionFactory sessionFactory, PurchaseBillBean purchaseBillBean,
			List<PurchasedItemBean> list) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		//System.out.println("before purchase bill bean " + purchaseBillBean);
		session.update(purchaseBillBean);
		//System.out.println("after purchase bill bean " + purchaseBillBean);
		//System.out.println("select item data from list bean "+purchaseBillBean.getPurchaseEmbeddedBean().getPurchaseBillNo());
		//System.out.println("select item data from list bean "+purchaseBillBean.getPurchaseEmbeddedBean().getPurchaseSuplierGSTNo());
		//System.out.println("select item data from list bean "+purchaseBillBean.getPurchaseEmbeddedBean().getPurchaseBranchId());
		@SuppressWarnings("unchecked")
		List<PurchasedItemBean> purchasedItemList = (List<PurchasedItemBean>) session
				.createCriteria(PurchasedItemBean.class)
				.add(Restrictions.eq("purchasedBillNo", purchaseBillBean.getPurchaseEmbeddedBean().getPurchaseBillNo()))
				.add(Restrictions.eq("purchasedSuplierGSTNo", purchaseBillBean.getPurchaseEmbeddedBean().getPurchaseSuplierGSTNo()))
				.add(Restrictions.eq("purchasedBranchId", purchaseBillBean.getPurchaseEmbeddedBean().getPurchaseBranchId()))
				.list();
		//System.out.println("list of item " + purchasedItemList);
		for(PurchasedItemBean purchasedItemBean : purchasedItemList) {
			System.out.println("list of item inside for loop " + purchasedItemBean);
			ItemMasterBean itemMasterBean = new ItemMasterBean(); 
			itemMasterBean = (ItemMasterBean) session.get(ItemMasterBean.class, purchasedItemBean.getPurchasedItemId());
			//System.out.println("item master featched " + itemMasterBean);
			BigDecimal itemQuantity = itemMasterBean.getItemQuantity();
			System.out.println(" from item master "+itemQuantity);
			BigDecimal oldBillItem = purchasedItemBean.getPurchasedItemQuantity();
			System.out.println(" from old bill list master "+oldBillItem);
			BigDecimal updateOldtoItem = itemQuantity.subtract(oldBillItem);
			System.out.println(" After update item with old bill list "+updateOldtoItem);
			itemMasterBean.setItemQuantity(updateOldtoItem);
			System.out.println("updated value to item master "+itemMasterBean);
			session.update(itemMasterBean);
		}
		session.flush();
		session.clear();
		for (PurchasedItemBean purchasedItemBean1 : list) {
			System.out.println("before updateing new edited purchased list "+purchasedItemBean1);
			
			session.update(purchasedItemBean1);
			
			
			/*@SuppressWarnings("unchecked")
			List<PurchasedItemBean> purchasedItemList1 = (List<PurchasedItemBean>) session
					.createCriteria(PurchasedItemBean.class)
					.add(Restrictions.eq("purchasedBillNo", purchaseBillBean.getPurchaseEmbeddedBean().getPurchaseBillNo()))
					.add(Restrictions.eq("purchasedSuplierGSTNo",
							purchaseBillBean.getPurchaseEmbeddedBean().getPurchaseSuplierGSTNo()))
					.add(Restrictions.eq("purchasedBranchId",
							purchaseBillBean.getPurchaseEmbeddedBean().getPurchaseBranchId()))
					.list();
			for(PurchasedItemBean purchasedItemBean2:purchasedItemList1) {
				System.out.println("inside second for loop "+ purchasedItemBean2);
				purchasedItemBean2.setPurchasedItemQuantity(purchasedItemBean1.getPurchasedItemQuantity());
				purchasedItemBean2.setPurchasedItemId(purchasedItemBean1.getPurchasedItemId());
				purchasedItemBean2.setPurchasedItemId(purchasedItemBean1.getPurchasedItemId());
				purchasedItemBean2.setPurchasedItemPrize(purchasedItemBean1.getPurchasedItemPrize());
				purchasedItemBean2.setPurchasedItemDescription(purchasedItemBean1.getPurchasedItemDescription());
				purchasedItemBean2.setPurchasedBillNo(purchasedItemBean1.getPurchasedBillNo());
				purchasedItemBean2.setPurchasedSuplierGSTNo(purchasedItemBean1.getPurchasedSuplierGSTNo());
				purchasedItemBean2.setPurchasedBranchId(purchasedItemBean1.getPurchasedBranchId());
				System.out.println("before  new edited purchased list "+purchasedItemBean2);
				session.update(purchasedItemBean2);
				System.out.println("after  new edited purchased list "+purchasedItemBean2);
			}*/
			ItemMasterBean itemMasterBean1 = new ItemMasterBean();
			itemMasterBean1 = (ItemMasterBean) session.get(ItemMasterBean.class, purchasedItemBean1.getPurchasedItemId());
			System.out.println("selected item master for new update " + itemMasterBean1);
			BigDecimal oldQunatity = itemMasterBean1.getItemQuantity();
			BigDecimal currentQuantity = purchasedItemBean1.getPurchasedItemQuantity();
			BigDecimal newQuantity = oldQunatity.add(currentQuantity);
			System.out.println("new quantity for item master"+newQuantity);
			itemMasterBean1.setItemQuantity(newQuantity);
			System.out.println("before updatein new item master "+ itemMasterBean1);
			session.update(itemMasterBean1);
			System.out.println("after updatein new item master "+ itemMasterBean1);
		}
		
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}

		return purchaseBillBean;
	}

	/*
	 * //delete purchase bill public PurchaseBillBean
	 * deletePurchaseDetailsDao(SessionFactory sessionFactory,PurchaseBillRequest
	 * purchaseBillRequest) { UserCreationBean
	 * ucb=Utils.getCurrentUser(httpServletRequest); PurchaseBillBean
	 * purchaseBillBean=null; session = sessionFactory.openSession();
	 * session.beginTransaction(); String strDelBy=ucb.getUserNumber(); Integer
	 * strBranchId = ucb.getBranchNumber(); BigInteger
	 * strPurBillNo=purchaseBillRequest.getPurchaseBillBean().getPurchaseBillNo();
	 * String strVendorName
	 * =purchaseBillRequest.getPurchaseBillBean().getVendorName(); Query
	 * update=session.
	 * createSQLQuery("update bil_purchase set purchase_sta='I'  where purchase_billno = '"
	 * +strPurBillNo+"' and purchase_branchid='"+strBranchId+"'");
	 * update.executeUpdate(); Query delPurchaseBillBean=session.
	 * createSQLQuery("insert into bil_delpurchase(delpurchase_billno,delpurchase_vendname,delpurchase_enteredby,delpurchase_enteredtime,delpurchase_branchid) values('"
	 * +strPurBillNo+"','"+strVendorName+"','"+strDelBy+
	 * "',to_char(now(),'HH24:MI:SS'),'"+strBranchId+"') ");
	 * delPurchaseBillBean.executeUpdate(); session.getTransaction().commit(); if
	 * (session.isOpen()) { session.close(); }
	 * if(!Utils.isNullList(purchaseBillBean)) { return purchaseBillBean; } return
	 * purchaseBillBean; }
	 */
}
