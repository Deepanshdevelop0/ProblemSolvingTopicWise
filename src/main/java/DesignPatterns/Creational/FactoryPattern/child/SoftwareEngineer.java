package DesignPatterns.Creational.FactoryPattern.child;

import DesignPatterns.Creational.FactoryPattern.parent.Employee;

public class SoftwareEngineer implements Employee {

    private final String name;

    public SoftwareEngineer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
    @Override
    public int getSalary() {
        return 100000;
    }

    @Override
    public String getRole() {
        return "Software Engineer";
    }

}
