package org.itsci.ubrswimming.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.itsci.ubrswimming.model.*;

public class HibernateConnection {
	public static SessionFactory sessionFactory;
	
	public static SessionFactory doHibernateConnection(){
		Properties database = new Properties();
		database.setProperty("hibernate.hbm2ddl.auto", "create");
		database.setProperty("hibernate.connection.driver_class","com.mysql.jdbc.Driver");
		database.setProperty("hibernate.connection.username","root");
		database.setProperty("hibernate.connection.password","12345678");
		database.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/it496_ubr?characterEncoding=UTF-8");
		database.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		Configuration cfg = new Configuration()
							.setProperties(database)
							.addPackage("bean")
							.addAnnotatedClass(Login.class)
							.addAnnotatedClass(Members.class)
							.addAnnotatedClass(Courses.class)
							.addAnnotatedClass(RegisterCourses.class)
							.addAnnotatedClass(Trainees.class)
							.addAnnotatedClass(PoolUsage.class)
							.addAnnotatedClass(PoolReservations.class)
							;
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		sessionFactory = cfg.buildSessionFactory(ssrb.build());
		return sessionFactory;
	}
}
