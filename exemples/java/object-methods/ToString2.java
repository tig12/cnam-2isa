

public class ToString2 {
    public static void main(String[] args) {
        Personne p1 = new Mathematicien("Curry", "Haskell", 1900);
        System.out.println("p1 = " + p1);
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
    public String toString(){
        return prenom + " " + nom + " (" + String.valueOf(anneeNaissance) + ")";
    }
}

class Mathematicien extends Personne {
    public Mathematicien(String nom, String prenom, int anneeNaissance){
        super(nom, prenom, anneeNaissance);
    }
}

