package SystemDesign.Examples.Food_Delivery_App_Swiggy.strategy.impl;

import SystemDesign.Examples.Food_Delivery_App_Swiggy.constants.Constants.*;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.managers.DeliveryPartnerManager;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.managers.RestaurentManager;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.order.Order;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.modules.NotificationModule.NotificationStrategy;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.modules.NotificationModule.strategy.Whatsapp_Strategy;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.strategy.FulfillmentStrategy;

public class HomeDeliveryStrategy implements FulfillmentStrategy {

    private String deliveryAddress;

    public HomeDeliveryStrategy(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    @Override
    public String getDestinationAddress() {
        return this.deliveryAddress;
    }

    @Override
    public String getOrderType() {
        return OrderType.HOME_DELIVERY.name();
    }

    @Override
    public void initiateFulfillment(Order order) {

        // 1. Alert the restaurent to start cooking
        RestaurentManager.getInstance().sendOrderToKitchen(order);

        NotificationStrategy notificationStrategy = new Whatsapp_Strategy();
        notificationStrategy.notifyUsers(order, "Order is confirmed! Delivery partner will leave with your food in 30 mins!");

        // 2. Contact delivery partner service
        DeliveryPartnerManager.getInstance().assignPartnerToOrder(order);
    }
}
