

public class Clone2 {
    public static void main(String[] args) {
        try{
            Personne p1 = new Personne("Curry", "Haskell", 1900, new Pays("Etats-Unis"));
            Personne p2 = p1.clone();
            System.out.println("======== p1 et p2 = p1.clone() ========");
            System.out.println("p1 = " + p1);
            System.out.println("p2 = " + p2);
            System.out.println("p1.getClass() = " + p1.getClass());
            System.out.println("p2.getClass() = " + p2.getClass());
            System.out.println("\n======== Modification de p1.nom et p1.annee ========");
            p1.setNom("Curry modifié");
            p1.setAnnee(2000);
            System.out.println("p1 = " + p1);
            System.out.println("p2 = " + p2);
            System.out.println("\n======== Modification de p1.pays ========");
            p1.getPays().setNom("Etats-Unis modifié");
            System.out.println("p1 = " + p1);
            System.out.println("p2 = " + p2);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}

class Pays{
    private String nom;
    public Pays(String nom){
        this.nom = nom;
    }
    public void setNom(String nom) { this.nom = nom; }
    public String getNom() { return nom; }
}
    
class Personne implements Cloneable{
    private String nom, prenom;
    private int annee;
    private Pays pays;
    public Personne(String nom, String prenom, int annee, Pays pays){
        this.nom = nom;
        this.prenom = prenom;
        this.annee = annee;
        this.pays = pays;
    }
    public void setNom(String nom) { this.nom = nom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public void setAnnee(int annee) { this.annee = annee; }
    public void setPays(Pays pays) { this.pays = pays; }
    public Pays getPays() { return pays; }
    @Override
    public String toString(){
        return prenom + " " + nom + " (" + String.valueOf(annee) + ") " + pays.getNom();
    }
    @Override
    public Personne clone() {
        Personne p = null;
        try{
            p = (Personne)super.clone();
            p.pays = new Pays(pays.getNom());
        }
        finally {
            return p;
        }
    }
    
}

