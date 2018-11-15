package resources;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * @author : Kittu Kiran
 * @created date : 17 Nov 2017
 * @modified by :
 * @modified date :
 */
@SuppressWarnings("unused")
public class HibernateUtil {
	private static final SessionFactory sessionFactory;

	static {
		try {
			Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
			StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
			sb.applySettings(cfg.getProperties());
			StandardServiceRegistry standardServiceRegistry = sb.build();
			sessionFactory = cfg.buildSessionFactory(standardServiceRegistry);
			// Get current session, current session is already associated with
			// Thread
			Session session = sessionFactory.getCurrentSession();
			// Begin transaction, if you would like save your instances, your
			// calling of save must be associated with a transaction

		} catch (Throwable th) {
			System.err.println("Initial SessionFactory creation failed" + th);
			throw new ExceptionInInitializerError(th);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}