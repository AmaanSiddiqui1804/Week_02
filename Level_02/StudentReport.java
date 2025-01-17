/* Program to Simulate Student Report
Problem Statement: Create a Student class with attributes name, rollNumber, 
and marks. 
Add two methods:
To calculate the grade based on the marks.
To display the student's details and grade.
Explanation: The Student class organizes all relevant details about a student as attributes. 
Methods are used to calculate the grade and provide a way to display all information.*/

import java.util.Scanner;

class Student {
    String name ;
    int rollNumber ;
    double marks ;

    // Constructor
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    //Method to calculate grade based on marks
    public char gradeCalculation (){
        if(marks >=0 && marks <=100){
            if(marks>=90 && marks <= 100){
                return 'A' ;
            } else if (marks>=76 && marks<=89){
                return 'B' ;
            } else if(marks>=56 && marks<=75){
                return 'C' ;
            } else if (marks>=33 && marks<=55){
                return 'D' ;
            } else if (marks>=33 && marks<=45){
                return 'E' ;
            } else {
                return 'F' ;
            }
        } else {
            System.out.println("Invalid marks");
            System.exit(0);
        }
        return 0 ;
    }

    //Method to display details and gade
    public void displayDetails(){
        System.out.println("\tStudent Details\t");
        System.out.println("Name of student: " + name);
        System.out.println("Roll number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + gradeCalculation());
        
    }
}
public class StudentReport{
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter student name");
        String name = sc.nextLine() ;

        System.out.println("Enter student roll number");
        int rollNumber = sc.nextInt() ;

        System.out.println("Enter student marks");
        double marks = sc.nextDouble() ;

        //Creating object of Student class and giving value in parameterized constructor
        Student s1 = new Student(name , rollNumber , marks);
        //Calling method via object
        s1.displayDetails();

        //Closing scanner class instance
        sc.close();
    }

}