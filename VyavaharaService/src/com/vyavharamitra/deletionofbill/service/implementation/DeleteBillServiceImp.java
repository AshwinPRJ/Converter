package com.vyavharamitra.deletionofbill.service.implementation;

import java.math.BigDecimal;
/**
 * @author : Kalyani
 * @created date : 27 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.cashsales.beans.CashSalesBean;
import com.vyavharamitra.cashsales.beans.CashSalesLineBean;
import com.vyavharamitra.deletionofbill.bean.DeleteBillBean;
import com.vyavharamitra.deletionofbill.bean.DeleteSellitemBean;
import com.vyavharamitra.deletionofbill.dao.IDeleteBillDao;
import com.vyavharamitra.deletionofbill.service.IDeleteBillService;
import com.vyavharamitra.deletionofbill.to.request.DeleteBillRequest;
import com.vyavharamitra.deletionofbill.to.request.DeleteRequest;
import com.vyavharamitra.itemdetails.beans.ItemMasterBean;

import resources.HibernateUtil;

@Service
public class DeleteBillServiceImp implements IDeleteBillService {

	@Autowired
	private IDeleteBillDao iDeleteBillDao;

	private SessionFactory sessionFactory;

	public DeleteBillServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	@Transactional(propagation = Propagation.REQUIRED)

	// creation of delete bil

	public List<CashSalesBean> sellitemFetch(DeleteBillRequest deleteBillRequest) {
		List<CashSalesBean> cashSalesBean;
		CashSalesLineBean cashSalesLineBean = new CashSalesLineBean();
		DeleteBillBean deleteBillBean = new DeleteBillBean();
		DeleteSellitemBean deleteSellitemBean = new DeleteSellitemBean();
		
		
		

		cashSalesBean = iDeleteBillDao.sellitemFetch(sessionFactory, deleteBillRequest);
/*		//System.out.println("cashSalesBean>>>>>>>>>>>>>>>>" + cashSalesBean);
		
		@SuppressWarnings("unused")
		ItemMasterBean 	itemMasterBean =new ItemMasterBean ();
	
		for(CashSalesBean cashSalesBean1 : cashSalesBean ){
			//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>  "+ cashSalesBean1.getSellItemId());
			
			deleteBillBean.setDelsellItemId(cashSalesBean1.getSellItemId());
			deleteSellitemBean.setDelId( cashSalesBean1.getSellItemId());
			deleteBillBean.setDelsellItemDate(cashSalesBean1.getSellItemDate());	
			deleteBillBean.setDelsellItemDate(cashSalesBean1.getSellItemDate());
			deleteBillBean.setDelsellItemTotalCost(cashSalesBean1.getSellItemTotalCost());
			deleteBillBean.setDelsellItemEnteredBy(cashSalesBean1.getSellItemEnteredBy());
			deleteBillBean.setDelsellItemEnteredDate(cashSalesBean1.getSellItemEnteredDate());
			deleteBillBean.setDelsellItemEnteredTime(cashSalesBean1.getSellItemEnteredTime());
			deleteBillBean.setDelsellItemCustomerPhone(cashSalesBean1.getSellItemCustomerPhone());
			deleteBillBean.setDelsellItemBranchId(cashSalesBean1.getSellItemBranchId());
			deleteSellitemBean.setDelItemId(cashSalesLineBean.getSellItemLineItemId());
			deleteSellitemBean.setDelSgst(cashSalesLineBean.getSellItemLineSGST());
			deleteSellitemBean.setDelCgst(cashSalesLineBean.getSellItemLineCGST());
			deleteSellitemBean.setDeligst(cashSalesLineBean.getSellItemLineIGST());
			deleteSellitemBean.setDelDiscountType(cashSalesLineBean.getSellItemLineDiscountType());
			deleteSellitemBean.setDelDiscountValue(cashSalesLineBean.getSellItemLineDiscountValue());
			deleteSellitemBean.setDelValueRp(cashSalesLineBean.getSellItemLineValueRP());
			deleteSellitemBean.setDelSellCost(cashSalesLineBean.getSellItemLineSellCost());
			deleteSellitemBean.setDelQuantity(cashSalesLineBean.getSellItemLineQuantity());
			deleteSellitemBean.setDelTotalSellCost(cashSalesLineBean.getSellItemLineTotalSellCost());
			deleteSellitemBean.setDelTotSelSgst(cashSalesLineBean.getSellItemLineSGSTPrice());
			deleteSellitemBean.setDelTotalSellCost(cashSalesLineBean.getSellItemLineTotalSellCost());
			deleteBillBean = iDeleteBillDao.deleteCreateDao(sessionFactory, deleteBillBean, deleteSellitemBean);
			deleteBillBean = iDeleteBillDao.updatebillstatus(sessionFactory, sellItemId);
			
		}
	if(deleteBillBean!=null)
		{
		
			Integer branchId=cashSalesLineBean.getSellItemLineId();
			Integer branchItemId=cashSalesLineBean.getSellItemLineItemId();
			
			BigDecimal quantity=(cashSalesLineBean.getSellItemLineQuantity());
			itemMasterBean = iDeleteBillDao.updateitemquan(sessionFactory,branchId,branchItemId,quantity);
		}*/
		
		return cashSalesBean;
	}
	
	
	public DeleteBillBean create(DeleteRequest deleteRequest){
		DeleteBillBean deleteBillBean=new DeleteBillBean();
		DeleteSellitemBean deleteSellitemBean=new DeleteSellitemBean();
		ItemMasterBean itemMasterBean=new ItemMasterBean();
		deleteBillBean=iDeleteBillDao.updatebillstatus(sessionFactory,deleteRequest);
		itemMasterBean=iDeleteBillDao.updateitemquan(sessionFactory,deleteRequest);
		deleteBillBean= iDeleteBillDao.deleteCreateDao(sessionFactory,deleteRequest.getDeleteBillBean() );
		deleteSellitemBean=iDeleteBillDao.deleteLineCreateDao(sessionFactory,deleteRequest.getDeleteSellitemBean());
		return deleteBillBean;
	}
	
	
	
}
