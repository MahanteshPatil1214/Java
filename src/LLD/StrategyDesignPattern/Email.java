package LLD.StrategyDesignPattern;

public class Email extends Notification{
    public Email(EncryptionStrategy encryptionstrategy, CompressionStrategy compressionStrategy) {
        super(encryptionstrategy, compressionStrategy);
    }

    @Override
    public void send() {
        System.out.println("Sending Email");
    }

}
