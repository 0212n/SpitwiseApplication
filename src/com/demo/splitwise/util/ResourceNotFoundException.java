package com.demo.splitwise.util;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String resourceName;
	String resourceID;

	public ResourceNotFoundException(String resourceType, String resourceID) {
		// TODO Auto-generated constructor stub
		this.resourceName = resourceType;
		this.resourceID = resourceID;
	}
	
	public String getMessage() {
		return this.resourceName + " with id : " + this.resourceID + " is not found";
	}

}
