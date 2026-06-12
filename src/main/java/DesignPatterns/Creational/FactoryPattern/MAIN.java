package DesignPatterns.Creational.FactoryPattern;

import DesignPatterns.Creational.FactoryPattern.factory.PrincipalSoftwareEngineerFactory;
import DesignPatterns.Creational.FactoryPattern.factory.SoftwareEngineerFactory;
import DesignPatterns.Creational.FactoryPattern.factory.WebDeveloperFactory;
import DesignPatterns.Creational.FactoryPattern.parent.Employee;
import DesignPatterns.Creational.FactoryPattern.parent.EmployeeFactory;
import DesignPatterns.Creational.FactoryPattern.serviceForPractice.PayrollService;

public class MAIN {

    public static void main(String[] args) {

        EmployeeFactory se = new SoftwareEngineerFactory();
        PayrollService psse = new PayrollService(se);
        Employee employee1 = psse.hireNewEmployee("Ashustosg");
        System.out.println(employee1.getRole() + " : " + employee1.getSalary());

        EmployeeFactory we = new WebDeveloperFactory();
        PayrollService pswe = new PayrollService(we);
        Employee employee2 = pswe.hireNewEmployee("aman");
        System.out.println(employee2.getRole() + " : " + employee2.getSalary());

        EmployeeFactory pr = new PrincipalSoftwareEngineerFactory();
        PayrollService pspr = new PayrollService(pr);
        Employee employee3 = pspr.hireNewEmployee("Ashihsh");
        System.out.println(employee3.getRole() + " : " + employee3.getSalary());

    }
}
