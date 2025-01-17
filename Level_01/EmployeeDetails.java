/* Program to Display Employee Details
Problem Statement: Write a program to create an Employee class with 
attributes name, id, and salary. Add a method to display the details.*/

class Employee {
    //Class level variable declaration
    String name ;
    int id ;
    int salary ;

    //Constructor
    public Employee(String name, int id , int salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    
    //Method to display employee details
    public  void displayDetails(){
        System.out.println("Employee name: " + name );
        System.out.println("Employee id: " + id);
        System.out.println("Employee salary: " + salary);
    }
    
}


public class EmployeeDetails {
    public static void main(String[] args) {
        
        Employee employee1 = new Employee("Amaan" , 211001 , 50000);
        Employee employee2 = new Employee("Abhay" , 211002 , 60000);
        Employee employee3 = new Employee("Nishank" , 211003 , 49000);

        //Displaying details of employees
        System.out.println("\tEmployee-1\t");
        employee1.displayDetails();

        System.out.println("\tEmployee-2\t");
        employee2.displayDetails();

        System.out.println("\tEmployee-3\t");
        employee3.displayDetails();
        
    }
}