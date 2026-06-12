package DesignPatterns.Creational.FactoryPattern.child;

import DesignPatterns.Creational.FactoryPattern.parent.Employee;

public class PrincipalSoftwareEngineer implements Employee {

    private final String name;

    public PrincipalSoftwareEngineer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSalary() {
        return 210000;
    }

    @Override
    public String getRole() {
        return "Principal Software Engineer";
    }



}
