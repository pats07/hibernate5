package com.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.domain.Employee;

public class HibernateUtil {

	public static SessionFactory sessionFactory;

	static {

		ServiceRegistry registry = new StandardServiceRegistryBuilder()
									.configure("hibernate.cfg.xml").build();

		Metadata metadata = new MetadataSources(registry)
							.addAnnotatedClass(Employee.class)
							.buildMetadata();

		try {
			sessionFactory = metadata.getSessionFactoryBuilder().build();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
