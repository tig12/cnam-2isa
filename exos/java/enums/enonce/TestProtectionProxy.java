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
        
        System.out.println("OK, role = " + args[0]);
    }
}
