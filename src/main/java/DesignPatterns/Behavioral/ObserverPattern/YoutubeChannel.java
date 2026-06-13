package DesignPatterns.Behavioral.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannel implements Subject {

    private final String name;
    List<Observer> observers = new ArrayList<>();

    public YoutubeChannel(String name) {
        this.name = name;
    }

    @Override
    public void subscribe(Observer ob) {
        observers.add(ob);
    }

    @Override
    public void unsubscribe(Observer ob) {
        observers.remove(ob);
    }

    @Override
    public void newVideoPublished(String message) {

        for (Observer ob : observers) {
            ob.notified(message);
        }

    }

}
