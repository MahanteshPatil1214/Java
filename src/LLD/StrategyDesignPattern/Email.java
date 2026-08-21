package LLD.StrategyDesignPattern;

public class Email implements Notification{
    @Override
    public void send() {
        System.out.println("Sending Email");
    }

    @Override
    public void encrypt() {
System.out.println("AES Encryption");
    }

    @Override
    public void compress() {
System.out.println("ZIP Compression");
    }
}
