package com.demo.splitwise.domain.entity;

public class Balance {
	private User paidBy;
	private User paidTo;
	private Double amount;
	
	public Balance(User paidBy, User paidTo, Double amount) {
		super();
		this.paidBy = paidBy;
		this.paidTo = paidTo;
		this.amount = amount;
	}

	public User getPaidBy() {
		return paidBy;
	}

	public User getPaidTo() {
		return paidTo;
	}

	public Double getAmount() {
		return amount;
	}
	
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		if(amount < 0.0) {
			return "Balance [User : " + paidBy.name + " owes " + paidTo.name + ", amount=" + amount*-1 + "]";
		}
		return "Balance [User : " + paidTo.name + " owes " + paidBy.name + ", amount=" + amount + "]";
	}
	
	

}
