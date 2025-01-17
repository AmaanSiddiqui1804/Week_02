/* Program to Model a Movie Ticket Booking System
Problem Statement: Create a MovieTicket class with attributes movieName, seatNumber, 
and price. Add methods to:
Book a ticket (assign seat and update price).
Display ticket details.
*/

import java.util.Scanner;

class MovieTicket { 
    String movieName ;
    int seatNumber ;
    int price ;

    // Constructor
    public MovieTicket(String movieName, int seatNumber, int price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
    }

    //Method to book a ticket
    public int ticketBooking() {
        int assignedSeat = 0 ;
        if(seatNumber != (int) (Math.random() * 80) +1){
            assignedSeat += seatNumber ;
        }
        else{
            System.err.println("Seat taken, take again! ");
        }
        return assignedSeat ;
    }

    //Method to display the ticket details
    public void displayDetails() {
        System.out.println("MovieName: " + movieName);
        System.out.println("Seat Number: " + ticketBooking());
        System.out.println("Ticket price: " + price);
    }

}
public class MovieTicketBooking {

    public static void main(String[] args) {
    //creating scanner class instance
    Scanner sc = new Scanner(System.in);
    
    //Asking user for input
    System.out.println("Enter movie name and seat number: ") ;

    String mvName = sc.nextLine() ;

    int seatNumber = sc.nextInt();

    int price = 250;
    if("Spider Man 4".equalsIgnoreCase(mvName)){
        price = price*0 +500 ;
    }
    else if("Venom The Last Dance".equalsIgnoreCase(mvName)){
        price = price*0 +400 ;
    }
    else if("Avengers 4".equalsIgnoreCase(mvName)){
        price = price*0 +450 ;
    }
    else if("Hera Pheri".equalsIgnoreCase(mvName)){
        price = price*0 +1000 ;
    }
    MovieTicket m1 = new MovieTicket(mvName , seatNumber , price);
    
    //CALLING METHOD TO DISPLAY DETAILS
    m1.displayDetails();

        //Closing scanner class instance
        sc.close();
    }
}
