package org.itsci.ubrswimming.bean;

import javax.persistence.*;

@Entity
@Table (name="logins")
public class logins {
	@Id
	@Column(name="email", length=50)
	private String email;
	
	@Column(name="password", nullable=false, length=16)
	private String password;
	
	@Column(name="status", nullable=false)
	private int status;
	
	@Column(name="members_id", length=13,nullable=false, unique = true)
	private String members_id;
	/*
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="members_id",nullable=false)
	private members members_id;
 	*/

	public logins() {
		super();
		// TODO Auto-generated constructor stub
	}
	public logins(String email, String password, int status, String members_id) {
		super();
		this.email = email;
		this.password = password;
		this.status = status;
		this.members_id = members_id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMembers_id() {
		return members_id;
	}
	public void setMembers_id(String member_id) {
		this.members_id = member_id;
	}
	
	

}

