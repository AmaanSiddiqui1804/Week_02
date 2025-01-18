
class Course {
    String courseName ;
    int duration ;
    int fee ;
    static String instituteName = "TIT" ;

    //Parameterized Constructor
    public Course(String courseName, int duration, int fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee ;
    }

    //Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Course details:\n");
        System.out.println("Course Name: " + courseName + "\nDuration: " + duration + "\nFee: " +
                         fee + " Rupees" + "\nInstitute Name: " + instituteName);
    }

    //Class method to update institute name 
    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName ;
    }

}
public class OnlineCourseManagement {
    public static void main(String[] args) {

        // Creating object of Course class
        Course c1 = new Course("Java", 3, 5000); //Passing values for parameterised Constructor
        Course c2 = new Course("Python", 2, 4000); //Passing values for parameterised Constructor
        Course c3 = new Course("C++", 4, 6000); //Passing values for parameterised Constructor

        // Displaying course details
        c1.displayCourseDetails();
        c2.displayCourseDetails();
        c3.displayCourseDetails();

        //Updating Institute name 
        Course.updateInstituteName("Technocrats Institute of Technology") ;

        // Displaying course details after updating institute name 
        // We are using class name to call class method instead of object 
        System.out.println("\n\nDisplaying course details after updating institute name: \n");
        c1.displayCourseDetails();
        c2.displayCourseDetails();
        c3.displayCourseDetails();
        
    }
}
