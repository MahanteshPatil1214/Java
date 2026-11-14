package theorytopics;

public class ThreadCreating implements Runnable{
    public void run(){
        System.out.println("Started");
    }

    public static void main(String[] args) {
        Thread a = new Thread(new ThreadCreating());
        a.start();
    }
}
