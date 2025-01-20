/* Sample Program 2: Library Management System
Create a Book class to manage library books with the following features:
Static:
A static variable libraryName shared across all books.
A static method displayLibraryName() to print the library name.
This:
Use this to initialize title, author, and isbn in the constructor.
Final:
Use a final variable isbn to ensure the unique identifier of a book cannot be changed.
Instanceof:
Verify if an object is an instance of the Book class before displaying its details.*/

import java.util.Scanner;

class Book {
    static String libraryName = "AA Libraries"; // Static variable shared across all books
    private final int isbn; // Final variable to ensure unique identifier cannot be changed
    private String title;
    private String author;
    private String customer;

    // Constructor to initialize Book attributes
    public Book(String title, String author, int isbn, String customer) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.customer = customer;
    }

    // Static method to display the library name
    static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Instance method to display book details
    void displayBookDetails() {
        System.out.println("Book Name: " + title);
        System.out.println("Author Name: " + author);
        System.out.println("ISBN Number: " + isbn);
        System.out.println("Issued To: " + customer);
    }
}

public class LibManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input customer and book details
        System.out.print("Enter your name: ");
        String customer = sc.nextLine();
        System.out.print("Enter book name: ");
        String book = sc.nextLine();
        System.out.print("Enter author name: ");
        String author = sc.nextLine();

        // Create Book objects
        Book.displayLibraryName();
        Book book1 = new Book("Reason To Live", "Amaan Siddiqui", 789110045, customer);
        Book book2 = new Book(book, author, 8541265, customer);

        // Use instanceof to verify before displaying details
        if (book1 instanceof Book) {
            System.out.println("\nDetails of Book 1:");
            book1.displayBookDetails();
        }
        if (book2 instanceof Book) {
            System.out.println("\nDetails of Book 2:");
            book2.displayBookDetails();
        }

        sc.close();
    }
}