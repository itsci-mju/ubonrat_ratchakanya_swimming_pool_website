package bean;

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
public class trainees {
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
	private register_courses register_courses;
	
	public trainees(int trainees_id, String name, int age, String tel, int student_gender,
			bean.register_courses register_courses) {
		super();
		this.trainees_id = trainees_id;
		this.name = name;
		this.age = age;
		this.tel = tel;
		this.student_gender = student_gender;
		this.register_courses = register_courses;
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



	public register_courses getRegister_courses() {
		return register_courses;
	}



	public void setRegister_courses(register_courses register_courses) {
		this.register_courses = register_courses;
	}



	public trainees() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
