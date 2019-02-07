/** 
    Exemple simple d'implémentation de toString
**/

class Personne{

    private String nom, prenom;
    private int anneeNaissance;
    
    public Personne(String nom, String prenom, int anneeNaissance){
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = anneeNaissance;
    }
    
}

public class ToString{
    public static void main(String[] args){
    
        Personne[] personnes = {
            new Personne("Church", "Alonzo", 1903),
            new Personne("Hopper", "Grace", 1906),
            new Personne("Kay", "Alan", 1940),
            new Personne("Turing", "Alan", 1912),
            new Personne("Von Neumann", "Johh", 1903),
        };
        
        for(Personne p : personnes){
            System.out.println(p);
        }
    
    }
}