package com.qts.tracker.demo_filling_tracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DivisionEndUserTab")
public class DivisionEndUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int divEndUserId;
	private String fullName;
	private String mail;
	private String phoneNumber;
	@Column(columnDefinition = "boolean default true")
	private boolean isEnabled;	

	@ManyToOne
	@JoinColumn(name="fk_company_id")
	private Company company;
	
	@ManyToOne
	@JoinColumn(name="fk_c_admin_id")
	private CompanyAdmin companyAdmin;
	
	@ManyToOne
	@JoinColumn(name="fk_division_admin_id")
	private DivisionAdmin divisionAdmin;
	
	

	public DivisionEndUser() {
		super();
	}

	public DivisionEndUser(int divEndUserId, String fullName, String mail, String phoneNumber,boolean isEnabled, Company company,
			CompanyAdmin companyAdmin, DivisionAdmin divisionAdmin) {
		super();
		this.divEndUserId = divEndUserId;
		this.fullName = fullName;
		this.mail = mail;
		this.phoneNumber = phoneNumber;
		this.company = company;
		this.companyAdmin = companyAdmin;
		this.divisionAdmin = divisionAdmin;
		this.isEnabled = isEnabled;
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


	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public CompanyAdmin getCompanyAdmin() {
		return companyAdmin;
	}

	public void setCompanyAdmin(CompanyAdmin companyAdmin) {
		this.companyAdmin = companyAdmin;
	}

	public DivisionAdmin getDivisionAdmin() {
		return divisionAdmin;
	}

	public void setDivisionAdmin(DivisionAdmin divisionAdmin) {
		this.divisionAdmin = divisionAdmin;
	}


	
	
	

}
