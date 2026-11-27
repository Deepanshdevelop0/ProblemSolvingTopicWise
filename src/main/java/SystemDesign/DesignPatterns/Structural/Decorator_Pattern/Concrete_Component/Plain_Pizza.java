package SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Concrete_Component;

import SystemDesign.DesignPatterns.Structural.Decorator_Pattern.Component.Pizza;

public class Plain_Pizza implements Pizza {

    @Override
    public String getDescription() {
        return "Plain Pizza";
    }

    @Override
    public double getPrice() {
        return 199.0;
    }

}
