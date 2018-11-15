package com.vyavharamitra.cashsales.service.implementation;
/**
 * @author : Brahmani
 * @created date : 25 Nov 2017
 * @modified by :
 * @modified date :
 */
import java.math.BigDecimal;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.cashsales.beans.CashSalesLineBean;
import com.vyavharamitra.cashsales.dao.ICashSalesDao;
import com.vyavharamitra.cashsales.service.ICashSalesService;
import com.vyavharamitra.cashsales.to.request.CashSalesCreateRequest;

import resources.HibernateUtil;

@Service
public class CashSalesServiceImpl implements ICashSalesService {
	@Autowired
	ICashSalesDao icashSalesDao;

	@SuppressWarnings("unused")
	private SessionFactory sessionFactory;

	public CashSalesServiceImpl() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public CashSalesLineBean cashSalesCalculationService(CashSalesCreateRequest cashSalesCreateRequest) {
		CashSalesLineBean cashSalesLineBean=new CashSalesLineBean();
			boolean Exclusive = cashSalesCreateRequest.getCashSalesLineBean().isExclusive();
			BigDecimal price1 = cashSalesCreateRequest.getCashSalesLineBean().getSellItemLineSellCost();
			double price = price1.doubleValue();
			BigDecimal discount1 = cashSalesCreateRequest.getCashSalesLineBean().getSellItemLineDiscountValue();
			double discount = discount1.doubleValue();
			String discounttype = cashSalesCreateRequest.getCashSalesLineBean().getSellItemLineDiscountType();
			BigDecimal quantity1 = cashSalesCreateRequest.getCashSalesLineBean().getSellItemLineQuantity();
			boolean intraStatus = cashSalesCreateRequest.getCashSalesLineBean().isIntra();
			double quantity = quantity1.doubleValue();
			BigDecimal cgst1 = cashSalesCreateRequest.getCashSalesLineBean().getSellItemLineCGST();
			BigDecimal sgst1 = cashSalesCreateRequest.getCashSalesLineBean().getSellItemLineSGST();
			BigDecimal igst1 = cashSalesCreateRequest.getCashSalesLineBean().getSellItemLineIGST();
			BigDecimal cess1 = cashSalesCreateRequest.getCashSalesLineBean().getSellItemLineCess();
			double cgst = cgst1.doubleValue();
			double sgst = sgst1.doubleValue();
			double igst = igst1.doubleValue();
			double cess = cess1.doubleValue();
			double discvalue;
				if (discounttype == "Percentage") {
					discvalue = (price * discount) / 100;
				} else {
					discvalue = discount;
				}
			
		

		if (Exclusive == true) {
			double sellingprice = price - discvalue;
			cashSalesLineBean.setSellItemLineSellCost(new BigDecimal(sellingprice));
	
			double totalSellingPrice = sellingprice * quantity;
			cashSalesLineBean.setSellItemLineTotalSellCost(new BigDecimal(totalSellingPrice));
			if (intraStatus == true) {
				double itemsgst = (totalSellingPrice * sgst) / 100;
				double itemcgst = (totalSellingPrice * cgst) / 100;
				double itemigst = 0;
				double itemcess = (totalSellingPrice * cess) / 100;
				cashSalesLineBean.setSellItemLineSGSTPrice(new BigDecimal(itemsgst));
				cashSalesLineBean.setSellItemLineCGSTPrice(new BigDecimal(itemcgst));
				cashSalesLineBean.setSellItemLineIGSTPrice(new BigDecimal(itemigst));
				cashSalesLineBean.setSellItemLineCessValue(new BigDecimal(itemcess));
				double totalCost = totalSellingPrice + itemsgst + itemcgst + itemcess;
				cashSalesLineBean.setSellItemLineTotalSellGST(new BigDecimal(totalCost));
			} else {
				double itemsgst = 0;
				double itemcgst = 0;
				double itemigst = (totalSellingPrice * igst) / 100;
				double itemcess = (totalSellingPrice * cess) / 100;
				cashSalesLineBean.setSellItemLineSGSTPrice(new BigDecimal(itemsgst));
				cashSalesLineBean.setSellItemLineCGSTPrice(new BigDecimal(itemcgst));
				cashSalesLineBean.setSellItemLineIGSTPrice(new BigDecimal(itemigst));
				cashSalesLineBean.setSellItemLineCessValue(new BigDecimal(itemcess));
				double totalCost = totalSellingPrice + itemigst + itemcess;
				cashSalesLineBean.setSellItemLineTotalSellGST(new BigDecimal(totalCost));
			}
		}else{
			double sellingprice = price - discvalue;
			if (intraStatus == true) {
				double itemsgst = (sgst/(100+(sgst+cgst))) * sellingprice;
				double itemcgst =  (cgst/(100+(sgst+cgst))) * sellingprice;
				double itemigst = 0;
				double itemcess = (sellingprice * cess) / 100;  
				double sgstvalue=itemsgst*quantity;
				double cgstvalue=itemcgst*quantity;
				double cessvalue=itemcess*quantity;
				cashSalesLineBean.setSellItemLineIGSTPrice(new BigDecimal(itemigst));
				cashSalesLineBean.setSellItemLineSGSTPrice(new BigDecimal(sgstvalue));
				cashSalesLineBean.setSellItemLineCGSTPrice(new BigDecimal(cgstvalue));
				cashSalesLineBean.setSellItemLineCessValue(new BigDecimal(itemcess));
				double sellCost = sellingprice -( itemsgst + itemcgst) - itemcess;
				cashSalesLineBean.setSellItemLineSellCost(new BigDecimal(sellCost));
				double sellprice=sellCost*quantity;
				cashSalesLineBean.setSellItemLineTotalSellCost(new BigDecimal(sellprice));
				double totalprice=(sellprice)+(sgstvalue)+(cgstvalue)+(cessvalue);
				cashSalesLineBean.setSellItemLineTotalSellGST(new BigDecimal(totalprice));
			}else{
				double itemsgst = 0;
				double itemcgst = 0;
				cashSalesLineBean.setSellItemLineSGSTPrice(new BigDecimal(itemsgst));
				cashSalesLineBean.setSellItemLineCGSTPrice(new BigDecimal(itemcgst));
				double itemigst = (igst/(100+igst)) * sellingprice;
				double itemcess = (sellingprice * cess) / 100;
				double igstvalue=itemigst*quantity;
				double cessvalue=itemcess*quantity;
				cashSalesLineBean.setSellItemLineIGSTPrice(new BigDecimal(igstvalue));
				cashSalesLineBean.setSellItemLineCessValue(new BigDecimal(itemcess));
				double sellCost = sellingprice - itemigst - itemcess;
				cashSalesLineBean.setSellItemLineSellCost(new BigDecimal(sellCost));
				double sellprice=sellCost*quantity;
				cashSalesLineBean.setSellItemLineTotalSellCost(new BigDecimal(sellprice));
				double totalprice=sellprice+igstvalue+cessvalue;
				cashSalesLineBean.setSellItemLineTotalSellGST(new BigDecimal(totalprice));
			}
		}
		return cashSalesLineBean;
	}

}
