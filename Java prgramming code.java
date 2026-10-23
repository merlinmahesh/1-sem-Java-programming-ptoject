import java.util.*;
import java.io.*;

class Patient {
    int id, age;
    String name, disease, prescription, doctor;
    ArrayList<String> visits = new ArrayList<>();

    Patient(int id, String name, int age, String disease,
            String prescription, String doctor) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.prescription = prescription;
        this.doctor = doctor;
    }

    void display() {
        System.out.println("\nPatient ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Disease: " + disease);
        System.out.println("Prescription: " + prescription);
        System.out.println("Doctor: " + doctor);
        System.out.println("Total Visits: " + visits.size());
    }
}

public class ClinicSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Patient> patients = new ArrayList<>();
    static int id = 1001;

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== CLINIC MANAGEMENT SYSTEM =====");
            System.out.println("1. Register Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Search Patient");
            System.out.println("4. Add Patient Visit");
            System.out.println("5. View Visit History");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    viewPatients();
                    break;

                case 3:
                    searchPatient();
                    break;

                case 4:
                    addVisit();
                    break;

                case 5:
                    viewHistory();
                    break;

                case 6:
                    saveRecords();
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);
    }

    static void registerPatient() {

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        System.out.print("Enter Prescription: ");
        String prescription = sc.nextLine();

        System.out.print("Enter Doctor Name: ");
        String doctor = sc.nextLine();

        Patient p = new Patient(
            id++, name, age, disease, prescription, doctor
        );

        patients.add(p);

        System.out.println("Patient registered successfully!");
        System.out.println("Patient ID: " + p.id);

        saveRecords();
    }

    static void viewPatients() {

        if (patients.isEmpty()) {
            System.out.println("No patient records found.");
            return;
        }

        for (Patient p : patients) {
            p.display();
        }
    }

    static void searchPatient() {

        System.out.print("Enter Patient ID: ");
        int searchId = Integer.parseInt(sc.nextLine());

        for (Patient p : patients) {
            if (p.id == searchId) {
                p.display();
                return;
            }
        }

        System.out.println("Patient not found.");
    }

    static void addVisit() {

        System.out.print("Enter Patient ID: ");
        int searchId = Integer.parseInt(sc.nextLine());

        for (Patient p : patients) {
            if (p.id == searchId) {

                System.out.print("Enter Visit Date: ");
                String date = sc.nextLine();

                System.out.print("Enter Visit Details: ");
                String details = sc.nextLine();

                p.visits.add(date + " - " + details);

                System.out.println("Visit added successfully!");
                saveRecords();
                return;
            }
        }

        System.out.println("Patient not found.");
    }

    static void viewHistory() {

        System.out.print("Enter Patient ID: ");
        int searchId = Integer.parseInt(sc.nextLine());

        for (Patient p : patients) {
            if (p.id == searchId) {

                System.out.println("Visit History of " + p.name);

                if (p.visits.isEmpty()) {
                    System.out.println("No visits recorded.");
                } else {
                    for (String visit : p.visits) {
                        System.out.println(visit);
                    }
                }

                return;
            }
        }

        System.out.println("Patient not found.");
    }

    static void saveRecords() {

        try (PrintWriter out =
                 new PrintWriter(new FileWriter("clinic_records.txt"))) {

            for (Patient p : patients) {
                out.println("Patient ID: " + p.id);
                out.println("Name: " + p.name);
                out.println("Age: " + p.age);
                out.println("Disease: " + p.disease);
                out.println("Prescription: " + p.prescription);
                out.println("Doctor: " + p.doctor);

                for (String visit : p.visits) {
                    out.println("Visit: " + visit);
                }

                out.println("-------------------------");
            }

        } catch (IOException e) {
            System.out.println("Error saving records.");
        }
    }
}