/* Problem 3: Company and Departments (Composition)
Description: A Company has several Department objects, and each department contains Employee objects. 
Model this using composition, where deleting a company should also delete all departments and employees.
Tasks:
Define a Company class that contains multiple Department objects.
Define an Employee class within each Department.
Show the composition relationship by ensuring that when a Company object is deleted, 
all associated Department and Employee objects are also removed.
Goal: Understand composition by implementing a relationship where Department and Employee 
objects cannot exist without a Company.
*/

import java.util.ArrayList;
class Employee {
    private String employeeName;
    private int employeeId;
    private String departmentName;

    // Constructor to initialize an employee
    Employee (String name, int id, String department) {
        this.employeeName = name;
        this.employeeId = id;
        this.departmentName = department;
    }
    

    public void displayEmployeeDetails(){
        System.out.println("Name: " + employeeName + ", ID: " + employeeId + ", Department: " + departmentName);
    }

}

class Department {
    private String departmentName;
    private ArrayList<Employee> employees; // Composition: A department contains multiple employees

    // Constructor to initialize a department
    Department(String name) {
        this.departmentName = name;
        this.employees = new ArrayList<>();
    }

    // Method to add an employee to the department
    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee " + employee + " has been added to " + departmentName);
    }

    // Method to display all employees in the department
    public void displayDepartmentDetails() {
        System.out.println("\nEmployees in " + departmentName + ":");
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i); 
            employee.displayEmployeeDetails(); // Calling method in employee classto display employee details
        }
    }

    // Method to get department name
    public String getDepartmentName() {
        return departmentName;
    }
}

class Company {
    private String companyName;
    private ArrayList<Department> departments; // Composition: A company contains multiple departments

    // Constructor to initialize a company
    Company(String name) {
        this.companyName = name;
        this.departments = new ArrayList<>();
    }

    // Method to add a department to the company
    public void addDepartment(Department department) {
        departments.add(department);
        System.out.println(department.getDepartmentName() + " department has been added to " + companyName);
    }

    // Method to display all departments in the company
    public void displayCompanyDetails() {
        System.out.println("Departments and Employees: ");

        for (int i = 0; i < departments.size(); i++) {
            Department department = departments.get(i);
            System.out.println("Department: " + department.getDepartmentName());
            department.displayDepartmentDetails(); // Display the details of the department
        }
    }

    //Destructor to delete the company
    public void deleteCompany() {
        System.out.println("Deleting Company " + companyName );
        departments.clear(); //Method to delete all departments using clear() method
        System.out.println("All departments and employees have been removed.");
    }
}

public class ComapnyAndDepartments {
    public static void main(String[] args) {  
        System.out.println("AA Consultancies\n\n");
        
        //Creating employees (objects)
        Employee employee1 = new Employee("Amaan Siddiqui", 211006, "Executive Management");
        Employee employee2 = new Employee("Nishank Bathri", 211005, "IT");
        Employee employee3 = new Employee("Tikesh Kardate", 211007, "HR");
        Employee employee4 = new Employee("Sonu Sharma", 211008, "IT");
        Employee employee5 = new Employee("Nishank Bathri", 211009, "IT");
        Employee employee6 = new Employee("Neeraj ", 2110010, "Sales"); 
        
        //Creating departments (objects)
        Department managmentDepartment = new Department("Executive Management");
        Department itDepartment = new Department("IT");
        Department hrDepartment = new Department("HR");
        Department salesDepartment = new Department("Sales");
        

        //Creating a company (object)
        Company company = new Company("AA Consulatanices");
        company.addDepartment(managmentDepartment);
        company.addDepartment(hrDepartment);
        company.addDepartment(itDepartment);
        company.addDepartment(salesDepartment);
        System.out.println();

        //Adding employees to departments
        managmentDepartment.addEmployee(employee1);

        itDepartment.addEmployee(employee2);
        itDepartment.addEmployee(employee4);
        itDepartment.addEmployee(employee5);

        hrDepartment.addEmployee(employee3);

        salesDepartment.addEmployee(employee6); 

        System.out.println();

        //Displaying company details
        company.displayCompanyDetails(); 

        // Simulating deletion of the company
        company.deleteCompany();
    }
}
