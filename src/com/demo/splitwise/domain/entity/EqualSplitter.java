package com.demo.splitwise.domain.entity;

import java.util.List;

import com.demo.splitwise.SplitwiseApplication;

public class EqualSplitter implements ISplitter {

	@Override
	public void split(Expense expense) {
		// TODO Auto-generated method stub
		Double totalAmount = expense.getAmount();
		List<String> usersIDs = expense.getPaidTo();
		int noOfSplits = usersIDs.size();
		double share = totalAmount/noOfSplits;
		SplitwiseApplication app = SplitwiseApplication.getInstance();
		User payee = app.getUser(expense.getPayeeID());
		for(String paidToID : usersIDs) {
			if(paidToID.equals(payee.getUserId()))
				continue;
			User paidTo = app.getUser(paidToID);
			payee.addBalance(paidTo, share);
			paidTo.addBalance(payee, -1 * share);
		}
	}

}
