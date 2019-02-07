
/** 
    Use of Command and Composite patterns
**/

import java.util.List;
import java.util.ArrayList;

public class MenuCommands {
    
    public static void main( String[] args ) {

        MenuI mFile = new Menu("File");
        MenuI mNew = new Menu("New");
        MenuI mOpen = new Menu("Open");
        MenuI mPrint = new Menu("Print");
        MenuI mQuit = new Menu("Quit");
        mNew.setCommand(new NewCommand());
        mOpen.setCommand(new OpenCommand());
        mPrint.setCommand(new PrintCommand());
        mQuit.setCommand(new QuitCommand());
        mFile.addChild(mNew);               
        mFile.addChild(mOpen);
        mFile.addChild(mPrint);
        mFile.addChild(mQuit);
        
        MenuI mEdit = new Menu("Edit");
        MenuI mPreferences = new Menu("Preferences");
        mPreferences.setCommand(new PreferencesCommand());
        mEdit.addChild(mPreferences);
        
        
        // Normal execution
        System.out.println("\n=== Normal execution ===");
        mFile.performMenuAction();
        mEdit.performMenuAction();
        
        System.out.println("\n=== Play a trick to user : invert new and open ===");
        mNew.setCommand(new OpenCommand());
        mOpen.setCommand(new NewCommand());
        mFile.performMenuAction();
        mEdit.performMenuAction();
    }
}

// ===== Composite menus =====
interface MenuI{
    public void setCommand(Command command);
    public void performMenuAction();
    public void addChild(MenuI child);
}

class Menu implements MenuI{
    private String name;
    private Command command = null;
    private List<MenuI> children = new ArrayList<>();
    
    public Menu(String name){
        this.name = name;
    }
    
    public void setCommand(Command command){
        this.command = command;
    }
    
    public void addChild(MenuI child){
        children.add(child);
    }
    
    public void performMenuAction(){
        System.out.println("Menu " + name);
        // terminal node
        if(children.size() == 0){
            command.execute();
        }
        // composite node
        else{
            for(MenuI child : children){
                child.performMenuAction();
            }
        }
    }
}


// ===== Abstract command =====
abstract class Command {
    public void execute() {
        System.out.println("   " + this.getClass().getSimpleName() + ".execute()");
    }
}

// ===== Concrete commands =====
class FileCommand extends Command{}
class NewCommand extends Command{}
class OpenCommand extends Command{}
class PrintCommand extends Command{}
class QuitCommand extends Command{}
class PreferencesCommand extends Command{}
