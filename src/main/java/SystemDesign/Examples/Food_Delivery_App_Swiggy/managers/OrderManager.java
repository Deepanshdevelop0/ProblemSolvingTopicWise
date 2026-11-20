package SystemDesign.Examples.Food_Delivery_App_Swiggy.managers;

import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.order.Order;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.User;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class OrderManager {

    private static volatile OrderManager orderManager = null;

    private List<Order> orderList;

    private OrderManager(){
        orderList = new CopyOnWriteArrayList<>();
    }

    public static OrderManager getInstance() {
        if (orderManager == null) {
            synchronized (OrderManager.class) {
                if (orderManager == null) {
                    orderManager = new OrderManager();
                }
            }
        }

        return orderManager;
    }

    public Order addOrder(Order order) {
        if (order == null) {
            throw new RuntimeException("Can't add null order");
        }

        orderList.add(order);
        return order;
    }

    public List<Order> listAllOrderOfUser(User user) {
        if (user == null) {
            throw new RuntimeException("User doesnt exists!");
        }

        return orderList.stream()
                .filter(order -> order.getUser().getUserId() == user.getUserId())
                .collect(Collectors.toList());
    }

}
