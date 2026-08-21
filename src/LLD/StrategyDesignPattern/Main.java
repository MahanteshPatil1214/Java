package LLD.StrategyDesignPattern;

public class Main {
    public static void main(String[] args) {
        Notification email = new Email(new AESEncryption(),new ZIPCompression());
        email.send();
        email.compress();
        email.encrypt();

        Notification sms = new Sms(new AESEncryption(),new GZIPCompression());
        sms.send();
        sms.compress();
        sms.encrypt();

        Notification push = new Push(new RSAEncryption(),new ZIPCompression());
        push.send();
        push.compress();
        push.encrypt();

        }

}
