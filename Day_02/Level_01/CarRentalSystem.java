import java.util.Scanner;

class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;

    //Default Constructor
    public CarRental() {
        customerName = "Tikesh Kardate";
        carModel = "Swift Dzire";
        rentalDays = 6;
    }

    //Parameterized Constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    //Method to calculate total cost
    public int calculateCost() {
        int cost = 300 ; //Cost of renting a car per day
        return cost * rentalDays;
    }

    //Method to display car details
    public void displayDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: " + calculateCost());
    }
}
public class CarRentalSystem {
    public static void main(String[] args) {

        //Creating scanner class object/instance
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Amaan's Car Retal Service: ");
        System.out.println("Enter zero, zero, 0 for default values");
        System.out.println("Enter Customer Name: ");
        String customerName = sc.nextLine();
        System.out.println("Enter Car Model: ");
        String carModel = sc.nextLine();
        System.out.println("Enter number of days to rent the car: ");
        int rentalDays = sc.nextInt();

        //Creating object of CarRental class
        CarRental car1 = new CarRental();  //Default Constructor 
        CarRental car2 = new CarRental(customerName, carModel, rentalDays);

        //calling displayDetails method to display car details
        System.out.println("Car Details: ");
        if(customerName.equalsIgnoreCase(carModel) && rentalDays == 0) {
            System.out.println("Showing details using default constructor: ");
            car1.displayDetails();
        } else {
            System.out.println("Showing details using parameterized constructor: ");
            car2.displayDetails();
        }
        //Closing scanner class object
        sc.close();
    }
}
