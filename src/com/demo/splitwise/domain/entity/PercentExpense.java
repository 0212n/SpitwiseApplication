package com.demo.splitwise.domain.entity;

import java.util.List;

import com.demo.splitwise.util.InvalidExpenseException;

public class PercentExpense extends Expense {
	List<Double> percentShares;

	public PercentExpense(String payeeID, Double amount, ExpenseType type, List<String> paidTo, List<Double> percent ) {
		// Validate Percent Equals 100\
		super(payeeID, amount, type, paidTo);
		// TODO Auto-generated constructor stub
		this.percentShares = percent;
		this.setSplitAlgo(new PercentSplitter());
	}
	
	@Override
	public boolean validateExpense() {
		// TODO Auto-generated method stub
		Double total = 0.0;
		for(Double share : percentShares) {
			total += share;
		}
		if(total.equals(100.0))
			return true;
		throw new InvalidExpenseException();
	}
	
	public List<Double> getShares(){
		return percentShares;
	}

}
