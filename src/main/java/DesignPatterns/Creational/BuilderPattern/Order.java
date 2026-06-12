package DesignPatterns.Creational.BuilderPattern;

public class Order {

    private final String orderId;
    private final String itemId;
    private String name;
    private String quantity;
    private String sku;

    private Order(Builder builder) {
        this.orderId = builder.orderId;
        this.itemId = builder.itemId;
        this.name = builder.name;
        this.quantity = builder.quantity;
        this.sku = builder.sku;
    }

    @Override
    public String toString() {
        return "Order : " +
                "orderId='" + orderId + '\'' +
                ", itemId='" + itemId + '\'' +
                ", itemName='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                ", sku='" + sku + '\'' + "";
    }

    public static class Builder {
        private final String orderId;
        private final String itemId;
        private String name;
        private String quantity;
        private String sku;

        public Builder(String orderId, String itemId) {
            this.orderId = orderId;
            this.itemId = itemId;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setQuantity(String quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setSKU(String sku) {
            this.sku = sku;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }
}
