package DesignPatterns.practice.Creational.Factory.factory;

import DesignPatterns.practice.Creational.Factory.child.StripeGateway;
import DesignPatterns.practice.Creational.Factory.parent.PaymentGateway;
import DesignPatterns.practice.Creational.Factory.parent.PaymentGatewayFactory;

public class StripeFactory implements PaymentGatewayFactory {

    @Override
    public PaymentGateway createGateway(String currency, String region) {
        return new StripeGateway(currency, region);
    }

}
