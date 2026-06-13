package DesignPatterns.Behavioral.ObserverPattern;

public class Subscriber implements Observer {

    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void notified(String message) {
        System.out.println(this.name + " you have new notification : " + message);
    }

}
