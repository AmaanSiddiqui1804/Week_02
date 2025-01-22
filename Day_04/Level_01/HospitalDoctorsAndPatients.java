/* Problem 3: Hospital, Doctors, and Patients (Association and Communication)
Description: Model a Hospital where Doctor and Patient objects interact through 
consultations. 
A doctor can see multiple patients, and each patient can consult multiple doctors.
Tasks:
Define a Hospital class containing Doctor and Patient classes.
Create a method consult() in the Doctor class to show communication, 
which would display the consultation between a doctor and a patient.
Model an association between doctors and patients to show that doctors and patients 
can have multiple relationships.
Goal: Practice creating an association with communication between objects 
by modeling doctor-patient consultations.
*/

import java.util.ArrayList;

// Hospital class (Aggregation with Doctors and Patients)
class Hospital {
    private String hospitalName;
    private ArrayList<Doctor> doctors; // Aggregation: A hospital contains multiple doctors
    private ArrayList<Patient> patients; // Aggregation: A hospital contains multiple patients

    // Constructor to initialize a hospital
    Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    // Method to add a doctor
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("Doctor " + doctor.getDoctorName() + " has been added to hospital " + hospitalName);
    }

    // Method to add a patient
    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient " + patient.getPatientName() + " is admitted to the hospital.");
    }

    // Method to display doctors and patients
    public void displayDoctorsAndPatients() {
        System.out.println("\nDoctors in " + hospitalName + ":");
        for (Doctor doctor : doctors) {
            System.out.println("- " + doctor.getDoctorName());
        }

        System.out.println("\nPatients in " + hospitalName + ":");
        for (Patient patient : patients) {
            System.out.println("- " + patient.getPatientName());
        }
    }
}

// Doctor class (Association with Patients)
class Doctor {
    private String doctorName;
    private int doctorId;
    private ArrayList<Patient> patients; // Association: A doctor can have multiple patients

    // Constructor
    Doctor(String doctorName, int doctorId) {
        this.doctorName = doctorName;
        this.doctorId = doctorId;
        this.patients = new ArrayList<>();
    }

    // Method to add a patient for consultation
    public void addPatient(Patient patient) {
        patients.add(patient);
        patient.addDoctor(this); // Maintain bidirectional association
        System.out.println("Doctor " + doctorName + " is now consulting with patient " + patient.getPatientName());
    }

    // Method to consult patients
    public void consult() {
        System.out.println("\nConsultations for Dr. " + doctorName + ":");
        for (Patient patient : patients) {
            System.out.println("- Consulting with patient: " + patient.getPatientName());
        }
    }

    // Getter for doctor name
    public String getDoctorName() {
        return doctorName;
    }
}

// Patient class (Association with Doctors)
class Patient {
    private String patientName;
    private int patientId;
    private ArrayList<Doctor> doctors; // Association: A patient can consult multiple doctors

    // Constructor
    Patient(String patientName, int patientId) {
        this.patientName = patientName;
        this.patientId = patientId;
        this.doctors = new ArrayList<>();
    }

    // Method to add a doctor for consultation
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor); // Maintain association
    }

    // Method to display doctors for the patient
    public void displayDoctors() {
        System.out.println("\nPatient " + patientName + " " + patientId +" is consulting with the following doctors:");
        for (Doctor doctor : doctors) {
            System.out.println("-"+  doctor.getDoctorName());
        }
    }

    // Getter for patient name
    public String getPatientName() {
        return patientName;
    }
}

// Main class
public class HospitalDoctorsAndPatients {
    public static void main(String[] args) {
        // Create a hospital
        Hospital hospital = new Hospital("AIMS Hospital");

        // Create doctors
        Doctor doctor1 = new Doctor("Dr. Abraham", 101);
        Doctor doctor2 = new Doctor("Dr. Amaan", 102);

        // Create patients
        Patient patient1 = new Patient("Tikesh", 201);
        Patient patient2 = new Patient("Isabella", 202);

        // Add doctors to the hospital
        hospital.addDoctor(doctor1);
        hospital.addDoctor(doctor2);

        // Add patients to the hospital
        hospital.addPatient(patient1);
        hospital.addPatient(patient2);

        // Associate doctors and patients
        doctor1.addPatient(patient1);
        doctor2.addPatient(patient1);
        doctor1.addPatient(patient2);

        // Display hospital data
        hospital.displayDoctorsAndPatients();

        // Display consultations
        doctor1.consult();
        doctor2.consult();

        // Display doctors for a patient
        patient1.displayDoctors();
        patient2.displayDoctors();
    }
}

