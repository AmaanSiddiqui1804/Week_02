package com.capgemini.week02.programs;

class Book {
    public String ISBN; // Public access
    protected String title; // Protected access
    private String author; // Private access

    // Constructor to initialize Book attributes
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public method to set the author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Public method to get the author
    public String getAuthor() {
        return author;
    }
}
class EBook extends Book {
    //Ebook class Constructor
    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author); // Initialize the parent class
    }
    //Method to display details
    public void displayDetails() {
        System.out.println("ISBN: " + ISBN); // Access public member
        System.out.println("Title: " + title); // Access protected member
        System.out.println("Author: " + getAuthor()); // Access private member via public method
    }
}
public class BookLibrarySystem {
    public static void main(String[] args) {
        //Creating object for Ebook
        EBook ebook = new EBook("5322489", "Java Programming", "Abraham");
        //Calling display details method to display details
        ebook.displayDetails();

        // Modifying the author and displaying again
        ebook.setAuthor("James Gosling");
        System.out.println("\nAfter modifying the author:");
        ebook.displayDetails();
    }
}
