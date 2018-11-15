package com.vyavharamitra.categoryofitem.dao.implimentation;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.categoryofitem.bean.DeleteCategoryOfItemBean;
import com.vyavharamitra.categoryofitem.bean.UpdateCategoryOfItemBean;
import com.vyavharamitra.categoryofitem.dao.ICategoryOfItemDao;
import com.vyavharamitra.utils.Utils;

/**
 * @author : Lavanya
 * @created date :24 Nov 2017
 * @modified by :
 * @modified date :
 */

@Repository
public class CategoryOfItemDaoImp implements ICategoryOfItemDao {

	private Session session;


	/**
	 *  create category item
	 */
	public CategoryOfItemBean categoryOfItemCreateDao(SessionFactory sessionFactory,
			CategoryOfItemBean categoryOfItemBean) {

		session = sessionFactory.openSession();
		session.save(categoryOfItemBean);
		session.beginTransaction().commit();

		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(categoryOfItemBean)) {
			return categoryOfItemBean;
		}
		return categoryOfItemBean;
	}

	/**
	 * update category(updating category details)
	 */

	public CategoryOfItemBean categoryOfItemUpdateDao(SessionFactory sessionFactory,
			CategoryOfItemBean categoryOfItemBean) {

		session = sessionFactory.openSession();
		session.beginTransaction();
		Query categoryOfItemUpdateQuery = session.createQuery(
				"UPDATE CategoryOfItemBean  SET categorySGST =:categorySGST,categoryCGST =:categoryCGST,categoryIGST =:categoryIGST,categoryUpdatedBy =:categoryUpdatedBy,categoryUpdatedTime =:categoryUpdatedTime,categoryUpdatedDate =:categoryUpdatedDate where categoryName =:categoryName  ");

		categoryOfItemUpdateQuery.setParameter("categoryName", categoryOfItemBean.getCategoryName());
		categoryOfItemUpdateQuery.setParameter("categorySGST", categoryOfItemBean.getCategorySGST());
		categoryOfItemUpdateQuery.setParameter("categoryCGST", categoryOfItemBean.getCategoryCGST());
		categoryOfItemUpdateQuery.setParameter("categoryIGST", categoryOfItemBean.getCategoryIGST());
		categoryOfItemUpdateQuery.setParameter("categoryUpdatedBy", categoryOfItemBean.getCategoryUpdatedBy());
		categoryOfItemUpdateQuery.setParameter("categoryUpdatedTime", categoryOfItemBean.getCategoryUpdatedTime());
		categoryOfItemUpdateQuery.setParameter("categoryUpdatedDate", categoryOfItemBean.getCategoryUpdatedDate());

		categoryOfItemUpdateQuery.executeUpdate();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(categoryOfItemBean)) {
			return categoryOfItemBean;
		}
		return categoryOfItemBean;
	}


	/**
	 * inserting updated category details
	 */
	public UpdateCategoryOfItemBean categoryOfItemCreateUpdateDao(SessionFactory sessionFactory, UpdateCategoryOfItemBean updateCategoryOfItemBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(updateCategoryOfItemBean);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(updateCategoryOfItemBean)) {
			return updateCategoryOfItemBean;
		}
		return updateCategoryOfItemBean;
	}


	/**
	 * read category
	 */

	public CategoryOfItemBean categoryOfItemSelectDao(SessionFactory sessionFactory, CategoryOfItemBean categoryOfItemBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		CategoryOfItemBean categoryDetails = (CategoryOfItemBean) session.createCriteria(CategoryOfItemBean.class).add(Restrictions.eq("categoryName", categoryOfItemBean.getCategoryName()))
				.add(Restrictions.eq("categoryStatus","A"))
				.uniqueResult();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(categoryDetails)) {
			return categoryDetails;
		}
		return categoryDetails;
	}

	/**
	 * delete category(updating status)
	 */

	public CategoryOfItemBean categoryOfItemDeleteDao(SessionFactory sessionFactory, CategoryOfItemBean categoryOfItemBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();
		Query categoryOfItemUpdateQuery = session.createQuery("UPDATE CategoryOfItemBean  SET categoryStatus =:categoryStatus where categoryName =:categoryName  ");
		categoryOfItemUpdateQuery.setParameter("categoryStatus", "D");
		categoryOfItemUpdateQuery.setParameter("categoryName", categoryOfItemBean.getCategoryName());
		categoryOfItemUpdateQuery.executeUpdate();
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(categoryOfItemBean)) {
			return categoryOfItemBean;
		}
		return categoryOfItemBean;
	}

	/**
	 * delete category(insertion of deleted category)
	 */

	public DeleteCategoryOfItemBean categoryOfItemCreateDeletedDao(SessionFactory sessionFactory, DeleteCategoryOfItemBean deleteCategoryOfItemBean) {
		session = sessionFactory.openSession();
		session.beginTransaction();


		deleteCategoryOfItemBean.setCategoryDeletedBy(deleteCategoryOfItemBean.getCategoryDeletedBy());


		session.save(deleteCategoryOfItemBean);
		session.getTransaction().commit();
		if (session.isOpen()) {
			session.close();
		}
		if(!Utils.isNullList(deleteCategoryOfItemBean)) {
			return deleteCategoryOfItemBean;
		}
		return deleteCategoryOfItemBean;
	}

}