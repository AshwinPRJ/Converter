package com.vyavharamitra.search.dao.implementation;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.categoryofitem.bean.CategoryOfItemBean;
import com.vyavharamitra.search.dao.ICategoryDetailsSearchDao;
import com.vyavharamitra.utils.Utils;

@Repository
public class CategoryDetailsSearchDaoImpl implements ICategoryDetailsSearchDao {

private Session session;
	
	@SuppressWarnings("unchecked")
	public List<CategoryOfItemBean> getCategoryDetailsDao (SessionFactory sessionFactory) {
		List<CategoryOfItemBean> categoryOfItemBeanlist = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			categoryOfItemBeanlist =(List<CategoryOfItemBean>) session.createSQLQuery("select ctoi_cid,ctoi_cname,ctoi_sgst,ctoi_cgst,ctoi_igst from bil_ctoi where ctoi_status='A' ").list();

			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();
				
			}
		}
		if(!Utils.isNullList(categoryOfItemBeanlist))
		{
			return categoryOfItemBeanlist;
		}
		return categoryOfItemBeanlist;
	}
}
