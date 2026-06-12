package DesignPatterns.Creational.FactoryPattern.factory;

import DesignPatterns.Creational.FactoryPattern.child.PrincipalSoftwareEngineer;
import DesignPatterns.Creational.FactoryPattern.parent.Employee;
import DesignPatterns.Creational.FactoryPattern.parent.EmployeeFactory;

public class PrincipalSoftwareEngineerFactory implements EmployeeFactory {

    @Override
    public Employee createEmployee(String name) {
        return new PrincipalSoftwareEngineer(name);
    }

}
