package com.demo.splitwise.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.demo.splitwise.domain.entity.EqualExpense;
import com.demo.splitwise.domain.entity.ExactExpense;
import com.demo.splitwise.domain.entity.Expense;
import com.demo.splitwise.domain.entity.ExpenseType;
import com.demo.splitwise.domain.entity.PercentExpense;
import com.demo.splitwise.domain.entity.User;
import com.demo.splitwise.domain.repo.ExpenseRepo;
import com.demo.splitwise.domain.repo.UserRepo;
import com.demo.splitwise.service.ExpenseService;
import com.demo.splitwise.util.InvalidExpenseException;

public class ExpenseServiceImpl implements ExpenseService{
	UserRepo userRepo;
	ExpenseRepo expenseRepo;

	public ExpenseServiceImpl(ExpenseRepo expenseRepo, UserRepo userRepo) {
		// TODO Auto-generated constructor stub
		this.userRepo = userRepo;
		this.expenseRepo = expenseRepo;
	}

	@Override
	public String addEqualExpense(String userId, Double amount, List<String> paidTo) {
		// TODO Auto-generated method stub
		Expense expense  = new EqualExpense(userId, amount, ExpenseType.EQUAL, paidTo);
		try {
			if(expense.validateExpense()) {
				expenseRepo.addNewExpense(expense);
				expense.split();
				updateBalanceSheet(expense);
			}
		}
		catch(InvalidExpenseException e) {
			return e.getMessage();
		}
		
		return null;
	}

	private void updateBalanceSheet(Expense expense) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String addUnEqualExpense(String userId, Double amount, ExpenseType type, List<String> paidTo, List<Double> shares) {
		// TODO Auto-generated method stub
		Expense expense = null;
		switch(type) {
		
		case PERCENT:
			expense  = new PercentExpense(userId, amount, ExpenseType.PERCENT, paidTo, shares);
			break;
		case EXACT:
			expense  = new ExactExpense(userId, amount, ExpenseType.EXACT, paidTo, shares);
			break;
		default :
			return "Invalid Expense Type";
		}
		try {
			if(expense.validateExpense()) {
				expenseRepo.addNewExpense(expense);
				expense.split();
				updateBalanceSheet(expense);
			}
		}
		catch(InvalidExpenseException e) {
			return e.getMessage();
		}
		return expense.toString();
	}

	@Override
	public List<String> showAllBalances() {
		// TODO Auto-generated method stub
		List<String> result = new ArrayList<>();
		for(User user : userRepo.getAllUsers()) {
			result.add(" -------------------------");
			result.add("Balances for User : " + user.getName());
			result.addAll(user.showBalances());
			result.add(" -------------------------");
		}
		return result;
	}

}
