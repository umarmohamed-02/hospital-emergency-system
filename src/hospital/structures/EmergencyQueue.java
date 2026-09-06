package hospital.structures;

import hospital.model.Patient;
import java.util.LinkedList;

public class EmergencyQueue {

    private LinkedList<Patient> queue = new LinkedList<>();

    // Add a patient to the back of the waiting queue
    public void enqueue(Patient patient) {
        queue.addLast(patient);
    }

    // Remove and return the next patient for treatment (front of queue)
    public Patient dequeue() {
        if (isEmpty()) {
            System.out.println("No patients waiting in the emergency queue.");
            return null;
        }
        return queue.removeFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Display all patients currently waiting, in order
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("No patients waiting in the emergency queue.");
            return;
        }
        System.out.println("Patients waiting in emergency queue:");
        for (Patient p : queue) {
            System.out.println(p);
        }
    }
}
