import java.util.ArrayList;

// Customer Class (Aggregation: A customer can have multiple orders)
class Customer {
    private String customerName;
    private ArrayList<Order> orders; // Aggregation: A customer can have multiple orders

    // Constructor to initialize a customer
    public Customer(String name) {
        this.customerName = name;
        this.orders = new ArrayList<>();
    }

    // Method to place an order
    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println("Order " + order.getOrderNumber() + " has been placed by " + customerName);
    }

    // Display orders
    public void displayOrders() {
        System.out.println("\nOrders placed by " + customerName + ":");
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }
}

// Order Class (Aggregation: An order can have multiple products)
class Order {
    private int orderNumber;
    private ArrayList<Product> products; // Aggregation: An order can have multiple products

    // Constructor to initialize an order
    public Order(int orderNumber) {
        this.orderNumber = orderNumber;
        this.products = new ArrayList<>();
    }

    // Method to add a product
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product " + product.getProductName() + " has been added to order " + orderNumber);
    }

    // Method to remove a product
    public void removeProduct(Product product) {
        products.remove(product);
        System.out.println("Product " + product.getProductName() + " has been removed from order " + orderNumber);
    }

    // Method to display all products in the order
    public void displayOrderDetails() {
        System.out.println("\nProducts in order " + orderNumber + ":");
        for (Product product : products) {
            product.displayProductDetails();
        }
    }

    // Getter for order number
    public int getOrderNumber() {
        return orderNumber;
    }
}

// Product Class
class Product {
    private String productName;
    private int productPrice;

    // Constructor to initialize a product
    public Product(String name, int price) {
        this.productName = name;
        this.productPrice = price;
    }

    // Method to display product details
    public void displayProductDetails() {
        System.out.println("Product: " + productName + ", Price: " + productPrice);
    }

    // Getter for product name
    public String getProductName() {
        return productName;
    }

    // Getter for product price
    public int getProductPrice() {
        return productPrice;
    }
}

// Main Class
public class EcommercePlatform {
    public static void main(String[] args) {
        // Creating Customers
        Customer customer1 = new Customer("Tikesh");
        Customer customer2 = new Customer("Abhay");

        // Creating Orders
        Order order1 = new Order(1001);
        Order order2 = new Order(1002);
        Order order3 = new Order(1003);

        // Creating Products
        Product product1 = new Product("Laptop", 50000);
        Product product2 = new Product("Mobile", 20000);
        Product product3 = new Product("Headphones", 1000);
        Product product4 = new Product("Mouse", 500);
        Product product5 = new Product("Keyboard", 1000);

        // Adding products to orders
        order1.addProduct(product1);
        order1.addProduct(product2);

        order2.addProduct(product3);
        order2.addProduct(product4);

        order3.addProduct(product5);

        // Placing orders
        customer1.placeOrder(order1);
        customer1.placeOrder(order2);
        customer2.placeOrder(order3);

        // Displaying orders
        customer1.displayOrders();
        customer2.displayOrders();

        // Removing a product from an order
        order1.removeProduct(product1);

        // Displaying orders again after removal
        customer1.displayOrders();
        customer2.displayOrders();
    }
}

