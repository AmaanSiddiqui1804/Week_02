/* Problem 1: Library and Books (Aggregation)
Description: Create a Library class that contains multiple Book objects. Model the relationship such that a library can
have many books, but a book can exist independently (outside of a specific library).
Tasks:
Define a Library class with an ArrayList of Book objects.
Define a Book class with attributes such as title and author.
Demonstrate the aggregation relationship by creating books and adding them to different libraries.
Goal: Understand aggregation by modeling a real-world relationship where the Library aggregates Book objects.
*/ 

import java.util.ArrayList ;
class Book {
    private String author ;
    private String title ;

    public Book(String author , String title) {
        this.author = author ;
        this.title = title ;
    }
    public String getAuthor() {
        return author ;
    }
    public String getTitle() {
        return title ;
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title + " Author: " + author);
    }
}
class Library {
    private String libraryName;
    private ArrayList <Book> books; // Aggregation: A library contains multiple books

    // Constructor to initialize a library
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
    }
    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " has been added to " + libraryName);
    }

    // Method to display all books in the library
    public void displayLibraryBooks() {
        System.out.println("\nBooks in " + libraryName + ":");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            book.displayBookDetails(); // Display the details of the book
        }
    }

        // Method to get library name
        public String getName() {
            return libraryName;
        }
    }
    // Main class
public class LibraryManagement {
    public static void main(String[] args) {
            // Creating books
            Book book1 = new Book("Paulo Coelho", "The Alchemist");
            Book book2 = new Book("Wings of Fire", "Dr. A.P.J. Abdul Kalam");
            Book book3 = new Book("Chetan Bhagat", "The Girl in Room 105");
            Book book4 = new Book("Moby Dick", "Herman Melville");

            // Creating libraries
            Library library1 = new Library("AA Library");
            Library library2 = new Library("Tk Library");

            // Adding books to libraries
            library1.addBook(book1);
            library1.addBook(book2);

            library2.addBook(book3);
            library2.addBook(book4);

            // Displaying books in libraries
            library1.displayLibraryBooks();
            library2.displayLibraryBooks();
    }
}