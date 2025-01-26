
// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    // Constructor to initialize vehicle attributes
    Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.setVehicleId(vehicleId);
        this.setDriverName(driverName);
        this.setRatePerKm(ratePerKm);
    }

    // Abstract method to calculate fare
    abstract double calculateFare(double distance);

    // Concrete method to get vehicle details
    public void getVehicleDetails() {
        System.out.println("\n\tVehicle Details: ");
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate Per Km: Rs " + ratePerKm);
    }

    // Getter and Setter methods for encapsulation
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }
}

// Interface GPS
interface GPS {
    String getCurrentLocation();

    void updateLocation(String newLocation);
}

// Car class (subclass of Vehicle implementing GPS interface)
class Car extends Vehicle implements GPS {
    private String currentLocation;

    // Constructor to initialize Car attributes
    Car(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    // Overriding calculateFare method
    @Override
    double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    // Implementing GPS methods
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Bike class (subclass of Vehicle implementing GPS interface)
class Bike extends Vehicle implements GPS {
    private String currentLocation;

    // Constructor to initialize Bike attributes
    Bike(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    // Overriding calculateFare method
    @Override
    double calculateFare(double distance) {
        return distance * getRatePerKm() * 0.9; // 10% discount for bikes
    }

    // Implementing GPS methods
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Auto class (subclass of Vehicle implementing GPS interface)
class Auto extends Vehicle implements GPS {
    private String currentLocation;

    // Constructor to initialize Auto attributes
    Auto(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    // Overriding calculateFare method
    @Override
    double calculateFare(double distance) {
        return distance * getRatePerKm() + 10; // Additional flat charge for autos
    }

    // Implementing GPS methods
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

/*
Main Class RideHailingApplication
Purpose: Demonstrates the functionality of the ride-hailing application.
*/
public class RideHailingApplication {
    public static void main(String[] args) {
        // Array of vehicles
        Vehicle[] vehicles = {
            new Car("C101", "Ibrahim Khan", 15, "Jhangirabad"),
            new Bike("B202", "Neeraj Prajapati", 8, "Ayodhya Bypass"),
            new Auto("A303", "Amaan", 100, "Hazrat Nizamuddin")
        };

        // Calculating fare dynamically using polymorphism
        double[] distances = {10.5, 7.2, 12.0}; // Sample distances for each vehicle
        for (int i = 0; i < vehicles.length; i++) {
            Vehicle vehicle = vehicles[i];
            vehicle.getVehicleDetails();
            System.out.println("Current Location: " + ((GPS) vehicle).getCurrentLocation());
            System.out.println("Fare for " + distances[i] + " km: Rs " + vehicle.calculateFare(distances[i]));
            ((GPS) vehicle).updateLocation("New Location " + (i + 1));
            System.out.println("Updated Location: " + ((GPS) vehicle).getCurrentLocation());
            System.out.println("-----------------------------------");
        }
    }
}
