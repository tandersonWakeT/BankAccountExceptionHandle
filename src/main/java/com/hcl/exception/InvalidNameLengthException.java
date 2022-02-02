package com.hcl.exception;

public class InvalidNameLengthException extends Exception{
	
	public InvalidNameLengthException() {
		System.out.println("User defined Exception thrown");
	}
	
	public String toString() {
		return "Ivalid Name Exception: The length of each name (First and Last) must be between 8-12 characters." ;
	}
}
