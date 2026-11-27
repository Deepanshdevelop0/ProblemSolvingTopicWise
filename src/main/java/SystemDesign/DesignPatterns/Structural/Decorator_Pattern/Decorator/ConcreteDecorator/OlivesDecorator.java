package SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Decorator.ConcreteDecorator;

import SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Component.Pizza;
import SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Decorator.PizzaDecorator;

public class OlivesDecorator extends PizzaDecorator {

    public OlivesDecorator(Pizza pizza) {
        super(pizza);
    }


    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Olives";
    }

    @Override
    public double getPrice() {
        return pizza.getPrice() + 10.0;
    }

}
