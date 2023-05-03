package com.interland.blooddonationmanagement.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "blood")
public class BloodDonation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "donorName")
	private String donorName;

	@Column(name = "donorAge")
	private int donorAge;

	@Column(name = "phoneNumber")
	private long phoneNumber;

	@Column(name = "bloodGroup")
	private String bloodGroup;
	
	@Column(name = "lastDonatedDate")
	private Date lastDonatedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDonorName() {
		return donorName;
	}

	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}

	public int getDonorAge() {
		return donorAge;
	}

	public void setDonorAge(int donorAge) {
		this.donorAge = donorAge;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Date getLastDonatedDate() {
		return lastDonatedDate;
	}

	public void setLastDonatedDate(Date lastDonatedDate) {
		this.lastDonatedDate = lastDonatedDate;
	}

	public BloodDonation(int id, String donorName, int donorAge, long phoneNumber, String bloodGroup,
			Date lastDonatedDate) {
		super();
		this.id = id;
		this.donorName = donorName;
		this.donorAge = donorAge;
		this.phoneNumber = phoneNumber;
		this.bloodGroup = bloodGroup;
		this.lastDonatedDate = lastDonatedDate;
	}
 
	public BloodDonation() {
		super();
	}
	





	

}
