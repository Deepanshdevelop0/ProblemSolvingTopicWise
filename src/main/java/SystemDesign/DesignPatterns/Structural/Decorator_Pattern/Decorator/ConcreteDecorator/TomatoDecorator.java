package SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Decorator.ConcreteDecorator;

import SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Component.Pizza;
import SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Decorator.PizzaDecorator;

public class TomatoDecorator extends PizzaDecorator {

    public TomatoDecorator(Pizza pizza) {
        super(pizza);
    }


    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Tomatoes";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 5;
    }

}
