package edu.classproject.support;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public boolean processRefund(double amount) {
       System.out.println("[PaymentService] Processing refund: Rs " + amount);
        return true; // simulate success
    }
}