package com.demo.splitwise.domain.entity;

import java.util.List;

import com.demo.splitwise.util.InvalidExpenseException;

public class ExactExpense extends Expense{
	
	List<Double> shares;

	public ExactExpense(String payeeID, Double amount, ExpenseType type, List<String> paidTo, List<Double> shares) {
		super(payeeID, amount, type, paidTo);
		// TODO Auto-generated constructor stub
		this.shares = shares;
	}

	@Override
	public boolean validateExpense() throws InvalidExpenseException {
		// TODO Auto-generated method stub
		return false;
	}

}
