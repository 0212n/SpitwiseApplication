package com.demo.splitwise.service.impl;

import java.util.List;

import com.demo.splitwise.domain.entity.User;
import com.demo.splitwise.domain.repo.UserRepo;
import com.demo.splitwise.service.UserService;

public class UserServiceImpl implements UserService{
	UserRepo userRepo;
	
	public UserServiceImpl(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public String addUser(String name, String email, String mobileNo) {
		// TODO Auto-generated method stub
		if(userRepo.isNoRegistered(mobileNo)) {
			return " Mobile No already registered";
		}
		String newUserID = userRepo.getNextID();
		User newUser = new User(newUserID, name, mobileNo, email);
		userRepo.addUser(newUser);
		return "New User added with  user ID : " + newUserID;
	}

	@Override
	public List<String> showBalances(String userID) {
		// TODO Auto-generated method stub
		User user = userRepo.getUser(userID);
		return user.showBalances();
	}

}
