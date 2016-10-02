package es.rf.tienda.util;

import org.hibernate.*;
import org.hibernate.cfg.*;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {

		try {
			Configuration config = new Configuration().configure("hibernate.cfg.xml");
			sessionFactory = config.buildSessionFactory();
		} catch (Throwable ex) {
			// Log exception!
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}

	}

	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}

	public static void shutdown() {
		// Close caches and connection pools
		sessionFactory.close();
	}
}