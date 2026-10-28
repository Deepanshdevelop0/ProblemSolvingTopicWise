package DesignPatterns.practice.Creational.Factory;

import DesignPatterns.practice.Creational.Factory.factoryRegistry.PaymentFactoryRegistry;
import DesignPatterns.practice.Creational.Factory.parent.PaymentGatewayFactory;
import DesignPatterns.practice.Creational.Factory.service.PaymentRoutingService;

public class MAIN {

    /*

    Your payment routing system handles transactions via Stripe, Razorpay, and PayPal.
    Depending on the user's region and currency, the system must dynamically instantiate the correct payment processor at runtime.
    How do you centralize this object creation logic without littering your code with complex if-else blocks?

    */

    public static void main(String[] args) {

        PaymentFactoryRegistry registry = new PaymentFactoryRegistry();
        PaymentRoutingService service = new PaymentRoutingService(registry);

        service.processPayment("paypal", "dollar", "US", "723wric9824yr2", 1000.0);

        service.processPayment("Stripe", "euro", "EU", "723wric9824yr2", 1000.0);

        service.processPayment("Razorpay", "inr", "Ind", "723wric9824yr2", 1000.0);
    }

}
