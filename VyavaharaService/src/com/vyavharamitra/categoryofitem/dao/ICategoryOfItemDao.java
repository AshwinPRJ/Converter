package com.vyavharamitra.categoryofitem.dao;


import org.hibernate.SessionFactory;
import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.categoryofitem.bean.DeleteCategoryOfItemBean;
import com.vyavharamitra.categoryofitem.bean.UpdateCategoryOfItemBean;


/**
 * @author : Lavanya
 * @created date :24 Nov 2017
 * @modified by :
 * @modified date :
 */

public interface ICategoryOfItemDao {

	public CategoryOfItemBean categoryOfItemCreateDao(SessionFactory sessionFactory, CategoryOfItemBean categoryOfItemBean);

	public CategoryOfItemBean categoryOfItemUpdateDao(SessionFactory sessionFactory, CategoryOfItemBean categoryOfItemBean);

	public UpdateCategoryOfItemBean  categoryOfItemCreateUpdateDao(SessionFactory sessionFactory, UpdateCategoryOfItemBean updateCategoryOfItemBean);


	public CategoryOfItemBean categoryOfItemSelectDao(SessionFactory sessionFactory, CategoryOfItemBean categoryOfItemBean);

	public CategoryOfItemBean categoryOfItemDeleteDao(SessionFactory sessionFactory, CategoryOfItemBean categoryOfItemBean);

	public DeleteCategoryOfItemBean categoryOfItemCreateDeletedDao(SessionFactory sessionFactory, DeleteCategoryOfItemBean deleteCategoryOfItemBean);

}
