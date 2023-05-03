package com.interland.blooddonationmanagement.dto;

import java.sql.Date;

public class BloodDonationDto {
	
	private int id;
	private String donorName;
	private int donorAge;
	private long phoneNumber;
	private String bloodGroup;
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
	@Override
	public String toString() {
		return "BloodDonationDto [id=" + id + ", donorName=" + donorName + ", donorAge=" + donorAge + ", phoneNumber="
				+ phoneNumber + ", bloodGroup=" + bloodGroup + ", lastDonatedDate=" + lastDonatedDate + "]";
	}
	public BloodDonationDto(int id, String donorName, int donorAge, long phoneNumber, String bloodGroup,
			Date lastDonatedDate) {
		super();
		this.id = id;
		this.donorName = donorName;
		this.donorAge = donorAge;
		this.phoneNumber = phoneNumber;
		this.bloodGroup = bloodGroup;
		this.lastDonatedDate = lastDonatedDate;
	}
	public BloodDonationDto() {
		super();
	}
	

}
