package com.vyavharamitra.search.dao.implementation;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.vyavharamitra.search.dao.IUnitMeasurementSearchDao;
import com.vyavharamitra.unitofmeasurement.bean.UnitOfMeasurementBean;
import com.vyavharamitra.utils.Utils;

@Repository
public class UnitMeasurementSearchDaoImpl  implements IUnitMeasurementSearchDao {

private Session session;
	
	@SuppressWarnings("unchecked")
	public List<UnitOfMeasurementBean> getUOMDetailsDao(SessionFactory sessionFactory) {
		List<UnitOfMeasurementBean> unitOfMeasurementBean = null;
		try {
			 session = sessionFactory.openSession();
			session.getTransaction().begin();
			unitOfMeasurementBean =(List<UnitOfMeasurementBean>) session.createSQLQuery("select uom_uid,uom_name from bil_uom").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			Utils.logger("Exception : " + e);
		} finally {
			if (session != null &&session.isOpen()) {
				session.close();
			}
		}
		return unitOfMeasurementBean;
	}
}
