package com.ty.exception;

public class InvalidChoiceException extends Exception {
          String message;

		public InvalidChoiceException(String message) {
			
			this.message = message;
		}

		


		@Override
		public String getMessage() {
			// TODO Auto-generated method stub
			return message;
		}
		
          
}
//custom exception 
