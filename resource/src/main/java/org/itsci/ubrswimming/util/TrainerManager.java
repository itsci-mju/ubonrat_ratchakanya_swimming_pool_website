package org.itsci.ubrswimming.util;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.ubrswimming.model.RegisterCourse;
import org.itsci.ubrswimming.model.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TrainerManager {
	
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<RegisterCourse> ViewTeachSchedule(String trainer_id){
		Session session = sessionFactory.getCurrentSession();
		Query<RegisterCourse> query = session.createQuery("from RegisterCourse where trainer_id=:trainer_id", RegisterCourse.class);
		query.setParameter("trainer_id", trainer_id);
		List<RegisterCourse> lrc = query.getResultList();
		return lrc;
	}
	
	//--- Trainer --- ListCoursesMember
	@Transactional
	public List<Trainee> ListCoursesMember(String cid){
		Session session = sessionFactory.getCurrentSession();
		Query<Trainee> query = session.createQuery("from Trainee where register_courses_id=:register_courses_id", Trainee.class);
		query.setParameter("register_courses_id", cid);
		List<Trainee> trn = query.getResultList();
		return trn;
	}
}
