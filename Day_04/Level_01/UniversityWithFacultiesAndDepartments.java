/* Problem 2: University with Faculties and Departments (Composition and Aggregation)
Description: Create a University with multiple Faculty members and Department objects. 
Model it so that the University and its Departments are in a composition 
relationship (deleting a university deletes all departments), and the Faculty members 
are in an aggregation relationship (faculty can exist outside of any 
specific department).
Tasks:
Define a University class with Department and Faculty classes.
Demonstrate how deleting a University also deletes its Departments.
Show that Faculty members can exist independently of a Department.
Goal: Understand the differences between composition and aggregation in modeling complex hierarchical relationships.*/
 
import java.util.ArrayList;
class University {
    String universityName ;
    ArrayList<Department> departments ;

    public University(String name) {
        this.universityName = name ;
        this.departments = new ArrayList<>() ;
    }
    //Method to add department
    public void addDepartment(Department department) {
        departments.add(department) ;
        System.out.println("Department " + department.getDepartmentName() + " has been added to " + universityName) ;
    }

    //Method to remove a department
    public void removeDepartment(Department department) {
        departments.remove(department) ;
        System.out.println("Department " + department.getDepartmentName() + " has been removed from " + universityName) ;
    }

    //Method to display all departments in the university
    public void displayDepartmets() {
        System.out.println("\nDepartments in " + universityName + ":") ;
        for (Department department : departments) {
            department.displayFacultiesInDepartment() ;
        }
    }
}

class Department {
    private String departmentName ;
    private ArrayList<Faculty> faculties ; //Aggregation: A department contains multiple faculties

    public Department(String name) {
        this.departmentName = name ;
        this.faculties = new ArrayList<>() ;
    }

    //Method to add a faculty
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty) ;
        System.out.println("Faculty " + faculty.getFacultyName() + " has been added to " + departmentName) ;
    }

    //Method to remove a faculty
    public void removeFaculty(Faculty faculty) {
        faculties.remove(faculty) ;
        System.out.println("Faculty " + faculty.getFacultyName() + " has been removed from " + departmentName) ;
    }

    //Method to display all faculties in the department
    public void displayFacultiesInDepartment() {
        System.out.println("\nFaculties in " + departmentName + ":") ;
        for (Faculty faculty : faculties) {
            faculty.displayFacultyDetails() ;
        }
    }

    //Method to get department name
    public String getDepartmentName() {
        return departmentName ;
    }
}

class Faculty {
    private String facultyName ;
    private int facultyId ;

    Faculty(String name, int id) {
        this.facultyName = name ;
        this.facultyId = id ;
    }

    //Method to display faculty details
    public void displayFacultyDetails() {
        System.out.println("Name: " + facultyName + ", ID: " + facultyId) ;
    }

    //Method getFacultyName
    public String getFacultyName() {
        return facultyName ;
    }
}
public class UniversityWithFacultiesAndDepartments {
    public static void main(String[] args) {
        
        //Creating a university
        University universityName = new University("AA University") ;

        //Creating departments (Composition relationship)
        Department csDepartment = new Department("Computer Science") ;
        Department eeeDepartment = new Department("Electrical and Electronics") ;

        //Adding departments to faculties
        universityName.addDepartment(csDepartment);
        universityName.addDepartment(eeeDepartment);
        
        //Displaying departments in university
        System.out.println("Departments in " + universityName + "\n" + csDepartment.getDepartmentName() + "\n" + eeeDepartment.getDepartmentName());
        
        //Creating faculty members (Aggregation Relationship)
        Faculty csFaculty1 = new Faculty("Abhay Gautam", 101);
        Faculty csFaculty2 = new Faculty("Tikesh Kardate", 102);
        Faculty eeeFaculty1 = new Faculty("Nishank", 103);
        Faculty eeeFaculty2 = new Faculty("Amaan Siddiqui",104) ;

        //Adding faculties to Department
        csDepartment.addFaculty(csFaculty1);
        csDepartment.addFaculty(csFaculty2);
        eeeDepartment.addFaculty(eeeFaculty1);
        eeeDepartment.addFaculty(eeeFaculty2);

        //Displaying University Details
        System.out.println("\n--- Universiy Details ---\n");
        universityName.displayDepartmets();

        //Aggregation demonstration
        System.out.println("Faculty can exist independantly (Aggregation)");
        Faculty independentFaculty = new Faculty("Sonu", 211045) ;
        independentFaculty.displayFacultyDetails();

        //Composition Demonstration
        System.out.println("Deleting a university deletes it department");
        universityName = null ; //University deleted (declared as null) 

        System.out.println("University deleted. All associated departments are also removed.");
    
    }
}
