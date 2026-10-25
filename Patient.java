
import java.util.*;

public class Patient {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<String[]> patients = new ArrayList<>();

    static void addPatient(String id, String name, String age,
                           String disease, String prescription,
                           String doctor, String visit) {
        patients.add(new String[]{
            id, name, age, disease, prescription, doctor, visit
        });
    }

    static void showPatient(String[] p) {
        System.out.println("\n===== PATIENT FULL DETAILS =====");
        System.out.println("Patient ID: " + p[0]);
        System.out.println("Name: " + p[1]);
        System.out.println("Age: " + p[2]);
        System.out.println("Disease: " + p[3]);
        System.out.println("Prescription: " + p[4]);
        System.out.println("Doctor: " + p[5]);
        System.out.println("Visit History: " + p[6]);
    }

    public static void main(String[] args) {

        addPatient("1001", "Gokul", "25", "Fever",
                "Paracetamol", "Dr. Kumar", "2026-10-01 - Fever checkup");
        addPatient("1002", "Arshad", "30", "Cold",
                "Cough Syrup", "Dr. Ravi", "2026-10-02 - Cold checkup");
        addPatient("1003", "Merlin", "20", "Headache",
                "Pain Relief Medicine", "Dr. Priya", "2026-10-03 - General checkup");
        addPatient("1004", "Rahul", "28", "Diabetes",
                "Doctor Consultation", "Dr. Kumar", "2026-10-04 - Checkup");
        addPatient("1005", "Priya", "24", "Allergy",
                "Antihistamine", "Dr. Meena", "2026-10-05 - Allergy checkup");
        addPatient("1006", "Kavin", "22", "Cough",
                "Cough Medicine", "Dr. Ravi", "2026-10-06 - Cough checkup");
        addPatient("1007", "Divya", "26", "Asthma",
                "Inhaler as prescribed", "Dr. Suresh", "2026-10-07 - Checkup");
        addPatient("1008", "Vijay", "35", "Fever",
                "Paracetamol", "Dr. Kumar", "2026-10-08 - Fever checkup");
        addPatient("1009", "Anu", "21", "Migraine",
                "Doctor Consultation", "Dr. Meena", "2026-10-09 - Checkup");
        addPatient("1010", "Sanjay", "32", "Blood Pressure",
                "Regular Checkup", "Dr. Suresh", "2026-10-10 - Checkup");

        while (true) {
            System.out.println("\n===== CLINIC MANAGEMENT SYSTEM =====");
            System.out.println("1. Search Patient");
            System.out.println("2. Register New Patient");
            System.out.println("3. View All Patients");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter Patient Name: ");
                    String search = sc.nextLine().trim();
                    boolean found = false;

                    for (String[] p : patients) {
                        if (p[1].equalsIgnoreCase(search)) {
                            showPatient(p);
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Patient not found!");
                        System.out.println("Please register the patient first.");
                    }
                    break;

                case "2":
                    System.out.print("Enter Patient Name: ");
                    String name = sc.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty!");
                        break;
                    }

                    boolean exists = false;
                    for (String[] p : patients) {
                        if (p[1].equalsIgnoreCase(name)) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Patient already exists!");
                        break;
                    }

                    System.out.print("Enter Age: ");
                    String age = sc.nextLine();

                    System.out.print("Enter Disease: ");
                    String disease = sc.nextLine();

                    System.out.print("Enter Prescription: ");
                    String prescription = sc.nextLine();

                    System.out.print("Enter Doctor Name: ");
                    String doctor = sc.nextLine();

                    System.out.print("Enter Visit History: ");
                    String visit = sc.nextLine();

                    int newId = 1001 + patients.size();

                    addPatient(String.valueOf(newId), name, age,
                            disease, prescription, doctor, visit);

                    System.out.println("Patient registered successfully!");
                    showPatient(patients.get(patients.size() - 1));
                    break;

                case "3":
                    for (String[] p : patients) {
                        showPatient(p);
                    }
                    break;

                case "4":
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
