import java.util.ArrayList;

// University Class
class University {
    private String universityName;
    private ArrayList<Department> departments;

    public University(String name) {
        this.universityName = name;
        this.departments = new ArrayList<>();
    }

    // Method to add a department
    public void addDepartment(Department department) {
        departments.add(department);
        System.out.println("Department " + department.getDepartmentName() + " has been added to " + universityName);
    }

    // Method to remove a department
    public void removeDepartment(Department department) {
        departments.remove(department);
        System.out.println("Department " + department.getDepartmentName() + " has been removed from " + universityName);
    }

    // Method to display all departments in the university
    public void displayDepartments() {
        System.out.println("\nDepartments in " + universityName + ":");
        for (Department department : departments) {
            department.displayFacultiesInDepartment();
        }
    }
}

// Department Class
class Department {
    private String departmentName;
    private ArrayList<Faculty> faculties; // Aggregation: A department contains multiple faculties
    private ArrayList<Course> courses;    // Aggregation: A department offers multiple courses

    public Department(String name) {
        this.departmentName = name;
        this.faculties = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    // Method to add a faculty
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
        System.out.println("Faculty " + faculty.getFacultyName() + " has been added to " + departmentName);
    }

    // Method to add a course
    public void addCourse(Course course) {
        courses.add(course);
        System.out.println("Course " + course.getCourseName() + " has been added to the " + departmentName + " department.");
    }

    // Method to display all faculties in the department
    public void displayFacultiesInDepartment() {
        System.out.println("\nFaculties in " + departmentName + ":");
        for (Faculty faculty : faculties) {
            faculty.displayFacultyDetails();
        }
    }

    // Method to display all courses in the department
    public void displayCoursesInDepartment() {
        System.out.println("\nCourses offered in " + departmentName + ":");
        for (Course course : courses) {
            course.displayCourseDetails();
        }
    }

    public String getDepartmentName() {
        return departmentName;
    }
}

// Faculty Class
class Faculty {
    private String facultyName;
    private int facultyId;

    Faculty(String name, int id) {
        this.facultyName = name;
        this.facultyId = id;
    }

    public void displayFacultyDetails() {
        System.out.println("Name: " + facultyName + ", ID: " + facultyId);
    }

    public String getFacultyName() {
        return facultyName;
    }
}

// Course Class
class Course {
    private String courseName;
    private Professor professor;           // Association: A course is taught by a professor
    private ArrayList<Student> students;   // Aggregation: A course can have multiple students enrolled

    public Course(String name) {
        this.courseName = name;
        this.students = new ArrayList<>();
    }

    // Assign a professor to the course
    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println("Professor " + professor.getProfessorName() + " has been assigned to " + courseName);
    }

    // Enroll a student in the course
    public void enrollStudent(Student student) {
        students.add(student);
        System.out.println("Student " + student.getStudentName() + " has enrolled in " + courseName);
    }

    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        if (professor != null) {
            System.out.println("Taught by: " + professor.getProfessorName());
        }
        System.out.println("Enrolled Students:");
        for (Student student : students) {
            System.out.println("- " + student.getStudentName());
        }
    }

    public String getCourseName() {
        return courseName;
    }
}

// Professor Class
class Professor {
    private String professorName;

    public Professor(String name) {
        this.professorName = name;
    }

    public String getProfessorName() {
        return professorName;
    }
}

// Student Class
class Student {
    private String studentName;

    public Student(String name) {
        this.studentName = name;
    }

    public String getStudentName() {
        return studentName;
    }
}

// Main Class
public class University2{
    public static void main(String[] args) {
        // Create a university
        University university = new University("AA University");

        // Create departments
        Department csDepartment = new Department("Computer Science");
        Department eeeDepartment = new Department("Electrical and Electronics");

        university.addDepartment(csDepartment);
        university.addDepartment(eeeDepartment);

        // Create faculties
        Faculty csFaculty1 = new Faculty("Abhay Gautam", 101);
        Faculty csFaculty2 = new Faculty("Tikesh Kardate", 102);

        csDepartment.addFaculty(csFaculty1);
        csDepartment.addFaculty(csFaculty2);

        // Create courses
        Course javaCourse = new Course("Java Programming");
        Course networksCourse = new Course("Computer Networks");

        csDepartment.addCourse(javaCourse);
        csDepartment.addCourse(networksCourse);

        // Create professors
        Professor prof1 = new Professor("Dr. Nishank");
        Professor prof2 = new Professor("Dr. Amaan Siddiqui");

        javaCourse.assignProfessor(prof1);
        networksCourse.assignProfessor(prof2);

        // Create students
        Student student1 = new Student("Sonu Sharma");
        Student student2 = new Student("Naman Banke");

        javaCourse.enrollStudent(student1);
        javaCourse.enrollStudent(student2);

        // Display university details
        System.out.println("\n--- University Details ---");
        university.displayDepartments();

        // Display courses and enrollment
        csDepartment.displayCoursesInDepartment();
    }
}
