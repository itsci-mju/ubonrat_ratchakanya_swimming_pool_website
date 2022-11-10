package org.itsci.ubrswimming.model;

public class General extends Member{

	private Login email;
	private Login password;
	
	public Login getEmail() {
		return email;
	}
	public void setEmail(Login email) {
		this.email = email;
	}
	public Login getPassword() {
		return password;
	}
	public void setPassword(Login password) {
		this.password = password;
	}
	
}
