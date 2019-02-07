
public class ExceptionsExample{
    public static void main(String args[]){
       Thread t1 = new Thread(() -> {
           try{ Thread.sleep(1000); }
           catch(InterruptedException e){}
       });
       Thread t2 = new Thread(() -> {
           try{ Thread.sleep(1000); }
           catch(InterruptedException e){}
       });
       t1.start();
       t2.start();
     }
}

public class ExceptionsExample{
    public static void main(String args[]){
        try{ 
            Thread t1 = new Thread(() -> { Thread.sleep(1000); });
            Thread t2 = new Thread(() -> { Thread.sleep(1000); });
            t1.start();
            t2.start();
        }
        catch(InterruptedException e){
        }
    }
}

