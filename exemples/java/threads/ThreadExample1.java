
public class ThreadExample1{
    public static void main(String args[]) {
        Thread t = new Thread(new HelloRunnable());
        t.start();
    }
}

class HelloRunnable implements Runnable {
    public void run() {
        System.out.println("Hello from a thread!");
    }
}
