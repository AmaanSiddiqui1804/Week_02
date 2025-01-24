/* Sample Problem 1: Bank Account Types
Description: Model a banking system with different account types using hierarchical 
inheritance. BankAccount is the superclass, with SavingsAccount, CheckingAccount, 
and FixedDepositAccount as subclasses.
Tasks:
Define a base class BankAccount with attributes like accountNumber and balance.
Define subclasses SavingsAccount, CheckingAccount, and FixedDepositAccount, each with 
unique attributes like interestRate for SavingsAccount and withdrawalLimit for CheckingAccount.
Implement a method displayAccountType() in each subclass to specify the account type.
Goal: Explore hierarchical inheritance, demonstrating how each subclass can have 
unique attributes while inheriting from a shared superclass 
*/
//Super Class
class BankAccount {
    String accountNumber ;
    double balance ;
    //Constructor
    public BankAccount(String accountNumber , double balance) {
        this.accountNumber = accountNumber ;
        this.balance = balance;
    } 

    //Method to display account info
    public String displayAccountType() {
        return "\t AA Banks \n" ;
    }
    //Getter method for account number
    public String getAccountNumber() {
        return accountNumber;
    }
    //Getter method for account number
    public double getBalance() {
        return balance;
    }
}
//sub class inheriting super class
class SavingsAccount extends BankAccount{
    double interestRate ;

    //Constructor
    public SavingsAccount(String accountNumber , double balance , double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate ;
    }
    //Method to display account info
    public String displayAccountType() {
        return "\n\tSavings Account\n" + 
        ("Account Number: " + accountNumber + "\nAccount Balance: " + balance + 
        "\nInterest Rate on Savings: " + interestRate + "% per Annum");
    }
}
//sub class inheriting super class
class CheckingAccount extends BankAccount {
    int withdrawalLimit ;
    
    //Constructor
    public CheckingAccount(String accountNumber , double balance , int withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit ;
    } 
    //Method to display account type and details
    public String displayAccountType() {
        return "\n\tSavings Account\n" + 
        ("Account Number: " + accountNumber + "\nAccount Balance: " + balance + 
        "\nWithdral Limit" + withdrawalLimit);
    }
} 
//sub class inheriting super class
class FixedDepositAccount extends BankAccount {
    int fixedDepositAmount ;

    //Constructor
    public FixedDepositAccount(String accountNumber , double balance , int fixedDepositAmount) {
        super(accountNumber, balance);
        this.fixedDepositAmount = fixedDepositAmount ;
    }
    //Method to display account type and details
    public String displayAccountType() {
        return "\n\tFixed Deposit Account\n" + 
        ("Account Number: " + accountNumber + "\nAccount Balance: " + balance + 
        "\nFixed Deposit Amount: " + fixedDepositAmount + "/-");
    }
}
//Main  Class
public class BankAccountTypes {
    public static void main(String[] args) {
        
        //Creating Objects
        BankAccount bankAccount = new BankAccount("111211006", 5000000) ;
        BankAccount savingsAccount = new SavingsAccount(bankAccount.getAccountNumber(), bankAccount.getBalance(), 5.1 );
        BankAccount checkingAccount = new CheckingAccount(bankAccount.getAccountNumber(), bankAccount.getBalance(), 35000);
        BankAccount fixedDepositAccount = new FixedDepositAccount(bankAccount.getAccountNumber(), bankAccount.getBalance(), 8000 );

        //Calling method to display details
        System.out.println(bankAccount.displayAccountType());
        System.out.println(savingsAccount.displayAccountType()) ;
        System.out.println(checkingAccount.displayAccountType()) ;
        System.out.println(fixedDepositAccount.displayAccountType()) ;
    }
}