package com.deve.springboot.exception;

public class InvoiceNotFoundException extends RuntimeException{
	
	private static final long serialVerionUID = 1L;
	
	
	
	public InvoiceNotFoundException()
	{
		super();
	}
	
	
	
	public InvoiceNotFoundException(String customMessage)
	{
		super(customMessage);
	}

	
	
	
}
