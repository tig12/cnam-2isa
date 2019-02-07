

class TestCompteAvecDecouvert{

    public static void main(String[] args){
        try{
            Compte c1 = new CompteAvecDecouvert("Compte 1", 1000.0);
            Compte c2 = new CompteAvecDecouvert("Compte 2", 4000.0);
            
            System.out.println("===== Etat initial =====");
            c1.afficher();
            c2.afficher();
            
            System.out.println("===== c1.retirer(800.0) =====");
            c1.retirer(800.0);
            c1.afficher();
            
            System.out.println("===== c1.virerVers(500.0, c2) =====");
            c1.virerVers(500.0, c2);
            c1.afficher();
            c2.afficher();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

}