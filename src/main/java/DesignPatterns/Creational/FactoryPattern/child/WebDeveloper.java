package DesignPatterns.Creational.FactoryPattern.child;

import DesignPatterns.Creational.FactoryPattern.parent.Employee;

public class WebDeveloper implements Employee {

    private final String name;

    public WebDeveloper(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSalary() {
        return 60000;
    }

    @Override
    public String getRole() {
        return "Web Developer";
    }

}
