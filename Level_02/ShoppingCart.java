/* Program to Simulate a Shopping Cart
Problem Statement: Create a CartItem class with attributes itemName, price, and quantity. 
Add methods to:
Add an item to the cart.
Remove an item from the cart.
Display the total cost.
Explanation: The CartItem class models a shopping cart item. The methods handle cart 
operations like adding or removing items and calculating the total cost.
*/

import java.util.Scanner;

class CartItem {
    String itemName;
    int price;
    int quantity;

    // Constructor to initialize the CartItem
    public CartItem(String itemName, int price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to add item to the cart
    public static CartItem addItem(String itemName, int price, int quantity) {
        return new CartItem(itemName, price, quantity);
    }

    // Method to display the cart items, quantity, individual prices, and total
    public static void displayCart(CartItem[] cart, int itemCount) {
        if (itemCount == 0) {
            System.out.println("The cart is empty.");
            return;
        }
        
        int totalCost = 0;
        System.out.println("Cart Details:");
        for (int i = 0; i < itemCount; i++) {
            CartItem item = cart[i];
            int itemTotal = item.price * item.quantity;
            System.out.println("Item: " + item.itemName + ", Price: " + item.price + ", Quantity: " + item.quantity + ", Total: " + itemTotal);
            totalCost += itemTotal;
        }
        System.out.println("Total cost of items in cart: " + totalCost);
    }

    // Method to remove an item from the cart
    public static CartItem[] removeItem(CartItem[] cart, int itemCount, String itemName) {
        for (int i = 0; i < itemCount; i++) {
            if (cart[i].itemName.equalsIgnoreCase(itemName)) {
                // Shift the remaining items to the left
                for (int j = i; j < itemCount - 1; j++) {
                    cart[j] = cart[j + 1];
                }
                cart[itemCount - 1] = null;  // Set the last item to null
                itemCount--;  // Reduce the item count
                System.out.println(itemName + " has been removed from the cart.");
                return cart;
            }
        }
        System.out.println(itemName + " not found in the cart.");
        return cart;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CartItem[] cart = new CartItem[10];  // Array to hold cart items (fixed size for simplicity)
        int itemCount = 0;

        while (true) {
            // Ask user for operation choice
            System.out.println("\nEnter 1 to add an item, 0 to remove an item, 2 to display the cart and total price, or any other key to exit:");
            int choice = sc.nextInt();
            sc.nextLine();  // Consume the newline left after nextInt()

            if (choice == 1) {
                // Add an item to the cart
                if (itemCount < cart.length) {
                    System.out.println("Enter item name:");
                    String itemName = sc.nextLine();
                    System.out.println("Enter item price:");
                    int price = sc.nextInt();
                    System.out.println("Enter item quantity:");
                    int quantity = sc.nextInt();
                    sc.nextLine();  // Consume the newline left after nextInt()

                    // Add item to the cart array
                    cart[itemCount] = CartItem.addItem(itemName, price, quantity);
                    itemCount++;
                    System.out.println(itemName + " has been added to the cart.");
                } else {
                    System.out.println("The cart is full. You cannot add more items.");
                }

            } else if (choice == 0) {
                // Remove an item from the cart
                System.out.println("Enter item name to remove:");
                String itemNameToRemove = sc.nextLine();
                cart = CartItem.removeItem(cart, itemCount, itemNameToRemove);
                itemCount--;  // Decrease the count after removing an item

            } else if (choice == 2) {
                // Display the cart and the total cost
                CartItem.displayCart(cart, itemCount);

            } else {
                // Exit the program
                System.out.println("Exiting the shopping cart.");
                System.exit(0);
            }
        }
    }
}

