/* Sample Problem 1: Library Management with Books and Authors
Description: Model a Book system where Book is the superclass, and Author is a subclass.
Tasks:
Define a superclass Book with attributes like title and publicationYear.
Define a subclass Author with additional attributes like name and bio.
Create a method displayInfo() to show details of the book and its author.
Goal: Practice single inheritance by extending the base class and adding more specific details in the subclass. 
*/
class Book {
    //Attributes
    protected String bookTitle ;
    protected String publicationYear ; 

    //Constructor
    public Book(String bookTitle, String publicationYear) {
        this.bookTitle = bookTitle ;
        this.publicationYear = publicationYear ;
    }

    //Method to display details
    public void displayInfo() {
        System.out.println("Details of book will be printed here: ");
    }
} 
class Author extends Book { 
    //Attributes
    String authorName ;
    String authorBio ;

    //Constructor
    public Author(String bookTitle, String publicationYear, String authorName, String authorBio) {
        super(bookTitle, publicationYear) ;
        this.authorName = authorName ;
        this.authorBio = authorBio ;
    }

    //Method overriding
    @Override  //Optional to write
    public void displayInfo() {
        System.out.println("Title of Book: " + bookTitle + "\nPublication Year: "+ 
                            publicationYear + "\nAuthor of book: " + authorName +
                            "\nDetails of author: " + authorBio);
    }
}
public class LibraryManagement {
    public static void main(String[] args) {
        
        //Creating object
        Book book = new Author("The Girl in room 105", "2019", 
                        "Chetan Bhagat", "Indian author, columnist, screenwriter, and YouTuber") ;
        //Calling method to display details
        book.displayInfo();
    }
}