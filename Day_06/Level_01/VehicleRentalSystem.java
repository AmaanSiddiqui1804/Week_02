/* Vehicle Rental System
Description: Design a system to manage vehicle rentals:
Define an abstract class Vehicle with fields like vehicleNumber, type, and rentalRate.
Add an abstract method calculateRentalCost(int days).
Create subclasses Car, Bike, and Truck with specific implementations of 
calculateRentalCost().
Use an interface Insurable with methods calculateInsurance() and getInsuranceDetails().
Apply encapsulation to restrict access to sensitive details like insurance policy numbers.
Demonstrate polymorphism by iterating over a list of vehicles and calculating rental 
and insurance costs for each.
*/
import java.util.ArrayList;
import java.util.List;
// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber; // Encapsulation for sensitive data
    private String type;
    private double rentalRate;

    // Constructor to initialize fields
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Abstract method to calculate rental cost
    public abstract double calculateRentalCost(int days);

    // Getter and Setter methods
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }
}
//Interfaces 
interface Insurable {
    double calculateInsurance() ;
    String getInsuranceDetails() ;
}
//Subclass
class Car extends Vehicle implements Insurable {

    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate); // Type is always "Car"
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.1; // Insurance is 10% of the rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance: Covers damage and liability.";
    }
}


class Bike extends Vehicle implements Insurable {

    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate); // Type is always "Bike"
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // Insurance is 5% of the rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance: Covers basic theft and accident damage.";
    }
} 

class Truck extends Vehicle implements Insurable {

    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate); // Type is always "Truck"
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.2; // Trucks have an additional surcharge (20%)
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; // Insurance is 15% of the rental rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance: Covers cargo and accident liability.";
    }
}


public class VehicleRentalSystem {
    public static void main(String[] args) {
        // Create a list of Vehicle objects
        List<Vehicle> vehicles = new ArrayList<>();

        // Add Car, Bike, and Truck objects
        vehicles.add(new Car("MP 04 AA 9827", 1000));
        vehicles.add(new Bike("MP 04 BB 8982", 500));
        vehicles.add(new Truck("21 BH 1234 PA", 3000));

        // Number of days for rental
        int rentalDays = 5;

        // Display details for each vehicle
        for (Vehicle vehicle : vehicles) {
            System.out.println("Vehicle Number: " + vehicle.getVehicleNumber());
            System.out.println("Type: " + vehicle.getType());
            System.out.println("Rental Rate: " + vehicle.getRentalRate());
            System.out.println("Rental Cost for " + rentalDays + " days: " + vehicle.calculateRentalCost(rentalDays));

            // Check if the vehicle is insurable
            if (vehicle instanceof Insurable) {
                Insurable insurableVehicle = (Insurable) vehicle;
                System.out.println(insurableVehicle.getInsuranceDetails());
                System.out.println("Insurance Cost: " + insurableVehicle.calculateInsurance());
            }

            System.out.println("-----------------------------------");
        }
    }
}
