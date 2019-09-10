package com.MRBSBooking.Bean;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="Login")
//This is the main Login Table. This table is used for Validation.
public class LoginBean {
	@Id
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@NotNull
	private String password;
	@NotNull
	private String role;
	@Override
	public String toString() {
		return "LoginBean [username=" + username + ", password=" + password + ", role=" + role + "]";
	}	
	
	
}
