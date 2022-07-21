package com.qts.tracker.demo_filling_tracker.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class CompanyWiseStatutory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int companyWiseStatutoryId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fk_company_id")
	private Company company;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="fk_statutory_id")
	private Statutory statutory ;
	@Column(columnDefinition = "boolean default true")
	private boolean isEnabled;
	public boolean isEnabled() {
		return isEnabled;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public int getCompanyWiseStatutoryId() {
		return companyWiseStatutoryId;
	}
	public void setCompanyWiseStatutoryId(int companyWiseStatutoryId) {
		this.companyWiseStatutoryId = companyWiseStatutoryId;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public Statutory getStatutory() {
		return statutory;
	}
	public void setStatutory(Statutory statutory) {
		this.statutory = statutory;
	}
//	public boolean isEnabled() {
//		return isEnabled;
//	}
//	public void setEnabled(boolean isEnabled) {
//		this.isEnabled = isEnabled;
//	}
	public CompanyWiseStatutory(int companyWiseStatutoryId, Company company, Statutory statutory, boolean isEnabled) {
		super();
		this.companyWiseStatutoryId = companyWiseStatutoryId;
		this.company = company;
		this.statutory = statutory;
		this.isEnabled = isEnabled;
	}
	public CompanyWiseStatutory(Company company, Statutory statutory, boolean isEnabled) {
		super();
		this.company = company;
		this.statutory = statutory;
		this.isEnabled = isEnabled;
	}
	public CompanyWiseStatutory() {
		super();
	}
	@Override
	public String toString() {
		return "CompanyWiseStatutory [companyWiseStatutoryId=" + companyWiseStatutoryId + ", company=" + company
				+ ", statutory=" + statutory + ", isEnabled=" + isEnabled + "]";
	}
	
				
}
