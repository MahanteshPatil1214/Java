package LLD.StrategyDesignPattern;

public class Push implements Notification{
    @Override
    public void send() {
        System.out.println("Sending Push Notification");
    }

    @Override
    public void encrypt() {
        System.out.println("RSA Encryption");
    }

    @Override
    public void compress() {
        System.out.println("ZIP Compression");

    }
}
