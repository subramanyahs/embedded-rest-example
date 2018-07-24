package com.subbu.shareapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.derby.impl.sql.compile.GetCurrentConnectionNode;
import org.json.JSONObject;

import com.subbu.shareapp.utils.ReportObj;

public class ShareAppDao {

	private Connection con = null;
	private Statement st = null;

	// get connection
	public ShareAppDao() {
		// do db connection
		String url = "jdbc:derby:shareapp;create=true";

		try {

			System.setProperty("derby.system.home", "../src/.derby");
			this.con = DriverManager.getConnection(url);
			this.st = con.createStatement();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public int authenticateUser(String mobile, String otp) {
		try {
			ResultSet rs = st.executeQuery("SELECT ident FROM users where phoneNumber = '" + mobile + "'");

			while (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public boolean addEvent(String json) {
		JSONObject jsonObj = new JSONObject(json);
		// create expense
		String insertExpense = "Insert into event (userId,eventId,groupId,toPay,createdDate,expenseStatus,payDate) values (?,?,?,?,?,?,?);";

		String[] users = jsonObj.get("users").toString().split(",");
		for (int iCounter = 0; iCounter < users.length; iCounter++) {
			PreparedStatement preparedStatement;
			try {
				preparedStatement = con.prepareStatement(insertExpense);
				preparedStatement.setInt(1, Integer.parseInt(users[iCounter]));
				preparedStatement.setInt(2, Integer.parseInt(jsonObj.get("eventId").toString()));
				preparedStatement.setInt(3, Integer.parseInt(jsonObj.get("groupId").toString()));

				preparedStatement.setInt(4, Integer.parseInt(jsonObj.get("payment").toString()));
				// execute insert SQL stetement
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}
	
	public boolean addExpense(String json) {
		return false;
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	public List reports(int userId){
		String reportQuery="select e.eventName,e.totalPeople,e.totalCost,ex.toPay,ex.expenseStatus from events e, expense ex,groupUsers gu where ex.eventId = e.ident and gu.userId ="+userId;
		List reportList=new ArrayList();
		try {
			ResultSet rs = st.executeQuery(reportQuery);
			
			while (rs.next()) {
				ReportObj repObj = new ReportObj();
				repObj.setEventName(rs.getString(1));
				repObj.setTotalPeople(rs.getString(2));
				repObj.setTotalCost(rs.getString(3));
				repObj.setToPay(rs.getString(4));
				repObj.setExpenseStatus(rs.getString(5));
				
				reportList.add(repObj);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reportList;
	}
}