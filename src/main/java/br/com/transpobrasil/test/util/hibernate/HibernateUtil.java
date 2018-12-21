package br.com.transpobrasil.test.util.hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// Cria um SessionFactory a partir hibernate.cfg.xml
			Configuration configuration = new Configuration();
			configuration.configure();

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();

			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			return sessionFactory;

		} catch (Throwable ex) {
			// Exibe uma mensagem de erro
			System.err.println("Falha ao tentar criar o SessionFactory." + ex.getCause());
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	 public static Session getSession() {
	 Session session = sessionFactory.getCurrentSession();
	 if (session == null) {
	 session = sessionFactory.openSession();
	 }
	 return session;
	 }

	public static void beginTransaction() {
		getSession().beginTransaction();
	}

	public static void commitTransaction() {
		getSession().getTransaction().commit();
	}

	public static void rollBackTransaction() {
		getSession().getTransaction().rollback();
	}

	public static void closeSession() {
		getSession().close();
	}

}
