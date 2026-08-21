package LLD.StrategyDesignPattern;

public abstract class Notification {
    EncryptionStrategy encryptionstrategy;
    CompressionStrategy compressionStrategy;

    public Notification(EncryptionStrategy encryptionstrategy, CompressionStrategy compressionStrategy) {
        this.encryptionstrategy = encryptionstrategy;
        this.compressionStrategy = compressionStrategy;
    }

    abstract void send();
    void encrypt(){
        encryptionstrategy.encrypt();
    }

    void compress(){
        compressionStrategy.compress();
    }
}


