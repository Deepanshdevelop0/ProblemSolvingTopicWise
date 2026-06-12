package DesignPatterns.Creational.FactoryPattern.factory;

import DesignPatterns.Creational.FactoryPattern.child.SoftwareEngineer;
import DesignPatterns.Creational.FactoryPattern.parent.Employee;
import DesignPatterns.Creational.FactoryPattern.parent.EmployeeFactory;

public class SoftwareEngineerFactory implements EmployeeFactory {

    @Override
    public Employee createEmployee(String name) {
        return new SoftwareEngineer(name);
    }

}
