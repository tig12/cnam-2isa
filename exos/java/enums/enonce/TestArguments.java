import java.util.Arrays;

/** Rôles possibles pour un utilisateur **/
enum Role{ ROOT, ADMIN, USER }

class TestArguments{
    
    public static void main(String[] args) {
        
        String[] possibles = {"ROOT", "ADMIN", "USER"};
        String usage = "Utilisation : java TestArguments <rôle>\n<rôle> peut prendre les valeurs : " + String.join(", ", possibles);
        
        // L'appel doit avoir un seul argument
        if(args.length != 1){
            System.out.println(usage);
            System.out.println("Il manque le paramètre rôle.");
            System.exit(0);
        }
        
        // L'argument doit faire partie des valeurs possibles 
        if(!Arrays.asList(possibles).contains(args[0])){
            System.out.println(usage);
            System.out.println("Valeur incorrecte : " + args[0]);
            System.exit(0);
        }
        
        // Ici, on sait que l'argument est correct, on peut remplir la variable role
        Role role = null;
        switch(args[0]){
            case "ROOT"     : role = Role.ROOT; break;
            case "ADMIN"    : role = Role.ADMIN; break;
            case "USER"     : role = Role.USER; break;
        }
        
        System.out.println("OK, role = " + args[0]);
    }
}
