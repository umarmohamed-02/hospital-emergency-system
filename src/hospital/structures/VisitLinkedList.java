package hospital.structures;

public class VisitLinkedList {

    // Each visit record
    public static class Visit {
        int visitId;
        String visitDate;
        String doctorName;
        String diagnosis;
        String treatment;
        Visit next;

        public Visit(int visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
            this.visitId = visitId;
            this.visitDate = visitDate;
            this.doctorName = doctorName;
            this.diagnosis = diagnosis;
            this.treatment = treatment;
        }

        @Override
        public String toString() {
            return "Visit ID: " + visitId +
                   ", Date: " + visitDate +
                   ", Doctor: " + doctorName +
                   ", Diagnosis: " + diagnosis +
                   ", Treatment: " + treatment;
        }
    }

    private Visit head;

    // Add a new visit to the end of the list
    public void addVisit(int visitId, String visitDate, String doctorName, String diagnosis, String treatment) {
        Visit newVisit = new Visit(visitId, visitDate, doctorName, diagnosis, treatment);
        if (head == null) {
            head = newVisit;
            return;
        }
        Visit current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newVisit;
    }

    // Remove a visit by its visitId
    public boolean removeVisit(int visitId) {
        if (head == null) {
            return false;
        }
        if (head.visitId == visitId) {
            head = head.next;
            return true;
        }
        Visit current = head;
        while (current.next != null) {
            if (current.next.visitId == visitId) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false; // not found
    }

    // Search for a visit by its visitId
    public Visit searchVisit(int visitId) {
        Visit current = head;
        while (current != null) {
            if (current.visitId == visitId) {
                return current;
            }
            current = current.next;
        }
        return null; // not found
    }

    // Display the full visit history
    public void displayVisits() {
        if (head == null) {
            System.out.println("No visit history available.");
            return;
        }
        System.out.println("Patient visit history:");
        Visit current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }
}