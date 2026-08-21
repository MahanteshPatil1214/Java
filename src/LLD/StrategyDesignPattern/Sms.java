package LLD.StrategyDesignPattern;

public class Sms extends Notification{
    public Sms(EncryptionStrategy encryptionstrategy, CompressionStrategy compressionStrategy) {
        super(encryptionstrategy, compressionStrategy);
    }

    @Override
    public void send() {
        System.out.println("Sending Sms");
    }

}
