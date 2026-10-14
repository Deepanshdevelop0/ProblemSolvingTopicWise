package DesignPatterns.practice.Creational.Factory.factory;

import DesignPatterns.practice.Creational.Factory.child.PaypalGateway;
import DesignPatterns.practice.Creational.Factory.parent.PaymentGateway;
import DesignPatterns.practice.Creational.Factory.parent.PaymentGatewayFactory;

public class PaypalFactory implements PaymentGatewayFactory {

    @Override
    public PaymentGateway createGateway(String currency, String region) {
        return new PaypalGateway(currency, region);
    }

}
