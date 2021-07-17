package com.demo.splitwise;
import com.demo.splitwise.domain.entity.User;
import com.demo.splitwise.domain.repo.ExpenseRepo;
import com.demo.splitwise.domain.repo.UserRepo;
import com.demo.splitwise.service.ExpenseService;
import com.demo.splitwise.service.UserService;
import com.demo.splitwise.service.impl.ExpenseServiceImpl;
import com.demo.splitwise.service.impl.UserServiceImpl;

public class SplitwiseApplication {
	private static SplitwiseApplication instance = null;

	private UserRepo userRepo;
	private ExpenseRepo expenseRepo;
	
	public UserService userService;
	public ExpenseService expenseService;

	private SplitwiseApplication() {
		userRepo = new UserRepo();
		expenseRepo = new ExpenseRepo();
		userService = new UserServiceImpl(userRepo);
		expenseService = new ExpenseServiceImpl(expenseRepo, userRepo);
	}

	public static SplitwiseApplication getInstance() {
		if (instance == null) {
			synchronized (SplitwiseApplication.class) {
				if (instance == null) {
					instance = new SplitwiseApplication();
				}
			}
		}
		return instance;
	}

	public User getUser(String userID) {
		// TODO Auto-generated method stub
		return userRepo.getUser(userID);
	}
	
}
