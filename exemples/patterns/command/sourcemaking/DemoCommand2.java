
/** 
    From https://sourcemaking.com/design_patterns/command/java/1
**/

import java.util.List;
import java.util.ArrayList;

// Client
public class DemoCommand2 {
    public static void main( String[] args ) {
        
        // Invoker - produce requests
        List<Command> queue = new ArrayList<>();
        queue.add(new DomesticEngineer());
        queue.add(new Politician());
        queue.add(new Programmer());
        
        // Reciever - execute requests
        for (Command command : queue) {
            command.execute();
        }
    }
}

// ===== Abstract command =====
abstract class Command {
    public void execute() {
        System.out.println(this.getClass().getSimpleName() + ".execute()");
    }
}

// ===== Concrete commands =====
class DomesticEngineer extends Command {}
class Politician extends Command {}
class Programmer extends Command {}

