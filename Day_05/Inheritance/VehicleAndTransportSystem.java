//package com.week_02_day_05_q3_vehicle_and_transport_system;

class Vehicle {
    //Attributes
    int maxSpeed ;
    String fuelType ;

    //Constructor
    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed ;
        this.fuelType = fuelType ;
    }
    //Method to display details
    public void displayInfo() {
        System.out.println("Details of vehicle will be displayed here. (Vehicle Class)");
        System.out.println("Vehicle type: Vehicle  \nMax Speed: " + maxSpeed+ "Km/hr" + "\nFuel Type: " + fuelType);
    }
}
class Car extends Vehicle {
    //Attributes and Constructor
    int seatCapacity ;
    public Car(int maxSpeed, String fuelType, int seatCapacity){
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity ;
    }
    //Overridin method
    @Override
    public void displayInfo() {
        System.out.println("Vehicle type: Car  \nMax Speed: " + maxSpeed + "Km/hr" + "\nFuel Type: " + fuelType + "\nSeating Capacity: " + seatCapacity);
    }
}
class Truck extends Vehicle {
    //Attributes and Constructor
    int loadingCapacity ;
    public Truck(int maxSpeed, String fuelType, int loadingCapacity){
        super(maxSpeed, fuelType);
        this.loadingCapacity = loadingCapacity ;
    }
    //Method overriding
    @Override
    public void displayInfo() {
        System.out.println("Vehicle type: Truck  \nMax Speed: " + maxSpeed + "Km/hr" + "\nFuel Type: " + fuelType + "\nLoading Capacity: " + loadingCapacity + " Kg.");
    }
}

class Motorcycle extends Vehicle {
    //Attributes and Constructor
    int numberOfWheels ;
    public Motorcycle(int maxSpeed, String fuelType, int numberOfWheels){
        super(maxSpeed, fuelType);
        this.numberOfWheels = numberOfWheels ;
    }
    @Override
    public void displayInfo() {
        System.out.println("Vehicle type: Motorcycle  \nMax Speed: " + maxSpeed+ "Km/hr" + "\nFuel Type: " + fuelType + "\nNumber of wheels: " + numberOfWheels);
    }
}

public class VehicleAndTransportSystem {
    public static void main(String[] args) {

        //Object creation
        Vehicle vehicle = new Vehicle(100, "Petrol");
        Vehicle car = new Car(300, "Petrol", 5);
        Vehicle truck = new Truck(150, "Diesel", 3000);
        Vehicle motorcycle = new Motorcycle(200, "Electric", 2);

        //Calling method to display details
        vehicle.displayInfo();
        car.displayInfo();
        truck.displayInfo();
        motorcycle.displayInfo();
    }
}
