package com.vyavharamitra.search.dao;
/**
 * @author : Brahmani
 * @created date : 
 * @modified by :
 * @modified date :
 */
import java.util.List;

import org.hibernate.SessionFactory;

import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;

public interface ICategoryDetailsSearchDao {

	List<CategoryOfItemBean> getCategoryDetailsDao(SessionFactory sessionFactory);
}
