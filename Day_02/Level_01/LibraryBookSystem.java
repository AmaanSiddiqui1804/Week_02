/* Library Book System: Create a Book class with attributes title, author, price, and 
availability. Implement a method to borrow a book.*/
class Book {
    String title ;
    String author ;
    int price ;
    boolean availablity ;
    int r = (int) (Math.random()*10) +1 ;
   //Default Constructor
    Book() {
        title = "The Man From BHOPAL";
        author = "Amaan";
        price = 500 ;
        if(r>5) availablity = true ;

        else availablity = false ;
   }

    //Parameterized Constructor
     Book(String title, String author, int price, boolean availablity) {
          this.title = title ;
          this.author = author ;
          this.price = price ;
          this.availablity = availablity ;
    }
    //Method to borrow a book
    public void borrowBook() {
        if (title.equalsIgnoreCase(title) && author.equalsIgnoreCase(author) && availablity == true) {
            System.out.println("Book: " + title + " is available for borrowing");
        } else {
            System.out.println("Book: " + title +" is not available for borrowing, choose another book");
        }
    }
}

public class LibraryBookSystem {
    public static void main(String[] args) {

        //Creating object of Book class
        Book book1 = new Book();  //Default Constructor
        //Parameterized Constructor
        Book book2 = new Book("Let Us Java", "Yashwant Kanetkar", 300, true);
        //Calling method to borrow a book
        book1.borrowBook();
        book2.borrowBook();
    }
}
