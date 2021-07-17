package com.demo.splitwise.util;

public class InvalidExpenseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		return "Invalid Shares in the expense";
	}

}
