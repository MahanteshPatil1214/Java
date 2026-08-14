package LLD.SingletonDesignPattern;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(Calculator::getInstance);
        Thread t2 = new Thread(Calculator::getInstance);
        t1.start();
        t2.start();

    }
}
