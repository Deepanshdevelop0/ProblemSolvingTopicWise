package SystemDesign.Examples.Food_Delivery_App_Swiggy.modules.PaymentModule.strategy;

import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.order.Order;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.modules.PaymentModule.PaymentStrategy;

public class UPI_Strategy implements PaymentStrategy {

    @Override
    public boolean makePayment(Order order) {
        System.out.println("Made Payment through UPI for order id : " + order.getOrderId());
        return true;
    }

}
