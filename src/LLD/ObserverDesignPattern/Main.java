package LLD.ObserverDesignPattern;

public class Main {
    public static void main(String[] args) {
     YoutubeSubscriber youtubeSubscriber = new YoutubeSubscriber("Mahantesh Patil",100);
     YoutubeSubscriber youtubeSubscriber1 = new YoutubeSubscriber("Kailash Patil",101);
     CodingChannel codingChannel = new CodingChannel();
     codingChannel.subscriber(youtubeSubscriber);
     codingChannel.subscriber(youtubeSubscriber1);
     codingChannel.uploadVideo("Observer Pattern","ObserverPatter.mp4");
    }
}
