package com.qts.tracker.demo_filling_tracker.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="division_admin_tab")
public class DivisionAdmin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int divisionAdminId;
	private String fullName;
	private String emailId;
	private String phoneNumber;
	private String divisionName;
	private String password;
	@Column(columnDefinition = "boolean default true")
	private boolean isEnabled;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_company_id")
	private Company company;
	
		

	public DivisionAdmin(int divisionAdminId,String fullName, String emailId, String phoneNumber, String divisionName,
			String password,boolean isEnabled, Company company) {
		super();
		this.divisionAdminId = divisionAdminId;
		this.fullName = fullName;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.divisionName = divisionName;
		this.password = password;
		this.isEnabled = isEnabled;
		this.company = company;
	}
	
	public DivisionAdmin() {
		super();
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
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}

	

}
