package com.iacsd.employeeManagement.model;

public class User {

	private long id;
	private String userName;
	private String emailId;
    private String password;
	private String mobileNumber;
	private String address;
	
	public User() {
		
	}
	
	public User(long id, String userName, String emailId, String password, String mobileNumber, String address) {
		super();
		this.id = id;
		this.userName = userName;
		this.emailId = emailId;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", emailId=" + emailId + ", password=" + password
				+ ", mobileNumber=" + mobileNumber + ", address=" + address + "]";
	}
}
