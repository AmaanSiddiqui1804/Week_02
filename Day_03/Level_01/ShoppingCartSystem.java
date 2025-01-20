/* Sample Program 4: Shopping Cart System
Create a Product class to manage shopping cart items with the following features:
Static:
A static variable discount shared by all products.
A static method updateDiscount() to modify the discount percentage.
This:
Use this to initialize productName, price, and quantity in the constructor.
Final:
Use a final variable productID to ensure each product has a unique identifier that cannot be changed.
Instanceof:
Validate whether an object is an instance of the Product class before processing its details.
*/

import java.util.Scanner;

class ProductClass {
    static double discount = 5.0 ;
    String productName ;
    double price ;
    int quantity ;
    final int productID ;
    
    ProductClass (String productName, double price, int quantity, int productID) {
        this.productName = productName ;
        this.price = price ;
        this.quantity = quantity ;
        this.productID = productID ;
    }
    
    // Static method to update the discount
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    } 

    //Method to display items and total
    void displayCartDetails(){
        double total = price * quantity;
        double discountedPrice = total - (total * discount / 100); //Calculating discount
        System.out.println("Product ID: " + productID);
        System.out.println("Product Name: " + productName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Original Price: " + total);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Price after " + discount + "% discount: " + discountedPrice);
    }
}
public class ShoppingCartSystem {
    public static void main(String[] args) { 

        Scanner sc = new Scanner(System.in);
        //Taking user input
        System.out.print("Enter product name: ");
        String productName = sc.nextLine() ;
        System.out.println();
        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();
        System.out.println();
        System.out.print("Enter price: ");
        double price = sc.nextDouble();
        System.out.println();
        int productID = (int) (Math.random() * 100) +1; //Product id generation 
        
        //Creating Product class object
        ProductClass p1 = new ProductClass(productName, price, quantity, productID) ;

        if (productID > 50) {
            ProductClass.updateDiscount(10.0); // Updating discount to 10% 
        }

        // Checking if the object is an instance of ProductClass
        if (p1 instanceof ProductClass) {
            System.out.println("\nProcessing product details...");
            p1.displayCartDetails();
        } else {
            System.out.println("Invalid product instance.");
        }

        sc.close();       
    }   
}
