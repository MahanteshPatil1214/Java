package theorytopics;

public class ThrowsAndThrow {
    public static int testTheDivide(int a,int b) throws ArithmeticException{
        if(a == 0 || b==0) throw new ArithmeticException();
        return a/b;
    }

    public static void main(String[] args) {
        try{
            testTheDivide(2,0);
        } catch (ArithmeticException e) {
            System.out.println("Divide by Zero");
        }
    }
}
