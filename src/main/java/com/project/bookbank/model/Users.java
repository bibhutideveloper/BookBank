package com.project.bookbank.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="USERS")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="USER_ID")
	private Integer userId;
	
//	@NotBlank(message="Username is rquired")
	@Column(name="USER_NAME")
	private String userName;
	
//	@NotBlank(message="Email is required")
//	@Email(message="Invalid email format")
	@Column(name="USER_EMAIL")
	private String userEmail;
	
//	@NotBlank(message="Contact is required")
//	@Column(name="USER_CONTACT")
	private String userContact;
	
//	@NotBlank(message="Password is required")
	@Column(name="USER_PASSWORD")
	private String userPassword;
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserContact() {
		return userContact;
	}

	public void setUserContact(String userContact) {
		this.userContact = userContact;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", userContact="
				+ userContact + ", userPassword=" + userPassword + "]";
	}

}
