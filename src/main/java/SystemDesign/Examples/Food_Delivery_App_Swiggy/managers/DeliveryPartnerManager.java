package SystemDesign.Examples.Food_Delivery_App_Swiggy.managers;

import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.order.Order;

public class DeliveryPartnerManager {

    private static volatile DeliveryPartnerManager deliveryPartnerManager = null;

    public DeliveryPartnerManager() {}


    public static DeliveryPartnerManager getInstance() {
        if (deliveryPartnerManager == null) {
            synchronized (DeliveryPartnerManager.class) {
                if (deliveryPartnerManager == null) {
                    deliveryPartnerManager = new DeliveryPartnerManager();
                }
            }
        }

        return deliveryPartnerManager;
    }

    public void assignPartnerToOrder(Order order) {
        System.out.println("Order assigned to delivery partner, orderId : " + order.getOrderId());
    }

}
