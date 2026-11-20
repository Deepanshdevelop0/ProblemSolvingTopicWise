package SystemDesign.DesignPatterns.practice.Creational.Factory.factory;

import SystemDesign.DesignPatterns.practice.Creational.Factory.child.RazorpayGateway;
import SystemDesign.DesignPatterns.practice.Creational.Factory.parent.PaymentGateway;
import SystemDesign.DesignPatterns.practice.Creational.Factory.parent.PaymentGatewayFactory;

public class RazorpayFactory implements PaymentGatewayFactory {

    @Override
    public PaymentGateway createGateway(String currency, String region) {
        return new RazorpayGateway(currency, region);
    }
}
