package DesignPatterns.Behavioral.ObserverPattern;

public class Main {

    public static void main(String[] args) {
        YoutubeChannel channel = new YoutubeChannel("CodeWithDeepanshu");

        Subscriber deepanshu = new Subscriber("Deepanshu");
        channel.subscribe(deepanshu);
        Subscriber ashutosh = new Subscriber("Ashutosh");
        channel.subscribe(ashutosh);
        Subscriber aman = new Subscriber("AMAN");
        channel.subscribe(aman);

        channel.newVideoPublished("New video on Observer Pattern is out!");
        channel.newVideoPublished("Preparing upcoming video on Strategy Pattern!");

        channel.unsubscribe(ashutosh);

        channel.newVideoPublished("Working upcoming video on Strategy Pattern!");

    }


}
