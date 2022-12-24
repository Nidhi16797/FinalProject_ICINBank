package com.icinbank.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class UserLoginDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String userId;
	private String password;

	public UserLoginDetails() {
		super();
	}

	public UserLoginDetails(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + "]";
	}

}
