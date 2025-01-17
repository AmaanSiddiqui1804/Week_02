/* Program to Track Inventory of Items
Problem Statement: Create an Item class with attributes itemCode, itemName, and price. 
Add a method to display item details and calculate the total cost for a given quantity.
*/

class MobilePhone {
    String brand ;
    String model ;
    int price ; 

    // Constructor
    public MobilePhone(String brand, String model, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
        //this.quantity = quantity ;
    }

    //Method to display Mobile phone details
    public void displayMobileDetails(){
        System.out.println("The price of " + brand + " mobile phone having model number \"" + 
                            model + "\" is Rs " + price);
    }
}
public class MobilePhoneDetails {
    public static void main(String[] args) {

        //Creating object of Mobile Phone class and giving value in parameterized constructor
        MobilePhone phone1 = new MobilePhone("Samsung" , "SM-2311" , 30000);
        //Calling method with object to display details of Mobile phone
        phone1.displayMobileDetails();
    }
}