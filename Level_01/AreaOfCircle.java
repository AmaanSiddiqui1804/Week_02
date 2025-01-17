/* Program to Compute Area of a Circle
Problem Statement: Write a program to create a Circle class with an 
attribute radius. Add methods to calculate and display the area and 
circumference of the circle.*/

import java.util.Scanner;

class Circle {
    double radius ;

    public Circle (double radius){
        this.radius = radius;
    }

    //Methoid to calculate and display the Circumference of circle
    public void calculateCircumference(){
        double pi = Math.round((22/7)*1000.0) /1000.0; //Rounding pi for upto 3 decimal places
        double circumference = 2*pi*radius; //Calculating circumference

        //displaying circumference
        System.out.println("Circumference of circle: " + circumference);
    }

    //Methoid to calculate and display the Area of circle
    public void calculateArea(){
        double pi = Math.round((22/7)*1000.0) /1000.0; //Rounding pi for upto 3 decimal places
        double area = 2*pi*radius*radius; //Calculating area

        //displaying circumference
        System.out.println("Area of circle: " + area);
    }
}
public class AreaOfCircle{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter radius to calculate circumference and area of Circle");
        double radius = sc.nextDouble();
        //Creating object of Circle class and giving value in parameterized constructor
        Circle c1 = new Circle(radius);
        //Calling method with object to calculate circumference
        c1.calculateCircumference();
        //Calling method with object to calculate area
        c1.calculateArea();
        //Closing scanner class
        sc.close();
    }
}