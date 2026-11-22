package SystemDesign.DesignPatterns.Behavioral.Observer_Pattern;

public interface Subject {

    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void newVideoPublished(String message);

}
