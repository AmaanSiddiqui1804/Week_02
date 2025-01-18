package com.capgemini.week02.programs;

class Employee {
    public int employeeID; // Public access
    protected String department; // Protected access
    private double salary; // Private access

    // Constructor to initialize Employee attributes
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify the salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Public method to get the salary
    public double getSalary() {
        return salary;
    }
}
//Subclass
class Manager extends Employee {
    //Employee subclass Constructor
    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary); //Using super keyword to get details from parent class
    }
    //Method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeID); // Access public member
        System.out.println("Department: " + department); // Access protected member
        System.out.println("Salary: $" + getSalary()); // Access private member via public method
    }
}

public class EmployeeRecords {
    public static void main(String[] args) {
        //Creating object for Manager class
        Manager manager = new Manager(100, "IT", 75000.00);
        //Displaying manager details
        manager.displayDetails();

        // Modifying the salary and displaying again
        manager.setSalary(80000.00);
        System.out.println("\nAfter modifying the salary:");
        manager.displayDetails();
    }
}