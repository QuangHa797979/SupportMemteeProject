package com.vti.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//import org.hibernate.validator.constraints.Length;

import com.vti.entity.Mentee;
import com.vti.validation.EmailNotExists;

public class CreatingMenteeForm {
	
	@NotBlank(message = "{CreateDto.name.NotBlank}")
	@EmailNotExists(message = "{CreateDto.name.NameNotExist}")
	@Size(min = 6, max = 50, message = "{CreateDto.name.Size}")
	private String userName;
	
	@NotBlank(message = "{CreateDto.name.NotBlank}")
	@Size(min = 9, max = 15, message = "{CreateDto.name.Size}")
	private String phoneNumber;
	
	@NotBlank(message = "{CreateDto.name.NotBlank}")
	@Size(max = 800, message = "{CreateDto.name.Size}")
	private String password;
	
	@NotBlank(message = "{CreateDto.name.NotBlank}")
	@Size(min = 6, max = 50, message = "{CreateDto.name.Size}")
	@Email(message = "Email ko đúng định dạng")
	@EmailNotExists(message = "{CreateDto.name.NameNotExist}")
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

	public CreatingMenteeForm() {
	}

	public Mentee toEntity() {
		return new Mentee(userName, password, phoneNumber, email);
	}
}
