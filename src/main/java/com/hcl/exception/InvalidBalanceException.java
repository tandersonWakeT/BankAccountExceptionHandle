package com.hcl.exception;

public class InvalidBalanceException extends Exception {
	
	public InvalidBalanceException() {
		System.out.println("User defined Exception thrown");
	}
	
	public String toString() {
		return "Ivalid Balance Exception: You can not have a negative balance." ;
	}
}
