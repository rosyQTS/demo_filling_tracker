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
@Table(name="companyAdmin")
public class CompanyAdmin {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int cAdminId;
	private String fullName;
	private String emailId;
	private String phNumber;
	private String password;
	@Column(columnDefinition = "boolean default true")
	private boolean isEnabled;	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_company_id")
	private Company company;
	
		
	public CompanyAdmin(int cAdminId,String fullName, String emailId, String phNumber, String password,boolean isEnabled,Company company) {
		super();
		this.cAdminId = cAdminId;
		this.fullName = fullName;
		this.emailId = emailId;
		this.phNumber = phNumber;
		this.password = password;
		this.company = company;
		this.isEnabled = isEnabled;
	}
	public CompanyAdmin() {
		super();
	}
	@Override
	public String toString() {
		return "CompanyAdmin [cAdminId=" + cAdminId + ", fullName=" + fullName + ", emailId=" + emailId + ", phNumber="
				+ phNumber + ", password=" + password + ", isEnabled=" + isEnabled + ", company=" + company + "]";
	}
	
	
	public int getcAdminId() {
		return cAdminId;
	}
	public void setcAdminId(Integer cAdminId) {
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
	public void setphNumber(String phno) {
		this.phNumber = phNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	
}
