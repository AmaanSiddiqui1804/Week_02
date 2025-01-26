/* Library Management System
Description: Develop a library management system:
Use an abstract class LibraryItem with fields like itemId, title, and author.
Add an abstract method getLoanDuration() and a concrete method getItemDetails().
Create subclasses Book, Magazine, and DVD, overriding getLoanDuration() with specific logic.
Implement an interface Reservable with methods reserveItem() and checkAvailability().
Apply encapsulation to secure details like the borrower’s personal data.
Use polymorphism to allow a general LibraryItem reference to manage all items, regardless of type.
*/

import java.util.ArrayList;
import java.util.List;

//Abstract class LibraryItem
abstract class LibraryItem {
    private int itemId;
    private String title;
    private String author;

    // Constructor to initialize LibraryItem attributes
    LibraryItem(int itemId, String title, String author) {
        this.setItemId(itemId);
        this.setTitle(title);
        this.setAuthor(author);
    }

    // Abstract method to be implemented by subclasses
    abstract int getLoanDuration();

    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("\n\t Item Details: \n");
        System.out.println("Item ID: " + itemId + "\nTitle: " + title +
         "\nAuthor: " + author);
    }

    // Getter and Setter methods
    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

//Interface
interface Reservable {
    String reserveItem();

    boolean checkAvailability();
}

//Book (sub class for Libraray item super class) implemeting Reservable interface
class Book extends LibraryItem implements Reservable {
    private int publicationYear;

    // Constructor to initialize Book attributes
    Book(int itemId, String title, String author, int publicationYear) {
        super(itemId, title, author);
        this.setPublicationYear(publicationYear);
    }

    // Getter and Setter for publication year
    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    // Overriding getLoanDuration method
    @Override
    int getLoanDuration() {
        return 14; // Loan duration for a book is 14 days
    }

    // Overriding reserveItem method
    @Override
    public String reserveItem() {
        return "This item is not a reserved item.";
    }

    // Overriding checkAvailability method
    @Override
    public boolean checkAvailability() {
        return true; // Books are available by default
    }
}

//Sub class magzine for Libraray item super class implemeting Reservable interface
class Magazine extends LibraryItem implements Reservable {
    private String category;

    // Constructor to initialize Magazine attributes
    Magazine(int itemId, String title, String author, String category) {
        super(itemId, title, author);
        this.setCategory(category);
    }

    // Getter and Setter for category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Overriding getLoanDuration method
    @Override
    int getLoanDuration() {
        return 0; 
    }

    // Overriding reserveItem method
    @Override
    public String reserveItem() {
        System.out.println("Category: " + category);
        System.out.println("Adult magazines are not available");
        return "This item is a reserved item.";
    }

    // Overriding checkAvailability method
    @Override
    public boolean checkAvailability() {
        return false; // Adult magazines are not available
    }
}

//Subclass DVD 
class DVD extends LibraryItem implements Reservable {
    private String category;

    // Constructor to initialize DVD attributes
    DVD(int itemId, String title, String author, String category) {
        super(itemId, title, author);
        this.setCategory(category);
    }

    // Getter and Setter for category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    // Overriding getLoanDuration method
    @Override
    int getLoanDuration() {
        return 5; // Loan duration for a DVD is 5 days
    }

    // Overriding reserveItem method
    @Override
    public String reserveItem() {
        System.out.println("Category: " + category);
        return "This item is not a reserved item.";
    }

    // Overriding checkAvailability method
    @Override
    public boolean checkAvailability() {
        return true; // DVDs are available by default
    }
}

/*
Main Class LibraryManagementSystem
Purpose: Demonstrates the functionality of the library management system using polymorphism.
*/
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // List to hold library items
        List<LibraryItem> libraryItems = new ArrayList<>();

        // Creating items
        LibraryItem book = new Book(112456, "Believe in Afterlife", "Amaan Siddiqui", 2025);
        LibraryItem magazine = new Magazine(21142, "Shades", "Nishank", "Adult");
        LibraryItem dvd = new DVD(2110465, "Shocking Love", "Sheru", "Rom-Com");

        // Adding items to the list
        libraryItems.add(book);
        libraryItems.add(magazine);
        libraryItems.add(dvd);

        // Displaying details and functionality of each item
        for (LibraryItem item : libraryItems) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            Reservable reservableItem = (Reservable) item;
            System.out.println(reservableItem.reserveItem());
            System.out.println("Is this item available: " + reservableItem.checkAvailability());
            System.out.println("-----------------------------------");
        }
    }
}
