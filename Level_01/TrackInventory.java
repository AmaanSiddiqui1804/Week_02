/* Program to Track Inventory of Items
Problem Statement: Create an Item class with attributes itemCode, 
itemName, and price. Add a method to display item details and 
calculate the total cost for a given quantity.
*/

import java.util.Scanner;

class Item {
    // Fields (Attributes)
    private int itemCode;
    private String itemName;
    private int price;
    private int quantity ;

    // Constructor
    public Item(int itemCode, String itemName, int price, int quantity) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity ;
    }

    // Method to display item details and total cost
    public void displayDetails() {
        System.out.println("Item code: " + itemCode);
        System.out.println("Item name: " + itemName);
        System.out.println("Item price: " + price);
        System.out.println("Item quantity: " + quantity);
        System.out.println("Total cost: " + quantity*price);
        }
    }



public class TrackInventory {
    public static void main(String[] args) {
        //Creating scanner class instane
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter quantity of xyz item: ");
        int quantity = sc.nextInt();

        //Creating object of Item class and giving value in parameterized constructor
        Item i1 = new Item(111 , "T-shirt" , 400 , quantity);
        //Calling method via object
        i1.displayDetails();

        //Closing scanner class instance
        sc.close();
    }    
}
