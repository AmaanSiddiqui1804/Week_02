/* Hotel Booking System: Create a HotelBooking class with attributes guestName, roomType, and nights. 
Use default, parameterized, and copy constructors to initialize bookings.
*/

import java.util.Scanner;

class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    //Default Constructor
    public HotelBooking() {
        guestName = "John Doe";
        roomType = "Usual";
        nights = 1;
    }

    //Parameterized Constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    //Copy Constructor
    public HotelBooking(HotelBooking booking) {
        guestName = booking.guestName;
        roomType = booking.roomType;
        nights = booking.nights;
    }

    //Method to display details
    public void displayDetails() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
        System.out.println();
    }
}
public class HotelBookingSystem {
    public static void main(String[] args) {

        //Creating scanner class object/instance
        Scanner sc = new Scanner(System.in);

        //Taking user input
        System.out.println("Enter Guest Name: ");
        String guestName = sc.nextLine();
        System.out.println("Enter Room Type: ");
        String roomType = sc.nextLine();
        System.out.println("Enter Number of Nights: ");
        int nights = sc.nextInt();

        //Crating object of HotelBooking class
        HotelBooking booking1 = new HotelBooking();  //Default Constructor
        HotelBooking booking2 = new HotelBooking(guestName , roomType , nights);
        HotelBooking booking3 = new HotelBooking(booking2);

        System.out.println("Booking Details: ");
        System.out.println("Showing details using default constructor: ");
        booking1.displayDetails();
        System.out.println("Showing details using parameterized constructor: ");
        booking2.displayDetails();
        System.out.println("Showing details using copy constructor: ");
        booking3.displayDetails();

        sc.close();
    }
}