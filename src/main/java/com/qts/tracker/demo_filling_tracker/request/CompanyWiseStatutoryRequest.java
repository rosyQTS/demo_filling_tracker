package com.qts.tracker.demo_filling_tracker.request;

import java.util.List;

import javax.persistence.Column;

public class CompanyWiseStatutoryRequest {
	private int companyWiseStatutoryId;
	private int companyId;
	private List<Integer> statutoryId;
	@Column(columnDefinition = "boolean default true")
	private boolean isEnabled;
	public int getCompanyWiseStatutoryId() {
		return companyWiseStatutoryId;
	}
	public void setCompanyWiseStatutoryId(int companyWiseStatutoryId) {
		this.companyWiseStatutoryId = companyWiseStatutoryId;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	public List<Integer> getStatutoryId() {
		return statutoryId;
	}
	public void setStatutoryId(List<Integer> statutoryId) {
		this.statutoryId = statutoryId;
	}
	public boolean isEnabled() {
		return isEnabled;
	}
	public CompanyWiseStatutoryRequest() {
		super();
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public CompanyWiseStatutoryRequest(int companyWiseStatutoryId, int companyId, List<Integer> statutoryId,
			boolean isEnabled) {
		super();
		this.companyWiseStatutoryId = companyWiseStatutoryId;
		this.companyId = companyId;
		this.statutoryId = statutoryId;
		this.isEnabled = isEnabled;
	}
	public CompanyWiseStatutoryRequest(int companyId, List<Integer> statutoryId, boolean isEnabled) {
		super();
		this.companyId = companyId;
		this.statutoryId = statutoryId;
		this.isEnabled = isEnabled;
	}
	@Override
	public String toString() {
		return "CompanyWiseStatutoryRequest [companyWiseStatutoryId=" + companyWiseStatutoryId + ", companyId="
				+ companyId + ", statutoryId=" + statutoryId + ", isEnabled=" + isEnabled + "]";
	}
	
	
	
}
