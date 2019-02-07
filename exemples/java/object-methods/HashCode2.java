

public class HashCode2 {
    public static void main(String[] args) {
        Personne p1 = new Personne(1, "Curry", "Haskell", 1900);
        System.out.println("p1.hashCode() = " + p1.hashCode());
        
        Personne p2 = new Personne(1, "Curry", "Haskell", 1900);
        System.out.println("p2.hashCode() = " + p2.hashCode());
        
        Personne p3 = new Personne(2, "Hilbert", "David", 1862);
        System.out.println("p3.hashCode() = " + p3.hashCode());
    }
}

class Personne{
    private int id; // unique id
    private String nom, prenom;
    private int anneeNaissance;
    public Personne(int id, String nom, String prenom, int anneeNaissance){
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = anneeNaissance;
    }
    
    @Override
    public  int hashCode() {
        return id;
    }
    
    @Override
    public  boolean equals(Object o) {
        if(!o.getClass().getName().equals(this.getClass().getName())){
            return false;
        }
        return o.hashCode() == hashCode();
        // ou encore :
        // return ((Personne)o).id == id;
        
    }
}

