package com.vyavharamitra.categoryofitem.service.implimentation;


import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.categoryofitem.bean.DeleteCategoryOfItemBean;
import com.vyavharamitra.categoryofitem.bean.UpdateCategoryOfItemBean;
import com.vyavharamitra.categoryofitem.dao.ICategoryOfItemDao;
import com.vyavharamitra.categoryofitem.service.ICategoryOfItemService;
import com.vyavharamitra.categoryofitem.to.request.CategoryOfItemRequest;
import com.vyavharamitra.usercreation.bean.UserCreationBean;
import com.vyavharamitra.utils.Utils;

import resources.HibernateUtil;

/**
 * @author : Lavanya
 * @created date :24 Nov 2017
 * @modified by :
 * @modified date :
 */

@Service
public class CategoryOfItemServiceImp implements ICategoryOfItemService {

	@Autowired
	ICategoryOfItemDao iCategoryOfItemDao;

	private SessionFactory sessionFactory;

	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();

	@Autowired
	private HttpServletRequest httpServletRequest;

	public CategoryOfItemServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	/**
	 * create category
	 */

	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public CategoryOfItemBean categoryOfItemCreateService(CategoryOfItemRequest categoryOfItemRequest) {
		UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
		categoryOfItemRequest.getCategoryOfItemBean().setCategoryEnteredBy(ucb.getUserNumber());
		String categoryStatus="A";
		categoryOfItemRequest.getCategoryOfItemBean().setCategoryStatus(categoryStatus);
		categoryOfItemRequest.getCategoryOfItemBean().setCategoryEnteredDate(date);
		categoryOfItemRequest.getCategoryOfItemBean().setCategoryEnterdTime(dateFormat.format(date));
		return iCategoryOfItemDao.categoryOfItemCreateDao(sessionFactory,
				categoryOfItemRequest.getCategoryOfItemBean());
	}

	/**
	 * update category
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public CategoryOfItemBean categoryOfItemUpdateService(CategoryOfItemRequest categoryOfItemRequest) {
		CategoryOfItemBean categoryOfItemBean;
		UpdateCategoryOfItemBean updateCategoryOfItemBean = new UpdateCategoryOfItemBean();
		UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);
		categoryOfItemRequest.getCategoryOfItemBean().setCategoryUpdatedBy(ucb.getUserNumber());
		categoryOfItemRequest.getCategoryOfItemBean().setCategoryUpdatedDate(date);
		categoryOfItemRequest.getCategoryOfItemBean().setCategoryUpdatedTime(dateFormat.format(date));

		categoryOfItemBean= iCategoryOfItemDao.categoryOfItemUpdateDao(sessionFactory,
				categoryOfItemRequest.getCategoryOfItemBean());
		if (categoryOfItemBean != null) {
			System.out.println(categoryOfItemBean);
			categoryOfItemBean = iCategoryOfItemDao.categoryOfItemSelectDao(sessionFactory, categoryOfItemRequest.getCategoryOfItemBean());
			if(categoryOfItemBean != null) {
				updateCategoryOfItemBean.setCategoryId(categoryOfItemBean.getCategoryId());
				updateCategoryOfItemBean.setCategoryName(categoryOfItemBean.getCategoryName());
				updateCategoryOfItemBean.setCategorySGST(categoryOfItemBean.getCategorySGST());
				updateCategoryOfItemBean.setCategoryCGST(categoryOfItemBean.getCategoryCGST());
				updateCategoryOfItemBean.setCategoryIGST(categoryOfItemBean.getCategoryIGST());
				updateCategoryOfItemBean.setCategoryEnteredBy(categoryOfItemBean.getCategoryEnteredBy());
				updateCategoryOfItemBean.setCategoryEnteredDate(categoryOfItemBean.getCategoryEnteredDate());
				updateCategoryOfItemBean.setCategoryEnterdTime(categoryOfItemBean.getCategoryEnterdTime());
				updateCategoryOfItemBean.setCategoryUpdatedBy(ucb.getUserNumber());
				updateCategoryOfItemBean.setCategoryUpdatedDate(date);
				updateCategoryOfItemBean.setCategoryUpdatedTime(dateFormat.format(date));
				updateCategoryOfItemBean = iCategoryOfItemDao.categoryOfItemCreateUpdateDao(sessionFactory, updateCategoryOfItemBean); 
			}
		}
		return categoryOfItemBean;
	}


	/**
	 * read category
	 */
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public CategoryOfItemBean categoryOfItemReadService(CategoryOfItemRequest categoryOfItemRequest) {
		return iCategoryOfItemDao.categoryOfItemSelectDao(sessionFactory,
				categoryOfItemRequest.getCategoryOfItemBean());
	}


