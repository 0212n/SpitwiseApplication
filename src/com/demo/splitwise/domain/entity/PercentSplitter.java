package com.demo.splitwise.domain.entity;

import java.util.List;

import com.demo.splitwise.SplitwiseApplication;

public class PercentSplitter implements ISplitter{

	@Override
	public void split(Expense expense) {
		Double totalAmount = expense.getAmount();
		List<String> usersIDs = expense.getPaidTo();
		int noOfSplits = usersIDs.size();
		List<Double> percentShares = ((PercentExpense)expense).getShares();
		SplitwiseApplication app = SplitwiseApplication.getInstance();
		User payee = app.getUser(expense.getPayeeID());
		int itr = 0;
		for(String paidToID : usersIDs) {
			if(paidToID.equals(payee.getUserId()))
				continue;
			User paidTo = app.getUser(paidToID);
			double percentShare = percentShares.get(itr);
			double share = totalAmount*(percentShare/100);
			payee.addBalance(paidTo, share);
			paidTo.addBalance(payee, -1 * share);
			itr++;
		}
		
	}

}
