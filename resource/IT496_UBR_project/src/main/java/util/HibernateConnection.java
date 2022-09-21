package util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import bean.*;

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
							.addAnnotatedClass(logins.class)
							.addAnnotatedClass(members.class)
							.addAnnotatedClass(courses.class)
							.addAnnotatedClass(register_courses.class)
							.addAnnotatedClass(trainees.class)
							.addAnnotatedClass(pool_usage.class)
							.addAnnotatedClass(pool_reservations.class)
							;
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		sessionFactory = cfg.buildSessionFactory(ssrb.build());
		return sessionFactory;
	}
}
