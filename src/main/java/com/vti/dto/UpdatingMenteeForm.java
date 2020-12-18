package com.vti.dto;

import com.vti.entity.Mentee;

public class UpdatingMenteeForm {

	private String userName;
	private String phoneNumber;
	private String password;
	private String email;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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

	public UpdatingMenteeForm() {
	}
	
	public Mentee toEntity() {
		return new Mentee(userName, password, phoneNumber, email);
	}

}