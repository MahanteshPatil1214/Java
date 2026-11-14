package theorytopics;

public class ConstructorChaining {
   ConstructorChaining(){
       this("Default Constructor");
   }

   ConstructorChaining(String s){
       System.out.println(s);
   }

    public static void main(String[] args) {
        ConstructorChaining b = new ConstructorChaining();
    }
}
