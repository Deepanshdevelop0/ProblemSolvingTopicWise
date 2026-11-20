package SystemDesign.Examples.Food_Delivery_App_Swiggy.model.order;

import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.MenuItem;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.Restaurent;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.User;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.modules.PaymentModule.PaymentStrategy;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.strategy.FulfillmentStrategy;

import java.util.Date;
import java.util.List;

public class Order {

    private int orderId;
    private Restaurent restaurent;
    private User user;
    private List<MenuItem> menuItems;
    private PaymentStrategy paymentStrategy;
    private FulfillmentStrategy fulfillmentStrategy;

    public int getOrderId() {
        return orderId;
    }

    public Restaurent getRestaurent() {
        return restaurent;
    }

    public User getUser() {
        return user;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public PaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public FulfillmentStrategy getFulfillmentStrategy() {
        return fulfillmentStrategy;
    }

    private  Order(OrderBuilder builder) {
        this.orderId = builder.orderId;
        this.restaurent = builder.restaurent;
        this.user = builder.user;
        this.menuItems = builder.menuItems;
        this.paymentStrategy = builder.paymentStrategy;
        this.fulfillmentStrategy = builder.fulfillmentStrategy;
    }

    public static class OrderBuilder {

        private int orderId;
        private Restaurent restaurent;
        private User user;
        private List<MenuItem> menuItems;
        private PaymentStrategy paymentStrategy;
        private FulfillmentStrategy fulfillmentStrategy;

        public OrderBuilder() {
        }

        public OrderBuilder setOrderId(int orderId) {
            this.orderId = orderId;
            return this;
        }

        public OrderBuilder setRestaurent(Restaurent restaurent) {
            this.restaurent = restaurent;
            return this;
        }

        public OrderBuilder setUser(User user) {
            this.user = user;
            return this;
        }

        public OrderBuilder setPaymentStrategy(PaymentStrategy paymentStrategy) {
            this.paymentStrategy = paymentStrategy;
            return this;
        }
        public OrderBuilder setMenuItems(List<MenuItem> menuItems) {
            this.menuItems = menuItems;
            return this;
        }

        public OrderBuilder setFulfillmentStrategy(FulfillmentStrategy fullFulfillmentStrategy) {
            this.fulfillmentStrategy = fullFulfillmentStrategy;
            return this;
        }

        public Order build() {
            return new Order(this);
        }

    }

}
