package com.vyavharamitra.reports.category.dao;
import java.util.List;
import org.hibernate.SessionFactory;
import com.vyavharamitra.categoryofitem.bean.UpdateCategoryOfItemBean;
import com.vyavharamitra.reports.category.to.request.CategoryUpdateRequest;
import com.vyavharamitra.categoryofitem.bean.DeleteCategoryOfItemBean;

/**
 * @author : Lavanya
 * @created date :18 Dec 2017
 * @modified by :
 * @modified date :
 */
public interface ICategoryUpdateDao {
	public List<UpdateCategoryOfItemBean> categoryDao(SessionFactory sessionFactory,String categoryName);
	public List<DeleteCategoryOfItemBean> categoryDeleteReadDao(SessionFactory sessionFactory,CategoryUpdateRequest categoryUpdateRequest);

}
