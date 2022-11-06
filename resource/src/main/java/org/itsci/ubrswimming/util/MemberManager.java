package org.itsci.ubrswimming.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.ubrswimming.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberManager {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public Login verifyLoginWEB(String em, String pw){
		Session session = sessionFactory.getCurrentSession();
		Query<Login> query = session.createQuery("from Login l where l.email=:email", Login.class);
		query.setParameter("email", em);
		Login l = query.getSingleResult();
		return l;
	}
	
	@Transactional
	public Login getStatusfromLogin(String mid){
		Session session = sessionFactory.getCurrentSession();
		Query<Login> query = session.createQuery("select members_id,status from Login where members_id=:members_id", Login.class);
		query.setParameter("members_id", mid);
		Login l = query.getSingleResult();
		return l;
	}
	
	@Transactional
	public Member getmtypefromMember(String mid) {
		Session session = sessionFactory.getCurrentSession();
		Query<Member> query = session.createQuery("select members_id,member_type from Member where members_id =:members_id", Member.class);
		query.setParameter("members_id", mid);
		Member mb = query.getSingleResult();
		return mb;
	}
	
	@Transactional
	public Login getLogin(String mid) {
		Session session = sessionFactory.getCurrentSession();
		Query<Login> query = session.createQuery("from Login where members_id=:members_id", Login.class);
		query.setParameter("members_id", mid);
		Login l = query.getSingleResult();
		return l;
	}
	
	@Transactional
	public Member getmember(String memID) {
		Session session = sessionFactory.getCurrentSession();
		Query<Member> query = session.createQuery("from Member where members_id=:members_id", Member.class);
		query.setParameter("members_id", memID);
		Member mb = query.getSingleResult();
		return mb;
	}
}
