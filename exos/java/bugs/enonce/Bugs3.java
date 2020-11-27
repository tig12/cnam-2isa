

class Bugs3 {

    public static void main(String[] args){
        
        var p1 = new Personne("Church", "Alonzo");
        var p2 = new Personne("Turing", "Alan");
        
        System.out.println("p1 : " + p1)
        System.out.println("p2 : " + p2.nom + " " + p2.prenom);
        
    }
    
}

class Personne {
    
    private String nom;
    private String prenom;
    
    public Personne(String nom, String prenom){
        this nom = nom;
        this.prenom = prenom;
    }
    
    public String toString(){
        return nom + " " + prenom;
    }
    
}