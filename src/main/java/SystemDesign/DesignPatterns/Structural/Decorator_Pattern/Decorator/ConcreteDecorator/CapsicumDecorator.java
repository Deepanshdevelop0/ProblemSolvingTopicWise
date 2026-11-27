package SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Decorator.ConcreteDecorator;

import SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Component.Pizza;
import SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Decorator.PizzaDecorator;

public class CapsicumDecorator extends PizzaDecorator {

    public CapsicumDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Capsicum";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 5.0;
    }

}
