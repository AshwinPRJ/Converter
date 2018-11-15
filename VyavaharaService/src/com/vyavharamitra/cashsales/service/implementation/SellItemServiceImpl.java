package com.vyavharamitra.cashsales.service.implementation;

/**
 * @author : Brahmani
 * @created date : 25 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.cashsales.beans.CashSalesLineBean;
import com.vyavharamitra.cashsales.dao.ISellItemDao;
import com.vyavharamitra.cashsales.service.ISellItemService;
import com.vyavharamitra.cashsales.to.request.CashSalesCreateRequest;
import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.organization.bean.BillVocherGenerationBean;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

import resources.HibernateUtil;

@Service
public class SellItemServiceImpl implements ISellItemService {

	@Autowired
	ISellItemDao iSellItemDao;

	@Autowired
	private HttpServletRequest httpServletRequest;

	private SessionFactory sessionFactory;

	public SellItemServiceImpl() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.SERIALIZABLE)
	public CashSalesBean createCashSalesService(CashSalesCreateRequest cashSalesCreateRequest) {
		BillVocherGenerationBean billVocherGenerationBean = new BillVocherGenerationBean();
		CashSalesBean cashSalesBean = new CashSalesBean();
		UserCreationBean ucb = Utils.getCurrentUser(httpServletRequest);
		Integer branchID = ucb.getBranchNumber();
		String sellItemStatus = "A";
		System.out.println("branchID in service "+branchID);
		cashSalesCreateRequest.getCashSalesBean().setSellItemBranchId(branchID);
		cashSalesCreateRequest.getCashSalesBean().setSellItemStatus(sellItemStatus);
		iSellItemDao.createBillNumberDao(sessionFactory, branchID);
		billVocherGenerationBean = iSellItemDao.selectBillNumberDao(sessionFactory, branchID);
		System.out.println("resulrrrrr"+billVocherGenerationBean);

		if (billVocherGenerationBean != null) {
			cashSalesCreateRequest.getCashSalesBean().setSellItemBillNumber(billVocherGenerationBean.getBillNumber());
			cashSalesBean = iSellItemDao.createCashSalesDao(sessionFactory, cashSalesCreateRequest.getCashSalesBean());
			List<CashSalesLineBean> cashSalesLineBeanList = cashSalesCreateRequest.getCashSalesLineBeanList();
			if (cashSalesBean != null) {
				for (CashSalesLineBean cashSalesLineBean : cashSalesLineBeanList) {
					cashSalesLineBean.setSellItemLineBranchId(branchID);
					cashSalesLineBean.setSellItemLineId(cashSalesBean.getSellItemId());
					cashSalesLineBean.setSellItemLineBillNo(cashSalesBean.getSellItemBillNumber());
					iSellItemDao.createCashSalesLineDao(sessionFactory, cashSalesLineBean);
					iSellItemDao.updateCashSale(sessionFactory, cashSalesLineBean);
				}
			}
		}
		return cashSalesBean;
	}
}