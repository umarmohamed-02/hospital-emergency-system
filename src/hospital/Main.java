package hospital;

import hospital.model.Patient;
import hospital.structures.PatientBST;
import hospital.structures.EmergencyQueue;
import hospital.structures.TreatmentStack;
import hospital.structures.TreatmentStack.TreatmentRecord;
import hospital.structures.VisitLinkedList;

import java.util.Scanner;

public class Main {

    private static PatientBST patientBST = new PatientBST();
    private static EmergencyQueue emergencyQueue = new EmergencyQueue();
    private static TreatmentStack treatmentStack = new TreatmentStack();
    private static VisitLinkedList visitHistory = new VisitLinkedList();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> searchPatient();
                case 3 -> deletePatient();
                case 4 -> patientBST.displayInOrder();
                case 5 -> enqueuePatient();
                case 6 -> dequeuePatient();
                case 7 -> emergencyQueue.displayQueue();
                case 8 -> pushTreatment();
                case 9 -> popTreatment();
                case 10 -> treatmentStack.displayStack();
                case 11 -> addVisit();
                case 12 -> removeVisit();
                case 13 -> searchVisit();
                case 14 -> visitHistory.displayVisits();
                case 0 -> System.out.println("Exiting system. Goodbye!");
                default -> System.out.println("Invalid choice, try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n===== Mini Hospital Emergency Management System =====");
        System.out.println("--- Patient Records (BST) ---");
        System.out.println("1. Add Patient");
        System.out.println("2. Search Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. Display All Patients (In-Order)");
        System.out.println("--- Emergency Queue ---");
        System.out.println("5. Enqueue Patient");
        System.out.println("6. Dequeue Patient (Treat Next)");
        System.out.println("7. Display Queue");
        System.out.println("--- Treatment Stack ---");
        System.out.println("8. Push Treatment Record");
        System.out.println("9. Pop Treatment Record");
        System.out.println("10. Display Treatment History");
        System.out.println("--- Patient Visit History (Linked List) ---");
        System.out.println("11. Add Visit");
        System.out.println("12. Remove Visit");
        System.out.println("13. Search Visit");
        System.out.println("14. Display Visit History");
        System.out.println("0. Exit");
    }

    // ---------- BST operations ----------
    private static void addPatient() {
        int id = readInt("Patient ID: ");
        String name = readString("Name: ");
        int age = readInt("Age: ");
        String contact = readString("Contact Number: ");
        String condition = readString("Medical Condition: ");
        patientBST.insert(new Patient(id, name, age, contact, condition));
        System.out.println("Patient added successfully.");
    }

    private static void searchPatient() {
        int id = readInt("Enter Patient ID to search: ");
        Patient found = patientBST.search(id);
        System.out.println(found != null ? found : "Patient not found.");
    }

    private static void deletePatient() {
        int id = readInt("Enter Patient ID to delete: ");
        patientBST.delete(id);
        System.out.println("Delete operation completed (if ID existed).");
    }

    // ---------- Queue operations ----------
    private static void enqueuePatient() {
        int id = readInt("Patient ID: ");
        String name = readString("Name: ");
        int age = readInt("Age: ");
        String contact = readString("Contact Number: ");
        String condition = readString("Medical Condition: ");
        emergencyQueue.enqueue(new Patient(id, name, age, contact, condition));
        System.out.println("Patient added to emergency queue.");
    }

    private static void dequeuePatient() {
        Patient next = emergencyQueue.dequeue();
        if (next != null) {
            System.out.println("Now treating: " + next);
        }
    }

    // ---------- Stack operations ----------
    private static void pushTreatment() {
        int id = readInt("Patient ID: ");
        String name = readString("Patient Name: ");
        String treatment = readString("Treatment Given: ");
        treatmentStack.push(new TreatmentRecord(id, name, treatment));
        System.out.println("Treatment record added.");
    }

    private static void popTreatment() {
        TreatmentRecord record = treatmentStack.pop();
        if (record != null) {
            System.out.println("Removed record: " + record);
        }
    }

    // ---------- Linked List operations ----------
    private static void addVisit() {
        int visitId = readInt("Visit ID: ");
        String date = readString("Visit Date: ");
        String doctor = readString("Doctor Name: ");
        String diagnosis = readString("Diagnosis: ");
        String treatment = readString("Treatment: ");
        visitHistory.addVisit(visitId, date, doctor, diagnosis, treatment);
        System.out.println("Visit added.");
    }

    private static void removeVisit() {
        int visitId = readInt("Enter Visit ID to remove: ");
        boolean removed = visitHistory.removeVisit(visitId);
        System.out.println(removed ? "Visit removed." : "Visit ID not found.");
    }

    private static void searchVisit() {
        int visitId = readInt("Enter Visit ID to search: ");
        var visit = visitHistory.searchVisit(visitId);
        System.out.println(visit != null ? visit : "Visit not found.");
    }

    // ---------- Input helpers ----------
    private static int readInt(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // clear leftover newline
        return value;
    }

    private static String readString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}