/* Sample Program 7: Hospital Management System
Create a Patient class with the following features:
Static:
A static variable hospitalName shared among all patients.
A static method getTotalPatients() to count the total patients admitted.
This:
Use this to initialize name, age, and ailment in the constructor.
Final:
Use a final variable patientID to uniquely identify each patient.
Instanceof:
Check if an object is an instance of the Patient class before displaying its details. 
*/

class Patient {
    // Static variable shared among all patients
    static String hospitalName = "City General Hospital";
    private static int totalPatients = 0;

    private final int patientID; // Final variable uniquely identifying each patient
    private String name;
    private int age;
    private String ailment;

    // Constructor used for initializing patient details
    public Patient(String name, int age, String ailment, int patientID) {
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        this.patientID = patientID;
        totalPatients++; // Total patients count incremented
    }

    // Static method used for getting the total number of patients admitted
    public static int getTotalPatients() {
        return totalPatients;
    }

    // Method used for displaying patient details
    public void displayPatientDetails() {
        System.out.println("Hospital Name: " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
    }
}

public class HospitalManagementSystem {
    public static void main(String[] args) {
        // Patient objects created
        Patient patient1 = new Patient("Alice Johnson", 35, "Fever", 101);
        Patient patient2 = new Patient("Bob Smith", 42, "Cough", 102);
        Patient patient3 = new Patient("Charlie Brown", 29, "Fracture", 103);

        // Details displayed if the object is validated as an instance of the Patient class
        if (patient1 instanceof Patient) {
            System.out.println("Patient 1 Details:");
            patient1.displayPatientDetails();
            System.out.println();
        }

        if (patient2 instanceof Patient) {
            System.out.println("Patient 2 Details:");
            patient2.displayPatientDetails();
            System.out.println();
        }

        if (patient3 instanceof Patient) {
            System.out.println("Patient 3 Details:");
            patient3.displayPatientDetails();
            System.out.println();
        }

        // Total patients admitted displayed
        System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());
    }
}
