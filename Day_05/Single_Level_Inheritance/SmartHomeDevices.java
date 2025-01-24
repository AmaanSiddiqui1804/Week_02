/* Sample Problem 2: Smart Home Devices
Description: Create a hierarchy for a smart home system where Device is the superclass and Thermostat is a subclass.
Tasks:
Define a superclass Device with attributes like deviceId and status.
Create a subclass Thermostat with additional attributes like temperatureSetting.
Implement a method displayStatus() to show each device's current settings.
Goal: Understand single inheritance by adding specific attributes to a subclass, keeping the superclass general.
*/ 
class Device {
    String deviceId ;
    String status ;

    //Constructor
    public Device(String deviceId, String status ){
        this.deviceId = deviceId ;
        this.status = status ;
    }
    public void displayStatus() { }
}
class Thermostat extends Device {
    String deviceName = "Thermostat" ;
    double temperatureSetting ;

    //Constructor
    public Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status) ;
        this.temperatureSetting = temperatureSetting ;
    }

    //Method to display details
    public void displayStatus() {
        System.out.println("Name of device: " + deviceName + "\nDevice ID: " + deviceId + 
                            "\nStatus: " + status + "\nTemperature Setting: " + temperatureSetting);
    }
}
public class SmartHomeDevices {
    public static void main(String[] args) {
        //Creating Objects
        Device thermostat = new Thermostat("21001", "ON", 22.50) ;

        thermostat.displayStatus();       
    }
}
