package LLD.SingletonDesignPattern;

public class Calculator {
    int a;
    int b;

    private static Calculator obj ;

    private Calculator() {
        System.out.println("Instance created");
    }

    public int sum(){
        return a*b;
    }

//    Lazy initialization Approach
    public static Calculator getInstance(){
        if(obj == null) {
            obj = new Calculator();
        }
        return obj;

    }
}
