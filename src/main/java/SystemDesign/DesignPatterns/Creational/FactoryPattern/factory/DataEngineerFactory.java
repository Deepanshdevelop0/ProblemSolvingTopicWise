package SystemDesign.DesignPatterns.Creational.FactoryPattern.factory;

import SystemDesign.DesignPatterns.Creational.FactoryPattern.child.DataEngineer;
import SystemDesign.DesignPatterns.Creational.FactoryPattern.child.SoftwareEngineer;
import SystemDesign.DesignPatterns.Creational.FactoryPattern.parent.Employee;
import SystemDesign.DesignPatterns.Creational.FactoryPattern.parent.EmployeeFactory;

public class DataEngineerFactory implements EmployeeFactory {

    @Override
    public Employee createEmployee(String name) {
        return new DataEngineer(name);
    }

}
