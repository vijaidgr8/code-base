package com.cappack13.exception;

public class CustomerNotFoundException  extends Exception {
	public CustomerNotFoundException()
	{
		super();
	}
	public CustomerNotFoundException(String errorMsg)
	{
		super(errorMsg);
	}
}

