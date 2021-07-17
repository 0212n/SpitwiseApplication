package com.demo.splitwise.domain.repo;

import com.demo.splitwise.util.ResourceNotFoundException;

public class UserNotFoundException extends ResourceNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException( String resourceID) {
		super("User", resourceID);
		// TODO Auto-generated constructor stub
	}

}
