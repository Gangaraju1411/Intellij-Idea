package com.mse.exception;

public class NoEmployeeFoundException extends RuntimeException{


	public NoEmployeeFoundException() {
		super();
	}

	public NoEmployeeFoundException(String message) {
		super(message);
	}
	
	
}
