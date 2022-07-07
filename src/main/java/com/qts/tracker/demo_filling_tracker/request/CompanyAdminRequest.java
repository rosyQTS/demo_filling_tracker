package com.qts.tracker.demo_filling_tracker.request;



public class CompanyAdminRequest {
	private int cAdminId;
	private String fullName;
	private String emailId;
	private String phNumber;
	private String password;
	private boolean isEnabled;
	private int companyId;
	
	public CompanyAdminRequest(int cAdminId, String fullName, String emailId, String phNumber, String password,
			boolean isEnabled, int companyId) {
		super();
		this.cAdminId = cAdminId;
		this.fullName = fullName;
		this.emailId = emailId;
		this.phNumber = phNumber;
		this.password = password;
		this.isEnabled = isEnabled;
		this.companyId = companyId;
	}
	public int getcAdminId() {
		return cAdminId;
	}
	public void setcAdminId(int cAdminId) {
		this.cAdminId = cAdminId;
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
	public String getphNumber() {
		return phNumber;
	}
	public void setPhno(String phno) {
		this.phNumber = phNumber;
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
	public int getcompanyId() {
		return companyId;
	}
	public void setcompanyId(int companyId) {
		this.companyId = companyId;
	}
	
	
}
