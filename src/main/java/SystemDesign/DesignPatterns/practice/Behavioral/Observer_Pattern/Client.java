package SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern;

import SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern.Observable.Channel;
import SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern.Observable.IChannel;
import SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern.Observer.ISubscriber;
import SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern.Observer.Subscriber;
import SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern.model.Video;

public class Client {

    public static void main(String[] args) {

        // 1. Create channel and uploaded new video
        IChannel channel1 = new Channel("DeepBytes");

        // 2. New Subscriber comes
        ISubscriber deepanshu = new Subscriber("Deepanshu");
        ISubscriber aman = new Subscriber("aman");

        // 3. Now subscribes to channel
        channel1.subscribe(deepanshu);
        channel1.subscribe(aman);

        // 4. time to get notified
        channel1.uploadVideo(new Video("Design Spotify", new byte[]{}));

        channel1.unSubscribe(aman);


        // 4. time to get notified
        channel1.uploadVideo(new Video("Design Uber", new byte[]{}));


    }


}
