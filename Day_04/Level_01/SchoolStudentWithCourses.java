/* Problem 1: School and Students with Courses (Association and Aggregation)
Description: Model a School with multiple Student objects, where each student can enroll in multiple courses, and 
each course can have multiple students.
Tasks:
Define School, Student, and Course classes.
Model an association between Student and Course to show that students can enroll in multiple courses.
Model an aggregation relationship between School and Student.
Demonstrate how a student can view the courses they are enrolled in and how a course can show its enrolled students.
Goal: Practice association by modeling many-to-many relationships between students and courses.*/

import java.util.ArrayList; 

class School {
    private String schoolName;
    private ArrayList<Student> students; // Aggregation: A school contains multiple students

    // Constructor to initialize a school
    School(String name) {
        this.schoolName = name;
        this.students = new ArrayList<>();
    }

    // Method to add a student to the school
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student " + student.getStudentName() + " has been added to " + schoolName);
    }

    // Method to display all students in the school
    public void displaySchoolStudents() {
        System.out.println("\nStudents in " + schoolName + ":");
        for (Student student : students) {
            student.viewEnrolledCourses(); // Display each student's details and courses
        }
    }
}

class Student {
    private String studentName;
    private int studentId;
    private ArrayList<Course> enrolledCourses; // Association: A student can enroll in multiple courses

    // Constructor to initialize a student
    Student(String name, int id) {
        this.studentName = name;
        this.studentId = id;
        this.enrolledCourses = new ArrayList<>();
    }

    // Method to enroll a course
    public void enrollCourse(Course course) {
        enrolledCourses.add(course); // Add course to student's enrolled list
        course.addStudent(this); // Add this student to the course's list of students
        System.out.println("Student " + studentName + " has been enrolled in " + course.getCourseName());
    }

    // Method to display courses a student is enrolled in
    public void viewEnrolledCourses() {
        System.out.println("Name: " + studentName + ", ID: " + studentId + " is enrolled in:");
        for (Course course : enrolledCourses) {
            System.out.println("  - " + course.getCourseName() + " (Course ID: " + course.getCourseId() + ")");
        }
    }

    // Method to get student name
    public String getStudentName() {
        return studentName;
    }
}

class Course {
    private String courseName;
    private int courseId;
    private ArrayList<Student> enrolledStudents; // Aggregation: A course contains multiple students

    // Constructor to initialize a course
    Course(String name, int id) {
        this.courseName = name;
        this.courseId = id;
        this.enrolledStudents = new ArrayList<>();
    }

    // Method to add a student to the course
    public void addStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    // Method to display all students enrolled in the course
    public void viewEnrolledStudents() {
        System.out.println("\nStudents enrolled in " + courseName + ":");
        for (Student student : enrolledStudents) {
            System.out.println("  - " + student.getStudentName());
        }
    }

    // Method to get course name
    public String getCourseName() {
        return courseName;
    }

    // Method to get course ID
    public int getCourseId() {
        return courseId;
    }
}

public class SchoolStudentWithCourses {
    public static void main(String[] args) {
        
        // Creating a school
        School school = new School("Bridge Labz School");

        // Creating students
        Student student1 = new Student("Abraham", 211001);
        Student student2 = new Student("Abhay", 211002);
        Student student3 = new Student("Tikesh", 211003);
        Student student4 = new Student("Nishank", 211004);
        Student student5 = new Student("Sonu", 211005);

        // Creating courses
        Course course1 = new Course("Java", 101);
        Course course2 = new Course("Python", 102);
        Course course3 = new Course("C++", 103);

        // Adding students to the school (Aggregation relationship)
        school.addStudent(student1);
        school.addStudent(student2);
        school.addStudent(student3);
        school.addStudent(student4);
        school.addStudent(student5);

        System.out.println();
        // Students enrolling in courses (Association relationship)
        student1.enrollCourse(course1);
        student2.enrollCourse(course1);
        student3.enrollCourse(course2);
        student4.enrollCourse(course2);
        student5.enrollCourse(course3);

        // Displaying students in the school with courses they are enrolled in
        school.displaySchoolStudents();

        // Displaying all students in each course
        System.out.println("\n--- Course Enrollments ---");
        course1.viewEnrolledStudents();
        course2.viewEnrolledStudents();
        course3.viewEnrolledStudents();

    }
}
