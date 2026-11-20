package SystemDesign.Examples.Food_Delivery_App_Swiggy.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Cart {

    private Restaurent restaurent;

    private List<MenuItem> itemsList;

    public Cart() {
        this.itemsList = new CopyOnWriteArrayList<>();
    }

    public void addToCart(Restaurent restaurent, MenuItem item) {

        if (restaurent == null || item == null) {
            throw new RuntimeException("Invalid Restaurent or Menu Item!");
        }
        if (!restaurent.getMenuItems().contains(item)) {
            throw new RuntimeException("Menu Item doesnt exist in this restaurent!");
        }

        this.restaurent = restaurent;
        this.itemsList.add(item);
    }

    public double totalCost() {
        return itemsList.stream()
                .mapToDouble(MenuItem::getPrice)
                .sum();
    }

    public void removeCart(MenuItem item) {
        this.itemsList.clear();
        this.restaurent = null;
    }

    public boolean isEmpty() {
        return restaurent == null && itemsList.isEmpty();
    }


    /* Getters and Setters */
    public Restaurent getRestaurent() {
        return restaurent;
    }

    public void setRestaurent(Restaurent restaurent) {
        this.restaurent = restaurent;
    }

    public List<MenuItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<MenuItem> itemsList) {
        this.itemsList = itemsList;
    }
}
