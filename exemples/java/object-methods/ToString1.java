
/** 
    Illustre la différence de traitement de null dans l'opérateur de concaténation de chaîne.
**/

class Personne {
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
        
        // Tests sur le comportement de toString() pour objets non null
        
        Personne p1 = new Personne("Curry", "Haskell", 1900);
        System.out.println("p1 = " + p1);
                                                                                                                                     
        Personne p2 = new Mathematicien("Curry", "Haskell", 1900);
        System.out.println("p2 = " + p2);
        
        Personne p3 = (Personne)p2;
        System.out.println("p3 = " + p3);
        
        Personne p4 = null;
        
        // Lorsqu'on utilise l'opérateur de concaténation de chaîne ou println(),
        // on obtient la chaîne "null"
        System.out.println("p4 = " + p4); // p4 = null
        String affichage = "affichage : p4 = " + p4;
        System.out.println(affichage); // affichage : p4 = null
        System.out.println(p4); // null
        
        // Mais lorsqu'on appelle une méthode sur un objet null, on obtient une exception.
        System.out.println("p4.toString() = " + p4.toString()); // java.lang.NullPointerException
    }
}
