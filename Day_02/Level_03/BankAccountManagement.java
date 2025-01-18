package com.capgemini.week02.programs;

class BankAccount {
    public String accountNumber; // Public access
    protected String accountHolder; // Protected access
    private double balance; // Private access

    // Constructor to initialize BankAccount attributes
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public method to set balance
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Public method to get balance
    public double getBalance() {
        return balance;
    }
}
class SavingsAccount extends BankAccount {
    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber); // Accessing public member
        System.out.println("Account Holder: " + accountHolder); // Accessing protected member
        System.out.println("Balance: $" + getBalance()); // Accessing private member via public method
    }
}
public class BankAccountManagement {
    public static void main(String[] args) {
        //Creating SavingsAccount class object
        SavingsAccount savingsAccount = new SavingsAccount("987654321", "Abraham", 15069.50);
        //Displaying bank account details
        savingsAccount.displayDetails();

        // Modifying the balance and displaying again
        savingsAccount.setBalance(697969.69);
        System.out.println("\nAfter modifying the balance:");
        savingsAccount.displayDetails();
    }
}
