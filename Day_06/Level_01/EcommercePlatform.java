/* E-Commerce Platform
Description: Develop a simplified e-commerce platform:
Create an abstract class Product with fields like productId, name, and price, and 
an abstract method calculateDiscount().
Extend it into concrete classes: Electronics, Clothing, and Groceries.
Implement an interface Taxable with methods calculateTax() and getTaxDetails() for 
applicable product categories.
Use encapsulation to protect product details, allowing updates only through setter 
methods.
Showcase polymorphism by creating a method that calculates and prints the 
final price (price + tax - discount) for a list of Product.*/

import java.util.ArrayList;
import java.util.List;

// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Abstract method for calculating discount
    public abstract double calculateDiscount();

    // Getter Methods
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Interface Taxable
interface Taxable {
    double calculateTax();

    String getTaxDetails();
}

// Electronics class extending Product and implementing Taxable
class Electronics extends Product implements Taxable {

    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        // Giving Electronics a flat 10% discount
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        // tax is 18% (GST) 
        return getPrice() * 0.18;
    }

    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }
}

// Clothing class extending Product and implementing Taxable
class Clothing extends Product implements Taxable {

    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        // Clothing has a flat 15% discount
        return getPrice() * 0.15;
    }

    @Override
    public double calculateTax() {
        // Clothing tax is 5%
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 5%";
    }
}

// Groceries class extending Product (Groceries are not taxable)
class Groceries extends Product {

    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        // Groceries have no discount
        return 0;
    }
}

// Main class
public class EcommercePlatform {
    public static void main(String[] args) {
        // Creating a list of products
        List<Product> products = new ArrayList<>();

        // Adding Electronics, Clothing, and Groceries objects
        Electronics electronics = new Electronics(101, "Laptop", 50000);
        Clothing clothing = new Clothing(102, "T-Shirt", 1000);
        Groceries groceries = new Groceries(103, "Rice", 500);

        products.add(electronics);
        products.add(clothing);
        products.add(groceries);

        // Display details and calculate final price for each product
        for (Product product : products) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: " + product.getPrice());
            System.out.println("Discount: " + product.calculateDiscount());

            if (product instanceof Taxable) {
                Taxable taxableProduct = (Taxable) product;
                System.out.println(taxableProduct.getTaxDetails());
                System.out.println("Tax: " + taxableProduct.calculateTax());
            } else {
                System.out.println("This product is not taxable.");
            }

            double finalPrice = product.getPrice() + 
                                (product instanceof Taxable ? ((Taxable) product).calculateTax() : 0) - 
                                product.calculateDiscount();
            System.out.println("Final Price: " + finalPrice);
            System.out.println("-----------------------------------");
        }
    }
}
