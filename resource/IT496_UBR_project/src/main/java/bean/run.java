package bean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import util.*;

public class run {

    public static void main(String[] args) {
    	HibernateConnection conn = new HibernateConnection();
		SessionFactory sessionFactory = conn.doHibernateConnection();
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();

        t.commit();
        session.close();
        sessionFactory.close();
    }

}
