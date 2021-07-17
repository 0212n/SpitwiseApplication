package com.demo.splitwise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.demo.splitwise.domain.entity.ExpenseType;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SplitwiseApplication app =  SplitwiseApplication.getInstance();
		
		System.out.println(app.userService.addUser("Prashant", "5252", "dada"));
		
		System.out.println(app.userService.addUser("Prash2", "5233", "pmail"));
		
		System.out.println(app.userService.addUser("Prash3", "5252", "faga"));
		
		System.out.println(app.userService.addUser("Prash4", "52", "pmail"));
		
		app.expenseService.addEqualExpense("U:1",10.0, new ArrayList<>(Arrays.asList("U:1","U:2")));
		
		app.expenseService.addEqualExpense("U:2", 27.0, new ArrayList<>(Arrays.asList("U:1","U:2", "U:3")));
		
		app.expenseService.addUnEqualExpense("U:3", 38.0, ExpenseType.PERCENT,new ArrayList<>(Arrays.asList("U:1","U:2")), new ArrayList<>(Arrays.asList(40.0,60.0)));
		
		app.expenseService.addUnEqualExpense("U:3", 38.0, ExpenseType.PERCENT,new ArrayList<>(Arrays.asList("U:1","U:2")), new ArrayList<>(Arrays.asList(20.0,60.0)));
		
		showOutput(app.userService.showBalances("U:1"));
		
		showOutput(app.userService.showBalances("U:2"));
		
		showOutput(app.expenseService.showAllBalances());
	}
	
	public static void showOutput(List<String> input) {
		for(String inp : input) {
			System.out.println(inp);
		}
	}

}
