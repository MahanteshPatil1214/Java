package LLD.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class CodingChannel {
    private String videoTitle;
    private String videoFileName;

    public String getVideoTitle() {
        return videoTitle;
    }

    public String getVideoFileName() {
        return videoFileName;
    }

    List<Subscriber> subscriberList = new ArrayList<>();
//    List<YoutubeSubscriber> subscriberList = new ArrayList<>();

    public void subscriber(Subscriber youtubeSubscriber){
        subscriberList.add(youtubeSubscriber);
    }

    public void notifySubscribers() {
        for (Subscriber youtubeSubscriber : subscriberList) {
            youtubeSubscriber.receiveNotification(this);
        }
    }

    public void uploadVideo(String videoTitle,String videoFileName){
        this.videoFileName=videoFileName;
        this.videoTitle=videoTitle;
        System.out.println("Video has been uploaded : " + " Title - " + videoTitle + " \tFilename - " + videoFileName);
        notifySubscribers();
    }

    }

