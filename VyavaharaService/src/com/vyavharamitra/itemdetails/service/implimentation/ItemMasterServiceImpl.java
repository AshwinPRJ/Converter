package com.vyavharamitra.itemdetails.service.implimentation;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.itemdetails.dao.IItemMasterDao;
import com.vyavharamitra.itemdetails.service.IItemMasterService;
import com.vyavharamitra.itemdetails.to.request.ItemMasterRequest;
import com.vyavharamitra.organization.bean.ItemVocherGenerationBean;
import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

import resources.HibernateUtil;

@Service
public class ItemMasterServiceImpl implements IItemMasterService {

	@Autowired
	IItemMasterDao itemMasterDao;

	@Autowired
	private HttpServletRequest httpServletRequest;
	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();
	private SessionFactory sessionFactory;

	public ItemMasterServiceImpl() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	
	
	//create item details
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)

	public ItemMasterBean itemMasterCreateService(ItemMasterRequest itemMasterRequest){
		UserCreationBean ucb=Utils.getCurrentUser(httpServletRequest);
		Integer branchID = ucb.getBranchNumber();
		ItemVocherGenerationBean itemVocherGenerationBean;
		itemVocherGenerationBean=itemMasterDao.createItemNumberDao(sessionFactory,branchID);
		itemVocherGenerationBean=itemMasterDao.selectItemNumberDao(sessionFactory, branchID);
	
		itemMasterRequest.getItemMasterBean().setBranchItemId(itemVocherGenerationBean.getItemNumber());
		return itemMasterDao.createItemDetailsDao(sessionFactory, itemMasterRequest.getItemMasterBean());
		
	}
	
	//select category details
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)

	public CategoryOfItemBean fetchCategoryDetailsService(ItemMasterRequest itemMasterRequest) {
		CategoryOfItemBean categoryOfItemBean = itemMasterRequest.getCategoryOfItemBean();
		return itemMasterDao.fetchCategoryDetailsDao(categoryOfItemBean,sessionFactory);

	}
	
	//select unit measurement details
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)

	public UnitOfMeasurementBean fetchUnitMeasurementDetailsService(ItemMasterRequest itemMasterRequest) {
		UnitOfMeasurementBean unitOfMeasurementBean = itemMasterRequest.getUnitOfMeasurementBean();
		return itemMasterDao.fetchUnitMeasurementDetailsDao(unitOfMeasurementBean,sessionFactory);

	}
	
	//update item details
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)

		public ItemMasterBean updateItemDetailsService(ItemMasterRequest itemMasterRequest) {
			return itemMasterDao.updateItemDetailsDao(sessionFactory, itemMasterRequest.getItemMasterBean());
		}
	
	// delete item details
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)

	public ItemMasterBean deleteItemDetailsService(ItemMasterRequest itemMasterRequest) {
		return itemMasterDao.deleteItemDetailsDao(sessionFactory, itemMasterRequest.getItemMasterBean());
	}
}
