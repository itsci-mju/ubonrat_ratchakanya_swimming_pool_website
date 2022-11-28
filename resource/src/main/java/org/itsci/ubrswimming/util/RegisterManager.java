package org.itsci.ubrswimming.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.ubrswimming.model.Login;
import org.itsci.ubrswimming.model.Member;
import org.itsci.ubrswimming.model.PoolReservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RegisterManager {
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean verifyEmail(String email) {
		Session session = sessionFactory.getCurrentSession();
		Query<Login> query = session.createQuery("select email from Login where email=:email", Login.class);
		query.setParameter("email", email);
		Login log = query.getSingleResult();
		Boolean i = false;
			if(log.getEmail()==null) {
				i = true;
			}
		return i;
	}
	
//	@Transactional
//	public int insertLogins(Login log) {
//		Session session = sessionFactory.getCurrentSession();
//		String hql = "insert into logins(email,password,status,members_id)"
//					+ "values(:email,:pass,:status,:member_id)";			
//		Query query = session.createQuery(hql);
//		query.setParameter("email", log.getEmail());
//		query.setParameter("pass", log.getPassword());
//		query.setParameter("status", log.getStatus());
//		query.setParameter("member_id", log.getMembers_id());
//	}
	
	@Transactional
	public int saveMember(Member mb) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(mb);
		return 1;
	}
	
	@Transactional
    public List<PoolReservation> getTimeforCourse(String rqdate) {
        Session session = sessionFactory.getCurrentSession();
		String hql = "from PoolReservation"+
					" where (start_time > :rqdate or end_time > :rqdate);"+
					" and status=:status;";
        Query<PoolReservation> query = session.createQuery(hql, PoolReservation.class);
        query.setParameter("rqdate", rqdate);
        query.setParameter("status", 1);
        List<PoolReservation> prs = query.getResultList();
        return prs;
    }
}
