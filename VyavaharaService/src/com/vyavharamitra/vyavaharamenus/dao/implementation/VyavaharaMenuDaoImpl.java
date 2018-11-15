package com.vyavharamitra.vyavaharamenus.dao.implementation;

import java.util.Collections;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.vyavaharamenus.bean.VyavaharaMenuBean;
import com.vyavharamitra.vyavaharamenus.dao.IVyavaharaMenuDao;
import com.vyavharamitra.vyavaharamenus.to.request.VyavaharaMenuRequest;

@Repository
public class VyavaharaMenuDaoImpl implements IVyavaharaMenuDao {
	private Session session;

	@SuppressWarnings("unchecked")
	public List<VyavaharaMenuBean> getMenues(VyavaharaMenuRequest vyavaharaMenuRequest, SessionFactory sessionFactory) {

		List<VyavaharaMenuBean> vyavaharaMenuBean = Collections.emptyList();
		try {
			Session session = sessionFactory.openSession();
			session.getTransaction().begin();
			vyavaharaMenuBean = session.createCriteria(VyavaharaMenuBean.class)
					.add(Restrictions.eq("organizationid",
							vyavaharaMenuRequest.getVyavaharaMenuBean().getOrganizationid()))
					.add(Restrictions.eq("usertype", vyavaharaMenuRequest.getVyavaharaMenuBean().getUsertype()))
					.add(Restrictions.eq("userlevel", vyavaharaMenuRequest.getVyavaharaMenuBean().getUserlevel()))
					.list();
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Exception : " + e);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();

			}
		}
		return vyavaharaMenuBean;
	}

}
