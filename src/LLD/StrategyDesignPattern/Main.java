package LLD.StrategyDesignPattern;

public class Main {
    public static void main(String[] args) {
        Notification notification = new Email();
        notification.encrypt();
        notification.send();
        notification.compress();
    }
}
