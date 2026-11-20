package SystemDesign.Examples.Food_Delivery_App_Swiggy.modules.NotificationModule;

import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.order.Order;

public interface NotificationStrategy {

    boolean notifyUsers(Order order, String message);

}
