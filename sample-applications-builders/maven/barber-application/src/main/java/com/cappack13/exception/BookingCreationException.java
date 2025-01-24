package com.cappack13.exception;

public class BookingCreationException extends Exception {
	
	public BookingCreationException()
	{
		super();
	}
	public BookingCreationException(String errorMsg)
	{
		super(errorMsg);
	}

}
