
import java.util.ArrayList;
import java.util.List;

// Abstract class Patient
abstract class Patient {
    private int patientId;
    private String name;
    private int age;

    // Constructor to initialize patient attributes
    Patient(int patientId, String name, int age) {
        this.setPatientId(patientId);
        this.setName(name);
        this.setAge(age);
    }

    // Abstract method to calculate bill
    abstract double calculateBill();

    // Concrete method to display patient details
    public void getPatientDetails() {
        System.out.println("\n\tPatient Details: ");
        System.out.println("Patient ID: " + patientId + "\nName: " + name + "\nAge: " + age);
    }

    // Getter and Setter methods
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);

    void viewRecords();
}

// InPatient (subclass of Patient implementing MedicalRecord interface)
class InPatient extends Patient implements MedicalRecord {
    private List<String> medicalRecords = new ArrayList<>();

    // Constructor to initialize InPatient attributes
    InPatient(int patientId, String name, int age) {
        super(patientId, name, age);
    }

    // Overriding calculateBill method
    @Override
    double calculateBill() {
        return 5000; // Flat rate for in-patients
    }

    // Implementing MedicalRecord interface methods
    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records: " + medicalRecords);
    }
}

// OutPatient (subclass of Patient implementing MedicalRecord interface)
class OutPatient extends Patient implements MedicalRecord {
    private List<String> medicalRecords = new ArrayList<>();

    // Constructor to initialize OutPatient attributes
    OutPatient(int patientId, String name, int age) {
        super(patientId, name, age);
    }

    // Overriding calculateBill method
    @Override
    double calculateBill() {
        return 500; // Flat rate for out-patients
    }

    // Implementing MedicalRecord interface methods
    @Override
    public void addRecord(String record) {
        medicalRecords.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records: " + medicalRecords);
    }
}


//Main Class HospitalManagementSystem
public class HospitalManagementSystem {
    public static void main(String[] args) {
        // List to hold patient details
        List<Patient> patients = new ArrayList<>();

        // Creating patients
        Patient inPatient = new InPatient(101, "Billu Bhutiya", 85);
        Patient outPatient = new OutPatient(102, "Bahaddur Bagga", 69);

        // Adding patients to the list
        patients.add(inPatient);
        patients.add(outPatient);

        // Adding medical records and displaying details
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill: Rs " + patient.calculateBill() + "/- only.");
            MedicalRecord record = (MedicalRecord) patient;
            record.addRecord("Routine Checkup");
            record.viewRecords();
            System.out.println("-----------------------------------");
        }
    }
}
