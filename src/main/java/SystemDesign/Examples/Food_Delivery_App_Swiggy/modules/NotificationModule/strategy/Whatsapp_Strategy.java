package SystemDesign.Examples.Food_Delivery_App_Swiggy.modules.NotificationModule.strategy;

import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.order.Order;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.modules.NotificationModule.NotificationStrategy;

public class Whatsapp_Strategy implements NotificationStrategy {

    @Override
    public boolean notifyUsers(Order order, String message) {
        System.out.println("notified the user : " + order.getUser().getName() + " for orderId : " + order.getOrderId() + " via whatsapp. Message : " + message);
        return true;
    }

}
