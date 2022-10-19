package org.itsci.ubrswimming.bean;

import java.util.Calendar;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="register_courses")
public class register_courses {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="register_courses_id")
	private int register_courses_id;
	
	@Column(name="start_learn",nullable=false)
	private Calendar start_learn;
	
	@Column(name="learn_time",nullable=false,length=45)
	private String learn_time;
	
	@Column(name="learn_type",nullable=false,length=45)
	private String learn_type;
	
	@Column(name="payment_document",nullable=true,length=45)
	private String payment_document;
	
	@Column(name="status", nullable=false)
	private int status;
	
	@Column(name="reason",nullable=true,length=255)
	private String reason;
	
	@Column(name="learn_count", nullable=false)
	private int learn_count;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="members_id",nullable=false,referencedColumnName="members_id")
	private members members;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="courses_id",nullable=false)
	private courses courses_id;

	public register_courses(int register_courses_id, Calendar start_learn, String learn_time, String learn_type,
			String payment_document, int status, String reason, int learn_count, org.itsci.ubrswimming.bean.members members,
			courses courses_id) {
		super();
		this.register_courses_id = register_courses_id;
		this.start_learn = start_learn;
		this.learn_time = learn_time;
		this.learn_type = learn_type;
		this.payment_document = payment_document;
		this.status = status;
		this.reason = reason;
		this.learn_count = learn_count;
		this.members = members;
		this.courses_id = courses_id;
	}

	public int getRegister_courses_id() {
		return register_courses_id;
	}

	public void setRegister_courses_id(int register_courses_id) {
		this.register_courses_id = register_courses_id;
	}

	public Calendar getStart_learn() {
		return start_learn;
	}

	public void setStart_learn(Calendar start_learn) {
		this.start_learn = start_learn;
	}

	public String getLearn_time() {
		return learn_time;
	}

	public void setLearn_time(String learn_time) {
		this.learn_time = learn_time;
	}

	public String getLearn_type() {
		return learn_type;
	}

	public void setLearn_type(String learn_type) {
		this.learn_type = learn_type;
	}

	public String getPayment_document() {
		return payment_document;
	}

	public void setPayment_document(String payment_document) {
		this.payment_document = payment_document;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getLearn_count() {
		return learn_count;
	}

	public void setLearn_count(int learn_count) {
		this.learn_count = learn_count;
	}

	public members getMembers() {
		return members;
	}

	public void setMembers(members members) {
		this.members = members;
	}

	public courses getCourses_id() {
		return courses_id;
	}

	public void setCourses_id(courses courses_id) {
		this.courses_id = courses_id;
	}

	

}
