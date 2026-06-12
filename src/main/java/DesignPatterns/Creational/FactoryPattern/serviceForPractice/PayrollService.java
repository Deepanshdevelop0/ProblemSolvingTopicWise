package DesignPatterns.Creational.FactoryPattern.serviceForPractice;

import DesignPatterns.Creational.FactoryPattern.parent.Employee;
import DesignPatterns.Creational.FactoryPattern.parent.EmployeeFactory;

public class PayrollService{

    private final EmployeeFactory employeeFactory;

    public PayrollService(EmployeeFactory employeeFactory) {
        this.employeeFactory = employeeFactory;
    }

    public Employee hireNewEmployee(String name) {
        System.out.println("Hiring new employee: " + name);

        Employee newHire = employeeFactory.createEmployee(name);

        System.out.println("Hired new employee: " + newHire.getRole() + " with salary: " + newHire.getSalary());

        return newHire;
    }

}
