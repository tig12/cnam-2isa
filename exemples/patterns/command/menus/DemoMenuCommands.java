
/** 
    Utilisation conjointe de Command and Composite
**/

import java.util.List;
import java.util.ArrayList;

public class DemoMenuCommands {
    
    public static void main( String[] args ) {
        
        // on crée deux structures composites : mFile et mEdit
        
        MenuI mFile = new Menu("File");
        
        MenuI mNew = new Menu("New");
        mNew.setCommand(new NewCommand());
        
        MenuI mOpen = new Menu("Open");
        mOpen.setCommand(new OpenCommand());
        
        MenuI mPrint = new Menu("Print");
        mPrint.setCommand(new PrintCommand());
        
        MenuI mQuit = new Menu("Quit");
        mQuit.setCommand(new QuitCommand());

        mFile.addChild(mNew);               
        mFile.addChild(mOpen);
        mFile.addChild(mPrint);
        mFile.addChild(mQuit);
        
        MenuI mEdit = new Menu("Edit");
        MenuI mPreferences = new Menu("Preferences");
        mPreferences.setCommand(new PreferencesCommand());
        mEdit.addChild(mPreferences);
        
        // Execution normale
        System.out.println("\n=== Normal execution ===");
        mFile.performMenuAction();
        mEdit.performMenuAction();
        
        // Association menu - command modifiée
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
    
    /** 
        performMenuAction() est à la fois 
        la méthode operation() du pattern Composite
        et la méthode execute() du pattern Command
    **/
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