	/**
	 * delete category
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public CategoryOfItemBean categoryOfItemDeleteService(CategoryOfItemRequest categoryOfItemRequest) {
		CategoryOfItemBean categoryOfItemBean = new CategoryOfItemBean();
		DeleteCategoryOfItemBean deleteCategoryOfItemBean = new DeleteCategoryOfItemBean();
		UserCreationBean ucb=    Utils.getCurrentUser(httpServletRequest);


		if (categoryOfItemBean != null) {
			categoryOfItemBean = iCategoryOfItemDao.categoryOfItemSelectDao(sessionFactory, categoryOfItemRequest.getCategoryOfItemBean());
			if(categoryOfItemBean != null) {
				deleteCategoryOfItemBean.setCategoryId(categoryOfItemBean.getCategoryId());
				deleteCategoryOfItemBean.setCategoryName(categoryOfItemBean.getCategoryName());
				deleteCategoryOfItemBean.setCategorySGST(categoryOfItemBean.getCategorySGST());
				deleteCategoryOfItemBean.setCategoryCGST(categoryOfItemBean.getCategoryCGST());
				deleteCategoryOfItemBean.setCategoryIGST(categoryOfItemBean.getCategoryIGST());
				deleteCategoryOfItemBean.setCategoryEnteredBy(categoryOfItemBean.getCategoryEnteredBy());
				deleteCategoryOfItemBean.setCategoryEnteredDate(categoryOfItemBean.getCategoryEnteredDate());
				deleteCategoryOfItemBean.setCategoryEnterdTime(categoryOfItemBean.getCategoryEnterdTime());
				deleteCategoryOfItemBean.setCategoryDeletedBy(ucb.getUserNumber());
				deleteCategoryOfItemBean.setCategoryDeletedDate(date);
				deleteCategoryOfItemBean.setCategoryDeletedTime(dateFormat.format(date));

				categoryOfItemBean = iCategoryOfItemDao.categoryOfItemDeleteDao(sessionFactory, categoryOfItemRequest.getCategoryOfItemBean());
				categoryItemInsert(sessionFactory, deleteCategoryOfItemBean);

			}

		}
		return categoryOfItemBean;
	}

	@Async
	private void categoryItemInsert(SessionFactory sessionFactory, DeleteCategoryOfItemBean deleteCategoryOfItemBean) {
		categoryItemAInsert(sessionFactory, deleteCategoryOfItemBean);
	}
	
	@Transactional
	private void categoryItemAInsert(SessionFactory sessionFactory, DeleteCategoryOfItemBean deleteCategoryOfItemBean) {
	iCategoryOfItemDao.categoryOfItemCreateDeletedDao(sessionFactory, deleteCategoryOfItemBean); 
		
	}

	/**
	 * Calculation of gst for category
	 */
	@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE)
	public CategoryOfItemBean gstCalcService(CategoryOfItemRequest categoryOfItemRequest) {
		CategoryOfItemBean categoryOfItemBean = new CategoryOfItemBean();
		boolean RecordExists = false;
		if(RecordExists == false){
			BigDecimal sgst1 = categoryOfItemRequest.getCategoryOfItemBean().getCategorySGST();
			double sgst = sgst1.doubleValue();
			categoryOfItemBean.setCategoryCGST(new BigDecimal(sgst));
			double igst = sgst+sgst;
			categoryOfItemBean.setCategoryIGST(new BigDecimal(igst));
		}
		return categoryOfItemBean;
	}
}