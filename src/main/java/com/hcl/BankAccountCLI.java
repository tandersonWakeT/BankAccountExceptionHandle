package com.hcl;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import com.hcl.entity.BankAccount;

/**
 * Main Method for BankAccount class
 * Negative balance should throw an user made Exception - InvalidBalanceException
 * Names longer than or shorter than a given length should throw
 * 	an user made Exception - InvalidNameException
 *
 */
public class BankAccountCLI {

    public static void main(String[] args) {

       List<BankAccount> accountList = new ArrayList<BankAccount>();
       Scanner kb = new Scanner(System.in);
       
       boolean flag = true;
       
       //Populate x number of Accounts with AccountId, Name, and Balance
       while (flag) {
    	   
    	   int tempId = 0;
    	   String tempName = "";
    	   double tempBalance = 0.0;
    	   String flagManip = "";
    	   
    	   System.out.println("\n===== Start New Account Details ======\n");
    	   
    	   System.out.println("Enter the Account Id: ");
    	   tempId = kb.nextInt();
    	   kb.nextLine();
    	   
    	   System.out.println("Enter Account Name: ");
    	   tempName = kb.nextLine();
    	   
    	   System.out.println("Enter Account Starting Balance: ");
    	   tempBalance = kb.nextDouble();
    	   kb.nextLine();
    	   
    	   accountList.add(new BankAccount(tempId, tempName, tempBalance));
    	   
    	   System.out.println("Account Successfully Created.");
    	   System.out.println("\nWould you like to create a new account?[y/n]: ");
    	   flagManip = kb.nextLine();
    	   System.out.println();
    	   
    	   if (flagManip.toLowerCase().charAt(0) != 'y') {
    		   flag = false;
    	   }
       }
       
       // Print the account details using the toString method
       for (int i = 0; i < accountList.size(); i++) {
    	   System.out.println(i + ".");
    	   System.out.println(accountList.get(i).toString());
       }
       
       System.out.println();
       
       // Locate account, print details, and withdraw user specified amount
       flag = true;
       while (flag) {
    	   
    	   int findAccount = 0;
    	   double withdraw = 0;
    	   String flagManip = "";
    	   
    	   System.out.println("\n===== Withdraw =====\n");
    	   System.out.println("Select the account youd like to withrdaw from: ");
    	   findAccount = kb.nextInt();
    	   kb.nextLine();
    	   
    	   if (findAccount <= accountList.size()) {
    		   System.out.println("\nCurrent Account: \n" + accountList.get(findAccount).toString() + "\n");
    		   System.out.println("Enter withdrawal amount: ");
    		   withdraw = kb.nextDouble();
    		   kb.nextLine();
    		   accountList.get(findAccount).withdraw(withdraw);
    		   
    		   System.out.println("\nYour new balance is: $" + accountList.get(findAccount).getAccountBalance());
    	   }
    	   else {
    		   System.out.println("This account does not exist.\n");
    	   }
    	   
    	   System.out.println("Would you like to withdraw from another account?[y/n]: ");
    	   flagManip = kb.nextLine();
    	   System.out.println();
    	   
    	   if (flagManip.toLowerCase().charAt(0) != 'y') {
    		   flag = false;
    	   }
       }
       
    	   
       System.out.println(" ========== END ========== ");
       
       kb.close();
    }
}
