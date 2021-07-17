package com.demo.splitwise.domain.repo;

import com.demo.splitwise.util.ResourceNotFoundException;

public class ExpenseNotFoundException extends ResourceNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExpenseNotFoundException(String expenseID) {
		// TODO Auto-generated constructor stub
		super("Expense", expenseID);
	}

}
