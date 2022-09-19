package com.dynamic.entities;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class LoginData {
	
	@NotBlank(message="User Name cannot be empty...!")
	@Size(min=3,max=20,message="UserNamec must be inj between 3-20")
	private String userName;
	private String email;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "LoginData [userName=" + userName + ", email=" + email + "]";
	}
	
	
	

}
