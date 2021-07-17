package com.demo.splitwise.service;

import java.util.List;

public interface UserService {
	
	public String addUser(String name, String email, String mobileNo);
	
	public List<String> showBalances(String userID);

}
