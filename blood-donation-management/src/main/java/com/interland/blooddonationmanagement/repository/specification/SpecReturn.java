package com.interland.blooddonationmanagement.repository.specification;

public class SpecReturn {
	
	private String donorName;
	private String donorAge;
	private String phoneNumber;
	private String bloodGroup;
	private String lastDonatedDate;
	private String orderBy;
	private String iDisplayStart;
	private String iDisplayLength;
	
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getDonorAge() {
		return donorAge;
	}
	public void setDonorAge(String donorAge) {
		this.donorAge = donorAge;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getLastDonatedDate() {
		return lastDonatedDate;
	}
	public void setLastDonatedDate(String lastDonatedDate) {
		this.lastDonatedDate = lastDonatedDate;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getiDisplayStart() {
		return iDisplayStart;
	}
	public void setiDisplayStart(String iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}
	public String getiDisplayLength() {
		return iDisplayLength;
	}
	public void setiDisplayLength(String iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}
	@Override
	public String toString() {
		return "SpecReturn [donorName=" + donorName + ", donorAge=" + donorAge + ", phoneNumber=" + phoneNumber
				+ ", bloodGroup=" + bloodGroup + ", lastDonatedDate=" + lastDonatedDate + ", orderBy=" + orderBy
				+ ", iDisplayStart=" + iDisplayStart + ", iDisplayLength=" + iDisplayLength + "]";
	}
	public SpecReturn(String donorName, String donorAge, String phoneNumber, String bloodGroup, String lastDonatedDate,
			String orderBy, String iDisplayStart, String iDisplayLength) {
		super();
		this.donorName = donorName;
		this.donorAge = donorAge;
		this.phoneNumber = phoneNumber;
		this.bloodGroup = bloodGroup;
		this.lastDonatedDate = lastDonatedDate;
		this.orderBy = orderBy;
		this.iDisplayStart = iDisplayStart;
		this.iDisplayLength = iDisplayLength;
	}
	public SpecReturn() {
		super();
	}
	
	
	

}
