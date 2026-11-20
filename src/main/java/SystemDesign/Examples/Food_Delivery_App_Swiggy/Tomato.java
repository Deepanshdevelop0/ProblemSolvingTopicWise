package SystemDesign.Examples.Food_Delivery_App_Swiggy;

import SystemDesign.Examples.Food_Delivery_App_Swiggy.managers.OrderManager;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.managers.RestaurentManager;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.Cart;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.MenuItem;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.Restaurent;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.User;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.order.Order;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.modules.PaymentModule.strategy.CreditCard_Strategy;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.modules.PaymentModule.strategy.UPI_Strategy;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.strategy.impl.HomeDeliveryStrategy;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.strategy.impl.PickupStrategy;

import java.util.List;

public class Tomato {

    public static void main(String[] args) {

        // 1. create User
        User user = new User();
        user.setUserId(1);
        user.setName("Deepanshu");
        user.setAddress("New Market");

        // 2. Create Restaurent
        Restaurent restaurent1 = new Restaurent();
        restaurent1.setId(1);
        restaurent1.setName("Sagar Gaire");
        restaurent1.setAddress("New Market");

        Restaurent restaurent2 = new Restaurent();
        restaurent2.setId(2);
        restaurent2.setName("Sharma Vishnu");
        restaurent2.setAddress("New Market");


        // 3. Create Menu items
        MenuItem item1 = new MenuItem();
        item1.setItemCode("paneer65");
        item1.setName("Paneer 65");
        item1.setPrice(229.0D);

        MenuItem item2 = new MenuItem();
        item2.setItemCode("chilliPaneer");
        item2.setName("Chilli Paneer");
        item2.setPrice(249.99D);

        MenuItem item3 = new MenuItem();
        item3.setItemCode("paneerPasanda");
        item3.setName("Paneer Pasanda");
        item3.setPrice(299.99D);

        // set items to restaurent
        restaurent1.setMenuItems(List.of(item1, item2));
        restaurent2.setMenuItems(List.of(item1, item2));

        RestaurentManager resManager = RestaurentManager.getInstance();
        resManager.addRestaurent(restaurent1);
        resManager.addRestaurent(restaurent2);

        // User searches for restaurent of its location
        List<Restaurent> restaurentsNearMe = resManager.searchByLocation(user.getAddress());
        restaurentsNearMe.forEach(res -> {
            System.out.println("restaurent name : " + res.getName() + ", address : " + res.getAddress());
        });

        // 4. Cart Operations
        Cart userCart = user.getCart();
        userCart.addToCart(restaurent1, item1);
        userCart.addToCart(restaurent1, item2);
        // userCart.addToCart(restaurent1, item3); // will throw exception as item in not in this restaurent1

        // 5. Build the delivery order
        Order order1 = new Order.OrderBuilder()
                .setOrderId(1)
                .setRestaurent(userCart.getRestaurent())
                .setUser(user)
                .setMenuItems(userCart.getItemsList())
                .setFulfillmentStrategy(new HomeDeliveryStrategy("Jane Street I, Bangalore"))
                .setPaymentStrategy(new UPI_Strategy())
                .build();

        // 5. Build the delivery order
        Order order2 = new Order.OrderBuilder()
                .setOrderId(2)
                .setRestaurent(userCart.getRestaurent())
                .setUser(user)
                .setMenuItems(userCart.getItemsList())
                .setFulfillmentStrategy(new PickupStrategy(userCart.getRestaurent()))
                .setPaymentStrategy(new CreditCard_Strategy())
                .build();

        // 6. Process the order
        processSuccessfulOrder(order1, userCart);

        System.out.println();
        System.out.println();
        System.out.println();
        processSuccessfulOrder(order2, userCart);
    }


    public static void processSuccessfulOrder(Order order, Cart cart) {

        boolean paySuccess = order.getPaymentStrategy().makePayment(order);

        if (paySuccess) {

            // save to db or list
            OrderManager.getInstance().addOrder(order);

            // trigger fulfillment logic
            // if orderType is delivery it assigns delivery partner. If pickup, it skips it.
            order.getFulfillmentStrategy().initiateFulfillment(order);
        }

    }

}
