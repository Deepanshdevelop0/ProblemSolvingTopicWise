package SystemDesign.DesignPatterns.Creational.FactoryPattern.factory;

import SystemDesign.DesignPatterns.Creational.FactoryPattern.child.DataEngineer;
import SystemDesign.DesignPatterns.Creational.FactoryPattern.child.WebDeveloper;
import SystemDesign.DesignPatterns.Creational.FactoryPattern.parent.Employee;
import SystemDesign.DesignPatterns.Creational.FactoryPattern.parent.EmployeeFactory;

public class WebDeveloperFactory implements EmployeeFactory {

    @Override
    public Employee createEmployee(String name) {
        return new WebDeveloper(name);
    }
}
