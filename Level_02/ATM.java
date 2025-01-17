/* Program to Simulate an ATM
Problem Statement: Create a BankAccount class with attributes 
accountHolder, accountNumber, and balance. Add methods for:
Depositing money.
Withdrawing money (only if sufficient balance exists).
Displaying the current balance
*/
import java.util.Scanner;

class BankAccount {
    //Declaring attributes
    String accountHolder;
    int accountNumber;
    double balance;

    // Constructor
    public BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit money
    public double moneyDeposit(double depositAmount) {
        balance += depositAmount;
        System.out.println("Amount deposited: " + depositAmount);
        return balance;
    }

    // Method to withdraw money
    public double moneyWithdraw(double withdrawAmount) {
        if (balance >= withdrawAmount) {
            balance -= withdrawAmount;
            System.out.println("Amount withdrawn: " + withdrawAmount);
        } else {
            System.out.println("Insufficient balance!");
        }
        return balance;
    }

    // Method to display account details
    public void displayBankDetails() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
}

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Predefined bank accounts
        BankAccount b1 = new BankAccount("Aman", 211006, 5000000);
        BankAccount b2 = new BankAccount("Nishu", 211061, 3000000);
        BankAccount b3 = new BankAccount("Titu", 211008, 1000000);

        // Prompt user to enter account number
        System.out.print("Enter account number: ");
        int enteredAccountNumber = sc.nextInt();
        sc.nextLine(); // consume newline

        // Check if the entered account number is valid
        BankAccount selectedAccount = null;
        if (enteredAccountNumber == b1.accountNumber) {
            selectedAccount = b1;
        } else if (enteredAccountNumber == b2.accountNumber) {
            selectedAccount = b2;
        } else if (enteredAccountNumber == b3.accountNumber) {
            selectedAccount = b3;
        }

        if (selectedAccount == null) {
            System.out.println("Incorrect details");
            System.exit(0);// Exitting program
        }

        // Display account details
        selectedAccount.displayBankDetails();

        // Prompt user to select operation
        System.out.println("\nChoose operation: Check Balance, Deposit, Withdraw");
        String operation = sc.nextLine();

        // Perform chosen operation
        switch (operation.toLowerCase()) {
            case "check balance":
                selectedAccount.displayBankDetails();
                break;
            case "deposit":
                System.out.print("Enter amount to deposit: ");
                double depositAmount = sc.nextDouble();
                selectedAccount.moneyDeposit(depositAmount);
                break;
            case "withdraw":
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = sc.nextDouble();
                selectedAccount.moneyWithdraw(withdrawAmount);
                break;
            default:
                System.out.println("Invalid operation selected");
                break;
        }

        // Display updated account details
        selectedAccount.displayBankDetails();

        sc.close();
    }
}

