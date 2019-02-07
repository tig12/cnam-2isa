class Personne{
    private String nom, prenom;
    private int anneeNaissance;
    public Personne(String nom, String prenom, int anneeNaissance){
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = anneeNaissance;
    }
}

class Mathematicien extends Personne {
    public Mathematicien(String nom, String prenom, int anneeNaissance){
        super(nom, prenom, anneeNaissance);
    }
}

public class ToString1 {
    public static void main(String[] args) {
        Personne p1 = new Personne("Curry", "Haskell", 1900);
        System.out.println("p1 = " + p1);
        
        Personne p2 = new Mathematicien("Curry", "Haskell", 1900);
        System.out.println("p2 = " + p2);
        
        Personne p3 = (Personne)p2;
        System.out.println("p3 = " + p3);
        
        Personne p4 = null;
        System.out.println("p4 = " + p4);
        System.out.println("p4.toString() = " + p4.toString()); // java.lang.NullPointerException
    }
}
