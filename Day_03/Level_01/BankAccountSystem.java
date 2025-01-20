/* Sample Program 1: Bank Account System
Create a BankAccount class with the following features:
Static:
A static variable bankName shared across all accounts.
A static method getTotalAccounts() to display the total number of accounts.
This:
Use this to resolve ambiguity in the constructor when initializing accountHolderName and accountNumber.
Final:
Use a final variable accountNumber to ensure it cannot be changed once assigned.
Instanceof:
Check if an account object is an instance of the BankAccount class before displaying its details.
*/

class BankAccount {
    static String bankName = "Amaan Bank"; // Shared across all accounts
    private String accountHolderName;
    private double balance;
    private final int accountNumber; // Final to ensure it cannot be changed
    private static int totalAccounts = 0; // To track total number of accounts

    // Constructor to initialize account details
    BankAccount(String accountHolderName, int accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber; // Use `this` to resolve ambiguity
        this.balance = balance;
        totalAccounts++; // Increment the count of total accounts
    }

    //Static method to get the total number of accounts
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

public class BankAccountSystem {
    public static void main(String[] args) {
        // Creating bank account objects
        BankAccount account1 = new BankAccount("Abraham", 211001, 14965.32);
        BankAccount account2 = new BankAccount("Bagga", 211002, 10000.0);

        // Checking if the objects are instances of the BankAccount1 class
        if (account1 instanceof BankAccount) {
            System.out.println("Account 1 is an instance of BankAccount1.");
        }
        if (account2 instanceof BankAccount) {
            System.out.println("Account 2 is an instance of BankAccount1.");
        }

        // Displaying account details
        System.out.println("\nAccount Details:");
        account1.displayAccountDetails();
        System.out.println();
        account2.displayAccountDetails();

        // Displaying total number of accounts
        System.out.println("\nTotal Accounts: " + BankAccount.getTotalAccounts());
    }
}