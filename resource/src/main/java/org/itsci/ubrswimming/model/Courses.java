package org.itsci.ubrswimming.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="courses")
public class Courses {
	@Id
	@Column(name="courses_id")
	private int courses_id;
	
	@Column(name="courses_name", nullable=false, length=45)
	private String courses_name;
	
	@Column(name="description", nullable=true, length=255)
	private String description;
	
	@Column(name="price", nullable=false)
	private int price;
	
	@Column(name="max_day", nullable=false)
	private int max_day;
	
	@Column(name="courses_type", nullable=false, length=45)
	private String courses_type;

	public Courses(int courses_id, String courses_name, String description, int price, int max_day,
				   String courses_type) {
		super();
		this.courses_id = courses_id;
		this.courses_name = courses_name;
		this.description = description;
		this.price = price;
		this.max_day = max_day;
		this.courses_type = courses_type;
	}

	
	



	public Courses(int price, String courses_name2, String description2, int price2, int max_day2, String courses_type2, RegisterCourses rc2) {
		super();
		
	}


	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCourses_id() {
		return courses_id;
	}

	public void setCourses_id(int courses_id) {
		this.courses_id = courses_id;
	}

	public String getCourses_name() {
		return courses_name;
	}

	public void setCourses_name(String courses_name) {
		this.courses_name = courses_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getMax_day() {
		return max_day;
	}

	public void setMax_day(int max_day) {
		this.max_day = max_day;
	}

	public String getCourses_type() {
		return courses_type;
	}

	public void setCourses_type(String courses_type) {
		this.courses_type = courses_type;
	}





	//เพิ่มมา
	public void setCourses_id(RegisterCourses rc) {
		// TODO Auto-generated method stub
		
	}
	//เพิ่มมา
	
}
