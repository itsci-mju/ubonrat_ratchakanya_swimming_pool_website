package org.itsci.ubrswimming.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.itsci.ubrswimming.model.PoolReservation;
import org.itsci.ubrswimming.model.PoolUsage;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JameManager {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<PoolUsage> getListRequestUsePool_memid() {
        Session session = sessionFactory.getCurrentSession();
        Query<PoolUsage> query = session.createQuery("from PoolUsage", PoolUsage.class);
        List<PoolUsage> pslist = query.getResultList();
        return pslist;
    }

    /*เอาราคารวมมาแสดง*/
    public String getSumPrice() {
        Session session = sessionFactory.getCurrentSession();
        Query<Integer> query = session.createQuery("select sum(price) from PoolUsage", Integer.class);
        Integer sumPrice = query.getSingleResult();
        return sumPrice.toString();
    }

    /*รวมจำนวนผู้ใช้*/
    public String getSumAmount() {
        Session session = sessionFactory.getCurrentSession();
        Query<Integer> query = session.createQuery("select sum(amount) from PoolUsage", Integer.class);
        Integer sumAmount = query.getSingleResult();
        return sumAmount.toString();
    }

    //Calendar
    @Transactional
    public List<PoolReservation> getPool_reservationsCalendar() {
        Session session = sessionFactory.getCurrentSession();
        Query<PoolReservation> query = session.createQuery("from PoolReservation p where p.status=:status", PoolReservation.class);
        query.setParameter("status", 1);
        List<PoolReservation> prs = query.getResultList();
        return prs;
    }
}
