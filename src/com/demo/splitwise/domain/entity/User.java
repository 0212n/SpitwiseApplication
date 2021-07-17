package com.demo.splitwise.domain.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User {
	String userId;
	String name;
	String mobileNo;
	String emailId;
	
	Map<String, Balance> balanceSheet;
	public User(String userId, String name, String mobileNo, String emailId) {
		this.userId = userId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		balanceSheet = new HashMap<>();
	}
	public String getUserId() {
		return userId;
	}
	public String getName() {
		return name;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void addBalance(User user, double amount) {
		Balance balance = balanceSheet.getOrDefault(user.userId, new Balance(this, user, 0.0));
		balance.setAmount(amount);
		balanceSheet.put(user.userId, balance);
	}
	public List<String> showBalances() {
		List<String> result = new ArrayList<>();
		for(Balance balance : balanceSheet.values()) {
			result.add(balance.toString());
		}
		return result;
	}

}
