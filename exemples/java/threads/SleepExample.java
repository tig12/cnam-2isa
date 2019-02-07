
public class SleepExample{
    
    public static void main(String args[]) throws InterruptedException {
        String messages[] = {
            "Message 1",
            "Message 2",
            "Message 3"
        };

        for (int i = 0; i < messages.length; i++) {
            System.out.println(messages[i]);
            Thread.sleep(1000); // milliseconds
        }
    }
}


