package edu.classproject.support;

public class SupportDemo {

    public static void main(String[] args) {

        PaymentService paymentService = new PaymentServiceImpl();
        SupportService supportService = new SupportServiceImpl(paymentService);

        // Raise complaint
        supportService.raiseComplaint(1, "Food was cold");

        // Request refund
        supportService.requestRefund(101, "Wrong order delivered", 250);

        // Approve refund
        supportService.approveRefund(101);

        // View complaints
        supportService.viewAllComplaints();
    }
}