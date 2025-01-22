import java.util.ArrayList;
class Customer {
    private String customerName;
    private ArrayList<Product> products; // Aggregation: An order can have multiple products

    // Constructor to initialize an order
    public Customer(String customerName) {
        this.customerName = customerName;
        this.products = new ArrayList<>();
    }

    // Method to add a product
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product " + product.getProductName() + " has been added.");
    }

    //Getter for products
    public ArrayList<Product> getProducts() {
        return products;
    }
    //Getter for products 
    public String getcustomerName() {
        return customerName ;
    }
}
class Product {
    private String productName;
    private double productPrice;
    private int quantity;

    // Constructor to initialize a product
    public Product(String name, double price, int quantity) {
        this.productName = name;
        this.productPrice = price;
        this.quantity = quantity ;
    }

    //Method to calculate total price
    public double getTotalPrice() {
        return productPrice*quantity;
    }

    //Method to get product
    public String getProductName() {
        return productName;
    }

    // Method to display product details
    public void displayProductDetails() {
        System.out.println(" Product: " + productName + "\n Price: " + productPrice +
                            "\n Quantity: " + quantity + "\n Total: " + getTotalPrice());
    }
}
class BillGenerator {
    public void billGeneration(Customer customer) {
        double total = 0.0 ;
        System.out.println("\n Bill for " + customer.getcustomerName() + ":");
        for (Product product : customer.getProducts()) {
            product.displayProductDetails();
            total += product.getTotalPrice();
        }
        System.out.printf("Total: $%.2f\n", total);
    }
}
public class GroceryStoreBillGeneration {
    public static void main(String[] args) {
        
        //Creating a customer
        Customer customer = new Customer("Alice") ;

        //Add products to the customer
        customer.addProduct(new Product("Apples" , 3.0, 2)) ;
        customer.addProduct(new Product("Milk", 1.0,  2));

        //Generating the bill
        BillGenerator billGeneration = new BillGenerator();
        billGeneration.billGeneration(customer) ;
    }
}
