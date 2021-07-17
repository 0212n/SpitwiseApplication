package com.demo.splitwise.service;

import java.util.List;

import com.demo.splitwise.domain.entity.ExpenseType;

public interface ExpenseService {
	
	public String addEqualExpense(String userId, Double amount, List<String> paidTo);
	
	public String addUnEqualExpense(String userId, Double amount, ExpenseType type,List<String> paidTo, List<Double> shares);
	
	public List<String> showAllBalances();
}
