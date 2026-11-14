package theorytopics;

public class ThreadCreating extends Thread {
    public void run(){
        System.out.println("Started");
    }

    public static void main(String[] args) {
        ThreadCreating a = new ThreadCreating();
        a.start();
    }
}
