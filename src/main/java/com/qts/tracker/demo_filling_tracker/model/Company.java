package com.qts.tracker.demo_filling_tracker.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String cname;
	private String ctype;
	private String cRegisterdAddress;
	private String cOperationalAddress;
	@Column(columnDefinition = "boolean default true")
	private boolean isEnabled;
	@CreationTimestamp
	private LocalDateTime insertedAt;
	@Column(columnDefinition = "LONGTEXT")
	private String cLogo;


	

	public Company(Integer cid, String cname, String ctype, String cRegisterdAddress,
			String cOperationalAddress,boolean isEnabled,LocalDateTime insertedAt,String cLogo) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.ctype = ctype;
		this.cRegisterdAddress = cRegisterdAddress;
		this.cOperationalAddress = cOperationalAddress;
		this.isEnabled = isEnabled;
		this.insertedAt = insertedAt;
		this.cLogo = cLogo;
	}
	
	public Company() {
		super();
	}

	@Override
	public String toString() {
		return "Company [cid=" + cid + ", cname=" + cname + ", ctype=" + ctype + ", cRegisterdAddress="
				+ cRegisterdAddress + ", cOperationalAddress=" + cOperationalAddress + ", isEnabled=" + isEnabled
				+ ", insertedAt=" + insertedAt + ", cLogo=" + cLogo + "]";
	}

	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getcRegisterdAddress() {
		return cRegisterdAddress;
	}
	public void setcRegisterdAddress(String cRegisterdAddress) {
		this.cRegisterdAddress = cRegisterdAddress;
	}
	public String getcOperationalAddress() {
		return cOperationalAddress;
	}
	public void setcOperationalAddress(String cOperationalAddress) {
		this.cOperationalAddress = cOperationalAddress;
	}
	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public boolean isEnabled() {
		return isEnabled;
	}
	public LocalDateTime getInsertedAt() {
		return insertedAt;
	}

	public void setInsertedAt(LocalDateTime insertedAt) {
		this.insertedAt = insertedAt;
	}
	public String getcLogo() {
		return cLogo;
	}

	public void setcLogo(String cLogo) {
		this.cLogo = cLogo;
	}

	
	
	

	
	
}
