package SystemDesign.Examples.Food_Delivery_App_Swiggy.managers;


import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.Restaurent;
import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.order.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class RestaurentManager {

    private static volatile RestaurentManager restaurentManager = null;

    private List<Restaurent> restaurentsList;

    private RestaurentManager() {
        restaurentsList = new CopyOnWriteArrayList<>();
    }

    public static RestaurentManager getInstance() {

        if (restaurentManager == null) {
            synchronized (RestaurentManager.class) {
                if (restaurentManager == null) {
                    restaurentManager = new RestaurentManager();
                }
            }
        }

        return restaurentManager;
    }


    public Restaurent addRestaurent(Restaurent restaurent) {
        if (restaurent == null) {
            throw new RuntimeException("Invalid restaurent registration found!");
        }
        restaurentsList.add(restaurent);
        return restaurent;
    }

    public List<Restaurent> getAllRestaurents() {
        return restaurentsList;
    }

    public void deleteRestaurent(Restaurent restaurent) {
        if (restaurent == null) {
            throw new RuntimeException("Invalid restaurent deletion found!");
        }
        restaurentsList.remove(restaurent);
    }

    public Restaurent updateRestaurent(Restaurent restaurent) {
        if (restaurent == null) {
            throw new RuntimeException("Invalid restaurent modification found!");
        }
        restaurentsList.remove(restaurent);
        restaurentsList.add(restaurent);
        return restaurent;
    }


    public List<Restaurent> searchByLocation(String currAddress) {
        return restaurentsList.stream()
                .filter(r -> r.getAddress().equals(currAddress))
                .collect(Collectors.toList());
    }

    public void sendOrderToKitchen(Order order) {
        System.out.println("Order sent to kitchen : " + order.getOrderId());
    }


}