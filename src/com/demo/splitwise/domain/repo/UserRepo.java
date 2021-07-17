package com.demo.splitwise.domain.repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.demo.splitwise.domain.entity.User;

public class UserRepo {
	private Map<String, User> userIDMap;
	private Set<String> mobileNoSet;

	public UserRepo() {
		userIDMap = new HashMap<>();
		mobileNoSet = new HashSet<>();
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> result = new ArrayList<>();
		for(User user : userIDMap.values() ) {
			result.add(user);
		}
		return result;
	}

	public User getUser(String userID) {
		if(userIDMap.containsKey(userID)) {
			return userIDMap.get(userID);
		}
		throw new UserNotFoundException(userID);
		
	}

	public boolean isNoRegistered(String mobileNo) {
		// TODO Auto-generated method stub
		if(mobileNoSet.contains(mobileNo)) {
			return true;
		}
		return false;
	}
	
	public void addUser(User user) {
		String userID =user.getUserId();
		userIDMap.put(userID, user);
		mobileNoSet.add(user.getMobileNo());
	}
	
	public String getNextID() {
		int size = userIDMap.size() + 1;
		String userID = "U:" + size;
		return userID;
	}
	
}
