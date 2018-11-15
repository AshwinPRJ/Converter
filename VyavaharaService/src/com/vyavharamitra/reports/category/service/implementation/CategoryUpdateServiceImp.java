package com.vyavharamitra.reports.category.service.implementation;


import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.vyavharamitra.categoryofitem.bean.DeleteCategoryOfItemBean;
import com.vyavharamitra.categoryofitem.bean.UpdateCategoryOfItemBean;
import com.vyavharamitra.reports.category.dao.ICategoryUpdateDao;
import com.vyavharamitra.reports.category.service.ICategoryUpdateService;
import com.vyavharamitra.reports.category.to.request.CategoryUpdateRequest;
import resources.HibernateUtil;


/**
 * @author : Lavanya
 * @created date :18 Dec 2017
 * @modified by :
 * @modified date :
 */

@Service
public class CategoryUpdateServiceImp implements ICategoryUpdateService {

	@Autowired
	ICategoryUpdateDao iCategoryUpdateDao;

	private SessionFactory sessionFactory;

	public CategoryUpdateServiceImp() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	/**
	 * Category Update Read
	 */
	@Transactional(readOnly=true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<UpdateCategoryOfItemBean> categoryService(String categoryName) {

		return iCategoryUpdateDao.categoryDao(sessionFactory, categoryName);
	}
	/**
	 * Category Delete Read
	 */
	@Transactional(readOnly=true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<DeleteCategoryOfItemBean> categoryDeleteReadService(CategoryUpdateRequest categoryUpdateRequest)
	{
		return iCategoryUpdateDao.categoryDeleteReadDao(sessionFactory, categoryUpdateRequest);
	}


}