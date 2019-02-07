
/** 
    From https://sourcemaking.com/design_patterns/command/java/1
**/

import java.util.List;
import java.util.ArrayList;


public class DemoCommand1 {
    public static void main( String[] args ) {
        
        // produce commands
        List<Command> queue = new ArrayList<>();
        queue.add(new DomesticEngineer());
        queue.add(new Politician());
        queue.add(new Programmer());
        
        // execute commands
        for (Command command : queue) {
            command.execute();
        }
    }
}

// ===== Abstract command =====
interface Command {
    void execute();
}

// ===== Concrete commands =====

class DomesticEngineer implements Command {
    public void execute() {
        System.out.println(this.getClass().getSimpleName() + ".execute()");
    }
}

class Politician implements Command {
    public void execute() {
        System.out.println(this.getClass().getSimpleName() + ".execute()");
    }
}

class Programmer implements Command {
    public void execute() {
        System.out.println(this.getClass().getSimpleName() + ".execute()");
    }
}
