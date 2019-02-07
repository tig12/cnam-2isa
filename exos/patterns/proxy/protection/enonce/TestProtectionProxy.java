import java.util.Arrays;

/** Rôles possibles pour un utilisateur **/
enum Role{
    ROOT,
    ADMIN,
    USER
}


class TestProtectionProxy{
    
    public static void main(String[] args) {
        
        // Vérifie les paramètres
        String[] possibles = new String[Role.values().length];
        for(Role value: Role.values()){
            possibles[value.ordinal()] = value.name();
        }
        String usage = "Utilisation : java TestProxy1 <rôle>\n<rôle> peut prendre les valeurs : " + String.join(", ", possibles);
/* 
        // sans utiliser l'api de Enum :
        String[] possibles = {"ROOT", "ADMIN", "USER"};
        String usage = "Utilisation : java TestProxy1 <rôle>\n<rôle> peut prendre les valeurs : ROOT, ADMIN, USER";
*/        

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
        
        // Convertit le paramètre d'entrée en valeur de l'enum Roles
        Role role = Enum.valueOf(Role.class, args[0]);
/* 
        // sans utiliser l'api de Enum :
        Role role = null;
        switch(args[0]){
        	case "ROOT" : role = Role.ROOT; break;
        	case "ADMIN" : role = Role.ADMIN; break;
        	case "USER" : role = Role.USER; break;
        }
*/
        
        // Appel de la classe Sensible
        Sensible.rootMethod(role);
        Sensible.adminMethod(role);
        Sensible.userMethod(role);
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
    public static void rootMethod(Role r){
        System.out.println("rootMethod called with role " + r);
    }
    
    /** Méthode pouvant être exécutée par ADMIN et ROOT, pas par USER **/
    public static void adminMethod(Role r){
        System.out.println("adminMethod called with role " + r);
    }
    
    /** Méthode pouvant être exécutée par tout le monde (USER, ADMIN, ROOT) **/
    public static void userMethod(Role r){
        System.out.println("userMethod called with role " + r);
    }
}

