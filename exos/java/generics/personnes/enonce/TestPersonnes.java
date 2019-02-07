
import java.util.List;
import java.util.Arrays;

public class TestPersonnes{
    public static void main(String[] args){
        Personne[] personnes = {
            new Logicien("Church", "Alonzo", 1903),
            new Informaticien("Hopper", "Grace", 1906),
            new Informaticien("Kay", "Alan", 1940),
            new Logicien("Turing", "Alan", 1912),
            new Mathematicien("Von Neumann", "Johh", 1903),
        };
        affichePersonnes(Arrays.asList(personnes));
    }
    
    public static void affichePersonnes(/* ICI ecrire le type correct */ personnes){
        for(Personne p: personnes){
            System.out.println(p + " : " + p.getClass());
        }
    }
}

class Personne{
    protected String nom, prenom;
    protected int anneeNaissance;
    public Personne(String nom, String prenom, int anneeNaissance){
        this.nom = nom;
        this.prenom = prenom;
        this.anneeNaissance = anneeNaissance;
    }
    @Override
    public String toString(){
        return "[ " + prenom + ", " + nom + ", " + anneeNaissance + " ]";
    }
}

class Mathematicien extends Personne {
    public Mathematicien(String nom, String prenom, int anneeNaissance){
        super(nom, prenom, anneeNaissance);
    }
}

class Logicien extends Mathematicien {
    public Logicien(String nom, String prenom, int anneeNaissance){
        super(nom, prenom, anneeNaissance);
    }
}

class Informaticien extends Personne {
    public Informaticien(String nom, String prenom, int anneeNaissance){
        super(nom, prenom, anneeNaissance);
    }
}
