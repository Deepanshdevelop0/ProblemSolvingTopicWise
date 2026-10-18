package DesignPatterns.practice.Creational.Factory.child;

import DesignPatterns.practice.Creational.Factory.parent.PaymentGateway;

public class RazorpayGateway implements PaymentGateway {

    private final String currency;
    private final String region;

    public RazorpayGateway(String currency, String region) {
        this.currency = currency;
        this.region = region;
    }

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public String getRegion() {
        return region;
    }

    @Override
    public String makePayment(String toAccountNo, Double amount) {
        System.out.println("Razorpay Gateway : Making " + amount + " payment to " + toAccountNo + ", in " + currency + " currency for " + region + " region");
        return "success";
    }
}
