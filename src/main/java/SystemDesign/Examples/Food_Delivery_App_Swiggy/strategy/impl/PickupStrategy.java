package SystemDesign.Examples.Food_Delivery_App_Swiggy.strategy.impl;

import SystemDesign.Examples.Food_Delivery_App_Swiggy.constants.Constants.*;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.managers.RestaurentManager;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.Restaurent;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.order.Order;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.modules.NotificationModule.NotificationStrategy;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.modules.NotificationModule.strategy.Whatsapp_Strategy;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.strategy.FulfillmentStrategy;

public class PickupStrategy implements FulfillmentStrategy {

    private Restaurent restaurent;

    public PickupStrategy(Restaurent restaurent) {
        this.restaurent = restaurent;
    }

    @Override
    public String getDestinationAddress() {
        return this.restaurent.getAddress();
    }

    @Override
    public String getOrderType() {
        return OrderType.PICKUP.name();
    }

    @Override
    public void initiateFulfillment(Order order) {

        // 1. Alert the restaurent to start cooking
        RestaurentManager.getInstance().sendOrderToKitchen(order);

        NotificationStrategy notifStrategy = new Whatsapp_Strategy();
        notifStrategy.notifyUsers(order, "Order is confirmed! Please pickup your order in 30 mins!");
    }


}
