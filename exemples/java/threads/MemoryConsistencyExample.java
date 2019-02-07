/** 
    PAS UTILISE DANS LE COURS
    A terminer
**/


public class MemoryConsistencyExample{
    public static void main(String args[]) throws InterruptedException{
        
        Counter c = new Counter();
        
        Thread t1 = new Thread(() -> {
            c.increment();
        });
        
        Thread t2 = new Thread(() -> {
            System.out.println("thread 2 - c = " + c.value());
        });
        
        t1.start();
        t2.start();
    }
}

class Counter {
    private int c = 0;
    public void increment() {
        for (int i = 0; i < 10000; i++) {
            c++;
        }
    }
    public void decrement() {
        for (int i = 0; i < 10000; i++) {
            c--;
        }
    }
    public int value() { return c; }
}

