import java.util.*;
import java.io.*;

public class Main {

    static class Patient {
        String name, disease, date;

        Patient(String n, String d, String dt) {
            name = n;
            disease = d;
            date = dt;
        }
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        ArrayList<Patient> list = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n1.Add Record  2.Search by Name  3.Save  4.Exit");
            choice = sc.nextInt();
            sc.nextLine();

            // Add details
            if (choice == 1) {
                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Disease: ");
                String disease = sc.nextLine();

                System.out.print("Enter Date: ");
                String date = sc.nextLine();

                list.add(new Patient(name, disease, date));
                System.out.println("Record Saved!");
            }

            // Search by name
            else if (choice == 2) {
                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                boolean found = false;

                for (Patient p : list) {
                    if (p.name.equalsIgnoreCase(name)) {
                        System.out.println("\n--- Patient Details ---");
                        System.out.println("Name: " + p.name);
                        System.out.println("Disease: " + p.disease);
                        System.out.println("Date: " + p.date);
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("No Record Found!");
                }
            }

            // Save to file
            else if (choice == 3) {
                FileWriter fw = new FileWriter("clinic.txt");

                for (Patient p : list) {
                    fw.write(p.name + "," + p.disease + "," + p.date + "\n");
                }

                fw.close();
                System.out.println("Saved to file!");
            }

        } while (choice != 4);

        sc.close();
    }
}