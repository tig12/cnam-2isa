
public class ThreadExample2{
    public static void main(String args[]) {
        Thread t = new HelloThread();
        t.start();
    }
}

class HelloThread extends Thread {
    public void run() {
        System.out.println("Hello from a thread!");
    }
}

