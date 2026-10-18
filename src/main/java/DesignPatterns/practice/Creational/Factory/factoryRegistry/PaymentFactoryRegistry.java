package DesignPatterns.practice.Creational.Factory.factoryRegistry;

import DesignPatterns.practice.Creational.Factory.factory.PaypalFactory;
import DesignPatterns.practice.Creational.Factory.factory.RazorpayFactory;
import DesignPatterns.practice.Creational.Factory.factory.StripeFactory;
import DesignPatterns.practice.Creational.Factory.parent.PaymentGatewayFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PaymentFactoryRegistry {

    private final Map<String, PaymentGatewayFactory> factoryMap = new HashMap<>();

    public PaymentFactoryRegistry() {
        factoryMap.put("RAZORPAY", new RazorpayFactory());
        factoryMap.put("STRIPE", new StripeFactory());
        factoryMap.put("PAYPAL", new PaypalFactory());
    }

    public PaymentGatewayFactory getFactory(String providerType) {
        return Optional.ofNullable(factoryMap.get(providerType.toUpperCase())).orElseThrow(() -> new IllegalArgumentException("Unknown Provider" + providerType));
    }

}
