package Multithreading;

public class CreatingThread extends Thread{
    @Override
    public void run() {
        System.out.println("Executing Task 1");
    }
}


class Main{
    public static void main(String[] args) {
//        CreatingThread t1 = new CreatingThread();
//        t1.start();

         Thread t1 = new Thread(() ->{
             System.out.println("Task 1");
         });
         System.out.println(Thread.currentThread().getName());
        t1.start();
    }
}
// public class CreatingThread implements Runnable{
//    @Override
//    public void run() {
//        System.out.println("Executing Task 1");
//    }
//}
