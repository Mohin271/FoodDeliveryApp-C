package edu.classproject.support;

public interface SupportService {

    void raiseComplaint(int id, String description);

    void requestRefund(int id, String reason, double amount);

    void approveRefund(int refundId);

    void rejectRefund(int refundId);

    void viewAllComplaints();
}