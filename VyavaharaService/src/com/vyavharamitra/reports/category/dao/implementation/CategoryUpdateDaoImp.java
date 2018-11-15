package com.vyavharamitra.reports.category.dao.implementation;

import java.util.Collections;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.vyavharamitra.categoryofitem.bean.DeleteCategoryOfItemBean;
import com.vyavharamitra.categoryofitem.bean.UpdateCategoryOfItemBean;
import com.vyavharamitra.reports.category.dao.ICategoryUpdateDao;
import com.vyavharamitra.reports.category.to.request.CategoryUpdateRequest;
import com.vyavharamitra.utils.Utils;

/**
 * @author : Lavanya
 * @created date :18 Dec 2017
 * @modified by :
 * @modified date :
 */

@Repository
public class CategoryUpdateDaoImp implements ICategoryUpdateDao {

	private Session session;
	/**
	 * Category Update Read
	 */
	@SuppressWarnings("unchecked")
	public List<UpdateCategoryOfItemBean> categoryDao(SessionFactory sessionFactory, String categoryName) {
		List<UpdateCategoryOfItemBean> categoryOfItemList = Collections.emptyList();
		try {
			 session = sessionFactory.openSession();
			Criteria categoryOfItemDetails = session.createCriteria(UpdateCategoryOfItemBean.class)
					.add(Restrictions.eq("categoryName", categoryName));
			categoryOfItemList = categoryOfItemDetails.list();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		}
		if(!Utils.isNullList(categoryOfItemList))
		{
			return categoryOfItemList;
		}
		return categoryOfItemList;
	}

	/**
	 * Category Delete Read
	 */
	@SuppressWarnings("unchecked")
	public List<DeleteCategoryOfItemBean> categoryDeleteReadDao(SessionFactory sessionFactory,
			CategoryUpdateRequest categoryUpdateRequest) {
		List<DeleteCategoryOfItemBean> deleteCategoryOfItemBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			String orderby=categoryUpdateRequest.getDeleteCategoryOfItemBean().getOrderby();
			deleteCategoryOfItemBean =(List<DeleteCategoryOfItemBean>) session.createSQLQuery("SELECT delctoi_cid,delctoi_cname,delctoi_sgst,delctoi_cgst,delctoi_igst, to_char(delctoi_eon,'DD Mon YYYY') as  delctoi_eon,delctoi_eby,delctoi_etime,delctoi_delby, to_char(delctoi_delon,'DD Mon YYYY') as delctoi_delon,delctoi_deltime  FROM bil_delctoi   order by "+ orderby + " ").list();

			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();

			}
		}
		if(!Utils.isNullList(deleteCategoryOfItemBean)){
			return deleteCategoryOfItemBean;
		}
		return deleteCategoryOfItemBean;
	}


}