package org.itsci.ubrswimming.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.ubrswimming.model.Login;
import org.itsci.ubrswimming.model.Member;
import org.itsci.ubrswimming.model.PoolReservation;
import org.itsci.ubrswimming.model.PoolUsage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class RequestManager {
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public int addRequestToUse(PoolReservation pool){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(pool);
		return 1;
	}
	
	@Transactional
	public List<PoolReservation> getListRequestUsePool(){
		Session session = sessionFactory.getCurrentSession();
		Query<PoolReservation> query = session.createQuery("from PoolReservation p where p.status=:status", PoolReservation.class);
		query.setParameter("status", 0);
		List<PoolReservation> pslist = query.getResultList();
		return pslist;
	}
	
	@Transactional
	public int updateRequestToUse_manager(PoolReservation pool) {
		Session session = sessionFactory.getCurrentSession();
		Query<PoolReservation> query = session.createQuery("update PoolReservation p set p.price=:price, status=:status", PoolReservation.class);
		query.setParameter("price", pool.getPrice());
		query.setParameter("status", pool.getStatus());
		int result = query.executeUpdate();
		return result;
	}
	
	// record_usage ------------------->
	@Transactional
	public int recordUsageService_mem(PoolUsage pus){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(pus);
		return 1;
	}
	
	@Transactional
	public int recordUsageService_non(PoolUsage pus){
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(pus);
		return 1;
	}
	
	@Transactional
	public List<PoolReservation> getListRequestUsePool_memid(String memid){
		Session session = sessionFactory.getCurrentSession();
		Query<PoolReservation> query = session.createQuery("from PoolReservation p where p.members_id=:members_id", PoolReservation.class);
		query.setParameter("members_id", memid);
		List<PoolReservation> pslist = query.getResultList();
		return pslist;
	}
	
	@Transactional
	public PoolReservation getRequestUsePoolReturn(String id){
		Session session = sessionFactory.getCurrentSession();
		Query<PoolReservation> query = session.createQuery("from PoolReservation p where p.pool_reservations_id=:id", PoolReservation.class);
		query.setParameter("id", id);
		PoolReservation pool = query.getSingleResult();
		return pool;
	}

	@Transactional
	public int acceptReservation(String pid) {
		Session session = sessionFactory.getCurrentSession();
		Query<PoolReservation> query = session.createQuery("update PoolReservation p set p.status=:status where pool_reservations_id=:pool_reservations_id", PoolReservation.class);
		query.setParameter("pool_reservations_id", pid);
		query.setParameter("status", 1);
		int result = query.executeUpdate();
		return result;
	}

	@Transactional
	public int deleteReservation(String pid) {
		Session session = sessionFactory.getCurrentSession();
		Query<PoolReservation> query = session.createQuery("delete from PoolReservation where  pool_reservations_id =:pool_reservations_id", PoolReservation.class);
		query.setParameter("pool_reservations_id", pid);
		int result = query.executeUpdate();
		return result;
	}
	
}
