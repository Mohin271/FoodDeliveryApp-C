package edu.classproject.support;

public class RefundRequest {
    private final int refundId;
    private final String reason;
    private final double amount;
    private String status;

    public RefundRequest(int refundId, String reason, double amount) {
        this.refundId = refundId;
        this.reason = reason;
        this.amount = amount;
        this.status = "PENDING";
    }

    public void markApproved() {
        this.status = "APPROVED";
    }

    public void markRejected() {
        this.status = "REJECTED";
    }

    public int getRefundId() {
        return refundId;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }
}