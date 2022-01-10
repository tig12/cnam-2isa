


/** 
    Illustre la différence de comportement entre passage d'un paramètre
    par valeur ou par référence.
**/
class RefVal{
    
    public static void main(String[] args){
        // type primitif
        int test1 = 0;
        System.out.println("Avant modif, test1 = " + test1);
        modify(test1);
        System.out.println("Après modif, test1 = " + test1);
        
        // type référence
        Personne test2 = new Personne("toto");
        System.out.println("Avant modif, test2 = " + test2.nom);
        modify(test2);
        System.out.println("Après modif, test2 = " + test2.nom);
    }
    
    /** Cette méthode ne modifie pas la valeur de test1 **/
    private static void modify(int a){
        a = a +1;
    }
    
    /** Cette méthode modifie la valeur de test2.nom **/
    private static void modify(Personne p){
        p.nom = "titi";
    }
    
}

class Personne{
    public String nom;
    public Personne(String nom){this.nom = nom;}
}
