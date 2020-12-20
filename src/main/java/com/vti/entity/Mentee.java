package com.vti.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.vti.utils.ScannerUtilMentee;

@Entity
@Table(name = "`Mentee`", catalog = "demomockproject")
public class Mentee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "mentee_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short menteeID;

	@Column(name = "`user_name`", length = 50, nullable = false, unique = true, updatable = false)
	private String userName;

	@Column(name = "`password`", length = 800, nullable = false)
	private String password;

	@Column(name = "`phone_number`", length = 15, nullable = false)
	private String phoneNumber;

	@Column(name = "`email`", length = 50, nullable = false, unique = true)
	private String email;

	@OneToMany(mappedBy = "mentee")
	private List<Request> requests;

	public short getMenteeID() {
		return menteeID;
	}

	public void setMenteeID(short menteeID) {
		this.menteeID = menteeID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Mentee() {
		super();
	}

	public Mentee(short menteeID) {
		this.menteeID = menteeID;
	}

	public Mentee(String userName, String password, String phoneNumber, String email) {
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("UserName (only put in 6 - 50 alphabets, at least one capital letter):");
		userName = ScannerUtilMentee.readUsername(sc, "Please input data as a String! \nPlease input again: ");
		System.out.println("Password: ");
		password=ScannerUtilMentee.readPassword(sc, "Please input data as a String! \nPlease input again: ");
		System.out.println("Phone (only put in 9 to 15 numbers):");
		phoneNumber=ScannerUtilMentee.readPhone(sc, "Please input data as a String! \nPlease input again: ");
		System.out.println("Email (only put in 6 - 50 alphabets, at least one capital letter):");
		email=ScannerUtilMentee.readEmail(sc, "Please input data as a String! \nPlease input again: ");
	}
}

//	@Override
//	public String toString() {
////		for (Request request : requests) {
////			System.out.println(request.getTitle());
////		}
//		return "Mentee [menteeID=" + menteeID + ", userName=" + userName + ", password=" + password + ", phoneNumber="
//				+ phoneNumber + ", email=" + email + "]";
//	}


//	@Override
//	public String toString() {
//		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
//				+ ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + "]";
//	}
//	
//}

//	@Override
//	public String toString() {
//		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password
//				+ ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + "]", creator=" + creator.getGroupId() + "]";
//	}
//
//}
