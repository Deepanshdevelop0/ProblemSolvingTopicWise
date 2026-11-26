package SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern.Observer;

import SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern.Observable.IChannel;

public interface ISubscriber {


    void update(IChannel channel);

}
