package SystemDesign.DesignPatterns.practice.Creational.Factory.factory;

import SystemDesign.DesignPatterns.practice.Creational.Factory.child.StripeGateway;
import SystemDesign.DesignPatterns.practice.Creational.Factory.parent.PaymentGateway;
import SystemDesign.DesignPatterns.practice.Creational.Factory.parent.PaymentGatewayFactory;

public class StripeFactory implements PaymentGatewayFactory {

    @Override
    public PaymentGateway createGateway(String currency, String region) {
        return new StripeGateway(currency, region);
    }

}
