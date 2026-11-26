package SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern.Observable;

import SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern.Observer.ISubscriber;
import SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern.model.Video;

public interface IChannel {

    void subscribe(ISubscriber subscriber);
    void unSubscribe(ISubscriber subscriber);

    void notifySubscribers();
    void uploadVideo(Video video);

    Video getLatestVideo();

    String getName();
}
