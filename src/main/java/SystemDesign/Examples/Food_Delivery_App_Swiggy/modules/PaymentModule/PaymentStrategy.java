package SystemDesign.Examples.Food_Delivery_App_Swiggy.modules.PaymentModule;

import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.order.Order;

public interface PaymentStrategy {


    boolean makePayment(Order order);

}
