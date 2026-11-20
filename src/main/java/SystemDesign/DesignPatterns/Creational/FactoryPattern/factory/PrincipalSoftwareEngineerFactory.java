package SystemDesign.DesignPatterns.Creational.FactoryPattern.factory;

import SystemDesign.DesignPatterns.Creational.FactoryPattern.child.PrincipalSoftwareEngineer;
import SystemDesign.DesignPatterns.Creational.FactoryPattern.parent.Employee;
import SystemDesign.DesignPatterns.Creational.FactoryPattern.parent.EmployeeFactory;

public class PrincipalSoftwareEngineerFactory implements EmployeeFactory {

    @Override
    public Employee createEmployee(String name) {
        return new PrincipalSoftwareEngineer(name);
    }

}
