package SystemDesign.Examples.Food_Delivery_App_Swiggy.strategy;

import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.order.Order;

public interface FulfillmentStrategy {

    String getDestinationAddress();
    String getOrderType();

    void initiateFulfillment(Order order);

}
