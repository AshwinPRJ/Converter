package com.vyavharamitra.cashsales.dao.implementation;

import java.math.BigDecimal;
/**
 * @author : Brahmani
 * @created date : 21 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.cashsales.beans.CashSalesLineBean;
import com.vyavharamitra.cashsales.dao.ISellItemDao;
import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.organization.bean.BillVocherGenerationBean;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

@Repository
public class SellItemDaoImpl implements ISellItemDao {

	private Session session;

	@Autowired
	private HttpServletRequest httpServletRequest;

	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();

	public CashSalesBean createCashSalesDao(SessionFactory sessionFactory, CashSalesBean cashSalesBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		UserCreationBean ucb = Utils.getCurrentUser(httpServletRequest);
		cashSalesBean.setSellItemEnteredBy(ucb.getUserNumber());
		cashSalesBean.setSellItemDate(date);
		cashSalesBean.setSellItemEnteredDate(date);
		cashSalesBean.setSellItemEnteredTime(dateFormat.format(date));
		System.out.println("cash " + cashSalesBean);
		session.save(cashSalesBean);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if (!Utils.isNullList(cashSalesBean)) {
			return cashSalesBean;
		}
		return cashSalesBean;
	}

	public CashSalesLineBean createCashSalesLineDao(SessionFactory sessionFactory,
			CashSalesLineBean cashSalesLineBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(cashSalesLineBean);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if (!Utils.isNullList(cashSalesLineBean)) {
			return cashSalesLineBean;
		}
		return cashSalesLineBean;
	}

	public CashSalesBean selectCashSalesDao(SessionFactory sessionFactory, CashSalesBean cashSalesBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		CashSalesBean cashSalesDetails = (CashSalesBean) session.createCriteria(CashSalesBean.class)
				.add(Restrictions.eq("sellItemId", cashSalesBean.getSellItemId())).uniqueResult();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if (!Utils.isNullList(cashSalesBean)) {
			return cashSalesBean;
		}
		return cashSalesDetails;
	}

	public BillVocherGenerationBean createBillNumberDao(SessionFactory sessionFactory, Integer branchID) {
		session = sessionFactory.openSession();
		BillVocherGenerationBean billVocherGenerationBean = new BillVocherGenerationBean();
		Query updateVNQuery = session
				.createSQLQuery("Update bil_vn set vn_billno = vn_billno + 1" + "where  vn_bid = :branchID ");
		updateVNQuery = updateVNQuery.setParameter("branchID", branchID); // Parameter binding escapes all input
		updateVNQuery.executeUpdate();
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if (!Utils.isNullList(billVocherGenerationBean)) {
			return billVocherGenerationBean;
		}
		return billVocherGenerationBean;
	}

	public BillVocherGenerationBean selectBillNumberDao(SessionFactory sessionFactory, Integer branchID) {
		session = sessionFactory.openSession();
		System.out.println("branch id   "+branchID);
		BillVocherGenerationBean fetchVocherDetails = (BillVocherGenerationBean) session
				.createCriteria(BillVocherGenerationBean.class).add(Restrictions.eq("branchNumber", branchID))
				.uniqueResult();
		if (!Utils.isNullList(fetchVocherDetails)) {
			return fetchVocherDetails;
		}
		return fetchVocherDetails;
	}

	@Override
	public void updateCashSale(SessionFactory sessionFactory, CashSalesLineBean cashSalesLineBean) {
		session = sessionFactory.openSession();
		ItemMasterBean itemMasterBean = new ItemMasterBean();
		System.out.println("result = " + cashSalesLineBean.getSellItemLineId());
		Criteria criteria = session.createCriteria(ItemMasterBean.class)
				.add(Restrictions.eq("itemNumber", cashSalesLineBean.getSellItemLineItemId()));
		Object result = criteria.uniqueResult();
		System.out.println("result = " + result);
		itemMasterBean = (ItemMasterBean) result;
		System.out.println("Genre = " + itemMasterBean);
		System.out.println("item master " + itemMasterBean);
		BigDecimal oldQunatity = itemMasterBean.getItemQuantity();
		BigDecimal currentQuantity = cashSalesLineBean.getSellItemLineQuantity();
		BigDecimal newQuantity = oldQunatity.subtract(currentQuantity);
		itemMasterBean.setItemQuantity(newQuantity);
		session.update(itemMasterBean);
		System.out.println("substrat happen " + itemMasterBean);
		session.beginTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
	}
}