class Employee {
    String name ;
    int id ;
    int salary ;
 
 
    //Constructor
    public Employee(String name, int id, int salary) {
        this.name = name ;
        this.id = id ;
        this.salary = salary ;
    }
 
 
    //Method to display details
    public void displayDetails() {
        System.out.println("Details of employee will be printed here. (Employee Class)");
        System.out.println("Designation: Employee  \nName: " + name + "\nId: " + id + "\nSalary: " + salary+ "/-");
    }
 }
 class Manager extends Employee {
    int teamSize ;
    public Manager (String name, int id, int salary,int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize ;
    }
    @Override
    public void displayDetails() {
        System.out.println("Designation: Manager  \nName: " + name + "\nId: " + id + "\nTeam size: " + teamSize + "\nSalary: " + salary+ "/-");
    }
 }
 class Developer extends Employee {
    String programmingLanguage ;
    public Developer (String name, int id, int salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage ;
    }
    //Method overriding
    @Override
    public void displayDetails() {
        System.out.println("Designation: Developer  \nName: " + name + "\nId: " + id + "\nTProgramming Language: " + programmingLanguage + "\nSalary: " + salary+ "/-");
    }
 }
 class Intern extends Employee {
    String internshipPeriod ;
    public Intern (String name, int id, int salary,String internshipPeriod) {
        super(name, id, salary);
        this.internshipPeriod = internshipPeriod ;
    }
    //Method overriding
    @Override
    public void displayDetails() {
        System.out.println("Designation: Manager  \nName: " + name + "\nId: " + id + "\nInternship Period: " + internshipPeriod + "\nSalary: Rs " + salary+ "/-");
    }
 }
 public class EmployeeManagementSystem {
    public static void main(String[] args) {
        //Creating Objects
        Employee employee = new Employee("AMAAN SIDDIQUI", 101, 100000);
        Employee manager = new Manager("Abhay Gautam", 211004, 50000, 5);
        Employee developer = new Developer("Niraj Prajapati", 211060, 40000, "JAVA");
        Employee intern = new Intern("Tikesh Kardate", 211116, 20000, "45 Days");
 
 
        //Calling method to display details
        employee.displayDetails();
        manager.displayDetails();
        developer.displayDetails();
        intern.displayDetails();
    }
 }
 