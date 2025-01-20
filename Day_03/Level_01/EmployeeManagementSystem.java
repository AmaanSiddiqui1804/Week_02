/* Sample Program 3: EmployeeManagementSystem
Design an Employee class with the following features:
Static:
A static variable companyName shared by all employees.
A static method displayTotalEmployees() to show the total number of employees.
This:
Use this to initialize name, id, and designation in the constructor.
Final:
Use a final variable id for the employee ID, which cannot be modified after assignment.
Instanceof:
Check if a given object is an instance of the Employee class before printing the employee details.*/


class Employee {
    static String companyName = "AA Consulatancies" ;
    private String name ;
    private int id ;
    private String designation ;
    static int totalEmployees ;

    static {
        System.out.println(companyName);
    }
    // Constructor to initialize employee details
    Employee(String name, int id, String designation) {
        this.name = name;
        this.id = id; 
        this.designation = designation;
        totalEmployees++; // Increment the count of total employees
    }

    //Static method to get the total number of accounts
    public static int getTotalEmployees() {
        return totalEmployees;
    }

    //Method to display employee details
    void displayEmployeeDetails(){
        System.out.println("Name of employee: " + name);
        System.out.println("ID of employee: " + id);
        System.out.println("Designation of employee: " + designation);
        System.out.println("Company Name: " + companyName);
    }
}
public class EmployeeManagementSystem {
    public static void main(String[] args) {

        //Creating objects for employee class
        Employee emp1 = new Employee("Amaan Siddiqui", 100201, "CEO") ;
        Employee emp2 = new Employee("Nishank Bathri", 211061, "Database Developer");
        Employee emp3 = new Employee("Tikesh Kardate", 211004, "Front Developer");
        Employee emp4 = new Employee("Abhay Gautam", 211004, "Backend Developer");
        
        // Checking if the objects are instances of the Employee class and displaying them
        System.out.println("\nEmployee Details:");
        if (emp1 instanceof Employee) {
            System.out.println("Employee 1 is an instance of Employee."); 
            emp1.displayEmployeeDetails();
            System.out.println();
        }
        if (emp2 instanceof Employee) {
            System.out.println("Employee 2 is an instance of Employee.");
            emp2.displayEmployeeDetails();
            System.out.println();
        }
        if (emp3 instanceof Employee) {
            System.out.println("Employee 3 is an instance of Employee.");
            emp3.displayEmployeeDetails();
            System.out.println();
        }
        if (emp4 instanceof Employee) {
            System.out.println("Employee 4 is an instance of Employee."); 
            emp4.displayEmployeeDetails();
            System.out.println();
        }
        // Displaying total number of employees
        System.out.println("\nTotal Employees: " + Employee.getTotalEmployees());
    }    
}
