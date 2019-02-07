
public class JoinExample{
    public static void main(String args[]) throws InterruptedException{
       Thread t1 = new Thread(() -> {
           try{
               System.out.println("    thread 1 avant sleep");
               Thread.sleep(1000);
               System.out.println("    thread 1 après sleep");
           }
           catch(InterruptedException e){ e.printStackTrace(); }
       });
       Thread t2 = new Thread(() -> {
           try{
               System.out.println("    thread 2 avant sleep");
               Thread.sleep(1000);
               System.out.println("    thread 2 après sleep");
           }
           catch(InterruptedException e){ e.printStackTrace(); }
       });
       Thread t3 = new Thread(() -> {
           try{
               System.out.println("    thread 3 avant sleep");
               Thread.sleep(1000);
               System.out.println("    thread 3 après sleep");
           }
           catch(InterruptedException e){ e.printStackTrace(); }
       });
       t1.start();
       t2.start();
       //t2.join();
       t3.start();
     }
}

