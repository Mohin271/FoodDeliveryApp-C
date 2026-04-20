package edu.classproject.support;

import java.util.*;

public class SupportServiceImpl implements SupportService {

    private final Map<Integer, Complaint> complaintMap = new HashMap<>();
    private final Map<Integer, RefundRequest> refundMap = new HashMap<>();
    private final PaymentService paymentService;

    public SupportServiceImpl(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void raiseComplaint(int id, String description) {
        Complaint complaint = new Complaint(id, description);
        complaint.submit();
        complaintMap.put(id, complaint);
    }

    @Override
    public void requestRefund(int id, String reason, double amount) {
        RefundRequest refund = new RefundRequest(id, reason, amount);
        System.out.println("[Refund] Request created: Rs " + amount);
        refundMap.put(id, refund);
    }

    @Override
    public void approveRefund(int refundId) {
        RefundRequest refund = refundMap.get(refundId);

        if (refund == null) {
            System.out.println("[Error] Refund not found");
            return;
        }

        boolean success = paymentService.processRefund(refund.getAmount());

        if (success) {
            refund.markApproved();
            System.out.println("[Refund] Approved");
        } else {
            System.out.println("[Refund] Failed");
        }
    }

    @Override
    public void rejectRefund(int refundId) {
        RefundRequest refund = refundMap.get(refundId);

        if (refund != null) {
            refund.markRejected();
            System.out.println("[Refund] Rejected");
        }
    }

    @Override
    public void viewAllComplaints() {
        for (Complaint c : complaintMap.values()) {
            System.out.println("[Complaint] ID: " + c.getComplaintId() +
                    " Status: " + c.getStatus());
        }
    }
}