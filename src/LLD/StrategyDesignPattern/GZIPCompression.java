package LLD.StrategyDesignPattern;

public class GZIPCompression implements CompressionStrategy{
    @Override
    public void compress() {
        System.out.println("GZIP Compression");
    }
}
