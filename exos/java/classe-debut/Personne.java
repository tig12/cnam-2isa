
public class Personne {
    
    private String nom;

    private float age;
    
    public Personne(String nom, float age) {
        this.nom = nom;
        this.age = age;
    }
    
    public String getNom() {
        return nom;
    }
    
    public float getAge() {
        return age;
    }
    
    public boolean estPlusAge(Personne p) {
        return this.age > p.getAge();
    }
    
}