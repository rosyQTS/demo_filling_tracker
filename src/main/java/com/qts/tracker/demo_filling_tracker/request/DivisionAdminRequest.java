package com.qts.tracker.demo_filling_tracker.request;



public class DivisionAdminRequest {
	private int divisionAdminId;
	private String fullName;
	private String emailId;
	private String phoneNumber;
	private String divisionName;
	private String password;
	private boolean isEnabled;
	private int companyId;
	
	public DivisionAdminRequest() {
		super();
	}
	public DivisionAdminRequest(int divisionAdminId, String fullName, String emailId, String phoneNumber,
			String divisionName, String password,boolean isEnabled, int companyId) {
		super();
		this.divisionAdminId = divisionAdminId;
		this.fullName = fullName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.divisionName = divisionName;
		this.password = password;
		this.isEnabled = isEnabled;
		this.companyId = companyId;
	}
	public int getDivisionAdminId() {
		return divisionAdminId;
	}
	public void setDivisionAdminId(int divisionAdminId) {
		this.divisionAdminId = divisionAdminId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getDivisionName() {
		return divisionName;
	}
	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
}
