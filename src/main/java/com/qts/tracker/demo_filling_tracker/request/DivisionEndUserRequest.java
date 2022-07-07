package com.qts.tracker.demo_filling_tracker.request;



public class DivisionEndUserRequest {
	private int divEndUserId;
	private String fullName;
	private String mail;
	private String phoneNumber;
	private boolean isEnabled;
	private int companyId;
	private int companyAdminId;
	private int divisionAdminId;
	
	public DivisionEndUserRequest() {
		super();
	}
	public DivisionEndUserRequest(int divEndUserId, String fullName, String mail, String phoneNumber,boolean isEnabled, int companyId,
			int companyAdminId, int divisionAdminId) {
		super();
		this.divEndUserId = divEndUserId;
		this.fullName = fullName;
		this.mail = mail;
		this.phoneNumber = phoneNumber;
		this.isEnabled = isEnabled;
		this.companyId = companyId;
		this.companyAdminId = companyAdminId;
		this.divisionAdminId = divisionAdminId;
	}
	public int getDivEndUserId() {
		return divEndUserId;
	}
	public void setDivEndUserId(int divEndUserId) {
		this.divEndUserId = divEndUserId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	public int getCompanyAdminId() {
		return companyAdminId;
	}
	public void setCompanyAdminId(int companyAdminId) {
		this.companyAdminId = companyAdminId;
	}
	public int getDivisionAdminId() {
		return divisionAdminId;
	}
	public void setDivisionAdminId(int divisionAdminId) {
		this.divisionAdminId = divisionAdminId;
	}

}
