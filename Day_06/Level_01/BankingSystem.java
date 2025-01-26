/* Banking System
Description: Create a banking system with different account types:
Define an abstract class BankAccount with fields like accountNumber, holderName, and balance.
Add methods like deposit(double amount) and withdraw(double amount) (concrete) and 
calculateInterest() (abstract).
Implement subclasses SavingsAccount and CurrentAccount with unique interest calculations.
Create an interface Loanable with methods applyForLoan() and calculateLoanEligibility().
Use encapsulation to secure account details and restrict unauthorized access.
Demonstrate polymorphism by processing different account types and calculating interest 
dynamically.
*/

// Abstract Class: BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getter and Setter Methods
    String getAccountNumber() {
        return accountNumber;
    }

    String getHolderName() {
        return holderName;
    }

    double getBalance() {
        return balance;
    }

    // Concrete Methods
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + ". New Balance: " + balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + ". Remaining Balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance.");
        }
    }

    // Abstract Method
    abstract void calculateInterest();
}

// Subclass: SavingsAccount
class SavingsAccount extends BankAccount implements Loanable {
    private double interestRate;

    // Constructor
    SavingsAccount(String accountNumber, String holderName, double balance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.interestRate = interestRate;
    }

    // Overriding Abstract Method
    @Override
    void calculateInterest() {
        double interest = getBalance() * interestRate / 100;
        System.out.println("Savings Account Interest: " + interest);
    }

    // Implementing Loanable Interface
    @Override
    public void applyForLoan(double amount) {
        System.out.println("Loan applied for: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() > 5000; // Eligibility condition
    }
}

// Subclass: CurrentAccount
class CurrentAccount extends BankAccount {

    // Constructor
    CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    // Overriding Abstract Method
    @Override
    void calculateInterest() {
        System.out.println("Current accounts do not earn interest.");
    }
}

// Interface: Loanable
interface Loanable {
    void applyForLoan(double amount);

    boolean calculateLoanEligibility();
}

// Main Class
public class BankingSystem {
    public static void main(String[] args) {
        // Create a SavingsAccount
        BankAccount savings = new SavingsAccount("SBI21140567", "Ibrahim", 100000, 4.0);

        // Create a CurrentAccount
        BankAccount current = new CurrentAccount("CBI12244552", "Nishank", 8000);

        // Perform deposit and withdrawal
        System.out.println("Operations on Savings Account");
        savings.deposit(2000);
        savings.withdraw(3000);

        System.out.println("\nOperations on Current Account");
        current.deposit(1000);
        current.withdraw(7000);

        // Calculate interest
        System.out.println("\nCalculating Interest on savings");
        savings.calculateInterest();
        System.out.println("\nCalculating Interest on current \n");
        current.calculateInterest();

        // Loan functionality for SavingsAccount
        if (savings instanceof Loanable) {
            Loanable loanableSavings = (Loanable) savings;
            loanableSavings.applyForLoan(20000);
            boolean isEligible = loanableSavings.calculateLoanEligibility();
            System.out.println("Loan Eligibility: " + isEligible);
        }
    }
}