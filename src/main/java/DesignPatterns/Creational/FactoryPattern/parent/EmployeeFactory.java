package DesignPatterns.Creational.FactoryPattern.parent;

import DesignPatterns.Creational.FactoryPattern.child.DataEngineer;
import DesignPatterns.Creational.FactoryPattern.child.PrincipalSoftwareEngineer;
import DesignPatterns.Creational.FactoryPattern.child.SoftwareEngineer;
import DesignPatterns.Creational.FactoryPattern.child.WebDeveloper;

public interface EmployeeFactory {

    Employee createEmployee(String name);

}
