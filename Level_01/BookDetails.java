/* Program to Handle Book Details
Problem Statement: Write a program to create a Book class with attributes 
title, author, and price. Add a method to display the book details.
*/

class Book {
    String title ;
    String author ;
    int price ;

    public Book (String title , String author , int price){
        this.title = title ;
        this.author = author ;
        this.price = price ;
    }
    
    //Method to display book details
    public void displayBookDetails(){
        System.out.println("The author of book \"" + title + "\" is " + 
                        author + ", " + "and the price of book is Rs:" + price);
    }
}

public class BookDetails {
    public static void main(String[] args) {

        //Creating object of Book class and giving value in parameterized constructor
        Book b1 = new Book("The Girl in Room 105" , "Chetan Bhagat" , 300);
        //Calling method with object to display details of book
        b1.displayBookDetails();
    }
}