package SystemDesign.DesignPatterns.practice.Behavioral.Observer_Pattern.model;

public class Video {

    private String name;

    private byte[] videoData;

    public Video(String name, byte[] videoData) {
        this.name = name;
        this.videoData = videoData;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getVideoData() {
        return videoData;
    }

    public void setVideoData(byte[] videoData) {
        this.videoData = videoData;
    }
}
