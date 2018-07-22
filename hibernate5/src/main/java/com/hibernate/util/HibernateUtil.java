package com.hibernate.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.domain.Address;
import com.hibernate.domain.Email;
import com.hibernate.domain.Employee;
import com.hibernate.domain.PoLine;
import com.hibernate.domain.PrHeader;
import com.hibernate.domain.PrLine;

public class HibernateUtil {

	public static SessionFactory sessionFactory;

	static {

		ServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure("hibernate.cfg.xml").build();

		Metadata metadata = new MetadataSources(registry)
				// .addAnnotatedClass(PrHeader.class)
				// .addAnnotatedClass(PrLine.class)
				// .addAnnotatedClass(PoLine.class)
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Address.class)
				.addAnnotatedClass(Email.class).buildMetadata();

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
