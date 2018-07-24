package com.subbu.shareapp.utils;

public class ReportObj {

	private String eventName;
	private String totalPeople;
	private String totalCost;
	private String toPay;
	private String expenseStatus;
	
	public String getEventName() {
		return eventName;
	}
	
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	public String getTotalPeople() {
		return totalPeople;
	}
	
	public void setTotalPeople(String totalPeople) {
		this.totalPeople = totalPeople;
	}
	
	public String getTotalCost() {
		return totalCost;
	}
	
	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}
	
	public String getToPay() {
		return toPay;
	}
	
	public void setToPay(String toPay) {
		this.toPay = toPay;
	}
	
	public String getExpenseStatus() {
		return expenseStatus;
	}
	
	public void setExpenseStatus(String expenseStatus) {
		this.expenseStatus = expenseStatus;
	}
}
