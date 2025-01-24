/* Sample Problem 2: Vehicle Management System with Hybrid Inheritance
Description: Model a vehicle system where Vehicle is the superclass and 
ElectricVehicle and PetrolVehicle are subclasses. Additionally, create a 
Refuelable interface implemented by PetrolVehicle.
Tasks:
Define a superclass Vehicle with attributes like maxSpeed and model.
Create an interface Refuelable with a method refuel().
Define subclasses ElectricVehicle and PetrolVehicle. PetrolVehicle should implement 
Refuelable, while ElectricVehicle include a charge() method.
Goal: Use hybrid inheritance by having PetrolVehicle implement both Vehicle and Refuelable, 
demonstrating how Java interfaces allow adding multiple behaviors.
*/

// Superclass Vehicle
class Vehicle {
    int maxSpeed;
    String model;

    // Constructor for Vehicle
    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    // Method to display vehicle details
    public void displayDetails() {
        System.out.println("Model: " + model + "\nMax Speed: " + maxSpeed + " km/h");
    }
}

// Interface Refuelable
interface Refuelable {
    // Abstract method to refuel a vehicle
    void refuel();
}

// Subclass ElectricVehicle inheriting from Vehicle
class ElectricVehicle extends Vehicle {
    int batteryCapacity; // in kWh

    // Constructor for ElectricVehicle
    public ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }

    // Method to charge the electric vehicle
    public void charge() {
        System.out.println("Charging the electric vehicle with a battery capacity of " + batteryCapacity + " kWh.");
    }

    // Overriding displayDetails to include battery capacity
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

// Subclass PetrolVehicle inheriting from Vehicle and implementing Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {
    int fuelCapacity; // in liters

    // Constructor for PetrolVehicle
    public PetrolVehicle(int maxSpeed, String model, int fuelCapacity) {
        super(maxSpeed, model);
        this.fuelCapacity = fuelCapacity;
    }

    // Overriding the refuel method from Refuelable
    @Override
    public void refuel() {
        System.out.println("Refueling the petrol vehicle with a tank capacity of " + fuelCapacity + " liters.");
    }

    // Overriding displayDetails to include fuel capacity
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Fuel Capacity: " + fuelCapacity + " liters");
    }
}

// Main class to test the implementation
public class VehicleManagementSystem {
    public static void main(String[] args) {
        // Creating an ElectricVehicle object
        ElectricVehicle ev = new ElectricVehicle(150, "Tesla Model 3", 75);

        // Creating a PetrolVehicle object
        PetrolVehicle pv = new PetrolVehicle(180, "Ford Mustang", 60);

        // Display details and demonstrate behavior for ElectricVehicle
        System.out.println("\t Electric Vehicle Details");
        ev.displayDetails();
        ev.charge();

        // Display details and demonstrate behavior for PetrolVehicle
        System.out.println("\n\t Petrol Vehicle Details");
        pv.displayDetails();
        pv.refuel();
    }
}
