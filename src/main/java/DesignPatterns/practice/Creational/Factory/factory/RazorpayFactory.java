package DesignPatterns.practice.Creational.Factory.factory;

import DesignPatterns.practice.Creational.Factory.child.RazorpayGateway;
import DesignPatterns.practice.Creational.Factory.parent.PaymentGateway;
import DesignPatterns.practice.Creational.Factory.parent.PaymentGatewayFactory;

public class RazorpayFactory implements PaymentGatewayFactory {

    @Override
    public PaymentGateway createGateway(String currency, String region) {
        return new RazorpayGateway(currency, region);
    }
}
