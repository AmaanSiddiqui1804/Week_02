/* Sample Problem 2: School System with Different Roles
Description: Create a hierarchy for a school system where Person is the superclass, 
and Teacher, Student, and Staff are subclasses.
Tasks:
Define a superclass Person with common attributes like name and age.
Define subclasses Teacher, Student, and Staff with specific attributes 
(e.g., subject for Teacher and grade for Student).
Each subclass should have a method like displayRole() that describes the role.
Goal: Demonstrate hierarchical inheritance by modeling different roles in a school, 
each with shared and unique characteristics. 
*/
//Super class
class Person {
    String name;
    int age;

    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display common details
    public void displayDetails() {
        System.out.println("Name: " + name + "\nAge: " + age);
    }

    // Method to display role (overridden in subclasses)
    public void displayRole() {
        System.out.println("Role: General Person");
    }
}
//subclass
class Teacher extends Person {
    String subject;

    // Constructor
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    // Overriding method to display teacher details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Subject: " + subject);
    }

    // Overriding method to display role
    @Override
    public void displayRole() {
        System.out.println("Role: Teacher");
    }
}
//Subclass
class Student extends Person {
    char grade;

    // Constructor
    public Student(String name, int age, char grade) {
        super(name, age);
        this.grade = grade;
    }

    // Overriding method to display student details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Grade: " + grade);
    }

    // Overriding method to display role
    @Override
    public void displayRole() {
        System.out.println("Role: Student");
    }
}
//Sub class
class Staff extends Person {
    int numberOfStaff;

    // Constructor
    public Staff(String name, int age, int numberOfStaff) {
        super(name, age);
        this.numberOfStaff = numberOfStaff;
    }

    // Overriding method to display staff details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Number of Staff Members: " + numberOfStaff);
    }

    // Overriding method to display role
    @Override
    public void displayRole() {
        System.out.println("Role: Staff Member");
    }
}
//main class
public class SchoolSystem {
    public static void main(String[] args) {

        // Creating Objects
        Teacher teacher = new Teacher("Amol Nagose", 35, "Java");
        Student student = new Student("Amaan", 21, 'A');
        Staff staff = new Staff("Vishnu", 30, 15);

        // Displaying details
        System.out.println("=== Teacher Details ===");
        teacher.displayDetails();
        teacher.displayRole();

        System.out.println("\n=== Student Details ===");
        student.displayDetails();
        student.displayRole();

        System.out.println("\n=== Staff Details ===");
        staff.displayDetails();
        staff.displayRole();
    }
}

