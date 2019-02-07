

/** 
    Illustre le fait que deux objets en apparence égaux ne le sont pas
    au sens de l'implémentation par défaut de equals,
    car ils pointent vers deux endroits diifférents de la mémoire
**/
public class Equals1 {
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
}
