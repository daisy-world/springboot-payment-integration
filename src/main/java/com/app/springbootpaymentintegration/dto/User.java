package com.app.springbootpaymentintegration.dto;

public class User {
	
	private String firstName ;
	private String lastName ;
	private String userEmail ;
	private String userPass ;
	private String userConfirmPass ;
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserConfirmPass() {
		return userConfirmPass;
	}
	public void setUserConfirmPass(String userConfirmPass) {
		this.userConfirmPass = userConfirmPass;
	}
	
	

}
