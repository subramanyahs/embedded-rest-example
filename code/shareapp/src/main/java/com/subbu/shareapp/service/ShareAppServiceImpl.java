package com.subbu.shareapp.service;

import java.util.List;

import com.subbu.shareapp.dao.ShareAppDao;

public class ShareAppServiceImpl implements ShareAppService {

	public int authenticateUser(String mobile, String otp) {
		ShareAppDao dao = new ShareAppDao();
		return dao.authenticateUser(mobile, otp);
	}

	public boolean addEvent(String json) {
		ShareAppDao dao = new ShareAppDao();
		return dao.addEvent(json);
	}

	public boolean addExpense(String json) {
		return false;
	}

	public List reports(int userId) {
		ShareAppDao dao = new ShareAppDao();
		return dao.reports(userId);
	}
}