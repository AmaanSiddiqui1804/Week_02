/* Sample Program 6: Vehicle Registration System
Create a Vehicle class with the following features:
Static:
A static variable registrationFee common for all vehicles.
A static method updateRegistrationFee() to modify the fee.
This:
Use this to initialize ownerName, vehicleType, and registrationNumber in the constructor.
Final:
Use a final variable registrationNumber to uniquely identify each vehicle.
Instanceof:
Check if an object belongs to the Vehicle class before displaying its registration details. 
*/ 

class Vehicle {
    // Static variable common for all vehicles
    static int registrationFee = 500;

    private String ownerName;
    private String vehicleType;
    private final int registrationNumber; // Final variable for unique registration number

    // Constructor
    Vehicle(String ownerName, String vehicleType, int registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    // Static method to update the registration fee
    public static void updateRegistrationFee(int newRegistrationFee) {
        registrationFee = newRegistrationFee;
        System.out.println("Registration fee updated to: " + registrationFee);
    }

    // Method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Registration Fee: " + registrationFee);
    }
}

public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        // Creating vehicle class objects
        Vehicle vehicle1 = new Vehicle("Sonu Sharma ", "Car", 101);
        Vehicle vehicle2 = new Vehicle("Tikesh ", "Motorcycle", 102);
        Vehicle vehicle3 = new Vehicle("Abhay Gautam", "Truck", 103);

        // Updating registration fee
        Vehicle.updateRegistrationFee(700);

        // Displaying vehicle details if they belong to the Vehicle class
        if (vehicle1 instanceof Vehicle) {
            System.out.println("\nVehicle 1 Details:");
            vehicle1.displayVehicleDetails();
        }

        if (vehicle2 instanceof Vehicle) {
            System.out.println("\nVehicle 2 Details:");
            vehicle2.displayVehicleDetails();
        }

        if (vehicle3 instanceof Vehicle) {
            System.out.println("\nVehicle 3 Details:");
            vehicle3.displayVehicleDetails();
        }
    }
}
