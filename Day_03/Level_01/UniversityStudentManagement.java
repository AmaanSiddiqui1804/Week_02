/* Sample Program 5: UniversityStudentManagement
Create a Student class to manage student data with the following features:
Static:
A static variable universityName shared across all students.
A static method displayTotalStudents() to show the number of students enrolled.
This:
Use this in the constructor to initialize name, rollNumber, and grade.
Final:
Use a final variable rollNumber for each student that cannot be changed.
Instanceof:
Check if a given object is an instance of the Student class before performing operations like displaying or updating grades.
*/

import java.util.Scanner;

class Student {
    // Static variable shared across all students
    static String universityName = "Technocrats Institute of Technology";
    private String studentName;
    private final int rollNumber; // Final variable for unique roll number
    private char grade;
    private static int totalStudents; // Static variable to track total students

    // Constructor to initialize student attributes
    Student(String studentName, int rollNumber, char grade) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.grade = grade;
        totalStudents++; // Increment total students count
    }

    // Static method to display the total number of students
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }

    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("University Name: " + universityName);
        System.out.println("Student Name: " + studentName);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Grade: " + grade);
    }

    // Method to update the grade of the student
    public void updateGrade(char newGrade) {
        grade = newGrade;
        System.out.println("Grade updated to: " + grade);
    }
}

public class UniversityStudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input details for the first student
        System.out.print("Enter student name: ");
        String studentName1 = sc.nextLine();
        System.out.print("Enter student roll number: ");
        int rollNumber1 = sc.nextInt();
        System.out.print("Enter student grade: ");
        char grade1 = sc.next().charAt(0);

        // Creating the first student object
        Student stu1 = new Student(studentName1, rollNumber1, grade1);

        //taking input for second student
        sc.nextLine();
        System.out.print("\nEnter another student name: ");
        String studentName2 = sc.nextLine();
        System.out.print("Enter student roll number: ");
        int rollNumber2 = sc.nextInt();
        System.out.print("Enter student grade: ");
        char grade2 = sc.next().charAt(0);

        // Creating the second student object
        Student stu2 = new Student(studentName2, rollNumber2, grade2);

        // Checking if stu1 is an instance of Student and displaying details
        if (stu1 instanceof Student) {
            System.out.println("\nStudent 1 Details:");
            stu1.displayStudentDetails();
        }

        // Checking if stu2 is an instance of Student and displaying details
        if (stu2 instanceof Student) {
            System.out.println("\nStudent 2 Details:");
            stu2.displayStudentDetails();
        }

        // Updating grade for the first student
        System.out.print("\nUpdate grade for " + studentName1 + ": ");
        char newGrade = sc.next().charAt(0);
        stu1.updateGrade(newGrade);

        // Displaying total students enrolled
        System.out.println("\n");
        Student.displayTotalStudents();

        sc.close();
    }
}
