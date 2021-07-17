package com.demo.splitwise.domain.entity;

import java.util.List;

public class EqualExpense extends Expense{

	public EqualExpense(String payeeID, Double amount, ExpenseType type, List<String> paidTo) {
		super(payeeID, amount, type, paidTo);
		// TODO Auto-generated constructor stub
		this.setSplitAlgo(new EqualSplitter());
	}

	@Override
	public boolean validateExpense() {
		// TODO Auto-generated method stub
		return true;
	}

}
