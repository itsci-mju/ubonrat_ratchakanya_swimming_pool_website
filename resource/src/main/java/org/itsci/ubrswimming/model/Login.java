package org.itsci.ubrswimming.model;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name="logins")
public class Login implements UserDetails {
	@Id
	@Column(name="email", length=50)
	private String email;
	
	@Column(name="password", nullable=false, length=255)
	private String password;
	
	@Column(name="status", nullable=false)
	private int status;
	
	@Column(name="member_id", length=13,nullable=false, unique = true)
	private String member_id;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
	@JoinTable(name = "login_authority",
			joinColumns= { @JoinColumn(name = "login_id")},
			inverseJoinColumns= { @JoinColumn(name = "authority_id")})
	private Set<Authority> authorities = new HashSet<>();
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String email, String password, int status, String member_id) {
		super();
		this.email = email;
		this.password = password;
		this.status = status;
		this.member_id = member_id;
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

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
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
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public Set<Authority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
}

