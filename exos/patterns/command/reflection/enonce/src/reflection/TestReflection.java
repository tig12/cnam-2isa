/** 
    Illustre l'utilisation de la reflection avec le pattern Command
**/

package reflection;

public class TestReflection {
    
    public static void main(String[] args){
    
        String usage = "Utilisation : java TestRelection <command>";

        if(args.length == 0){
            System.out.println(usage);
            System.out.println("Il manque le paramètre command.");
            System.exit(0);
        }
        if(args.length > 1){
            System.out.println(usage);
            System.out.println("Paramètre inutile : " + args[1]);
            System.exit(0);
        }
        
        // Compléter le code ici
    }
}

