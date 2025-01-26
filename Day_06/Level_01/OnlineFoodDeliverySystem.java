

import java.util.ArrayList;
import java.util.List;

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor to initialize food item attributes
    FoodItem(String itemName, double price, int quantity) {
        this.setItemName(itemName);
        this.setPrice(price);
        this.setQuantity(quantity);
    }

    // Abstract method to calculate total price
    abstract double calculateTotalPrice();

    // Concrete method to display item details
    public void getItemDetails() {
        System.out.println("\n\tItem Details: ");
        System.out.println("Name: " + itemName + "\nPrice: " + price + "\nQuantity: " + quantity);
    }

    // Getter and Setter methods
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

// Interface Discountable
interface Discountable {
    double applyDiscount(double discountPercentage);

    String getDiscountDetails();
}

// VegItem (subclass of FoodItem implementing Discountable interface)
class VegItem extends FoodItem implements Discountable {

    // Constructor to initialize VegItem attributes
    VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    // Overriding calculateTotalPrice method
    @Override
    double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    // Implementing Discountable interface methods
    @Override
    public double applyDiscount(double discountPercentage) {
        return calculateTotalPrice() - (calculateTotalPrice() * discountPercentage / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Veg items are eligible for discounts.";
    }
}

// NonVegItem (subclass of FoodItem implementing Discountable interface)
class NonVegItem extends FoodItem implements Discountable {
    private static final double NON_VEG_CHARGE = 50.0;

    // Constructor to initialize NonVegItem attributes
    NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    // Overriding calculateTotalPrice method
    @Override
    double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + NON_VEG_CHARGE;
    }

    // Implementing Discountable interface methods
    @Override
    public double applyDiscount(double discountPercentage) {
        return calculateTotalPrice() - (calculateTotalPrice() * discountPercentage / 100);
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg items include an additional charge of Rs " + NON_VEG_CHARGE + "/-.";
    }
}


//Main Class OnlineFoodDeliverySystem
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        // List to hold food items
        List<FoodItem> foodItems = new ArrayList<>();

        // Creating items
        FoodItem vegItem = new VegItem("Paneer Butter Masala", 200, 2);
        FoodItem nonVegItem = new NonVegItem("Chicken Biryani", 300, 1);

        // Adding items to the list
        foodItems.add(vegItem);
        foodItems.add(nonVegItem);

        // Displaying details and functionality of each item
        for (FoodItem item : foodItems) {
            item.getItemDetails();
            System.out.println("Total Price: ₹" + item.calculateTotalPrice());
            Discountable discountableItem = (Discountable) item;
            System.out.println(discountableItem.getDiscountDetails());
            System.out.println("Price after discount (20%): ₹" + discountableItem.applyDiscount(20));
            System.out.println("-----------------------------------");
        }
    }
}
