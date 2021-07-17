package com.demo.splitwise.domain.repo;

import java.util.HashMap;
import java.util.Map;

import com.demo.splitwise.domain.entity.Expense;

public class ExpenseRepo {
	Map<String, Expense> expenseIDMap;

	public ExpenseRepo() {
		expenseIDMap = new HashMap<>();
	}
	
	public String getNextId() {
		int size = expenseIDMap.size() + 1;
		return "E" + size;
	}
	
	public Expense getExpense(String expenseID) {
		if(expenseIDMap.containsKey(expenseID)) {
			return expenseIDMap.get(expenseID);
		}
		throw new ExpenseNotFoundException(expenseID);
	}

	public void addNewExpense(Expense expense) {
		String expenseId = getNextId();
		expenseIDMap.put(expenseId, expense);
	}
}
