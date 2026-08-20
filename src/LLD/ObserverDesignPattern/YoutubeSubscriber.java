package LLD.ObserverDesignPattern;

public class YoutubeSubscriber implements Subscriber{
    private String name;
    private int id;

    public YoutubeSubscriber(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void receiveNotification(CodingChannel codingChannel){
        System.out.println("Upload Video : Received notification to user : " + name + " userId : " +id);
        System.out.println("Video Title : " + codingChannel.getVideoTitle() + " \tVideo Filename : " + codingChannel.getVideoFileName() );
    }
}
