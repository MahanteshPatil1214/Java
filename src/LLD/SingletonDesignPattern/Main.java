package LLD.SingletonDesignPattern;

public class Main {
    public static void main(String[] args) {
        Calculator cal = Calculator.INSTANCE;
        cal.setValues(10,20);
        System.out.println("Sum:" + cal.sum());
        Calculator cal2 = Calculator.INSTANCE;
        cal2.setValues(1,20);
        System.out.println("Sum:" + cal2.sum());
    }
}
