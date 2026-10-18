package DesignPatterns.practice.Creational.Factory.parent;

public interface PaymentGateway {

    String getCurrency();

    String getRegion();

    String makePayment(String toAccountNo, Double amount);

}
