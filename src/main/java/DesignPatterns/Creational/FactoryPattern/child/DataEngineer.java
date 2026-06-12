package DesignPatterns.Creational.FactoryPattern.child;

import DesignPatterns.Creational.FactoryPattern.parent.Employee;

public class DataEngineer implements Employee {

    private final String name;

    public DataEngineer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSalary() {
        return 90000;
    }

    @Override
    public String getRole() {
        return "Data Engineer";
    }

}
