package com.vti.dto;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.vti.entity.Mentee;
import com.vti.validation.EmailNotExists;

public class MenteeDTO {
	
	private String userName;
	private String phoneNumber;
	private String email;
//	private List<String> requestTitles;

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

//	public List<String> getRequestTitles() {
//		return requestTitles;
//	}
//
//	public void setRequestTitles(List<String> requestTitles) {
//		this.requestTitles = requestTitles;
//	}
	
//	public MenteeDTO(String userName, String phoneNumber, String email, List<String> requestTitles) {
//		super();
//		this.userName = userName;
//		this.phoneNumber = phoneNumber;
//		this.email = email;
//		this.requestTitles = requestTitles;
//	}

	public MenteeDTO(String userName, String phoneNumber, String email) {
		super();
		this.userName = userName;
		this.phoneNumber = phoneNumber;
		this.email = email;
//		this.requestTitles = requestTitles;
	}

//	public MenteeDTO(List<String> requestTitles) {
//		this.requestTitles = requestTitles;
//	}

}
