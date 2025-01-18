/* Problem 1: University Management System
Create a Student class with:
rollNumber (public).
name (protected).
CGPA (private).
Write methods to:
Access and modify CGPA using public methods.
Create a subclass PostgraduateStudent to demonstrate the use of protected members.
*/

package com.capgemini.week02.programs;

class Student {
    public int rollNumber ;
    protected String name ;
    private double CGPA ;

    //Constructor to initialize student details
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    //Public method to get CGPA
    public  double getCGPA() {
        return CGPA ;
    }

    //public method to set CGPA
    public void setCGPA(double CGPA) {
        if(CGPA >=0 && CGPA <=10)
            this.CGPA = CGPA;
        else System.out.println("Invalid CGPA");
    }

    // Method to display Student details
    public void displayDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
}
class PostgraduateStudent extends Student {
    private String specialization ;

    //Constructor for postgraduate student
    public PostgraduateStudent(int rollNumber, String name, double CGPA, String specialization) {
        super(rollNumber, name, CGPA); //Super keyword is used to call methods from parent clas
        this.specialization = specialization;
    }

    // Method to display Postgraduate Student details
    public void displayPostgraduateDetails() {
        System.out.println("Postgraduate Student Details:");
        System.out.println("Roll Number: " + rollNumber); // Accessing public member
        System.out.println("Name: " + name);             // Accessing protected member
        System.out.println("Specialization: " + specialization);
    }
}
public class UniversityManagementSystem {
    public static void main(String[] args) {
        //Creating a student object
        Student st1 = new Student(211006, "Abraham", 9.10) ;

        st1.displayDetails();

        //Modifying and accessing CGPA using public methods
        st1.setCGPA(8.85);
        System.out.println("Updated CGPA: " + st1.getCGPA() + "\n");

        // Creating a PostgraduateStudent object
        PostgraduateStudent pgStudent = new PostgraduateStudent(211204, "Nishank", 9.2, "Computer Architecture");
        pgStudent.displayPostgraduateDetails();
    }
}
