/**
 * An ADT that is used for new user registration
 */
package com.tom.model;

public class UserBean {
	private String username;
	private String password;
	private String fistName;
	private String lastName;
	
	// Constructors
	public UserBean() {}
	
	public UserBean(String username, String password, String fistName, String lastName) {
		//super();
		this.username = username;
		this.password = password;
		this.fistName = fistName;
		this.lastName = lastName;
	}
	
	// Getters and Setters
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
	public String getFistName() {
		return fistName;
	}
	public void setFistName(String fistName) {
		this.fistName = fistName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "UserBean [username=" + username + ", password=" + password + ", fistName=" + fistName + ", lastName="
				+ lastName + "]";
	}
	
}
