/* Employee Management System
Description: Build an employee management system with the following requirements:
Use an abstract class Employee with fields like employeeId, name, and baseSalary.
Provide an abstract method calculateSalary() and a concrete method displayDetails().
Create two subclasses: FullTimeEmployee and PartTimeEmployee, 
implementing calculateSalary() based on work hours or fixed salary.
Use encapsulation to restrict direct access to fields and provide getter and setter methods.
Create an interface Department with methods like assignDepartment() and getDepartmentDetails().
Ensure polymorphism by processing a list of employees and displaying their 
details using the Employee reference */

import java.util.ArrayList;
import java.util.List;

// Abstract class Employee
abstract class Employee {
    private int employeeId;
    private String name;
    private int baseSalary;

    // Constructor to initialize Employee attributes
    public Employee(int employeeId, String name, int baseSalary) {
        this.setEmployeeId(employeeId);
        this.setName(name);
        this.setBaseSalary(baseSalary);
    }

    // Abstract method to calculate salary
    public abstract int calculateSalary();

    // Concrete method to display employee details
    public void displayDetails() {
        System.out.println("Employee ID: " + getEmployeeId());
        System.out.println("Name: " + getName());
        System.out.println("Base Salary: " + getBaseSalary());
    }

    // Getter and Setter methods
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }
}

// Interface Department
interface Department {
    void assignDepartment(String departmentName);

    String getDepartmentDetails();
}

// FullTimeEmployee class extending Employee and implementing Department
class FullTimeEmployee extends Employee implements Department {
    private int fixedSalary;
    private String department;

    // Constructor for FullTimeEmployee
    public FullTimeEmployee(int employeeId, String name, int baseSalary, int fixedSalary) {
        super(employeeId, name, baseSalary);
        this.setFixedSalary(fixedSalary);
    }

    // Overriding calculateSalary method
    @Override
    public int calculateSalary() {
        return getFixedSalary();
    }

    // Implementing assignDepartment method
    @Override
    public void assignDepartment(String departmentName) {
        this.setDepartment(departmentName);
    }

    // Implementing getDepartmentDetails method
    @Override
    public String getDepartmentDetails() {
        return "Department: " + getDepartment();
    }

    // Overriding displayDetails method
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Fixed Salary: " + getFixedSalary());
        System.out.println(getDepartmentDetails());
    }

    // Getter and Setter methods
    public int getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(int fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

// PartTimeEmployee class extending Employee and implementing Department
class PartTimeEmployee extends Employee implements Department {
    private int workHours;
    private int hourlyRate;
    private String department;

    // Constructor for PartTimeEmployee
    public PartTimeEmployee(int employeeId, String name, int baseSalary, int workHours, int hourlyRate) {
        super(employeeId, name, baseSalary);
        this.setWorkHours(workHours);
        this.setHourlyRate(hourlyRate);
    }

    // Overriding calculateSalary method
    @Override
    public int calculateSalary() {
        return getWorkHours() * getHourlyRate();
    }

    // Implementing assignDepartment method
    @Override
    public void assignDepartment(String departmentName) {
        this.setDepartment(departmentName);
    }

    // Implementing getDepartmentDetails method
    @Override
    public String getDepartmentDetails() {
        return "Department: " + getDepartment();
    }

    // Overriding displayDetails method
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Work Hours: " + getWorkHours());
        System.out.println("Hourly Rate: " + getHourlyRate());
        System.out.println(getDepartmentDetails());
    }

    // Getter and Setter methods
    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

// Main class to demonstrate the Employee Management System
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Creating a list of employees
        List<Employee> employees = new ArrayList<>();

        // Adding FullTimeEmployee and PartTimeEmployee objects
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee(211064, "Nishank", 50000, 80000);
        fullTimeEmployee.assignDepartment("Engineering");

        PartTimeEmployee partTimeEmployee = new PartTimeEmployee(2110063, "Niraj", 20000, 20, 50);
        partTimeEmployee.assignDepartment("Assistant");

        employees.add(fullTimeEmployee);
        employees.add(partTimeEmployee);

        // Displaying details of all employees
        for (Employee employee : employees) {
            employee.displayDetails();
            System.out.println("Calculated Salary: " + employee.calculateSalary());
            System.out.println("-----------------------------------");
        }
    }
}
