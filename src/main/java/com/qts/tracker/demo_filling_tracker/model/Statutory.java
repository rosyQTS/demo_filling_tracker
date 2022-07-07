package com.qts.tracker.demo_filling_tracker.model;




import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="statutory")
public class Statutory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int statutoryId;
	private String statutoryName;
	private String frequency;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date lastDate;
	@Column(columnDefinition = "boolean default true")
	private boolean isEnabled;
	

	@CreationTimestamp
	private LocalDateTime insertedAt;
	
	
	public Statutory(int statutoryId, String statutoryName, String frequency, Date lastDate,boolean isEnabled, LocalDateTime insertedAt) {
		super();
		this.statutoryId = statutoryId;
		this.statutoryName = statutoryName;
		this.frequency = frequency; 
		this.lastDate = lastDate;
		this.isEnabled = isEnabled;
		this.insertedAt = insertedAt;
	}
	
	public Statutory() {
		super();
	}
	
	public int getStatutoryId() {
		return statutoryId;
	}
	public void setStatutoryId(int statutoryId) {
		this.statutoryId = statutoryId;
	}
	public String getStatutoryName() {
		return statutoryName;
	}
	public void setStatutoryName(String statutoryName) {
		this.statutoryName = statutoryName;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public Date getLastDate() {
		return lastDate;
	}
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public LocalDateTime getInsertedAt() {
		return insertedAt;
	}

	public void setInsertedAt(LocalDateTime insertedAt) {
		this.insertedAt = insertedAt;
	}
	public boolean isEnabled() {
		return isEnabled;
	}

	public void setEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	

}
