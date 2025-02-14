package com.ty.exception;

public class StudentNotFoundException extends Exception {
	String message;

	public StudentNotFoundException(String message) {
		
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}