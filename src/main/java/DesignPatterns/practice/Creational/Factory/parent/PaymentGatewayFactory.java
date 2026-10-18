package DesignPatterns.practice.Creational.Factory.parent;

public interface PaymentGatewayFactory {

    PaymentGateway createGateway(String currency, String region);

}
