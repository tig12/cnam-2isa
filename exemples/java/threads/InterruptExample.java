
public class InterruptExample{
    public static void main(String args[]) throws InterruptedException{
        Thread t = new Thread(new HelloThread());
        System.out.println("main thread avant start");
        t.start();
        System.out.println("main thread après start");
        Thread.sleep(3005);
        System.out.println("main thread après sleep()");
        t.interrupt();
        System.out.println("main thread après interrupt()");
    }
}

class HelloThread implements Runnable {
    public void run() {
        try{
            String messages[] = {
                "Message 1",
                "Message 2",
                "Message 3"
            };
    
            for (int i = 0; i < messages.length; i++) {
                System.out.println("    HelloThread " + messages[i]);
                Thread.sleep(1000);
            }
            System.out.println("    HelloThread - après la boucle d'affichage de messages");
            
            for (int i = 0; i < 10000; i++) {
                System.out.print(i + " ");
                if (Thread.interrupted()) {
                    System.out.println("    HelloThread - Thread.interrupted() a renvoyé true");
                    return; // stop thread execution
                }
            }
        }
        catch(InterruptedException e){
            return; // stop thread execution
        }
    }
}
