/** 
    From https://www.tutorialspoint.com/design_pattern/mediator_pattern.htm
**/

import java.util.Date;
import java.text.SimpleDateFormat;

public class ChatDemo {
    public static void main(String[] args) {
        User robert = new User("Robert");
        User john = new User("John");
        
        robert.sendMessage(john, "Hi John");
        john.sendMessage(robert, "Hello Robert");
        robert.sendMessage(john, "What's up ?");
        john.sendMessage(robert, "Nothing special");
    }
}

class ChatMediator {
    public static void showMessage(User from, User to, String msg){
        String isoDate = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm").format(new Date());
        String transmittedMsg = isoDate + "  [from " + from.getName() + "]\t: " + msg;
        to.recieveMessage(transmittedMsg);
    }
}

class User {
    private String name;
    public User(String name){ this.name  = name; }
    public String getName() { return name; }
    
    public void sendMessage(User dest, String msg){
        ChatMediator.showMessage(this, dest, msg);
    }
    
    public void recieveMessage(String msg){
        System.out.println(" CONSOLE DE " + name + " :\t" + msg);
    }
}
