

public class HashCode1 {
    public static void main(String[] args) {
        Personne p1 = new Personne("Curry", "Haskell", 1900);
        System.out.println("p1.hashCode() = " + p1.hashCode());
        
        Personne p2 = new Personne("Haskell", "Curry", 1900);
        System.out.println("p2.hashCode() = " + p2.hashCode());
        
        Personne p3 = new Personne("Hilbert", "David", 1862);
        System.out.println("p3.hashCode() = " + p3.hashCode());
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
    
    @Override
    public  int hashCode() {
        return nom.hashCode() * prenom.hashCode() * anneeNaissance;
    }
}

