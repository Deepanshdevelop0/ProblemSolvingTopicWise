package SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern.Observable;

import SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern.Observer.ISubscriber;
import SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern.model.Video;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Channel implements IChannel {

    private String name;
    private Video latestVideo;

    private Set<ISubscriber> subscribers;

    public Channel(String name) {
        this.name = name;
        latestVideo = null;
        subscribers = new CopyOnWriteArraySet<>();
    }

    @Override
    public void subscribe(ISubscriber subscriber) {
        if (subscriber == null) {
            throw new IllegalArgumentException("Subscriber cannot be null!");
        }
        subscribers.add(subscriber);
    }

    @Override
    public void unSubscribe(ISubscriber subscriber) {
        if (subscriber == null) {
            throw new IllegalArgumentException("Subscriber cant be null!");
        }
        subscribers.remove(subscriber);
    }

    @Override
    public void uploadVideo(Video video) {
        if (video == null) {
            throw new IllegalArgumentException("Upload video is null!");
        }
        this.latestVideo = video;

        notifySubscribers();
    }

    @Override
    public void notifySubscribers() {

        for (ISubscriber subscriber : subscribers) {
            subscriber.update(this);
        }

    }

    @Override
    public Video getLatestVideo() {
        return this.latestVideo;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
