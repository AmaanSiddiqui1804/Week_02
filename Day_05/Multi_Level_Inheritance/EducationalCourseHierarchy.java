/* Sample Problem 2: Educational Course Hierarchy
Description: Model a course system where Course is the base class, OnlineCourse is a subclass, and 
PaidOnlineCourse extends OnlineCourse.
Tasks:
Define a superclass Course with attributes like courseName and duration.
Define OnlineCourse to add attributes such as platform and isRecorded.
Define PaidOnlineCourse to add fee and discount.
Goal: Demonstrate how each level of inheritance builds on the previous, adding complexity to the system.
*/

// Base class representing a general course
class Course {
    String courseName; // Name of the course
    String duration;   // Duration of the course

    // Constructor for Course
    public Course(String courseName, String duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    // Method to display course details
    public void courseDetails() {
        System.out.println("Course name: " + courseName + "\nDuration: " + duration);
    }

    // Getters for attributes
    public String getCourseName() {
        return courseName;
    }

    public String getDuration() {
        return duration;
    }
}

// Subclass of Course 
class OnlineCourse extends Course {
    //Attributes  
    String platform;  
    boolean isRecorded; 

    // Constructor for OnlineCourse
    public OnlineCourse(String courseName, String duration, String platform, boolean isRecorded) {
        super(courseName, duration); // Call to base class constructor
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    // Overriding method to display online course details
    @Override
    public void courseDetails() {
        System.out.println("Course name: " + courseName + "\nDuration: " + duration + "\nPlatform: " + 
                            platform + "\nIs Lecture Recorded: " + (isRecorded ? "Yes" : "No"));
    }

    // Getter for platform
    public String getPlatform() {
        return platform;
    }
}

// Subclass of OnlineCourse 
class PaidOnlineCourse extends OnlineCourse {
    int fee;      // Course fee
    int discount; // Discount on the fee

    // Constructor for PaidOnlineCourse
    public PaidOnlineCourse(String courseName, String duration, String platform, boolean isRecorded, int fee, int discount) {
        super(courseName, duration, platform, isRecorded); // Call to parent class constructor
        this.fee = fee;
        this.discount = discount;
    }

    // Overriding method to display paid online course details
    @Override
    public void courseDetails() {
        System.out.println("Course name: " + courseName + "\nDuration: " + duration + 
                           "\nPlatform: " + platform + "\nIs Lecture Recorded: " + (isRecorded ? "Yes" : "No") + 
                           "\nFee: Rs" + fee + "/- \nDiscount: " + discount + "%");
    }
}

public class EducationalCourseHierarchy {
    public static void main(String[] args) {

        // Creating a base course object
        Course course = new Course("JAVA", "3 months");

        // Creating an online course object using the base course's details
        OnlineCourse onlineCourse = new OnlineCourse(course.getCourseName(), course.getDuration(), "Bridge Labz", false);

        // Creating a paid online course object using the online course's details
        PaidOnlineCourse paidOnlineCourse = new PaidOnlineCourse(
            course.getCourseName(), course.getDuration(), onlineCourse.getPlatform(), false, 7000, 25);

        // Displaying course details
        System.out.println("=== Base Course ===");
        course.courseDetails(); // Displays base course details

        System.out.println("\n=== Online Course ===");
        onlineCourse.courseDetails(); // Displays online course details

        System.out.println("\n=== Paid Online Course ===");
        paidOnlineCourse.courseDetails(); // Displays paid online course details
    }
}
