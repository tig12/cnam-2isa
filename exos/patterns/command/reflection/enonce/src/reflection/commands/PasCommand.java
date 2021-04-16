/** 
    Sert à tester dans main() le chargement d'une classe du package
    n'implémentant pas Command
**/
package reflection.commands;

public class PasCommand {
    public void execute(){
        System.out.println("execute() dans PasCommand");
    }
}
