class Person {
    String name;
    int age;
    String nativePlace;

    // Default Constructor
    public Person() {
        name = "Unknown";
        age = 0;
        nativePlace = "Unknown";
    }

    //Parameterized Constructor
    Person(String name, int age, String nativePlace){
        this.name = name;
        this.age = age;
        this.nativePlace = nativePlace;
    }

    // Copy Constructor
    public Person(Person p) {
        this.name = p.name;
        this.age = p.age;
        this.nativePlace = p.nativePlace;
    }

    // Method to display person attributes
    public void displayValues() {
        System.out.println("Person details:");
        System.out.println("Name: " + name + "\nAge: " + age + "\nNative Place: " + nativePlace);
    }
}

public class PersonDetails {
    public static void main(String[] args) {
        // Creating object of Person class
        Person p0 = new Person(); //Object  for default constructor
        Person p1 = new Person("Babu Bhaiya", 54, "Kolhapur"); //Passing values for parameterised Constructor

        // Default Constructor
        System.out.println("Displaying details of person 0 through default constructor:");
        p0.displayValues();

        System.out.println();
        System.out.println("Displaying details of person 1 through parameterised constructor:");
        p1.displayValues();
        
        // Copy Constructor
        Person p2 = new Person(p1);
        System.out.println("\nCopying attributes of person1 into person2:");
        System.out.println("Displaying details of person2:");
        p2.displayValues();
    }
}
