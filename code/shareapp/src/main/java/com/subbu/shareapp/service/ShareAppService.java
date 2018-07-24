package com.subbu.shareapp.service;

import java.util.List;

public interface ShareAppService {

	public int authenticateUser(String mobile,String otp);

	public boolean addEvent(String json);
	
	public boolean addExpense(String json);
	
	public List reports(int userId);

}