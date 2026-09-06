package hospital.structures;

public class TreatmentStack {

    // Each treatment record stores basic info about a completed treatment
    public static class TreatmentRecord {
        int patientId;
        String patientName;
        String treatmentGiven;

        public TreatmentRecord(int patientId, String patientName, String treatmentGiven) {
            this.patientId = patientId;
            this.patientName = patientName;
            this.treatmentGiven = treatmentGiven;
        }

        @Override
        public String toString() {
            return "Patient ID: " + patientId +
                   ", Name: " + patientName +
                   ", Treatment: " + treatmentGiven;
        }
    }

    private java.util.LinkedList<TreatmentRecord> stack = new java.util.LinkedList<>();

    // Add a completed treatment record to the top of the stack
    public void push(TreatmentRecord record) {
        stack.addFirst(record);
    }

    // Remove and return the most recently completed treatment record
    public TreatmentRecord pop() {
        if (isEmpty()) {
            System.out.println("No treatment records to remove.");
            return null;
        }
        return stack.removeFirst();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // Display all treatment records, most recent first
    public void displayStack() {
        if (isEmpty()) {
            System.out.println("No treatment records available.");
            return;
        }
        System.out.println("Treatment history (most recent first):");
        for (TreatmentRecord r : stack) {
            System.out.println(r);
        }
    }
}