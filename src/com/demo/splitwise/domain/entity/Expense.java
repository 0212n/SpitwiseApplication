package com.demo.splitwise.domain.entity;

import java.util.List;

import com.demo.splitwise.util.InvalidExpenseException;

public abstract class Expense {
	
	private String payeeID;
	private Double amount;
	private ExpenseType type;
	private ISplitter splitAlgo;
	private List<String> paidTo;
	
	public Expense(String payeeID, Double amount, ExpenseType type, List<String> paidTo) {
		this.payeeID = payeeID;
		this.amount = amount;
		this.type = type;
		this.paidTo = paidTo;
		
	}
	
	public abstract boolean validateExpense() throws InvalidExpenseException;

	public ISplitter getSplitAlgo() {
		return splitAlgo;
	}
	public void setSplitAlgo(ISplitter splitAlgo) {
		this.splitAlgo = splitAlgo;
	}
	public String getPayeeID() {
		return payeeID;
	}
	public Double getAmount() {
		return amount;
	}
	public ExpenseType getType() {
		return type;
	}
	public List<String> getPaidTo() {
		return paidTo;
	}
	
	public void split() {
		splitAlgo.split(this);
	}

}
