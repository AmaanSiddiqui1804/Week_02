
class Book {
    String title ;
    String author ;
    int price ;

    //Default Constructor
    Book() {
        title = "The Man From BHOPAL";
        author = "Amaan";
        price = 500 ;
    }

    //Parameterized Constructor
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
        // Default Constructor
        Book b1 = new Book();
        System.out.println("Default Constructor Output: ");
        b1.displayBookDetails();

        // Parameterized Constructor
        Book b2 = new Book("The Girl in Room 105" , "Chetan Bhagat" , 300);
        //Calling method with object to display details of book
        System.out.println("Parameterized Constructor");
        b2.displayBookDetails();
    }
}
