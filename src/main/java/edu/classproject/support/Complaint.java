package edu.classproject.support;

public class Complaint {
    private final int complaintId;
    private final String description;
    private String status;

    public Complaint(int complaintId, String description) {
        this.complaintId = complaintId;
        this.description = description;
        this.status = "PENDING";
    }

    public void submit() {
        System.out.println("[Complaint] Submitted: " + description);
    }

    public void updateStatus(String status) {
        this.status = status;
        System.out.println("[Complaint] Status updated to: " + status);
    }

    public int getComplaintId() {
        return complaintId;
    }

    public String getStatus() {
        return status;
    }
}