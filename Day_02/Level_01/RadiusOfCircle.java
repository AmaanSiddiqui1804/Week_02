/*Write a Circle class with a radius attribute. Use constructor chaining to
initialize radius with default and user-provided values.
 */
import java.util.Scanner;

class Circle {
    double radius ;

    //Default Constructor
    public Circle(){
        radius = 7 ;
    }
    //Parameterized Constructor
    public Circle (double radius){
        this.radius = radius;
    }

    //Method to calculate and display the Circumference of circle
    public void displayRadius() {
        //displaying radius using parameterized constructor
        System.out.println("Radius of circle : " + radius);
    }
}

public class RadiusOfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius: ");
        double radius = sc.nextDouble();

        //Creating object of Circle class and calling Default constructor
        Circle c2 = new Circle() ;
        System.out.println("Default Constructor");
        c2.displayRadius();

        //Creating object of Circle class and giving value in parameterized constructor
        Circle c1 = new Circle(radius);
        //Calling method with object to calculate circumference
        System.out.println("Parameterized Constructor");
        c1.displayRadius();

        //Closing scanner class
        sc.close();
    }
}
