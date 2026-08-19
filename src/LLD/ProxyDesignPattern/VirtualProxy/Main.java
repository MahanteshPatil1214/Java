package LLD.ProxyDesignPattern.VirtualProxy;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//       Video video = new Movies("Shaw shank Redemption.mp4");
//        Video video1 = new Movies("Golmaal.mp4");
        Video video = new MovieProxy("Shaw shank Redemption.mp4");
        Video video1 = new MovieProxy("Golmaal.mp4");
        video1.play();
        video.play();
        video1.play();
        video.play();
    }
}
