package SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Decorator;


import SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Component.Pizza;

public abstract class PizzaDecorator implements Pizza {

    protected final Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        if (pizza == null) {
            throw new IllegalArgumentException("Pizza cannot be null!");
        }
        this.pizza = pizza;
    }

    public String getDescription() {
        return pizza.getDescription();
    }

    public double getPrice() {
        return pizza.getPrice();
    }

}
