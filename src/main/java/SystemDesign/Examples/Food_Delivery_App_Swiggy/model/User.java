package SystemDesign.Examples.Food_Delivery_App_Swiggy.model;


import SystemDesign.Examples.Food_Delivery_App_Swiggy.model.order.Order;

import java.util.List;

public class User {

    private int userId;
    private String name;
    private String address;
    private Cart cart;
    private List<Order> orderList;

    public User() {
        this.cart = new Cart();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }
}
