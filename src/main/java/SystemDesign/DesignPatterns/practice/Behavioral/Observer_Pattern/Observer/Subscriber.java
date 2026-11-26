package SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern.Observer;

import SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern.Observable.IChannel;
import SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern.model.Video;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Subscriber implements ISubscriber {

    private String name;

    public String getName() {
        return name;
    }

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(IChannel channel) {
        Video video = channel.getLatestVideo();

        System.out.println("Hey " + this.name + ", \n Uploaded new video : " + video.getName() + " by subscribed channel : " + channel.getName());
    }


}
