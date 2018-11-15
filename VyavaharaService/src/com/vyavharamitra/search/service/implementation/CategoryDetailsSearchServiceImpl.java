package com.vyavharamitra.search.service.implementation;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.search.dao.ICategoryDetailsSearchDao;
import com.vyavharamitra.search.service.ICategoryDetailsSearchService;

import resources.HibernateUtil;

@Service
public class CategoryDetailsSearchServiceImpl implements ICategoryDetailsSearchService{

	@Autowired
	private ICategoryDetailsSearchDao iCategoryDetailsSearchDao;
	/**
	 * Creating Object to SessionFactory
	 */
	private SessionFactory sessionFactory;
	public CategoryDetailsSearchServiceImpl() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<CategoryOfItemBean> getCategoryDetails(){
		return  iCategoryDetailsSearchDao.getCategoryDetailsDao(sessionFactory);
	}
}
