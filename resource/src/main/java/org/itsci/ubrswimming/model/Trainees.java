package org.itsci.ubrswimming.model;

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
@Table (name="trainees")
public class Trainees {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trainees_id")
	private int trainees_id;
	
	@Column(name="name", nullable=false, length=65)
	private String name;
	
	@Column(name="age", nullable=false)
	private int age;
	
	@Column(name="tel", nullable=false, length=10)
	private String tel;
	
	@Column(name="student_gender", nullable=false)
	private int student_gender;

	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="register_courses_id",nullable=false,referencedColumnName="register_courses_id")
	private RegisterCourses register_courses;
	
	public Trainees(int trainees_id, String name, int age, String tel, int student_gender,
					RegisterCourses register_courses) {
		super();
		this.trainees_id = trainees_id;
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.student_gender = student_gender;
		this.register_courses = register_courses;
	}

	


	public Trainees(String name, int age, String tel, int student_gender, RegisterCourses register_courses) {
		super();
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.student_gender = student_gender;
		this.register_courses = register_courses;
	}


	


	public Trainees(String name, int age, String tel, int student_gender) {
		super();
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.student_gender = student_gender;
	}

	public Trainees(int trainees_id, String name, int age, String tel, int student_gender) {
		super();
		this.trainees_id = trainees_id;
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.student_gender = student_gender;
	}



	public int getTrainees_id() {
		return trainees_id;
	}



	public void setTrainees_id(int trainees_id) {
		this.trainees_id = trainees_id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getTel() {
		return tel;
	}



	public void setTel(String tel) {
		this.tel = tel;
	}



	public int getStudent_gender() {
		return student_gender;
	}



	public void setStudent_gender(int student_gender) {
		this.student_gender = student_gender;
	}



	public RegisterCourses getRegister_courses() {
		return register_courses;
	}



	public void setRegister_courses(RegisterCourses register_courses) {
		this.register_courses = register_courses;
	}



	public Trainees() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
