package SystemDesign.DesignPatterns.Structural.Decorator_Pattern;

import SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Component.Pizza;
import SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Decorator.ConcreteDecorator.CapsicumDecorator;
import SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Decorator.ConcreteDecorator.CheeseDecorator;
import SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Decorator.ConcreteDecorator.OlivesDecorator;
import SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Decorator.ConcreteDecorator.TomatoDecorator;
import SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Concrete_Component.Plain_Pizza;

public class Client {

    public static void main(String[] args) {

        Pizza pizza = new Plain_Pizza();

        System.out.println(pizza.getDescription() + ", price : " + pizza.getPrice());

        Pizza cheesePizza = new CheeseDecorator(pizza);
        System.out.println(cheesePizza.getDescription() + ", price : " + cheesePizza.getPrice());

        Pizza tomatoCheesePizza = new TomatoDecorator(cheesePizza);
        System.out.println(tomatoCheesePizza.getDescription() + ", price : " + tomatoCheesePizza.getPrice());

        Pizza olivesTomatoCheesePizza = new OlivesDecorator(tomatoCheesePizza);
        System.out.println(olivesTomatoCheesePizza.getDescription() + ", price : " + olivesTomatoCheesePizza.getPrice());

        Pizza capsicumOlivesTomatoCheesePizza = new CapsicumDecorator(olivesTomatoCheesePizza);
        System.out.println(capsicumOlivesTomatoCheesePizza.getDescription() + ", price : " + capsicumOlivesTomatoCheesePizza.getPrice());

    }
}
