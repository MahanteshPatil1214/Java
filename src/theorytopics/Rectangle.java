package theorytopics;

public class Rectangle {
    public static void main(String[] args) {
        Area a = new Area();
        //Shallow Copy
        Area b = a;

        //Deep Copy
        Area c = new Area();
        c.length=a.length;
        c.breadth=b.breadth;
    }
}

class  Area{
    int length;
    int breadth;
}