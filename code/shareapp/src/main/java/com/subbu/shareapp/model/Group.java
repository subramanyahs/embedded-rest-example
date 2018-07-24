package com.subbu.shareapp.model;

public class Group {
	
	private String ident;
	private String groupName;
	private String groupStatus;
	private String createdDate;
	private String admin;
	
	public String getIdent() {
		return ident;
	}
	
	public void setIdent(String ident) {
		this.ident = ident;
	}
	
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public String getGroupStatus() {
		return groupStatus;
	}
	
	public void setGroupStatus(String groupStatus) {
		this.groupStatus = groupStatus;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getAdmin() {
		return admin;
	}
	
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
}
