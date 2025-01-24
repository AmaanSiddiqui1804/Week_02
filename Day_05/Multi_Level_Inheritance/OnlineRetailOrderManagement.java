/* Sample Problem 1: Online Retail Order Management
Description: Create a multilevel hierarchy to manage orders, where Order is the base class, ShippedOrder is a subclass, 
and DeliveredOrder extends ShippedOrder.
Tasks:
Define a base class Order with common attributes like orderId and orderDate.
Create a subclass ShippedOrder with additional attributes like trackingNumber.
Create another subclass DeliveredOrder extending ShippedOrder, adding a deliveryDate attribute.
Implement a method getOrderStatus() to return the current order status based on the class level.
Goal: Explore multilevel inheritance, showing how attributes and methods can be added across a chain of classes.*/

// Base class representing an order
class Order {
    int orderId; // Unique identifier for the order
    String orderDate; // Date when the order was placed

    // Constructor for Order
    public Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Method to display order details and status
    public String getOrderStatus() {
        System.out.println("Order Id: " + orderId + "\nOrder Date: " + orderDate);
        return "Order Placed\n";
    }

    // Getters for attributes
    public int getOrderId() {
        return orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }
}

// Subclass of Order representing a shipped order
class ShippedOrder extends Order {
    int trackingNumber; // Unique tracking number for the shipped order

    // Constructor for ShippedOrder
    public ShippedOrder(int orderId, String orderDate, int trackingNumber) {
        super(orderId, orderDate); // Call to base class constructor
        this.trackingNumber = trackingNumber;
    }

    // Overriding method to display shipped order details and status
    @Override
    public String getOrderStatus() {
        System.out.println("\nShipped Order Details\n");
        System.out.println("Order Id: " + orderId + "\nOrder Date: " + orderDate +
                           "\nOrder Tracking Number: " + trackingNumber);
        return "Order Shipped\n";
    }

    // Getter for trackingNumber
    public int getTrackingNumber() {
        return trackingNumber;
    }
}

// Subclass of ShippedOrder representing a delivered order
class DeliveredOrder extends ShippedOrder {
    String deliveryDate; // Date when the order was delivered

    // Constructor for DeliveredOrder
    public DeliveredOrder(int orderId, String orderDate, int trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber); // Call to parent class constructor
        this.deliveryDate = deliveryDate;
    }

    // Overriding method to display delivered order details and status
    @Override
    public String getOrderStatus() {
        System.out.println("\nDelivered Order Details\n");
        System.out.println("Order Id: " + orderId + "\nOrder Date: " + orderDate +
                           "\nOrder Tracking Number: " + trackingNumber +
                           "\nDelivery Date: " + deliveryDate);
        return "Order Delivered";
    }
}

// Main class to demonstrate multilevel inheritance
public class OnlineRetailOrderManagement {
    public static void main(String[] args) {

        // Creating a base order object
        Order order = new Order(1224505, "24/01/2025");

        // Creating a shipped order object using the base order's details
        ShippedOrder shippedOrder = new ShippedOrder(order.getOrderId(), order.getOrderDate(), 2212546);

        // Creating a delivered order object using the shipped order's details
        DeliveredOrder deliveredOrder = new DeliveredOrder(order.getOrderId(), order.getOrderDate(),
                                                            shippedOrder.getTrackingNumber(), "28/01/25");

        // Displaying information for each type of order
        order.getOrderStatus(); // Displays base order details
        shippedOrder.getOrderStatus(); // Displays shipped order details
        deliveredOrder.getOrderStatus(); // Displays delivered order details
    }
}
