

public class GetClass {
    public static void main(String[] args) {
        Personne p1 = new Personne("Curry", "Haskell", 1900);
        System.out.println("p1.getClass() = " + p1.getClass());
        
        Personne p2 = new Mathematicien("Curry", "Haskell", 1900);
        System.out.println("p2.getClass() = " + p2.getClass());
        
        Personne p3 = (Personne)p2;
        System.out.println("p3.getClass() = " + p3.getClass());
    }
}

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

