package DesignPatterns.Creational.SingletonPattern;

public class AzureTablesInstance {

    private static AzureTablesInstance obj;
    private int counter;


    private AzureTablesInstance() {
        // private constructor to prevent instantiation
        this.counter = 1;
    }


    public static AzureTablesInstance getInstance() {
        if (obj == null) {
            synchronized (AzureTablesInstance.class) {
                if (obj == null) {
                    obj = new AzureTablesInstance();
                }
            }
        }

        return obj;
    }

    public int getCounter() {
        return counter;
    }
    public void incrementCounter() {
        counter++;
    }

}
