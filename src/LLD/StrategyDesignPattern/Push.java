package LLD.StrategyDesignPattern;

public class Push extends Notification{
    public Push(EncryptionStrategy encryptionstrategy, CompressionStrategy compressionStrategy) {
        super(encryptionstrategy, compressionStrategy);
    }

    @Override
    public void send() {
        System.out.println("Sending Push Notification");
    }
}
