class Vehicle {
    String ownerName ;
    String vehicleType ; // Sedan, SUV, Hatchback
    static int registerationFee = 5000 ;

    //Parameterized Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType ;
    }

    //Instance method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Vehicle details:\n");
        System.out.println("Owner Name: " + ownerName + "\nVehicle Type: " + vehicleType + "\nRegisteration Fee: " +
                         registerationFee + " Rupees");
    }

    //Class method to update Registeration fee 
    public static void updateRegisterationFee(int newRegisterationFee) {
        registerationFee = newRegisterationFee;
    }
}

public class VehicleRegisteration {

    public static void main(String[] args) {

        // Creating object of Vehicle class
        Vehicle v1 = new Vehicle("Amaan", "Sedan"); //Passing values for parameterised Constructor
        Vehicle v2 = new Vehicle("Nishank", "Hatchback"); //Passing values for parameterised Constructor
        Vehicle v3 = new Vehicle("Tikku", "SUV"); //Passing values for parameterised Constructor
        
        // Displaying course details
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
        v3.displayVehicleDetails();

        //Updating Registeration Fees 
        Vehicle.updateRegisterationFee(7000) ; //Updating Registeration Fees (chaiWala hai toh mumkin hai)

        // Displaying cehicle details after updating registerationn fees
        System.out.println("\n\nDisplaying vehicle details after updating registeration fee: \n");
        // Displaying vehicle details
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
        v3.displayVehicleDetails();
    }
}
