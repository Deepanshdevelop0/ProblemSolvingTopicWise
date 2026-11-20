package SystemDesign.DesignPatterns.Creational.FactoryPattern.parent;

import SystemDesign.DesignPatterns.Creational.FactoryPattern.child.DataEngineer;
import SystemDesign.DesignPatterns.Creational.FactoryPattern.child.PrincipalSoftwareEngineer;
import SystemDesign.DesignPatterns.Creational.FactoryPattern.child.SoftwareEngineer;
import SystemDesign.DesignPatterns.Creational.FactoryPattern.child.WebDeveloper;

public interface EmployeeFactory {

    Employee createEmployee(String name);

}
