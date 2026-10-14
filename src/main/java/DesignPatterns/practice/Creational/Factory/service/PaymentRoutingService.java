package DesignPatterns.practice.Creational.Factory.service;

import DesignPatterns.practice.Creational.Factory.factoryRegistry.PaymentFactoryRegistry;
import DesignPatterns.practice.Creational.Factory.parent.PaymentGateway;
import DesignPatterns.practice.Creational.Factory.parent.PaymentGatewayFactory;

public class PaymentRoutingService {

    private final PaymentFactoryRegistry registry;

    public PaymentRoutingService(PaymentFactoryRegistry registry) {
        this.registry = registry;
    }

    public String processPayment(String providerType, String currency, String region, String accountNo, Double amount) {

        PaymentGatewayFactory factory = registry.getFactory(providerType);

        PaymentGateway gateway = factory.createGateway(currency, region);

        return gateway.makePayment(accountNo, amount);
    }

}
