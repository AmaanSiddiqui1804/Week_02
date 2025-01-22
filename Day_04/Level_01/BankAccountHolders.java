/* Problem 2: Bank and Account Holders (Association)
Description: Model a relationship where a Bank has Customer objects associated with it. 
A Customer can have multiple bank accounts, and each account is linked to a Bank.
Tasks:
Define a Bank class and a Customer class.
Use an association relationship to show that each customer has an account in a bank.
Implement methods that enable communication, such as openAccount() in the Bank class and viewBalance() in the Customer class.
Goal: Illustrate association by setting up a relationship between customers and the bank. 
*/ 

import java.util.ArrayList;

class Customer {
    private String customerName;
    private int balance; // Balance in the account
    private String accountNumber;

    // Constructor to initialize a customer
    public Customer(String name, int balance, String accountNumber) {
        this.customerName = name;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    // Getter Method to get customer name
    public String getName() {
        return customerName;
    }    

    // Getter Method to get account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Method to view balance
    public void viewBalance() {
        System.out.println("The balance of " + customerName + " is " + balance);
    }

    // Method to deposit money
    public void deposit(int amount) {
        balance += amount;
        System.out.println(amount + " deposited. New balance: " + balance);
    }

    // Method to withdraw money
    public void withdraw(int amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance for " + customerName + ". Withdrawal failed.");
        } else {
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        }
    }

    // Method to display all details
    public void displayDetails() {
        System.out.println("Name: " + customerName + ", Balance: " + balance + ", Account Number: " + accountNumber);
    }
}

class Bank {
    static String bankName = "AA Bank";
    private ArrayList<Customer> customers; // Association: A bank has multiple customers

    // Constructor to initialize a bank
    public Bank() {
        this.customers = new ArrayList<>();
    }

    // Method to add customers to the bank
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer " + customer.getName() + " with Account Number " + customer.getAccountNumber() + " added to the bank.");
    }

    // Method to open an account (display details for all customers)
    public void openAccount() {
        System.out.println("\nAccounts opened in " + bankName + ":");
        for (Customer customer : customers) {
            customer.displayDetails();
        }
    }

    // Method to display all customers in the bank
    public void displayBankCustomers() {
        System.out.println("\nCustomers of " + bankName + ":");
        for (Customer customer : customers) {
            System.out.println("- " + customer.getName());
        }
    }

    // Method to deposit money
    public void depositMoney(Customer customer, int amount) {
        if (customers.contains(customer)) {
            System.out.println("\nDepositing money for " + customer.getName() + ":");
            customer.deposit(amount);
        } else {
            System.out.println("Customer not found in the bank.");
        }
    }

    // Method to withdraw money
    public void withdrawMoney(Customer customer, int amount) {
        if (customers.contains(customer)) {
            System.out.println("\nWithdrawing money for " + customer.getName() + ":");
            customer.withdraw(amount);
        } else {
            System.out.println("Customer not found in the bank.");
        }
    }
}

public class BankAccountHolders {
    public static void main(String[] args) {
        // Creating customers
        Customer customer1 = new Customer("Abhay", 10000, "211004");
        Customer customer2 = new Customer("Tikesh", 20000, "211005");
        Customer customer3 = new Customer("Sonu", 30000, "211006");
        Customer customer4 = new Customer("Nishank", 40000, "211007");

        // Creating a bank
        Bank bank = new Bank();

        // Adding customers to the bank
        bank.addCustomer(customer1);
        bank.addCustomer(customer2);
        bank.addCustomer(customer3);

        // Opening an account
        bank.openAccount();

        // Displaying all customers in the bank
        bank.displayBankCustomers();

        // Deposit and Withdraw operations
        bank.depositMoney(customer1, 5000); // Deposit for Abhay
        bank.withdrawMoney(customer2, 10000); // Withdraw for Tikesh
        bank.depositMoney(customer3, 7000); // Deposit for Sonu
        bank.withdrawMoney(customer4, 5000); // Attempting to withdraw for a customer not added to the bank
    }
}
