import java.util.Arrays;

class TestProtectionProxy{
    
    public static void main(String[] args) {
        
        // Vérifie les paramètres
        String[] possibles = {"ROOT", "ADMIN", "USER"};
        String usage = "Utilisation : java TestProxy1 <rôle>\n<rôle> peut prendre les valeurs : ROOT, ADMIN, USER";

        if(args.length != 1){
            System.out.println(usage);
            System.out.println("il manque le paramètre rôle.");
            System.exit(0);
        }
        if(!Arrays.asList(possibles).contains(args[0])){
            System.out.println(usage);
            System.out.println("Valeur incorrecte : " + args[0]);
            System.exit(0);
        }
        
        String role = args[0];
        
        // Appel de la classe Sensible
        Sensible sensible = new Sensible();
        sensible.rootMethod(role);
        sensible.adminMethod(role);
        sensible.userMethod(role);
    }
}

/**
    Protège l'accès a la classe Sensible
    A compléter
**/
class Proxy{
}

class Sensible{

    /** Méthode pouvant être exécutée par ROOT, pas par ADMIN ni USER **/
    public void rootMethod(String role){
        System.out.println("rootMethod called with role " + role);
    }
    
    /** Méthode pouvant être exécutée par ADMIN et ROOT, pas par USER **/
    public void adminMethod(String role){
        System.out.println("adminMethod called with role " + role);
    }
    
    /** Méthode pouvant être exécutée par tout le monde (USER, ADMIN, ROOT) **/
    public void userMethod(String role){
        System.out.println("userMethod called with role " + role);
    }
}

