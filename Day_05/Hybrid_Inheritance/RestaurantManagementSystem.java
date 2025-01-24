/* Sample Problem 1: Restaurant Management System with Hybrid Inheritance
Description: Model a restaurant system where Person is the superclass and Chef and 
Waiter are subclasses. Both Chef and Waiter should implement a Worker interface that 
requires a performDuties() method.
Tasks:
Define a superclass Person with attributes like name and id.
Create an interface Worker with a method performDuties().
Define subclasses Chef and Waiter that inherit from Person and implement the Worker interface, 
each providing a unique implementation of performDuties().
Goal: Practice hybrid inheritance by combining inheritance and interfaces, giving multiple 
behaviors to the same objects. 
*/

// Superclass Person
class Person {
    String name;
    int id;

    // Constructor for Person
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Method to display basic details
    public void displayDetails() {
        System.out.println("Name: " + name + "\nID: " + id);
    }
}

// Worker interface
interface Worker {
    // Abstract method to be implemented by subclasses
    void performDuties();
}

// Subclass Chef inherits from Person and implements Worker
class Chef extends Person implements Worker {
    String specialty;

    // Constructor for Chef
    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    // Overriding performDuties method
    @Override
    public void performDuties() {
        System.out.println("Role: Chef \nDuties: Preparing dishes and managing the kitchen.");
    }

    // Method to display Chef details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Specialty: " + specialty);
    }
}

// Subclass Waiter inherits from Person and implements Worker
class Waiter extends Person implements Worker {
    String shift;

    // Constructor for Waiter
    public Waiter(String name, int id, String shift) {
        super(name, id);
        this.shift = shift;
    }

    // Overriding performDuties method
    @Override
    public void performDuties() {
        System.out.println("Role: Waiter \nDuties: Serving food and attending to customers.");
    }

    // Method to display Waiter details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Shift: " + shift);
    }
}

// Main class to test the implementation
public class RestaurantManagementSystem {
    public static void main(String[] args) {
        // Creating objects
        Chef chef = new Chef("Vikash Khanna", 101, "Indian Cuisine");
        Waiter waiter = new Waiter("Billu", 202, "Evening");

        // Displaying details and duties of Chef
        System.out.println("\tChef Details ");
        chef.displayDetails();
        chef.performDuties();

        // Displaying details and duties of Waiter
        System.out.println("\n\tWaiter Details ");
        waiter.displayDetails();
        waiter.performDuties();
    }
}
