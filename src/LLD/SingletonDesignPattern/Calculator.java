package LLD.SingletonDesignPattern;

//Enum Approach
public enum Calculator {
    INSTANCE;

    int a;
    int b;

    public void setValues(int a,int b ){
        this.a=a;
        this.b=b;
    }

    Calculator() {
        System.out.println("Instance created");
    }

    public int sum(){
        return a*b;
    }
}
