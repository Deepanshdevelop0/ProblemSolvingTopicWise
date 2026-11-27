package SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Decorator.ConcreteDecorator;

import SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Component.Pizza;
import SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Decorator.PizzaDecorator;

public class CheeseDecorator extends PizzaDecorator {

    public CheeseDecorator(Pizza pizzaDecorator) {
        super(pizzaDecorator);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Cheese";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 10;
    }

}
