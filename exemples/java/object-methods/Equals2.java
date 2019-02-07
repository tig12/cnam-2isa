
/** 
    Corrige les différences constatées dans Equals1
    en réimplémentant equals()
**/
public class Equals2 {
    public static void main(String[] args) {
        Classe o1 = new Classe("o1");
        Classe o2 = o1;
        System.out.println("o1 == o2 ? " + (o1 == o2));
        System.out.println("o1.equals(o2) ? " + (o1.equals(o2)));
        
        Classe o3 = new Classe("o1");
        System.out.println("\no1 == o3 ? " + (o1 == o3));
        System.out.println("o1.equals(o3) ? " + (o1.equals(o3)));
    }
}

class Classe{
    private String nom;
    public Classe(String nom){
        this.nom = nom;
    }
    public String getNom() { return nom; }
    public boolean equals(Object obj){
        if(obj.getClass() != this.getClass()){
            return false;
        }
        return ((Classe)obj).getNom() == nom;
    }
}
