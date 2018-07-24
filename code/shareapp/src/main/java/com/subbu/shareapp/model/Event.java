package com.subbu.shareapp.model;

public class Event {
	
	private String ident;
	private String eventName;
	private int totalPeople;
	private double totalCost;
	private String createdDate;
	private String eventStatus;
	
	public String getIdent() {
		return ident;
	}
	
	public void setIdent(String ident) {
		this.ident = ident;
	}
	
	public String getEventName() {
		return eventName;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public int getTotalPeople() {
		return totalPeople;
	}
	
	public void setTotalPeople(int totalPeople) {
		this.totalPeople = totalPeople;
	}
	
	public double getTotalCost() {
		return totalCost;
	}
	
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	
	public String getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getEventStatus() {
		return eventStatus;
	}
	
	public void setEventStatus(String eventStatus) {
		this.eventStatus = eventStatus;
	}
}
