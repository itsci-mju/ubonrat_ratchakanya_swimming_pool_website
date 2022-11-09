package org.itsci.ubrswimming.model;
import java.util.Calendar;

import javax.persistence.*;

@Entity
@Table (name="members")
public class Member {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="member_id",nullable=false,referencedColumnName="member_id")
	private Login login;
	
	@Column(name="firstname",nullable=false,length=30)
	private String firstname;
	
	@Column(name="lastname",nullable=false,length=30)
	private String lastname;
	
	@Column(name="gender",nullable=false,length=10)
	private String gender;
	
	@Column(name="phone",nullable=false,length=10)
	private String phone;
	
	@Column(name="birthdate",nullable=false)
	private Calendar birthdate;
	
	@Column(name="member_type",nullable=false,length=45)
	private int member_type;
	
	@Column(name="address",nullable=false,length=255)
	private String address;
	
	@Column(name="sub_districts",nullable=false,length=255)
	private String sub_districts;
	
	@Column(name="districts",nullable=false,length=255)
	private String districts;
	
	@Column(name="province",nullable=false,length=255)
	private String province;
	
	@Column(name="post_code",nullable=false,length=5)
	private String post_code;
	
	@Column(name="pid",nullable=true,length=13)
	private String pid;
	
	@Column(name="emergency_name",nullable=true,length=100)
	private String emergency_name;
	
	@Column(name="emergency_phone",nullable=true,length=10)
	private String emergency_phone;
	
	@Column(name="image",nullable=true,length=50)
	private String image;
	
	@Column(name="stuid",nullable=true,length=10)
	private String stuid;
	
	@Column(name="faculty",nullable=true,length=45)
	private String faculty;
	
	@Column(name="stu_card",nullable=true,length=15)
	private String stu_card;
	
	@Column(name="affiliation",nullable=true,length=50)
	private String affiliation;
	
	@Column(name="officer_card",nullable=true,length=45)
	private String officer_card;
	
	@Column(name="marriage_cer",nullable=true,length=45)
	private String marriage_cer;
	
	@Column(name="pid_card",nullable=true,length=45)
	private String pid_card;
	
	@Column(name="alumni_card",nullable=true,length=45)
	private String alumni_card;

	

	public Member(Login login, String firstname, String lastname, String gender, String phone,
			Calendar birthdate, int member_type, String address, String sub_districts, String districts,
			String province, String post_code, String pid, String emergency_name, String emergency_phone, String image,
			String stuid, String faculty, String stu_card, String affiliation, String officer_card, String marriage_cer,
			String pid_card, String alumni_card) {
		super();
		this.login = login;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gender = gender;
		this.phone = phone;
		this.birthdate = birthdate;
		this.member_type = member_type;
		this.address = address;
		this.sub_districts = sub_districts;
		this.districts = districts;
		this.province = province;
		this.post_code = post_code;
		this.pid = pid;
		this.emergency_name = emergency_name;
		this.emergency_phone = emergency_phone;
		this.image = image;
		this.stuid = stuid;
		this.faculty = faculty;
		this.stu_card = stu_card;
		this.affiliation = affiliation;
		this.officer_card = officer_card;
		this.marriage_cer = marriage_cer;
		this.pid_card = pid_card;
		this.alumni_card = alumni_card;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Calendar getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Calendar birthdate) {
		this.birthdate = birthdate;
	}

	public int getMember_type() {
		return member_type;
	}

	public void setMember_type(int member_type) {
		this.member_type = member_type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getEmergency_name() {
		return emergency_name;
	}

	public void setEmergency_name(String emergency_name) {
		this.emergency_name = emergency_name;
	}

	public String getEmergency_phone() {
		return emergency_phone;
	}

	public void setEmergency_phone(String emergency_phone) {
		this.emergency_phone = emergency_phone;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStuid() {
		return stuid;
	}

	public void setStuid(String stuid) {
		this.stuid = stuid;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getStu_card() {
		return stu_card;
	}

	public void setStu_card(String stu_card) {
		this.stu_card = stu_card;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

	public String getOfficer_card() {
		return officer_card;
	}

	public void setOfficer_card(String officer_card) {
		this.officer_card = officer_card;
	}

	public String getMarriage_cer() {
		return marriage_cer;
	}

	public void setMarriage_cer(String marriage_cer) {
		this.marriage_cer = marriage_cer;
	}

	public String getPid_card() {
		return pid_card;
	}

	public void setPid_card(String pid_card) {
		this.pid_card = pid_card;
	}

	public String getAlumni_card() {
		return alumni_card;
	}

	public void setAlumni_card(String alumni_card) {
		this.alumni_card = alumni_card;
	}
	
	

	public String getSub_districts() {
		return sub_districts;
	}

	public void setSub_districts(String sub_districts) {
		this.sub_districts = sub_districts;
	}

	public String getDistricts() {
		return districts;
	}

	public void setDistricts(String districts) {
		this.districts = districts;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPost_code() {
		return post_code;
	}

	public void setPost_code(String post_code) {
		this.post_code = post_code;
	}

	public Member() {
		// TODO Auto-generated constructor stub
	}

}

