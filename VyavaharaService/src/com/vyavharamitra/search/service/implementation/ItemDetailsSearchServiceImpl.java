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

import com.vyavharamitra.itemdetails.beans.ItemMasterBean;
import com.vyavharamitra.search.dao.IItemDetailsSearchDao;
import com.vyavharamitra.search.service.IItemDetailsSearchService;
import com.vyavharamitra.search.to.request.ItemDetailsSearchRequest;

import resources.HibernateUtil;

@Service
public class ItemDetailsSearchServiceImpl implements IItemDetailsSearchService {
	@Autowired
	private IItemDetailsSearchDao iItemDetailsSearchDao;
	/**
	 * Creating Object to SessionFactory
	 */
	private SessionFactory sessionFactory;
	public ItemDetailsSearchServiceImpl() {
		/**
		 * getting SessionFactory from Hibernate Util
		 */
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<ItemMasterBean> getItemDetails(){
		return  iItemDetailsSearchDao.getItemDetailsDao(sessionFactory);
	}
	
	@Transactional(readOnly = true,propagation = Propagation.REQUIRED,isolation=Isolation.SERIALIZABLE)
	public List<ItemMasterBean> getItemDetailsblur(ItemDetailsSearchRequest itemDetailsSearchRequest){
		return  iItemDetailsSearchDao.getItemDetailsDaoblur(sessionFactory,itemDetailsSearchRequest);
	}
	
	

}
