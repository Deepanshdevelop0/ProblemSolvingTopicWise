package DesignPatterns.Creational.SingletonPattern;

public class MAIN {

    public static void main(String[] args) {
        AzureTablesInstance instance1 = AzureTablesInstance.getInstance();
        System.out.println("Counter val : " + instance1.getCounter());
        instance1.incrementCounter();

        AzureTablesInstance instance2 = AzureTablesInstance.getInstance();
        System.out.println("Counter val : " + instance2.getCounter());
        System.out.println(instance2.hashCode() == instance1.hashCode());

    }
}
