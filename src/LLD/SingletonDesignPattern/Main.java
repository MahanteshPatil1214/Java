package LLD.SingletonDesignPattern;

public class Main {
    public static void main(String[] args) {
        Calculator c1 = Calculator.getInstance();
        Calculator c2 = Calculator.getInstance();
        c1.a=3;
        c1.b=10;


        c1.a=4;
        c1.b=1;
        System.out.println(c1.sum());
        System.out.println(c2.sum());

    }
}
