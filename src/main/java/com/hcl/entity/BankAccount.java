package com.hcl.entity;

import com.hcl.exception.InvalidBalanceException;
import com.hcl.exception.InvalidNameLengthException;

public class BankAccount {

	// instance variables
	private int accountId;
	private String accountName;
	private double accountBalance;

	// no-arg constructor
	public BankAccount() {
		this.accountId = 0;
		this.accountName = "";
		this.accountBalance = 0;
	}

	// constructor accepting arguments
	public BankAccount(int id, String name, double bal) {

		this.accountId = id;

		// Check if name meets criteria: First name and Last name must be between 10 and
		// 15 characters each
		try {
			String[] firstLast = name.split(" ");

			if ((firstLast[0].length() < 8 || firstLast[0].length() > 12)
					|| (firstLast[1].length() < 8 || firstLast[1].length() > 12)
					|| firstLast.length > 2) {

				throw new InvalidNameLengthException();
			} else {
				this.accountName = name;
			}
		} catch (InvalidNameLengthException e) {
			System.out.println(e);
			System.out.println("\nName assigned as John Doe.\n");
			this.accountName = "John Doe";
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
			System.out.println("\nName assigned as John Doe.\n");
			this.accountName = "John Doe";
		}

		// Check if initial balance is negative
		try {
			if (bal < 0)
				throw new InvalidBalanceException();
			else
				this.accountBalance = bal;
		} catch (InvalidBalanceException e) {
			System.out.println(e);
			System.out.println("Account Balance set to $0");
		}
	}

	/*
	 * getter and setter methods
	 */

	// Sets accountId
	public void setAccountId(int id) {
		this.accountId = id;
	}

	// Sets accountName
	public void setAccountName(String name) {
		// Check if name meets criteria: First name and Last name must be between 10 and
		// 15 characters each
		try {
			String[] firstLast = name.split(" ");

			if ((firstLast[0].length() < 8 || firstLast[0].length() > 12)
					|| (firstLast[1].length() < 8 || firstLast[1].length() > 12)
					|| firstLast.length > 2) {

				throw new InvalidNameLengthException();
			} else {
				this.accountName = name;
			}
		} catch (InvalidNameLengthException e) {
			System.out.println(e);
			System.out.println("\nName assigned as John Doe.\n");
			this.accountName = "John Doe";
		} catch (IndexOutOfBoundsException e) {
			System.out.println(e);
			System.out.println("\nName assigned as John Doe.\n");
			this.accountName = "John Doe";
		}
	}

	// Sets accountBalance
	public void setAccountBalance(double bal) {

		try {
			if (bal < 0)
				throw new InvalidBalanceException();
			else
				this.accountBalance = bal;
		} catch (InvalidBalanceException e) {
			System.out.println(e);
		}
	}

	// Gets accountId
	public int getAccountId() {
		return this.accountId;
	}

	// Gets accountName
	public String getAccountName() {
		return this.accountName;
	}

	// Gets accountBalance
	public double getAccountBalance() {
		return this.accountBalance;
	}

	/*
	 * Withdraws from the balance of the account
	 * 
	 * @param: double amount the amount to be withdrawn
	 */
	public void withdraw(double amount) {

		try {
			if (this.getAccountBalance() < amount) {
				throw new InvalidBalanceException();
			} else {
				this.accountBalance = this.accountBalance - amount;
			}
		} catch (InvalidBalanceException e) {
			System.out.println(e);
		}

	}

	// toString method for listing details of object
	public String toString() {

		String details = "Account Id: " + this.accountId + "\nAccount Name: " + this.accountName
				+ "\nAccount Balance: $" + this.accountBalance + "\n";

		return details;
	}
}
